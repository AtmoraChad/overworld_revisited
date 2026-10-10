package net.atmorachad.overworld_revisited.worldgen.feature.features;

import com.mojang.serialization.MapCodec;
import net.atmorachad.overworld_revisited.block.ModDesertBlocks;
import net.atmorachad.overworld_revisited.worldgen.ModBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

public class BadlandsCaveCoatingFeature implements Feature {

    public static final BadlandsCaveCoatingFeature INSTANCE = new BadlandsCaveCoatingFeature();

    public static final MapCodec<BadlandsCaveCoatingFeature> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        ChunkPos chunkPos = new ChunkPos(origin.getX() >> 4, origin.getZ() >> 4);
        int minX = chunkPos.getMinBlockX(); int minZ = chunkPos.getMinBlockZ();

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        boolean changed = false;

        // Start above the deepslate region since we're deliberately
        // leaving that alone.
        for (int y = 8; y < level.getMaxY(); y++) {
            for (int x = minX; x < minX + 16; x++) {
                for (int z = minZ; z < minZ + 16; z++) {
                    pos.set(x, y, z);

                    BlockState state = level.getBlockState(pos);

                    // The rest is your existing exposed-stone coating.
                    // Keep this above the deepslate transition.
                    if (y < 8) {
                        continue;
                    }

                    if (!state.is(Blocks.STONE)) {
                        continue;
                    }

                    if (!level.getBiome(pos).is(ModBiomes.BADLANDS_CAVES)) {
                        continue;
                    }

                    if (!isExposed(level, pos)) {
                        continue;
                    }

                    level.setBlock(
                            pos,
                            ModDesertBlocks.PACKED_RED_SAND.defaultBlockState(),
                            2
                    );

                    changed = true;
                }
            }
        }

        return changed;
    }

    private static boolean isExposed(
            WorldGenLevel level,
            BlockPos pos
    ) {
        for (Direction direction : Direction.values()) {
            if (level.getBlockState(pos.relative(direction)).isAir()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public MapCodec<? extends Feature> codec() {
        return CODEC;
    }
}