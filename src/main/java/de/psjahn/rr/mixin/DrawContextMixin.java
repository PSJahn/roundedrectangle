package de.psjahn.rr.mixin;

import de.psjahn.rr.mixinHelper.RoundedRectangleDrawContext;
import de.psjahn.rr.render.ModRenderLayers;
import de.psjahn.rr.render.RoundedRectangleUniforms;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DrawContext.class)
public abstract class DrawContextMixin implements RoundedRectangleDrawContext {
    @Shadow @Final private VertexConsumerProvider.Immediate vertexConsumers;

    @Shadow @Final private MatrixStack matrices;

    @Override
    public void fillRounded(float x1, float y1, float x2, float y2, float radius, float smoothness, int color) {
        this.fillRounded(x1, y1, x2, y2, 0.0F, radius, smoothness, color);
    }

    @Override
    public void fillRounded(float x1, float y1, float x2, float y2, float z, float radius, float smoothness, int color) {
        Matrix4f matrix4f = this.matrices.peek().getPositionMatrix();

        Window window = MinecraftClient.getInstance().getWindow();
        float scaleFactor = (float) window.getScaleFactor();

        int wh = window.getHeight();
        int ww = window.getWidth();

        float actualX1 = x1 * scaleFactor;
        float actualX2 = x2 * scaleFactor;

        float actualY1 = wh - y2 * scaleFactor;
        float actualY2 = wh - y1 * scaleFactor;

        RoundedRectangleUniforms.setBounds(new float[]{actualX1, actualY1, actualX2, actualY2});
        RoundedRectangleUniforms.setRadius(radius);
        RoundedRectangleUniforms.setSmoothness(smoothness);
        VertexConsumer vertexConsumer = this.vertexConsumers.getBuffer(ModRenderLayers.getRoundedRectangle());
        vertexConsumer.vertex(matrix4f, 0, 0, z).color(color);
        vertexConsumer.vertex(matrix4f, 0, wh, z).color(color);
        vertexConsumer.vertex(matrix4f, ww, wh, z).color(color);
        vertexConsumer.vertex(matrix4f, ww, 0, z).color(color);
    }
}
