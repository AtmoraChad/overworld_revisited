package net.atmorachad.overworld_revisited.util;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.biolith.api.biome.BiolithFittestNodes;
import com.terraformersmc.biolith.api.biome.sub.Criterion;
import com.terraformersmc.biolith.api.biome.sub.CriterionType;
import com.terraformersmc.biolith.api.biome.sub.CriterionTypes;
import com.terraformersmc.biolith.impl.biome.DimensionBiomePlacement;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import org.jspecify.annotations.Nullable;

public record MinYCriterion(int minY) implements Criterion {

    public static final MapCodec<MinYCriterion> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    com.mojang.serialization.Codec.INT.fieldOf("min_y")
                            .forGetter(MinYCriterion::minY)
            ).apply(instance, MinYCriterion::new)
    );

    public static final CriterionType<MinYCriterion> TYPE =
            CriterionTypes.add(
                    CriterionType.createType(
                            CODEC,
                            Identifier.fromNamespaceAndPath(
                                    "overworld_revisited",
                                    "min_y"
                            )
                    )
            );

    @Override
    public CriterionType<MinYCriterion> getType() {
        return TYPE;
    }

    @Override
    public MapCodec<MinYCriterion> getCodec() {
        return CODEC;
    }

    @Override
    public boolean matches(

            BiolithFittestNodes<Holder<Biome>> fittestNodes,
            DimensionBiomePlacement biomePlacement,
            Climate.TargetPoint noisePoint,
            @Nullable InclusiveRange<Float> replacementRange,
            float replacementNoise
    ) {
        System.out.println("!!! MIN_Y CRITERION CALLED !!!");

        int biomeY = QuartPos.toBlock(
                DimensionBiomePlacement.getEvaluatingBiomePos().getY()
        );

        System.out.println("!!! BIOME Y = " + biomeY + " / MIN Y = " + minY + " !!!");

        return biomeY >= minY;
    }
}