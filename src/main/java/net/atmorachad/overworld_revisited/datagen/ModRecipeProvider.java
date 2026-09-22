package net.atmorachad.overworld_revisited.datagen;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.block.ModWindsweptBlocks;
import net.atmorachad.overworld_revisited.item.ModItems;
import net.atmorachad.overworld_revisited.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipeContext,
            BootstrapContext<Advancement> advancementContext) {
        return new RecipeProvider(recipeContext, advancementContext) {

            @Override
            public void buildRecipes() {

                shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BIRCH_LOG, 1)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModBlocks.THIN_BIRCH)
                        .unlockedBy(getHasName(ModBlocks.THIN_BIRCH), has(ModBlocks.THIN_BIRCH))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_WOOD, 3)
                        .define('R', ModWindsweptBlocks.GALE_STEM)
                        .pattern("RR")
                        .pattern("RR")
                        .group("bark")
                        .unlockedBy("has_log", this.has(ModWindsweptBlocks.GALE_STEM))
                        .save(this.output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.STRIPPED_GALE_WOOD, 3)
                        .define('R', ModWindsweptBlocks.STRIPPED_GALE_STEM)
                        .pattern("RR")
                        .pattern("RR")
                        .group("bark")
                        .unlockedBy("has_log", this.has(ModWindsweptBlocks.STRIPPED_GALE_STEM))
                        .save(this.output);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_PLANKS, 4)
                        .requires(ModTags.Items.GALE_STEMS_CRAFTING).group("planks").unlockedBy("has_logs", this.has(ModTags.Items.GALE_STEMS_CRAFTING)).save(this.output);


                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_STAIRS, 4)
                        .pattern("R  ")
                        .pattern("RR ")
                        .pattern("RRR")
                        .define('R', ModWindsweptBlocks.GALE_PLANKS)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_SLAB, 6)
                        .pattern("RRR")
                        .define('R', ModWindsweptBlocks.GALE_PLANKS)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_FENCE, 3)
                        .pattern("RSR")
                        .pattern("RSR")
                        .define('R', ModWindsweptBlocks.GALE_PLANKS)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_FENCE_GATE)
                        .pattern("RSR")
                        .pattern("RSR")
                        .define('R', Items.STICK)
                        .define('S', ModWindsweptBlocks.GALE_PLANKS)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_PRESSURE_PLATE)
                        .pattern("RR")
                        .define('R', ModWindsweptBlocks.GALE_PLANKS)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_BUTTON)
                        .pattern("R")
                        .define('R', ModWindsweptBlocks.GALE_PLANKS)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GALE_SIGN, 3)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern(" S ")
                        .define('R', ModWindsweptBlocks.GALE_PLANKS)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GALE_HANGING_SIGN, 3)
                        .pattern("S S")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModWindsweptBlocks.STRIPPED_GALE_STEM)
                        .define('S', Items.IRON_CHAIN)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_SHELF)
                        .pattern("RRR")
                        .pattern("   ")
                        .pattern("RRR")
                        .define('R', ModWindsweptBlocks.GALE_STEM)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_STEM), has(ModWindsweptBlocks.GALE_STEM))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_TRAPDOOR)
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModWindsweptBlocks.GALE_PLANKS)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModWindsweptBlocks.GALE_DOOR)
                        .pattern("RR")
                        .pattern("RR")
                        .pattern("RR")
                        .define('R', ModWindsweptBlocks.GALE_PLANKS)
                        .unlockedBy(getHasName(ModWindsweptBlocks.GALE_PLANKS), has(ModWindsweptBlocks.GALE_PLANKS))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Overworld Revisited " +
                "Recipes";
    }
}