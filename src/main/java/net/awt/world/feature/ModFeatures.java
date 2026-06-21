package net.awt.world.feature;

import net.awt.AdventuresWithTARDISes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {
    public static final Feature<DefaultFeatureConfig> SKARO_TREE = Registry.register(
            Registries.FEATURE,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "skaro_tree"),
            new SkaroTreeFeature()
    );

    public static void registerModFeatures() {
        AdventuresWithTARDISes.LOGGER.info("Registering ModFeatures for " + AdventuresWithTARDISes.MOD_ID);
    }
}
