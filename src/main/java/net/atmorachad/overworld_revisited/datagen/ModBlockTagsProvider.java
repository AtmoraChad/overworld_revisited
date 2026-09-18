package net.atmorachad.overworld_revisited.datagen;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @SafeVarargs
    private final void addToTags(ResourceKey<Block> block, TagKey<Block>... tags) {
        for (TagKey<Block> tag : tags) {
            builder(tag).add(block);
        }
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)

        ;

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.THIN_BIRCH))
        ;

        tag(BlockTags.MINEABLE_WITH_HOE)

        ;

        tag(BlockTags.BLOCKS_FLUID_FLOW)
        ;


        tag(BlockTags.BASE_STONE_OVERWORLD)

        ;

        tag(BlockTags.WALLS)

        ;


        tag(BlockTags.STAIRS)

        ;


        tag(BlockTags.SLABS)

        ;


        tag(BlockTags.WOODEN_STAIRS)

        ;


        tag(BlockTags.WOODEN_SLABS)

        ;


        tag(BlockTags.REPLACEABLE)

        ;

        tag(BlockTags.LEAVES)
                .add(ModBlocks.getRK(ModBlocks.YELLOW_BIRCH_LEAVES))
        ;


        tag(BlockTags.REPLACEABLE_BY_TREES)
        ;

        tag(BlockTags.REPLACEABLE_BY_MUSHROOMS)
        ;

        tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
        ;

        tag(BlockTags.ENDERMAN_HOLDABLE)
        ;

        tag(BlockTags.VALID_SPAWN)
        ;

        tag(BlockTags.MOSS_REPLACEABLE)
        ;

        tag(BlockTags.DIRT)
        ;

        tag(BlockTags.LUSH_GROUND_REPLACEABLE)
        ;

        tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE)
                .add(ModBlocks.getRK(ModBlocks.YELLOW_BIRCH_LEAVES))
        ;

        addToTags(
                ModBlocks.getRK(ModBlocks.THIN_BIRCH),
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.SWORD_INSTANTLY_MINES,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.BLOCKS_MOTION);

        addToTags(
                ModBlocks.getRK(ModBlocks.THIN_BIRCH_SAPLING),
                BlockTags.SWORD_INSTANTLY_MINES,
                BlockTags.WASHED_AWAY_BY_FLUIDS);
    }
}
