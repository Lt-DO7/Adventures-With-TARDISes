package net.awt.world.biome;

import net.awt.AdventuresWithTARDISes;
import net.awt.world.ModPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;

public class ModBiomes {
    public static final RegistryKey<Biome> SKARO_WASTE_LAND = RegistryKey.of(
            RegistryKeys.BIOME, new Identifier(AdventuresWithTARDISes.MOD_ID, "skaro_waste_land"));

    public static void bootstrap(Registerable<Biome> context) {
        var placedFeatures = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        var carvers = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);
        GenerationSettings.LookupBackedBuilder generation = new GenerationSettings.LookupBackedBuilder(placedFeatures, carvers);
        generation.feature(GenerationStep.Feature.UNDERGROUND_ORES, placedFeatures.getOrThrow(ModPlacedFeatures.SKARO_KALETITE_PLACED_KEY));
        generation.feature(GenerationStep.Feature.UNDERGROUND_ORES, placedFeatures.getOrThrow(ModPlacedFeatures.DALEKANIUM_ORE_PLACED_KEY));
        generation.feature(GenerationStep.Feature.VEGETAL_DECORATION, placedFeatures.getOrThrow(ModPlacedFeatures.SKARO_TREE_PLACED_KEY));

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        context.register(SKARO_WASTE_LAND, new Biome.Builder()
                .precipitation(false)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .fogColor(9073756)
                        .skyColor(13872735)
                        .waterColor(5607190)
                        .waterFogColor(2635560)
                        .grassColor(7824977)
                        .foliageColor(6844216)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generation.build())
                .build());
    }
}
