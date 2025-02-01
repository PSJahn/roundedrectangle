package de.psjahn.rr.render;

import de.psjahn.rr.RoundedRectangleMod;
import net.minecraft.client.gl.Defines;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;

public class ModShaderPrograms {
    public static final ShaderProgramKey RENDERTYPE_ROUNDED_RECTANGLE = register("rendertype_rounded_rectangle", VertexFormats.POSITION_COLOR);

    public static final RenderPhase.ShaderProgram ROUNDED_RECTANGLE_PROGRAM = new RenderPhase.ShaderProgram(RENDERTYPE_ROUNDED_RECTANGLE);

    private static ShaderProgramKey register(String id, VertexFormat format) {
        return register(id, format, Defines.EMPTY);
    }

    private static ShaderProgramKey register(String is, VertexFormat format, Defines defines) {
        ShaderProgramKey shaderProgramKey = new ShaderProgramKey(RoundedRectangleMod.id("core/" + is), format, defines);
        ShaderProgramKeys.getAll().add(shaderProgramKey);
        return shaderProgramKey;
    }
}
