package net.atmorachad.overworld_revisited;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.item.ModItems;
import net.atmorachad.overworld_revisited.particle.ModParticles;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OverworldRevisited implements ModInitializer {
	public static final String MOD_ID = "overworld_revisited";

		public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModParticles.registerModParticles();

		ParticleProviderRegistry.getInstance().register(
				ModParticles.YELLOW_BIRCH_LEAVES, FallingLeavesParticle.PoplarProvider::new
		);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
