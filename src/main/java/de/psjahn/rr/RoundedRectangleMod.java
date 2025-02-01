package de.psjahn.rr;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;

public class RoundedRectangleMod implements ClientModInitializer {
	public static final String MOD_ID = "rounded-rectangle";

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitializeClient() {

	}
}