package de.psjahn.rr.render;

public class RoundedRectangleUniforms {
    private static float[] bounds = new float[]{0.0F, 0.0F, 0.0F, 0.0F};
    private static float radius = 5.0F;
    private static float smoothness = 1.0F;

    public static float[] getBounds() {
        return bounds;
    }

    public static void setBounds(float[] bounds) {
        RoundedRectangleUniforms.bounds = bounds;
    }

    public static float getRadius() {
        return radius;
    }

    public static void setRadius(float radius) {
        RoundedRectangleUniforms.radius = radius;
    }

    public static float getSmoothness() {
        return smoothness;
    }

    public static void setSmoothness(float smoothness) {
        RoundedRectangleUniforms.smoothness = smoothness;
    }
}
