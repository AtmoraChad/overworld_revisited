package net.atmorachad.overworld_revisited.mixin;

import net.atmorachad.overworld_revisited.entity.variant.GoatEntityAccessor;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Goat.class)
public abstract class GoatEntityMixin implements GoatEntityAccessor {

    @Unique
    private static final EntityDataAccessor<Integer> OVERWORLD_REVISITED_GOAT_VARIANT =
            SynchedEntityData.defineId(
                    Goat.class,
                    EntityDataSerializers.INT
            );


    @Inject(
            method = "defineSynchedData",
            at = @At("TAIL")
    )
    private void overworldRevisited$defineGoatVariant(
            SynchedEntityData.Builder builder,
            CallbackInfo ci
    ) {
        builder.define(
                OVERWORLD_REVISITED_GOAT_VARIANT,
                NORMAL
        );
    }


    /*
     * Natural spawn selection:
     *
     * 1/3 Normal
     * 1/3 Black
     * 1/3 Brown
     */
    @Inject(
            method = "finalizeSpawn",
            at = @At("TAIL")
    )
    private void overworldRevisited$initializeGoatVariant(
            ServerLevelAccessor level,
            DifficultyInstance difficulty,
            EntitySpawnReason spawnReason,
            SpawnGroupData groupData,
            CallbackInfoReturnable<SpawnGroupData> cir
    ) {
        Goat goat = (Goat) (Object) this;

        int variant = switch (goat.getRandom().nextInt(3)) {
            case 1 -> BLACK;
            case 2 -> BROWN;
            default -> NORMAL;
        };

        overworldRevisited$setGoatVariant(variant);
    }


    @Inject(
            method = "addAdditionalSaveData",
            at = @At("TAIL")
    )
    private void overworldRevisited$writeGoatVariant(
            ValueOutput output,
            CallbackInfo ci
    ) {
        output.putInt(
                "OverworldRevisitedGoatVariant",
                overworldRevisited$getGoatVariant()
        );
    }


    @Inject(
            method = "readAdditionalSaveData",
            at = @At("TAIL")
    )
    private void overworldRevisited$readGoatVariant(
            ValueInput input,
            CallbackInfo ci
    ) {
        overworldRevisited$setGoatVariant(
                input.getIntOr(
                        "OverworldRevisitedGoatVariant",
                        NORMAL
                )
        );
    }


    /*
     * Baby randomly inherits one parent's coat.
     *
     * This remains independent of the vanilla
     * screaming-goat trait.
     */
    @Inject(
            method = "getBreedOffspring",
            at = @At("RETURN")
    )
    private void overworldRevisited$inheritGoatVariant(
            ServerLevel level,
            AgeableMob partner,
            CallbackInfoReturnable<Goat> cir
    ) {
        Goat child = cir.getReturnValue();

        if (child == null || !(partner instanceof Goat otherGoat)) {
            return;
        }

        Goat parent = (Goat) (Object) this;

        GoatEntityAccessor parentAccessor =
                (GoatEntityAccessor) parent;

        GoatEntityAccessor otherParentAccessor =
                (GoatEntityAccessor) otherGoat;

        GoatEntityAccessor childAccessor =
                (GoatEntityAccessor) child;

        int inheritedVariant =
                parent.getRandom().nextBoolean()
                        ? parentAccessor.overworldRevisited$getGoatVariant()
                        : otherParentAccessor.overworldRevisited$getGoatVariant();

        childAccessor.overworldRevisited$setGoatVariant(
                inheritedVariant
        );
    }


    @Unique
    @Override
    public int overworldRevisited$getGoatVariant() {
        Goat goat = (Goat) (Object) this;

        return goat.getEntityData().get(
                OVERWORLD_REVISITED_GOAT_VARIANT
        );
    }


    @Unique
    @Override
    public void overworldRevisited$setGoatVariant(int variant) {
        Goat goat = (Goat) (Object) this;

        goat.getEntityData().set(
                OVERWORLD_REVISITED_GOAT_VARIANT,
                variant
        );
    }
}