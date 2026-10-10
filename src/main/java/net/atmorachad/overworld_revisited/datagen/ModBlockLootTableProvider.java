package net.atmorachad.overworld_revisited.datagen;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.block.ModDesertBlocks;
import net.atmorachad.overworld_revisited.block.ModWindsweptBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {


        dropSelf(ModBlocks.THIN_BIRCH);
        dropOther(ModBlocks.THIN_BIRCH_SAPLING, ModBlocks.THIN_BIRCH);

        dropSelf(ModBlocks.WARM_SNIFFER_EGG);
        dropSelf(ModBlocks.COLD_SNIFFER_EGG);

        add(ModBlocks.VERDANT_CYCAD, createSinglePropConditionTable
                (ModBlocks.VERDANT_CYCAD,DoublePlantBlock.HALF,DoubleBlockHalf.LOWER)
        );
        dropSelf(ModBlocks.ELDER_CACTUS);

        dropSelf(ModBlocks.FRIGID_LICHEN);
        dropSelf(ModBlocks.PERMASNOW_BUSH);

        add(ModWindsweptBlocks.TEMPEST_LEAVES, createShearsOrSilkTouchOnlyDrop(ModWindsweptBlocks.TEMPEST_LEAVES));
        add(ModWindsweptBlocks.TEMPEST_VINE, createShearsOrSilkTouchOnlyDrop(ModWindsweptBlocks.TEMPEST_VINE));
        add(ModWindsweptBlocks.TEMPEST_GRASS, createShearsOrSilkTouchOnlyDrop(ModWindsweptBlocks.TEMPEST_GRASS));
        add(ModBlocks.YELLOW_BIRCH_LEAVES, createShearsOrSilkTouchOnlyDrop(ModBlocks.YELLOW_BIRCH_LEAVES));

        dropSelf(ModDesertBlocks.PACKED_SAND);
        dropSelf(ModDesertBlocks.PACKED_RED_SAND);

        createOreDrop(ModDesertBlocks.TERRACOTTA_GOLD_ORE, Items.RAW_GOLD);
        createOreDrop(ModDesertBlocks.SOFT_SANDSTONE_GOLD_ORE, Items.RAW_GOLD);
        createOreDrop(ModDesertBlocks.SOFT_RED_SANDSTONE_IRON_ORE, Items.RAW_IRON);

    }
}
