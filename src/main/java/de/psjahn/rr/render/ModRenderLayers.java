package de.psjahn.rr.render;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;

public class ModRenderLayers {
    private static final RenderLayer ROUNDED_RECTANGLE = RenderLayer.of(
            "rounded_rectangle",
            VertexFormats.POSITION_COLOR,
            VertexFormat.DrawMode.QUADS,
            1536, //TODO: keine Ahnung
            false,
            true,
            RenderLayer.MultiPhaseParameters.builder()
                    .program(ModShaderPrograms.ROUNDED_RECTANGLE_PROGRAM)
                    .writeMaskState(RenderPhase.COLOR_MASK) //TODO: evtl. optional
                    .cull(RenderPhase.DISABLE_CULLING) //TODO: evtl. optional
                    .depthTest(RenderPhase.LEQUAL_DEPTH_TEST)
                    .transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY)
                    .build(false)
    );

    public static RenderLayer getRoundedRectangle() {
        return ROUNDED_RECTANGLE;
    }
}
