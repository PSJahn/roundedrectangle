package de.psjahn.rr.render;

import static com.mojang.blaze3d.systems.RenderSystem.assertOnRenderThread;

public class RoundedRectangleUniforms {
    private static float[] bounds = new float[]{0.0F, 0.0F, 0.0F, 0.0F};
    private static float radius = 5.0F;
    private static float smoothness = 1.0F;

    public static float[] getBounds() {
        assertOnRenderThread();
        return bounds;
    }

    public static void setBounds(float[] bounds) {
        assertOnRenderThread();
        RoundedRectangleUniforms.bounds = bounds;
    }

    public static float getRadius() {
        assertOnRenderThread();
        return radius;
    }

    public static void setRadius(float radius) {
        assertOnRenderThread();
        RoundedRectangleUniforms.radius = radius;
    }

    public static float getSmoothness() {
        assertOnRenderThread();
        return smoothness;
    }

    public static void setSmoothness(float smoothness) {
        assertOnRenderThread();
        RoundedRectangleUniforms.smoothness = smoothness;
    }
}
