package net.atmorachad.overworld_revisited.datagen;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(ItemTags.STONE_CRAFTING_MATERIALS)

        ;

        tag(ItemTags.STONE_TOOL_MATERIALS)

        ;

        tag(ItemTags.MUSHROOMS)

        ;

        tag(ItemTags.LEAVES)
                .add(ModBlocks.getItemRK(ModBlocks.YELLOW_BIRCH_LEAVES))
        ;

        tag(ItemTags.WOODEN_STAIRS)

        ;


        tag(ItemTags.WOODEN_SLABS)

        ;


        tag(ItemTags.WALLS)

        ;
    }
}
