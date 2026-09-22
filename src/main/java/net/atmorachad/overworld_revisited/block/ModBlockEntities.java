package net.atmorachad.overworld_revisited.block;


import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;


public class ModBlockEntities {

    public static void registerModBlockEntities() {

        FabricBlockEntityType shelfType =
                (FabricBlockEntityType) BlockEntityTypes.SHELF;
        shelfType.addValidBlock(ModWindsweptBlocks.GALE_SHELF);


        FabricBlockEntityType signType =
                (FabricBlockEntityType) BlockEntityTypes.SIGN;

        signType.addValidBlock(ModWindsweptBlocks.GALE_SIGN);
        signType.addValidBlock(ModWindsweptBlocks.GALE_WALL_SIGN);

        FabricBlockEntityType hangingSignType =
                (FabricBlockEntityType) BlockEntityTypes.HANGING_SIGN;

        hangingSignType.addValidBlock(ModWindsweptBlocks.GALE_HANGING_SIGN);
        hangingSignType.addValidBlock(ModWindsweptBlocks.GALE_WALL_HANGING_SIGN);
    }
}