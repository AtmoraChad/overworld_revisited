package net.atmorachad.overworld_revisited;

import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.atmorachad.overworld_revisited.block.ModBlockEntities;
import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.block.ModDesertBlocks;
import net.atmorachad.overworld_revisited.block.ModWindsweptBlocks;
import net.atmorachad.overworld_revisited.creativetab.ModCreativeTabs;
import net.atmorachad.overworld_revisited.item.ModItems;
import net.atmorachad.overworld_revisited.particle.ModParticles;
import net.atmorachad.overworld_revisited.util.MinYCriterion;
import net.atmorachad.overworld_revisited.worldgen.ModMaterialRules;
import net.atmorachad.overworld_revisited.worldgen.feature.ModFeatures;
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
		ModWindsweptBlocks.registerModBlocks();
		ModDesertBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();
		ModItems.registerModItems();
		ModParticles.registerModParticles();
		ModCreativeTabs.registerModCreativeModeTabs();
		ModFeatures.registerModFeatures();

		MinYCriterion.TYPE.getId();

		ParticleProviderRegistry.getInstance().register(
				ModParticles.YELLOW_BIRCH_LEAVES, FallingLeavesParticle.PoplarProvider::new
		);

		ParticleProviderRegistry.getInstance().register(
				ModParticles.TEMPEST_LEAVES, FallingLeavesParticle.PoplarProvider::new
		);

		SurfaceGeneration.addOverworldSurfaceRules(
				Identifier.fromNamespaceAndPath("overworld_revisited", "desert_caves"),
				ModMaterialRules::desertCaves
		);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
