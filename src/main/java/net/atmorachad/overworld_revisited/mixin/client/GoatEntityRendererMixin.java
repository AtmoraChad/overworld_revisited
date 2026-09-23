package net.atmorachad.overworld_revisited.mixin.client;

import net.atmorachad.overworld_revisited.entity.variant.GoatEntityAccessor;

import net.fabricmc.fabric.api.client.rendering.v1.FabricRenderState;
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;

import net.minecraft.client.renderer.entity.GoatRenderer;
import net.minecraft.client.renderer.entity.state.GoatRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.goat.Goat;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GoatRenderer.class)
public class GoatEntityRendererMixin {

    @Unique
    private static final RenderStateDataKey<Integer> OVERWORLD_REVISITED_GOAT_VARIANT =
            RenderStateDataKey.create(
                    () -> "Overworld Revisited goat variant"
            );


    @Unique
    private static final Identifier BLACK_GOAT_TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "overworld_revisited",
                    "textures/entity/goat/black_goat.png"
            );

    @Unique
    private static final Identifier BLACK_GOAT_BABY_TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "overworld_revisited",
                    "textures/entity/goat/black_goat_baby.png"
            );

    @Unique
    private static final Identifier BROWN_GOAT_TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "overworld_revisited",
                    "textures/entity/goat/brown_goat.png"
            );

    @Unique
    private static final Identifier BROWN_GOAT_BABY_TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "overworld_revisited",
                    "textures/entity/goat/brown_goat_baby.png"
            );


    /*
     * Copy the custom variant from the actual Goat
     * into its render state.
     */
    @Inject(
            method = "extractRenderState",
            at = @At("TAIL")
    )
    private void overworldRevisited$extractGoatVariant(
            Goat goat,
            GoatRenderState state,
            float partialTicks,
            CallbackInfo ci
    ) {
        state.isBaby = goat.isBaby();

        int variant =
                ((GoatEntityAccessor) goat)
                        .overworldRevisited$getGoatVariant();

        ((FabricRenderState) state).setData(
                OVERWORLD_REVISITED_GOAT_VARIANT,
                variant
        );
    }


    /*
     * Override the vanilla goat texture only when
     * this goat has one of our custom variants.
     */
    @Inject(
            method = "getTextureLocation",
            at = @At("HEAD"),
            cancellable = true
    )
    private void overworldRevisited$getGoatTexture(
            GoatRenderState state,
            CallbackInfoReturnable<Identifier> cir
    ) {
        int variant =
                ((FabricRenderState) state).getDataOrDefault(
                        OVERWORLD_REVISITED_GOAT_VARIANT,
                        GoatEntityAccessor.NORMAL
                );

        switch (variant) {
            case GoatEntityAccessor.BLACK ->
                    cir.setReturnValue(
                            state.isBaby
                                    ? BLACK_GOAT_BABY_TEXTURE
                                    : BLACK_GOAT_TEXTURE
                    );

            case GoatEntityAccessor.BROWN ->
                    cir.setReturnValue(
                            state.isBaby
                                    ? BROWN_GOAT_BABY_TEXTURE
                                    : BROWN_GOAT_TEXTURE
                    );
        }
    }
}