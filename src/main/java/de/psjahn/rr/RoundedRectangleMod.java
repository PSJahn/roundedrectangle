package de.psjahn.rr;

import de.psjahn.rr.mixinHelper.RoundedRectangleDrawContext;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.util.Identifier;

import java.awt.*;

public class RoundedRectangleMod implements ClientModInitializer {
	public static final String MOD_ID = "rounded-rectangle";

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitializeClient() {
		HudRenderCallback.EVENT.register(((drawContext, renderTickCounter) -> {
			RoundedRectangleDrawContext roundedContext = (RoundedRectangleDrawContext) drawContext;
			drawContext.fill(0, 0, 50, 50, 10, Color.WHITE.getRGB());
			roundedContext.fillRounded(50, 0, 150, 50, 10, 20, Color.RED.getRGB());
		}));
	}
}