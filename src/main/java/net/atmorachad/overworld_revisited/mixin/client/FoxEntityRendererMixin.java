package net.atmorachad.overworld_revisited.mixin.client;

import net.atmorachad.overworld_revisited.entity.variant.FoxEntityAccessor;

import net.fabricmc.fabric.api.client.rendering.v1.FabricRenderState;
import net.fabricmc.fabric.api.client.rendering.v1.RenderStateDataKey;

import net.minecraft.client.renderer.entity.FoxRenderer;
import net.minecraft.client.renderer.entity.state.FoxRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.fox.Fox;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FoxRenderer.class)
public class FoxEntityRendererMixin {

    /*
     * Fabric gives EntityRenderState extra-data storage.
     *
     * This replaces the need for a separate FoxRenderStateMixin.
     */
    @Unique
    private static final RenderStateDataKey<Integer> OVERWORLD_REVISITED_FOX_VARIANT =
            RenderStateDataKey.create(
                    () -> "Overworld Revisited fox variant"
            );


    @Unique
    private static final Identifier[] TIMBER_TEXTURES =
            overworldRevisited$createTextures("timber_fox");

    @Unique
    private static final Identifier[] BLACK_TEXTURES =
            overworldRevisited$createTextures("black_fox");

    @Unique
    private static final Identifier[] BIRCH_TEXTURES =
            overworldRevisited$createTextures("birch_fox");

    @Unique
    private static final Identifier[] CINNAMON_TEXTURES =
            overworldRevisited$createTextures("cinnamon_fox");


    /*
     * Copy the fox's tracked variant into its render state.
     */
    @Inject(
            method = "extractRenderState",
            at = @At("TAIL")
    )
    private void overworldRevisited$extractFoxVariant(
            Fox fox,
            FoxRenderState state,
            float partialTicks,
            CallbackInfo ci
    ) {
        int variant =
                ((FoxEntityAccessor) fox)
                        .overworldRevisited$getFoxVariant();

        ((FabricRenderState) state).setData(
                OVERWORLD_REVISITED_FOX_VARIANT,
                variant
        );
    }


    /*
     * Select custom texture.
     *
     * NORMAL does nothing, so vanilla's Red/Snow texture
     * selection continues normally.
     */
    @Inject(
            method = "getTextureLocation",
            at = @At("HEAD"),
            cancellable = true
    )
    private void overworldRevisited$getFoxTexture(
            FoxRenderState state,
            CallbackInfoReturnable<Identifier> cir
    ) {
        int variant =
                ((FabricRenderState) state).getDataOrDefault(
                        OVERWORLD_REVISITED_FOX_VARIANT,
                        FoxEntityAccessor.NORMAL
                );

        Identifier[] textures = switch (variant) {
            case FoxEntityAccessor.TIMBER -> TIMBER_TEXTURES;
            case FoxEntityAccessor.BLACK -> BLACK_TEXTURES;
            case FoxEntityAccessor.BIRCH -> BIRCH_TEXTURES;
            case FoxEntityAccessor.CINNAMON -> CINNAMON_TEXTURES;

            default -> null;
        };

        if (textures != null) {
            cir.setReturnValue(
                    overworldRevisited$chooseTexture(
                            state,
                            textures
                    )
            );
        }
    }


    /*
     * Texture array:
     *
     * 0 = adult awake
     * 1 = adult asleep
     * 2 = baby awake
     * 3 = baby asleep
     */
    @Unique
    private static Identifier overworldRevisited$chooseTexture(
            FoxRenderState state,
            Identifier[] textures
    ) {
        int index;

        if (state.isBaby) {
            index = state.isSleeping ? 3 : 2;
        } else {
            index = state.isSleeping ? 1 : 0;
        }

        return textures[index];
    }


    @Unique
    private static Identifier[] overworldRevisited$createTextures(
            String name
    ) {
        return new Identifier[] {
                Identifier.fromNamespaceAndPath(
                        "overworld_revisited",
                        "textures/entity/fox/" + name + ".png"
                ),

                Identifier.fromNamespaceAndPath(
                        "overworld_revisited",
                        "textures/entity/fox/" + name + "_sleep.png"
                ),

                Identifier.fromNamespaceAndPath(
                        "overworld_revisited",
                        "textures/entity/fox/" + name + "_baby.png"
                ),

                Identifier.fromNamespaceAndPath(
                        "overworld_revisited",
                        "textures/entity/fox/" + name + "_baby_sleep.png"
                )
        };
    }
}