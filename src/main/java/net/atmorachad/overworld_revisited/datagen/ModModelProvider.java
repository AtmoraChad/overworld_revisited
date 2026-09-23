package net.atmorachad.overworld_revisited.datagen;

import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.block.ModWindsweptBlocks;
import net.atmorachad.overworld_revisited.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {super(output);}

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        blockModelGenerators.createTrivialCube(ModBlocks.YELLOW_BIRCH_LEAVES);

        blockModelGenerators.family(ModWindsweptBlocks.GALE_PLANKS)
                .generateFor(ModWindsweptBlocks.GALE_FAMILY);


        blockModelGenerators.createShelf(ModWindsweptBlocks.GALE_SHELF, ModWindsweptBlocks.STRIPPED_GALE_STEM);

        blockModelGenerators.woodProvider(ModWindsweptBlocks.GALE_STEM)
                .logWithHorizontal(ModWindsweptBlocks.GALE_STEM)
                .wood(ModWindsweptBlocks.GALE_WOOD);

        blockModelGenerators.woodProvider(ModWindsweptBlocks.STRIPPED_GALE_STEM)
                .logWithHorizontal(ModWindsweptBlocks.STRIPPED_GALE_STEM)
                .wood(ModWindsweptBlocks.STRIPPED_GALE_WOOD);

        blockModelGenerators.createDoublePlant(ModWindsweptBlocks.TEMPEST_GRASS, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createTrivialCube(ModWindsweptBlocks.TEMPEST_LEAVES);

        blockModelGenerators.createCrossBlock(ModWindsweptBlocks.STORMWOOD_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

    }


    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

        itemModelGenerators.generateFlatItem(ModItems.TEMPEST_GRASS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TEMPEST_VINES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STORMWOOD_SAPLING, ModelTemplates.FLAT_ITEM);


    }

    private static void registerWoodSet(BlockModelGenerators generator,
            Block wood, Block log, Block stairs, Block slab, Block wall) {
        TextureMapping textures = TextureMapping.cube(log);

        // STAIRS
        Identifier stair = ModelTemplates.STAIRS_STRAIGHT.create(stairs, textures, generator.modelOutput);
        Identifier inner = ModelTemplates.STAIRS_INNER.create(stairs, textures, generator.modelOutput);
        Identifier outer = ModelTemplates.STAIRS_OUTER.create(stairs, textures, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createStairs(stairs,
                BlockModelGenerators.plainVariant(inner), BlockModelGenerators.plainVariant(stair), BlockModelGenerators.plainVariant(outer)));
        generator.registerSimpleItemModel(stairs, stair);

        // SLAB
        Identifier slabBottom = ModelTemplates.SLAB_BOTTOM.create(slab, textures, generator.modelOutput);
        Identifier slabTop = ModelTemplates.SLAB_TOP.create(slab, textures, generator.modelOutput);
        Identifier fullBlock = ModelLocationUtils.getModelLocation(wood);
        generator.blockStateOutput.accept(BlockModelGenerators.createSlab(slab,
                BlockModelGenerators.plainVariant(slabBottom), BlockModelGenerators.plainVariant(slabTop), BlockModelGenerators.plainVariant(fullBlock)));
        generator.registerSimpleItemModel(slab, slabBottom);

        // WALL
        Identifier post = ModelTemplates.WALL_POST.create(wall, textures, generator.modelOutput);
        Identifier low = ModelTemplates.WALL_LOW_SIDE.create(wall, textures, generator.modelOutput);
        Identifier tall = ModelTemplates.WALL_TALL_SIDE.create(wall, textures, generator.modelOutput);
        Identifier inventory = ModelTemplates.WALL_INVENTORY.create(wall, textures, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createWall(wall,
                BlockModelGenerators.plainVariant(post), BlockModelGenerators.plainVariant(low), BlockModelGenerators.plainVariant(tall)));
        generator.registerSimpleItemModel(wall, inventory);
    }
}
