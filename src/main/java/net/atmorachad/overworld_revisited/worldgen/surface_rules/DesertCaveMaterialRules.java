package net.atmorachad.overworld_revisited.worldgen.surface_rules;

import net.atmorachad.overworld_revisited.block.ModDesertBlocks;
import net.atmorachad.overworld_revisited.worldgen.ModBiomes;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.condition.MaterialCondition;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class DesertCaveMaterialRules {

    private static final MaterialCondition NEAR_SURFACE = MaterialRules.abovePreliminarySurface();

    private static final MaterialRule SAND = MaterialRules.state(Blocks.SAND.defaultBlockState());

    private static final MaterialRule PACKED_SAND = MaterialRules.state(ModDesertBlocks.PACKED_SAND.defaultBlockState());

    private static final MaterialRule SANDSTONE = MaterialRules.state(Blocks.SANDSTONE.defaultBlockState());

    private static final MaterialCondition SAND_LAYER =
            MaterialRules.stoneDepthCheck(
                    2, false, 0, CaveSurface.FLOOR);

    private static final MaterialCondition PACKED_SAND_LAYER =
            MaterialRules.stoneDepthCheck(
                    4, false, 0, CaveSurface.FLOOR);

    private static final MaterialCondition SANDSTONE_LAYER =
            MaterialRules.stoneDepthCheck(
                    8, false, 0, CaveSurface.FLOOR);

    private static final MaterialCondition CEILING_PACKED_SAND =
            MaterialRules.stoneDepthCheck(
                    0, false, 0, CaveSurface.CEILING);

    private static final MaterialCondition CEILING_SANDSTONE =
            MaterialRules.stoneDepthCheck(
                    3, false, 0, CaveSurface.CEILING);

    private static final MaterialCondition DESERT_CAVE_DEPTH = MaterialRules.yBlockCheck(
                    VerticalAnchor.absolute(-30), 0);

    public static MaterialRule desertCaves(RegistryAccess registryAccess) {
        return MaterialRules.ifTrue(MaterialRules.isBiome(registryAccess.lookupOrThrow(Registries.BIOME),
                        ModBiomes.DESERT_CAVES),



                MaterialRules.ifTrue(DESERT_CAVE_DEPTH, MaterialRules.sequence(
                        MaterialRules.ifTrue(NEAR_SURFACE, MaterialRules.sequence(
                                        MaterialRules.ifTrue(SAND_LAYER, SAND), SAND)),


                                // Ceiling
                                MaterialRules.ifTrue(CEILING_PACKED_SAND, PACKED_SAND),
                                MaterialRules.ifTrue(CEILING_SANDSTONE, SANDSTONE),

                                // Floor
                                MaterialRules.ifTrue(SAND_LAYER, SAND),
                                MaterialRules.ifTrue(PACKED_SAND_LAYER, PACKED_SAND),
                                MaterialRules.ifTrue(SANDSTONE_LAYER, SANDSTONE),

                                TERRACOTTA_BANDS
                        )
                )
        );
    }



    private static final ResourceKey<NormalNoise> DESERT_CAVE_TERRACOTTA = ResourceKey.create(
                    Registries.NOISE, Identifier.fromNamespaceAndPath("overworld_revisited", "desert_cave_terracotta"));

    private static final MaterialRule TERRACOTTA =
            MaterialRules.state(Blocks.TERRACOTTA.defaultBlockState());

    private static final MaterialRule ORANGE_TERRACOTTA =
            MaterialRules.state(Blocks.DYED_TERRACOTTA.orange().defaultBlockState());

    private static final MaterialRule YELLOW_TERRACOTTA =
            MaterialRules.state(Blocks.DYED_TERRACOTTA.yellow().defaultBlockState());


    private static final MaterialRule TERRACOTTA_BANDS = MaterialRules.sequence(
                    MaterialRules.ifTrue(MaterialRules.noiseCondition3d(
                                    DESERT_CAVE_TERRACOTTA, -1.0F, -0.33F), YELLOW_TERRACOTTA),

                    MaterialRules.ifTrue(MaterialRules.noiseCondition3d(
                                    DESERT_CAVE_TERRACOTTA, -0.35F, 0.33F), TERRACOTTA),

                    MaterialRules.ifTrue(MaterialRules.noiseCondition3d(
                                    DESERT_CAVE_TERRACOTTA, 0.33F, 1.0F), ORANGE_TERRACOTTA));

}
