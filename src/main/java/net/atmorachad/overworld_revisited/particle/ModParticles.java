package net.atmorachad.overworld_revisited.particle;

import net.atmorachad.overworld_revisited.OverworldRevisited;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModParticles {

    public static final SimpleParticleType YELLOW_BIRCH_LEAVES =
            register("yellow_birch_leaves", FabricParticleTypes.simple());

    private static SimpleParticleType register(String name, SimpleParticleType particle) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE,
                Identifier.fromNamespaceAndPath(OverworldRevisited.MOD_ID, name), particle);
    }


    public static void registerModParticles() {
        OverworldRevisited.LOGGER.info("Registering Mod Particles for " + OverworldRevisited.MOD_ID);
    }
}
