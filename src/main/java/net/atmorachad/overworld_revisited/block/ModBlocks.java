package net.atmorachad.overworld_revisited.block;

import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.atmorachad.overworld_revisited.block.blocktype.ThinBirchSaplingBlock;
import net.atmorachad.overworld_revisited.block.blocktype.ThinBirchStalkBlock;
import net.atmorachad.overworld_revisited.particle.ModParticles;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {

    public static final Block YELLOW_BIRCH_LEAVES = registerBlock("yellow_birch_leaves",
            properties -> new UntintedParticleLeavesBlock(
                    0.01F, ModParticles.YELLOW_BIRCH_LEAVES,AmbientLeavesBlockSoundPlayer.of(
                            SoundEvents.POPLAR_LEAVES_AMBIENT, BlockTags.REQUIRED_FOR_POPLAR_LEAF_AMBIENCE),
                    properties.mapColor(MapColor.PLANT).strength(0.2F).isRedstoneConductor(Blocks::never)
                            .sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).ignitedByLava()
                            .isSuffocating(Blocks::never).randomTicks().pushReaction(PushReaction.POPPED)));

    public static final Block THIN_BIRCH_SAPLING = registerBlockWithoutItem("thin_birch_sapling",
            properties -> new ThinBirchSaplingBlock(
                    properties.mapColor(MapColor.WOOD).forceSolidOn().randomTicks().instabreak().noCollision()
                            .strength(1.0F).sound(SoundType.BAMBOO_SAPLING).ignitedByLava()
                            .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.POPPED)));

    public static final Block THIN_BIRCH = registerBlock("thin_birch",
            properties -> new ThinBirchStalkBlock(
                    properties.mapColor(MapColor.PLANT).forceSolidOn().randomTicks().instabreak().ignitedByLava()
                            .strength(1.0F).sound(SoundType.BAMBOO).noOcclusion().dynamicShape()
                            .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.POPPED)
                            .isRedstoneConductor(Blocks::never)));

    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    public static ResourceKey<Item> getItemRK(Block block) {
        Identifier id = BuiltInRegistries.BLOCK.getKey(block);
        return ResourceKey.create(Registries.ITEM, id);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name)))));
    }

    private static Block registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name), toRegister);
    }

    public static void registerModBlocks() {
        OverworldRevisited.LOGGER.info("Registering Mod Blocks for " + OverworldRevisited.MOD_ID);
    }
}
