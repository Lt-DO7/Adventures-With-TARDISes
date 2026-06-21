package net.awt.world;

import net.awt.AdventuresWithTARDISes;
import net.awt.block.ModBlocks;
import net.awt.world.feature.ModFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ATRIUM_ORE_KEY = registerKey("atrium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTORIC_ORE_KEY = registerKey("prehistoric_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DALEKANIUM_ORE_KEY = registerKey("dalekanium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SKARO_KALETITE_KEY = registerKey("skaro_kaletite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SKARO_TREE_KEY = registerKey("skaro_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);


        List<OreFeatureConfig.Target> atriumOres =
                List.of(
                        OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ATRIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_ATRIUM_ORE.getDefaultState())
                );

        register(context, ATRIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(atriumOres, 6));

        List<OreFeatureConfig.Target> prehistoricOres =
                List.of(
                        OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PREHISTORIC_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_PREHISTORIC_ORE.getDefaultState())
                );
        register(context, PREHISTORIC_ORE_KEY, Feature.ORE, new OreFeatureConfig(prehistoricOres, 1));

        List<OreFeatureConfig.Target> dalekaniumOres =
                List.of(
                        OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.DALEKANIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_DALEKANIUM_ORE.getDefaultState())
                );
        register(context, DALEKANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(dalekaniumOres, 8));

        List<OreFeatureConfig.Target> skaroKaletiteOres =
                List.of(
                        OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.KALETITE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.COBBLED_KALETITE.getDefaultState())
                );
        register(context, SKARO_KALETITE_KEY, Feature.ORE, new OreFeatureConfig(skaroKaletiteOres, 24));
        register(context, SKARO_TREE_KEY, ModFeatures.SKARO_TREE, FeatureConfig.DEFAULT);

    }




    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(AdventuresWithTARDISes.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
