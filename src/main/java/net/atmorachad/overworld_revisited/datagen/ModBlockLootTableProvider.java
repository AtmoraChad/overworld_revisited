package net.atmorachad.overworld_revisited.datagen;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.block.ModWindsweptBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        createShearsOrSilkTouchOnlyDrop(ModBlocks.YELLOW_BIRCH_LEAVES);
        createShearsOrSilkTouchOnlyDrop(ModWindsweptBlocks.TEMPEST_GRASS);
        createShearsOrSilkTouchOnlyDrop(ModWindsweptBlocks.TEMPEST_LEAVES);
        createShearsOrSilkTouchOnlyDrop(ModWindsweptBlocks.TEMPEST_VINE);

        dropSelf(ModBlocks.THIN_BIRCH);
        dropOther(ModBlocks.THIN_BIRCH_SAPLING, ModBlocks.THIN_BIRCH);
    }
}
