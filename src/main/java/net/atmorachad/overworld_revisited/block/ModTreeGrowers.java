package net.atmorachad.overworld_revisited.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModTreeGrowers {

    public static final ResourceKey<Feature> STORMWOOD_TREE = ResourceKey.create(Registries.FEATURE,
            Identifier.fromNamespaceAndPath("overworld_revisited", "stormwood"));

    public static final TreeGrower STORMWOOD = new TreeGrower("overworld_revisited:stormwood",
            WeightedList.of(), WeightedList.of(STORMWOOD_TREE), WeightedList.of(), null);
}