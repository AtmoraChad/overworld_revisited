package net.atmorachad.overworld_revisited.block;

import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModDesertBlocks {



    public static final Block PACKED_SAND = registerBlock("soft_sandstone",
            properties -> new Block(properties.mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE).strength(0.75F).sound(SoundType.STONE)));

    public static final Block PACKED_RED_SAND = registerBlock("soft_red_sandstone",
            properties -> new Block(properties.mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.SNARE).strength(0.75F).sound(SoundType.STONE)));

    public static final Block SOFT_SANDSTONE_GOLD_ORE = registerBlock("soft_sandstone_gold_ore",
            properties -> new Block(properties.mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE).strength(0.75F).sound(SoundType.STONE)));

    public static final Block SOFT_RED_SANDSTONE_IRON_ORE = registerBlock("soft_red_sandstone_iron_ore",
            properties -> new Block(properties.mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.SNARE).strength(0.75F).sound(SoundType.STONE)));

    public static final Block TERRACOTTA_GOLD_ORE = registerBlock("terracotta_gold_ore",
            properties -> new Block(properties.mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(1.25F, 4.2F)));

    public static final Block LUMINESCENT_CACTUS_FLOWER = registerBlockWithoutItem("luminescent_cactus_flower",
            properties -> new CactusFlowerBlock(properties.mapColor(MapColor.COLOR_PINK).noCollision().instabreak().ignitedByLava()
                    .sound(SoundType.CACTUS_FLOWER).pushReaction(PushReaction.POPPED).lightLevel(state -> 9)));


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


    private static Block registerColoredBlock(String name, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties) {
        Identifier id = Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name);
        Block block = function.apply(properties.setId(ResourceKey.create(Registries.BLOCK, id)));
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }


    private static Block registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name), toRegister);
    }

    public static void registerModBlocks() {
        OverworldRevisited.LOGGER.info("Registering Mod Blocks for " + OverworldRevisited.MOD_ID);
    }
}
