package net.atmorachad.overworld_revisited.datagen;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.block.ModWindsweptBlocks;
import net.atmorachad.overworld_revisited.tag.ModTags;
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
        

        tag(ItemTags.LEAVES)
                .add(ModBlocks.getItemRK(ModBlocks.YELLOW_BIRCH_LEAVES))
                .add(ModBlocks.getItemRK(ModWindsweptBlocks.TEMPEST_LEAVES))
        ;

        tag(ItemTags.PLANKS)
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_PLANKS));

        tag(ItemTags.WOODEN_FENCES)
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_FENCE));

        tag(ItemTags.FENCE_GATES)
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_FENCE_GATE));

        tag(ItemTags.WOODEN_BUTTONS)
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_BUTTON));

        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_PRESSURE_PLATE));

        tag(ItemTags.WOODEN_STAIRS)
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_STAIRS));

        tag(ItemTags.WOODEN_SLABS)
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_SLAB));

        tag(ModTags.Items.GALE_STEMS_CRAFTING)
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_STEM))
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.GALE_WOOD))
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                .add(ModWindsweptBlocks.getItemRK(ModWindsweptBlocks.STRIPPED_GALE_WOOD));
    }
}
