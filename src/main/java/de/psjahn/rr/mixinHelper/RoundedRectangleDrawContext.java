package de.psjahn.rr.mixinHelper;

public interface RoundedRectangleDrawContext {
    default void fillRounded(float x1, float y1, float x2, float y2, float radius, float smoothness, int color) {}
    default void fillRounded(float x1, float y1, float x2, float y2, float z, float radius, float smoothness, int color) {}
}
