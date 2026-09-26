package net.atmorachad.overworld_revisited.mixin;

import net.atmorachad.overworld_revisited.entity.variant.SnifferEntityAccessor;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Sniffer.class)
public abstract class SnifferEntityMixin
        extends Animal
        implements SnifferEntityAccessor {

    

    @Unique
    private static final EntityDataAccessor<Integer>
            OVERWORLD_REVISITED_SNIFFER_VARIANT =
            SynchedEntityData.defineId(
                    Sniffer.class,
                    EntityDataSerializers.INT
            );


    protected SnifferEntityMixin(
            EntityType<? extends Animal> type,
            Level level
    ) {
        super(type, level);
    }


    /*
     * Add our variant value to the Sniffer's synced entity data.
     *
     * 0 = normal
     * 1 = warm
     * 2 = cold
     */
    @Inject(
            method = "defineSynchedData",
            at = @At("TAIL")
    )
    private void overworldRevisited$defineSnifferVariant(
            SynchedEntityData.Builder builder,
            CallbackInfo ci
    ) {
        builder.define(
                OVERWORLD_REVISITED_SNIFFER_VARIANT,
                NORMAL
        );
    }


    /*
     * Sniffer itself does not override this method in vanilla,
     * so we add an override directly to Sniffer through the mixin.
     */
    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);

        output.putInt(
                "OverworldRevisitedSnifferVariant",
                overworldRevisited$getSnifferVariant()
        );
    }


    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);

        overworldRevisited$setSnifferVariant(
                input.getIntOr(
                        "OverworldRevisitedSnifferVariant",
                        NORMAL
                )
        );
    }


    @Unique
    @Override
    public int overworldRevisited$getSnifferVariant() {
        return this.getEntityData().get(
                OVERWORLD_REVISITED_SNIFFER_VARIANT
        );
    }


    @Unique
    @Override
    public void overworldRevisited$setSnifferVariant(int variant) {
        this.getEntityData().set(
                OVERWORLD_REVISITED_SNIFFER_VARIANT,
                variant
        );
    }


}