package de.psjahn.rr.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.psjahn.rr.render.RoundedRectangleUniforms;
import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.ShaderProgramDefinition;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ShaderProgram.class)
public abstract class ShaderProgramMixin {
    @Shadow public abstract @Nullable GlUniform getUniform(String name);

    @Nullable
    public GlUniform bounds;
    @Nullable
    public GlUniform radius;
    @Nullable
    public GlUniform smoothness;

    @Inject(method = "set", at = @At("TAIL"))
    private void set(List<ShaderProgramDefinition.Uniform> uniforms, List<ShaderProgramDefinition.Sampler> samplers, CallbackInfo ci) {
        this.bounds = this.getUniform("Bounds");
        this.radius = this.getUniform("Radius");
        this.smoothness = this.getUniform("Smoothness");
    }

    @WrapOperation(method = "initializeUniforms", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setupShaderLights(Lnet/minecraft/client/gl/ShaderProgram;)V"))
    private void initializeUniforms(ShaderProgram shader, Operation<Void> original) {
        if(this.bounds != null) {
            float[] bounds = RoundedRectangleUniforms.getBounds();
            this.bounds.set(bounds[0], bounds[1], bounds[2], bounds[3]);
        }

        if(this.radius != null) {
            this.radius.set(RoundedRectangleUniforms.getRadius());
        }

        if(this.smoothness != null) {
            this.smoothness.set(RoundedRectangleUniforms.getSmoothness());
        }

        original.call(shader);
    }
}
