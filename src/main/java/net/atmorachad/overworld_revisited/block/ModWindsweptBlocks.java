package net.atmorachad.overworld_revisited.block;

import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.atmorachad.overworld_revisited.particle.ModParticles;
import net.atmorachad.overworld_revisited.tag.ModTags;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModWindsweptBlocks {
    
    public static final Block GALE_STEM = registerBlock("stormwood_log",
            properties -> new RotatedPillarBlock(logProperties(properties,
                    MapColor.TERRACOTTA_BLUE).randomTicks()));

    public static final Block GALE_WOOD = registerBlock("stormwood_wood",
            properties -> new RotatedPillarBlock(logProperties(properties,
                    MapColor.TERRACOTTA_BLUE).randomTicks()));

    public static final Block STRIPPED_GALE_STEM = registerBlock("stripped_stormwood_log",
            properties -> new RotatedPillarBlock(logProperties(properties,
                    MapColor.TERRACOTTA_BLUE).randomTicks()));

    public static final Block STRIPPED_GALE_WOOD = registerBlock("stripped_stormwood_wood",
            properties -> new RotatedPillarBlock(logProperties(properties,
                    MapColor.TERRACOTTA_BLUE).randomTicks()));

    public static final Block GALE_PLANKS = registerBlock("stormwood_planks",
            properties -> new Block(properties.mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.WOOD)
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F)));

    public static final Block GALE_STAIRS = registerBlock("stormwood_stairs",
            properties -> new StairBlock(ModWindsweptBlocks.GALE_PLANKS.defaultBlockState(),
                    properties.mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS).strength(0.4F).requiresCorrectToolForDrops()));

    public static final Block GALE_SLAB = registerBlock("stormwood_slab",
            properties -> new SlabBlock(properties.mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Block GALE_FENCE = registerBlock("stormwood_fence",
            properties -> new FenceBlock(properties.mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Block GALE_FENCE_GATE = registerBlock("stormwood_fence_gate",
            properties -> new FenceGateBlock(ModWoodTypes.GALE, properties.mapColor(MapColor.TERRACOTTA_BLUE).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F)));

    public static final Block GALE_PRESSURE_PLATE = registerBlock("stormwood_pressure_plate",
            properties -> new PressurePlateBlock(ModBlockSetType.GALE, properties.mapColor(MapColor.TERRACOTTA_BLUE).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).pushReaction(PushReaction.POPPED)));

    public static final Block GALE_BUTTON = registerBlock("stormwood_button",
            properties -> new ButtonBlock(ModBlockSetType.GALE, 30,
                    properties.noCollision().strength(0.5F).pushReaction(PushReaction.POPPED)));


    public static final Block GALE_SIGN = registerBlockWithoutItem("stormwood_sign",
            properties -> new StandingSignBlock(ModWoodTypes.GALE, properties.mapColor(MapColor.TERRACOTTA_BLUE).noCollision()
                    .forceSolidOn().strength(1.0F).instrument(NoteBlockInstrument.BASS)));

    public static final Block GALE_WALL_SIGN = registerBlockWithoutItem("stormwood_wall_sign",
            properties -> new WallSignBlock(ModWoodTypes.GALE,
                    wallVariant(properties.mapColor(MapColor.WOOD).forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F),
                            GALE_SIGN, true)));

    public static final Block GALE_HANGING_SIGN = registerBlockWithoutItem("stormwood_hanging_sign",
            properties -> new CeilingHangingSignBlock(ModWoodTypes.GALE, properties.mapColor(MapColor.TERRACOTTA_BLUE).noCollision()
                    .forceSolidOn().strength(1.0F).instrument(NoteBlockInstrument.BASS)));

    public static final Block GALE_WALL_HANGING_SIGN = registerBlockWithoutItem("stormwood_wall_hanging_sign",
            properties -> new WallHangingSignBlock(ModWoodTypes.GALE,
                    wallVariant(properties.mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS)
                                    .noCollision().strength(1.0F),
                            GALE_HANGING_SIGN, true)));

    public static final Block GALE_SHELF = registerBlock("stormwood_shelf",
            properties -> new ShelfBlock(properties.mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.SHELF).ignitedByLava().strength(2.0F, 3.0F)));

    public static final Block GALE_DOOR = registerBlock("stormwood_door",
            properties -> new DoorBlock(ModBlockSetType.GALE, properties.mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F).noOcclusion().pushReaction(PushReaction.POPPED)));

    public static final Block GALE_TRAPDOOR = registerBlock("stormwood_trapdoor",
            properties -> new TrapDoorBlock(ModBlockSetType.GALE, properties.mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F).noOcclusion().pushReaction(PushReaction.POPPED)));

    public static final Block TEMPEST_GRASS = registerBlockWithoutItem("tempest_grass",
            properties -> new DoublePlantBlock(properties.mapColor(MapColor.PLANT).replaceable().noCollision().instabreak()
                    .sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.POPPED)));

    public static final Block TEMPEST_LEAVES = registerBlock("tempest_leaves",
            properties -> new UntintedParticleLeavesBlock(
                    0.01F, ModParticles.TEMPEST_LEAVES, AmbientLeavesBlockSoundPlayer.of(
                    SoundEvents.POPLAR_LEAVES_AMBIENT, BlockTags.REQUIRED_FOR_POPLAR_LEAF_AMBIENCE),
                    properties.mapColor(MapColor.PLANT).strength(0.2F).isRedstoneConductor(Blocks::never)
                            .sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).ignitedByLava()
                            .isSuffocating(Blocks::never).randomTicks().pushReaction(PushReaction.POPPED)));

    public static final Block TEMPEST_VINE = registerBlockWithoutItem("tempest_vine",
            properties -> new VineBlock(properties.mapColor(MapColor.PLANT).replaceable().noCollision().randomTicks()
                    .strength(0.2F).sound(SoundType.VINE).ignitedByLava()
                    .lightLevel(state -> 15).pushReaction(PushReaction.POPPED)));

    public static final Block STORMWOOD_SAPLING = registerBlockWithoutItem("stormwood_sapling",
            properties -> new SaplingBlock(ModTreeGrowers.STORMWOOD,
                    properties.mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.GRASS)
                            .pushReaction(PushReaction.POPPED)));


    public static final BlockFamily GALE_FAMILY =
            new BlockFamily.Builder(GALE_PLANKS)
                    .log(GALE_STEM)
                    .strippedLog(STRIPPED_GALE_STEM)
                    .stairs(GALE_STAIRS)
                    .slab(GALE_SLAB)
                    .fence(GALE_FENCE)
                    .fenceGate(GALE_FENCE_GATE)
                    .button(GALE_BUTTON)
                    .pressurePlate(GALE_PRESSURE_PLATE)
                    .sign(GALE_SIGN, GALE_WALL_SIGN)
                    .hangingSign(GALE_HANGING_SIGN, GALE_WALL_HANGING_SIGN)
                    .door(GALE_DOOR)
                    .trapdoor(GALE_TRAPDOOR)
                    .getFamily();




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

    public static BlockBehaviour.Properties logProperties(
            BlockBehaviour.Properties properties, final MapColor mapColor)  {
        return properties
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava();
    }

    private static BlockBehaviour.Properties wallVariant(
            BlockBehaviour.Properties properties, final Block standingBlock, final boolean copyName)
    {properties = properties.overrideLootTable(standingBlock.getLootTable());
        if (copyName) {properties = properties.overrideDescription(standingBlock.getDescriptionId());
        } return properties;
    }


    public static void registerModBlocks() {
        OverworldRevisited.LOGGER.info("Registering Mod Blocks for " + OverworldRevisited.MOD_ID);
    }
}
