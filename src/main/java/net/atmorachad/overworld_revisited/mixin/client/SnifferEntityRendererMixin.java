package net.atmorachad.overworld_revisited.mixin.client;

import net.atmorachad.overworld_revisited.entity.variant.SnifferEntityAccessor;

import net.fabricmc.fabric.api.client.rendering.v1.FabricRenderState;
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;

import net.minecraft.client.renderer.entity.SnifferRenderer;
import net.minecraft.client.renderer.entity.state.SnifferRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.sniffer.Sniffer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SnifferRenderer.class)
public class SnifferEntityRendererMixin {

    @Unique
    private static final RenderStateDataKey<Integer>
            OVERWORLD_REVISITED_SNIFFER_VARIANT =
            RenderStateDataKey.create(
                    () -> "Overworld Revisited sniffer variant"
            );


    @Unique
    private static final Identifier WARM_SNIFFER_TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "overworld_revisited",
                    "textures/entity/sniffer/warm_sniffer.png"
            );

    @Unique
    private static final Identifier WARM_SNIFFLET_TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "overworld_revisited",
                    "textures/entity/sniffer/warm_snifflet.png"
            );


    @Unique
    private static final Identifier COLD_SNIFFER_TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "overworld_revisited",
                    "textures/entity/sniffer/cold_sniffer.png"
            );

    @Unique
    private static final Identifier COLD_SNIFFLET_TEXTURE =
            Identifier.fromNamespaceAndPath(
                    "overworld_revisited",
                    "textures/entity/sniffer/cold_snifflet.png"
            );


    /*
     * Copy our custom variant from the actual Sniffer
     * into its render state.
     */
    @Inject(
            method = "extractRenderState",
            at = @At("TAIL")
    )
    private void overworldRevisited$extractSnifferVariant(
            Sniffer sniffer,
            SnifferRenderState state,
            float partialTicks,
            CallbackInfo ci
    ) {
        int variant =
                ((SnifferEntityAccessor) sniffer)
                        .overworldRevisited$getSnifferVariant();

        ((FabricRenderState) state).setData(
                OVERWORLD_REVISITED_SNIFFER_VARIANT,
                variant
        );
    }


    /*
     * Choose our custom texture.
     *
     * NORMAL is deliberately left untouched so vanilla
     * chooses its ordinary Sniffer/Snifflet texture.
     */
    @Inject(
            method = "getTextureLocation",
            at = @At("HEAD"),
            cancellable = true
    )
    private void overworldRevisited$getSnifferTexture(
            SnifferRenderState state,
            CallbackInfoReturnable<Identifier> cir
    ) {
        int variant =
                ((FabricRenderState) state).getDataOrDefault(
                        OVERWORLD_REVISITED_SNIFFER_VARIANT,
                        SnifferEntityAccessor.NORMAL
                );

        switch (variant) {
            case SnifferEntityAccessor.WARM ->
                    cir.setReturnValue(
                            state.isBaby
                                    ? WARM_SNIFFLET_TEXTURE
                                    : WARM_SNIFFER_TEXTURE
                    );

            case SnifferEntityAccessor.COLD ->
                    cir.setReturnValue(
                            state.isBaby
                                    ? COLD_SNIFFLET_TEXTURE
                                    : COLD_SNIFFER_TEXTURE
                    );
        }
    }
}