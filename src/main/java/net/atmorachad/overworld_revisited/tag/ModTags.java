package net.atmorachad.overworld_revisited.tag;

import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> GALE_STEMS = createTag("gale_stems");

        public static final TagKey<Block> SUPPORTS_THIN_BIRCH = createTag("supports_thin_birch");


        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> GALE_STEMS_CRAFTING = createTag("gale_stems_crafting");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name));
        }
    }

    public static class Fluids {

        private static TagKey<Fluid> createTag(String name) {
            return TagKey.create(Registries.FLUID, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name));
        }
    }
}
