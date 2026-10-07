package net.atmorachad.overworld_revisited.worldgen.feature;

import com.mojang.serialization.MapCodec;
import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.atmorachad.overworld_revisited.worldgen.feature.features.DesertCaveCoatingFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModFeatures {

    public static final MapCodec<DesertCaveCoatingFeature> DESERT_CAVE_COATING = Registry.register(
                    BuiltInRegistries.FEATURE_TYPE, Identifier.fromNamespaceAndPath(
                            "overworld_revisited", "desert_cave_coating"), DesertCaveCoatingFeature.CODEC);

    public static void registerModFeatures() {
        OverworldRevisited.LOGGER.info("Registering Mod Features for " + OverworldRevisited.MOD_ID);
    }
}
