package net.atmorachad.overworld_revisited.worldgen;

import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {


    public static final ResourceKey<Biome> DESERT_CAVES =
            ResourceKey.create(Registries.BIOME, OverworldRevisited.id("desert_caves"));

    public static final ResourceKey<Biome> BADLANDS_CAVES =
            ResourceKey.create(Registries.BIOME, OverworldRevisited.id("badlands_caves"));
}
