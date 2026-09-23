package net.atmorachad.overworld_revisited.mixin;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.atmorachad.overworld_revisited.entity.variant.FoxEntityAccessor;

@Mixin(Fox.class)
public abstract class FoxEntityMixin implements FoxEntityAccessor {

    @Unique
    private static final EntityDataAccessor<Integer> OVERWORLD_REVISITED_FOX_VARIANT =
            SynchedEntityData.defineId(
                    Fox.class,
                    EntityDataSerializers.INT
            );


    /*
     * Add our custom variant value to the Fox's synced entity data.
     */
    @Inject(
            method = "defineSynchedData",
            at = @At("TAIL")
    )
    private void overworldRevisited$defineFoxVariant(
            SynchedEntityData.Builder builder,
            CallbackInfo ci
    ) {
        builder.define(
                OVERWORLD_REVISITED_FOX_VARIANT,
                NORMAL
        );
    }


    /*
     * Choose the custom variant after vanilla has already decided
     * whether this fox is RED or SNOW.
     */
    @Inject(
            method = "finalizeSpawn",
            at = @At("TAIL")
    )
    private void overworldRevisited$initializeFoxVariant(
            ServerLevelAccessor level,
            DifficultyInstance difficulty,
            EntitySpawnReason spawnReason,
            SpawnGroupData groupData,
            CallbackInfoReturnable<SpawnGroupData> cir
    ) {
        Fox fox = (Fox) (Object) this;

        int variant = overworldRevisited$chooseSpawnVariant(
                fox,
                level
        );

        overworldRevisited$setFoxVariant(variant);
    }


    /*
     * Save custom variant.
     */
    @Inject(
            method = "addAdditionalSaveData",
            at = @At("TAIL")
    )
    private void overworldRevisited$writeFoxVariant(
            ValueOutput output,
            CallbackInfo ci
    ) {
        output.putInt(
                "OverworldRevisitedFoxVariant",
                overworldRevisited$getFoxVariant()
        );
    }


    /*
     * Load custom variant.
     */
    @Inject(
            method = "readAdditionalSaveData",
            at = @At("TAIL")
    )
    private void overworldRevisited$readFoxVariant(
            ValueInput input,
            CallbackInfo ci
    ) {
        overworldRevisited$setFoxVariant(
                input.getIntOr(
                        "OverworldRevisitedFoxVariant",
                        NORMAL
                )
        );
    }


    /*
     * Child randomly inherits one parent's OR variant.
     */
    @Inject(
            method = "getBreedOffspring",
            at = @At("RETURN")
    )
    private void overworldRevisited$inheritFoxVariant(
            ServerLevel level,
            AgeableMob partner,
            CallbackInfoReturnable<Fox> cir
    ) {
        Fox child = cir.getReturnValue();

        if (child == null || !(partner instanceof Fox otherFox)) {
            return;
        }

        Fox parent = (Fox) (Object) this;

        FoxEntityAccessor parentAccessor =
                (FoxEntityAccessor) parent;

        FoxEntityAccessor otherParentAccessor =
                (FoxEntityAccessor) otherFox;

        FoxEntityAccessor childAccessor =
                (FoxEntityAccessor) child;

        int inheritedVariant =
                parent.getRandom().nextBoolean()
                        ? parentAccessor.overworldRevisited$getFoxVariant()
                        : otherParentAccessor.overworldRevisited$getFoxVariant();

        childAccessor.overworldRevisited$setFoxVariant(
                inheritedVariant
        );
    }


    /*
     * All natural-spawn selection lives here.
     */
    @Unique
    private static int overworldRevisited$chooseSpawnVariant(
            Fox fox,
            ServerLevelAccessor level
    ) {
        var biome = level.getBiome(fox.blockPosition());

        /*
         * Birch fox overrides the ordinary Red Fox pool.
         */
        if (biome.is(Biomes.BIRCH_FOREST)
                || biome.is(Biomes.OLD_GROWTH_BIRCH_FOREST)) {
            return BIRCH;
        }

        /*
         * Snow foxes:
         *
         * 50% vanilla
         * 50% black
         */
        if (fox.getVariant() == Fox.Variant.SNOW) {
            return fox.getRandom().nextBoolean()
                    ? BLACK
                    : NORMAL;
        }

        /*
         * Red foxes:
         *
         * 1/3 vanilla
         * 1/3 timber
         * 1/3 cinnamon
         */
        return switch (fox.getRandom().nextInt(3)) {
            case 1 -> TIMBER;
            case 2 -> CINNAMON;
            default -> NORMAL;
        };
    }


    @Unique
    @Override
    public int overworldRevisited$getFoxVariant() {
        Fox fox = (Fox) (Object) this;

        return fox.getEntityData().get(
                OVERWORLD_REVISITED_FOX_VARIANT
        );
    }


    @Unique
    @Override
    public void overworldRevisited$setFoxVariant(int variant) {
        Fox fox = (Fox) (Object) this;

        fox.getEntityData().set(
                OVERWORLD_REVISITED_FOX_VARIANT,
                variant
        );
    }
}