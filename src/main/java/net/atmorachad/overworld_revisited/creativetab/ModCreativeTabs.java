package net.atmorachad.overworld_revisited.creativetab;

import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.atmorachad.overworld_revisited.block.ModWindsweptBlocks;
import net.atmorachad.overworld_revisited.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

    public static final CreativeModeTab OR_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, "overworld_revisited_tab"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.THIN_BIRCH))
                    .title(Component.translatable("creativemodetab.overworld_revisited.fluorite_blocks"))
                    .displayItems((parameters, output) -> {

                        output.accept(ModBlocks.THIN_BIRCH);
                        output.accept(ModBlocks.YELLOW_BIRCH_LEAVES);

                        output.accept(ModItems.WARM_SNIFFER_EGG);
                        output.accept(ModItems.COLD_SNIFFER_EGG);

                        output.accept(ModBlocks.ELDER_CACTUS);
                        output.accept(ModBlocks.VERDANT_CYCAD);

                        output.accept(ModBlocks.FRIGID_LICHEN);
                        output.accept(ModBlocks.PERMASNOW_BUSH);

                        output.accept(ModWindsweptBlocks.TEMPEST_GRASS);
                        output.accept(ModWindsweptBlocks.TEMPEST_LEAVES);
                        output.accept(ModWindsweptBlocks.TEMPEST_VINE);

                        output.accept(ModWindsweptBlocks.GALE_STEM);
                        output.accept(ModWindsweptBlocks.GALE_WOOD);
                        output.accept(ModWindsweptBlocks.STRIPPED_GALE_STEM);
                        output.accept(ModWindsweptBlocks.STRIPPED_GALE_WOOD);
                        output.accept(ModWindsweptBlocks.GALE_PLANKS);
                        output.accept(ModWindsweptBlocks.GALE_STAIRS);
                        output.accept(ModWindsweptBlocks.GALE_SLAB);
                        output.accept(ModWindsweptBlocks.GALE_FENCE);
                        output.accept(ModWindsweptBlocks.GALE_FENCE_GATE);
                        output.accept(ModWindsweptBlocks.GALE_TRAPDOOR);
                        output.accept(ModWindsweptBlocks.GALE_DOOR);
                        output.accept(ModWindsweptBlocks.GALE_PRESSURE_PLATE);
                        output.accept(ModWindsweptBlocks.GALE_BUTTON);
                        output.accept(ModItems.GALE_SIGN);
                        output.accept(ModItems.GALE_HANGING_SIGN);
                        output.accept(ModWindsweptBlocks.GALE_SHELF);
                        
                    }).build());

    public static void registerModCreativeModeTabs() {
        OverworldRevisited.LOGGER.info("Registering Creative Mode Tabs for " + OverworldRevisited.MOD_ID);
    }
}