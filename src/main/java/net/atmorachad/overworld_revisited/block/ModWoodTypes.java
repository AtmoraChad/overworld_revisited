package net.atmorachad.overworld_revisited.block;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Map;
import java.util.stream.Stream;

public class ModWoodTypes {
    private static final Map<String, WoodType> TYPES = new Object2ObjectArrayMap<>();

    public static final WoodType GALE = register(
            new WoodType(
                    "gale",
                    ModBlockSetType.GALE,
                    SoundType.WOOD,
                    SoundType.HANGING_SIGN,
                    SoundEvents.FENCE_GATE_CLOSE,
                    SoundEvents.FENCE_GATE_OPEN
            )
    );

    private static WoodType register(final WoodType type) {
        TYPES.put(type.name(), type);
        return type;
    }

    public static Stream<WoodType> values() {
        return TYPES.values().stream();
    }
}
