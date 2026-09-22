package net.atmorachad.overworld_revisited.block;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockSetType {
    private static final Map<String, BlockSetType> TYPES = new Object2ObjectArrayMap<>();

    public static final Codec<BlockSetType> CODEC =
            Codec.stringResolver(BlockSetType::name, TYPES::get);

    public static final BlockSetType GALE = register(
            new BlockSetType(
                    "gale",
                    true,
                    true,
                    true,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.WOOD,
                    SoundEvents.WOODEN_DOOR_CLOSE,
                    SoundEvents.WOODEN_DOOR_OPEN,
                    SoundEvents.WOODEN_TRAPDOOR_CLOSE,
                    SoundEvents.WOODEN_TRAPDOOR_OPEN,
                    SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.WOODEN_BUTTON_CLICK_OFF,
                    SoundEvents.WOODEN_BUTTON_CLICK_ON
            )
    );

    private static BlockSetType register(BlockSetType type) {
        TYPES.put(type.name(), type);
        return type;
    }

    public static Stream<BlockSetType> values() {
        return TYPES.values().stream();
    }
}
