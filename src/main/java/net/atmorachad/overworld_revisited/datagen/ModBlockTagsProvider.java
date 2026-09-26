package net.atmorachad.overworld_revisited.datagen;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.block.ModWindsweptBlocks;
import net.atmorachad.overworld_revisited.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

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
                .add(ModBlocks.getRK(ModBlocks.FRIGID_LICHEN));
        ;

        tag(BlockTags.MINEABLE_WITH_PICKAXE)

        ;

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.THIN_BIRCH))

                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_WOOD))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_WOOD))

                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_PLANKS))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_STAIRS))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_SLAB))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_FENCE))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_FENCE_GATE))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_PRESSURE_PLATE))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_BUTTON))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_SHELF))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_DOOR))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_TRAPDOOR));

        tag(BlockTags.PLANKS)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_PLANKS));

        tag(BlockTags.LOGS)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_WOOD))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_WOOD));

        tag(ModTags.Blocks.GALE_STEMS)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_WOOD))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_WOOD));

        tag(BlockTags.PREVENTS_NEARBY_LEAF_DECAY)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_WOOD))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_WOOD));

        tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_WOOD))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_WOOD));

        tag(BlockTags.PARROTS_SPAWNABLE_ON)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_WOOD))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_WOOD));

        tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_WOOD))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.STRIPPED_GALE_WOOD));

        tag(BlockTags.WOODEN_SHELVES)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_SHELF));

        tag(BlockTags.DOORS)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_DOOR));

        tag(BlockTags.WOODEN_DOORS)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_DOOR));

        tag(BlockTags.TRAPDOORS)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_TRAPDOOR));

        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModWindsweptBlocks.getRK(ModWindsweptBlocks.GALE_TRAPDOOR));

        tag(BlockTags.STAIRS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_STAIRS));

        tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_STAIRS));

        tag(BlockTags.SLABS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_SLAB));

        tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_SLAB));

        tag(BlockTags.FENCES)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_FENCE));

        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_FENCE));

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_FENCE_GATE));

        tag(BlockTags.BUTTONS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_BUTTON));

        tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_BUTTON));

        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_PRESSURE_PLATE));

        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_PRESSURE_PLATE));

        tag(BlockTags.SIGNS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_SIGN))
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_WALL_SIGN));

        tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_SIGN));

        tag(BlockTags.WALL_POST_OVERRIDE)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_SIGN));

        tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_WALL_SIGN));

        tag(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_HANGING_SIGN))
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_WALL_HANGING_SIGN));

        tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_HANGING_SIGN));

        tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.getRK(ModWindsweptBlocks.GALE_WALL_HANGING_SIGN));

        tag(BlockTags.REPLACEABLE_BY_TREES)
                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_GRASS))
                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_VINE))
                .add(ModBlocks.getRK(ModBlocks.VERDANT_CYCAD))
                .add(ModBlocks.getRK(ModBlocks.FRIGID_LICHEN))
                .add(ModBlocks.getRK(ModBlocks.PERMASNOW_BUSH))
        ;

        tag(BlockTags.WASHED_AWAY_BY_FLUIDS)
                .add(ModBlocks.getRK(ModBlocks.PERMASNOW_BUSH))

        ;


        tag(BlockTags.LEAVES)
                .add(ModBlocks.getRK(ModBlocks.YELLOW_BIRCH_LEAVES))
                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_LEAVES));


        tag(BlockTags.REPLACEABLE)
                .add(ModBlocks.getRK(ModBlocks.YELLOW_BIRCH_LEAVES))
                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_GRASS))
                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_VINE))
                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_LEAVES))
                .add(ModBlocks.getRK(ModBlocks.VERDANT_CYCAD))
                .add(ModBlocks.getRK(ModBlocks.FRIGID_LICHEN))
                .add(ModBlocks.getRK(ModBlocks.PERMASNOW_BUSH))
        ;

        tag(BlockTags.REPLACEABLE_BY_MUSHROOMS)

                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_VINE))
                .add(ModBlocks.getRK(ModBlocks.FRIGID_LICHEN))
                .add(ModBlocks.getRK(ModBlocks.PERMASNOW_BUSH))
        ;


        tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE)
                .add(ModBlocks.getRK(ModBlocks.YELLOW_BIRCH_LEAVES))
                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_VINE))
                .add(ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_LEAVES));


        tag(ModTags.Blocks.SUPPORTS_THIN_BIRCH)
                .add(ModBlocks.getRK(Blocks.SUSPICIOUS_GRAVEL))
                .add(ModBlocks.getRK(Blocks.GRAVEL))
                .add(ModBlocks.getRK(ModBlocks.THIN_BIRCH_SAPLING))
                .add(ModBlocks.getRK(ModBlocks.THIN_BIRCH))
                .forceAddTag(BlockTags.SAND)
                .forceAddTag(BlockTags.SUBSTRATE_OVERWORLD)
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

        addToTags(
                ModBlocks.getRK(ModWindsweptBlocks.STORMWOOD_SAPLING),
                BlockTags.SAPLINGS,
                BlockTags.WASHED_AWAY_BY_FLUIDS);

        addToTags(
                ModBlocks.getRK(ModWindsweptBlocks.TEMPEST_VINE),
                BlockTags.FALL_DAMAGE_RESETTING,
                BlockTags.ENCHANTMENT_POWER_TRANSMITTER,
                BlockTags.CLIMBABLE,
                BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH,
                BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH,
                BlockTags.CAN_GLIDE_THROUGH,
                BlockTags.WASHED_AWAY_BY_FLUIDS,
                BlockTags.SWORD_EFFICIENT,
                BlockTags.SHEARS_MINOR_BREAKING_SPEED);

        addToTags(
                ModBlocks.getRK(ModBlocks.ELDER_CACTUS),
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.CAT_DOES_NOT_TELEPORT_TO,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.ENDERMAN_HOLDABLE,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.SUPPORT_OVERRIDE_CACTUS_FLOWER,
                BlockTags.ENDERMAN_DOES_NOT_TELEPORT_TO,
                BlockTags.BLOCKS_MOTION,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.HAPPY_GHAST_AVOIDS,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.DANGEROUS_FOR_TELEPORTATION);

        addToTags(
                ModBlocks.getRK(ModBlocks.WARM_SNIFFER_EGG),
                BlockTags.BLOCKS_MOTION,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE);

        addToTags(
                ModBlocks.getRK(ModBlocks.COLD_SNIFFER_EGG),
                BlockTags.BLOCKS_MOTION,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE);

        addToTags(
                ModBlocks.getRK(ModBlocks.COLD_SNIFFER_EGG),
                BlockTags.BLOCKS_MOTION,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE);

        addToTags(
                ModBlocks.getRK(ModBlocks.FRIGID_LICHEN),
                BlockTags.FALL_DAMAGE_RESETTING,
                BlockTags.ENCHANTMENT_POWER_TRANSMITTER,
                BlockTags.WASHED_AWAY_BY_FLUIDS,
                BlockTags.SWORD_EFFICIENT,
                BlockTags.INSIDE_STEP_SOUND_BLOCKS,
                BlockTags.SHEARS_MINOR_BREAKING_SPEED);
    }
}
