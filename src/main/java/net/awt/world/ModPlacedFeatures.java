package net.awt.world;

import net.awt.AdventuresWithTARDISes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ATRIUM_ORE_PLACED_KEY =
            registerKey("atrium_ore_placed");

    public static final RegistryKey<PlacedFeature> PREHISTORIC_ORE_PLACED_KEY =
            registerKey("prehistoric_ore_placed");

    public static final RegistryKey<PlacedFeature> DALEKANIUM_ORE_PLACED_KEY =
            registerKey("dalekanium_ore_placed");
    public static final RegistryKey<PlacedFeature> SKARO_KALETITE_PLACED_KEY =
            registerKey("skaro_kaletite_placed");
    public static final RegistryKey<PlacedFeature> SKARO_TREE_PLACED_KEY =
            registerKey("skaro_tree_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {

        var configured = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context,
                ATRIUM_ORE_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.ATRIUM_ORE_KEY),
                ModOreGeneration.modifiersWithCount(
                        8,
                        HeightRangePlacementModifier.uniform(
                                YOffset.fixed(-64),
                                YOffset.fixed(16)
                        )
                )
        );

        register(context,
                PREHISTORIC_ORE_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.PREHISTORIC_ORE_KEY),
                ModOreGeneration.modifiersWithCount(
                        8,
                        HeightRangePlacementModifier.uniform(
                                YOffset.fixed(-64),
                                YOffset.fixed(16)
                        )
                )
        );

        register(context,
                DALEKANIUM_ORE_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.DALEKANIUM_ORE_KEY),
                ModOreGeneration.modifiersWithCount(
                        14,
                        HeightRangePlacementModifier.uniform(
                                YOffset.fixed(-64),
                                YOffset.fixed(96)
                        )
                )
        );

        register(context,
                SKARO_KALETITE_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.SKARO_KALETITE_KEY),
                ModOreGeneration.modifiersWithCount(
                        40,
                        HeightRangePlacementModifier.uniform(
                                YOffset.fixed(-64),
                                YOffset.fixed(192)
                        )
                )
        );

        register(context,
                SKARO_TREE_PLACED_KEY,
                configured.getOrThrow(ModConfiguredFeatures.SKARO_TREE_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(8),
                        SquarePlacementModifier.of(),
                        HeightmapPlacementModifier.of(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES),
                        BiomePlacementModifier.of()
                )
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE,
                new Identifier(AdventuresWithTARDISes.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<PlacedFeature> context,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> configuration,
            PlacementModifier... modifiers) {

        register(context, key, configuration, List.of(modifiers));
    }
}
