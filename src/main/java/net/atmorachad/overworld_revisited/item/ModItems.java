package net.atmorachad.overworld_revisited.item;

import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.atmorachad.overworld_revisited.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Function;

public class ModItems {



    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name)))));
    }

    private static Item registerSpawnEgg(String name, EntityType<?> type) {
        return registerItem(name, properties -> new SpawnEggItem(
                properties.spawnEgg(type)));
    }

    public static void registerModItems() {
        OverworldRevisited.LOGGER.info("Registering Mod Items for" + OverworldRevisited.MOD_ID);
    }
}
