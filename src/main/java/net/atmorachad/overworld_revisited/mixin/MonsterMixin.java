package net.atmorachad.overworld_revisited.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Monster.class)
public abstract class MonsterMixin {

    @Unique
    private static final ResourceKey<Biome> OVERWORLD_REVISITED$DESERT_CAVES =
            ResourceKey.create(
                    Registries.BIOME,
                    Identifier.fromNamespaceAndPath(
                            "overworld_revisited",
                            "desert_caves"
                    )
            );

    @Inject(
            method = "checkSurfaceMonstersSpawnRules",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void overworld_revisited$allowDesertCaveMobs(
            EntityType<? extends Mob> type,
            ServerLevelAccessor level,
            EntitySpawnReason spawnReason,
            BlockPos pos,
            RandomSource random,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if ((type == EntityTypes.HUSK || type == EntityTypes.PARCHED)
                && level.getBiome(pos).is(OVERWORLD_REVISITED$DESERT_CAVES)) {

            cir.setReturnValue(
                    Monster.checkMonsterSpawnRules(
                            type,
                            level,
                            spawnReason,
                            pos,
                            random
                    )
            );
        }
    }
}