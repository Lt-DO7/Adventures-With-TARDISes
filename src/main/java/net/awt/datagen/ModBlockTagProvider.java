package net.awt.datagen;


import net.awt.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);}

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.WHITE_CONCRETE_ROUNDEL)
                .add(ModBlocks.BLACK_CONCRETE_ROUNDEL)
                .add(ModBlocks.END_STONE_BRICKS_ROUNDEL)
                .add(ModBlocks.GRAY_CONCRETE_ROUNDEL)
                .add(ModBlocks.GREEN_CONCRETE_ROUNDEL)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_ROUNDEL)
                .add(ModBlocks.POLISHED_ANDESITE_ROUNDEL)
                .add(ModBlocks.POLISHED_DEEPSLATE_ROUNDEL)
                .add(ModBlocks.POLISHED_GRANITE_ROUNDEL)
                .add(ModBlocks.POLISHED_DIORITE_ROUNDEL)
                .add(ModBlocks.QUARTZ_ROUNDEL)
                .add(ModBlocks.AMBQUARTZ_ROUNDEL)
                .add(ModBlocks.BLUEQUARTZ_ROUNDEL)
                .add(ModBlocks.CRIMQUARTZ_ROUNDEL)
                .add(ModBlocks.VERDQUARTZ_ROUNDEL)
                .add(ModBlocks.VIOQUARTZ_ROUNDEL)
                .add(ModBlocks.OBSIQUARTZ_ROUNDEL)
                .add(ModBlocks.SANDSTONE_ROUNDEL)
                .add(ModBlocks.CYAN_CONCRETE_ROUNDEL)
                .add(ModBlocks.YELLOW_CONCRETE_ROUNDEL)
                .add(ModBlocks.WEATHERED_COPPER_ROUNDEL)
                .add(ModBlocks.RED_CONCRETE_ROUNDEL)
                .add(ModBlocks.PURPLE_CONCRETE_ROUNDEL)
                .add(ModBlocks.PINK_CONCRETE_ROUNDEL)
                .add(ModBlocks.BROWN_CONCRETE_ROUNDEL)
                .add(ModBlocks.ORANGE_CONCRETE_ROUNDEL)
                .add(ModBlocks.OXIDIZED_COPPER_ROUNDEL)
                .add(ModBlocks.LIME_CONCRETE_ROUNDEL)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_ROUNDEL)
                .add(ModBlocks.BLUE_CONCRETE_ROUNDEL)
                .add(ModBlocks.EXPOSED_COPPER_ROUNDEL)
                .add(ModBlocks.COPPER_ROUNDEL)
                .add(ModBlocks.HARTNELL_ROUNDEL)
                .add(ModBlocks.HARTNELL_WALL)
                .add(ModBlocks.COBBLED_KALETITE)
                .add(ModBlocks.KALETITE)
                .add(ModBlocks.KALETITE_BRICKS)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ATRIUM_BLOCK)
                .add(ModBlocks.ATRIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ATRIUM_ORE)

                .add(ModBlocks.PREHISTORIC_BLOCK)
                .add(ModBlocks.PREHISTORIC_ORE)
                .add(ModBlocks.DEEPSLATE_PREHISTORIC_ORE)

                .add(ModBlocks.DALEKANIUM_BLOCK)
                .add(ModBlocks.DALEKANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_DALEKANIUM_ORE)

                .add(ModBlocks.STEEL_BLOCK)

                .add(ModBlocks.METALERTANIUM_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.THE_MOMENT)
        ;


        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")));

        getOrCreateTagBuilder(BlockTags.FENCES)
        ;

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
        ;

        getOrCreateTagBuilder(BlockTags.WALLS)
        ;

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PREHISTORIC_PLANKS)
                .add(ModBlocks.PREHISTORIC_LOG)
                .add(ModBlocks.PREHISTORIC_STAIRS)
                .add(ModBlocks.PREHISTORIC_SLAB)
              //  .add(ModBlocks.WASTED_BUTTON)
              //  .add(ModBlocks.WASTED_DOOR)
                .add(ModBlocks.WASTED_LEAVES)
               // .add(ModBlocks.WASTED_BUSH_PLANT)
                .add(ModBlocks.WASTED_LOG)
                .add(ModBlocks.WASTED_PLANK_SLAB)
               // .add(ModBlocks.WASTED_PLANK_STAIRS)
                .add(ModBlocks.WASTED_PLANKS)
              //  .add(ModBlocks.WASTED_PRESSURE_PLATE)
               // .add(ModBlocks.WASTED_TRAP_DOOR)
        ;


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ATRIUM_BLOCK)
                .add(ModBlocks.ATRIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ATRIUM_ORE)
                .add(ModBlocks.THE_MOMENT)
                .add(ModBlocks.WHITE_CONCRETE_ROUNDEL)
                .add(ModBlocks.BLACK_CONCRETE_ROUNDEL)
                .add(ModBlocks.END_STONE_BRICKS_ROUNDEL)
                .add(ModBlocks.GRAY_CONCRETE_ROUNDEL)
                .add(ModBlocks.GREEN_CONCRETE_ROUNDEL)
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_ROUNDEL)
                .add(ModBlocks.POLISHED_ANDESITE_ROUNDEL)
                .add(ModBlocks.POLISHED_DEEPSLATE_ROUNDEL)
                .add(ModBlocks.POLISHED_GRANITE_ROUNDEL)
                .add(ModBlocks.POLISHED_DIORITE_ROUNDEL)
                .add(ModBlocks.QUARTZ_ROUNDEL)
                .add(ModBlocks.AMBQUARTZ_ROUNDEL)
                .add(ModBlocks.BLUEQUARTZ_ROUNDEL)
                .add(ModBlocks.CRIMQUARTZ_ROUNDEL)
                .add(ModBlocks.VERDQUARTZ_ROUNDEL)
                .add(ModBlocks.VIOQUARTZ_ROUNDEL)
                .add(ModBlocks.OBSIQUARTZ_ROUNDEL)
                .add(ModBlocks.SANDSTONE_ROUNDEL)
                .add(ModBlocks.CYAN_CONCRETE_ROUNDEL)
                .add(ModBlocks.YELLOW_CONCRETE_ROUNDEL)
                .add(ModBlocks.WEATHERED_COPPER_ROUNDEL)
                .add(ModBlocks.RED_CONCRETE_ROUNDEL)
                .add(ModBlocks.PURPLE_CONCRETE_ROUNDEL)
                .add(ModBlocks.PINK_CONCRETE_ROUNDEL)
                .add(ModBlocks.BROWN_CONCRETE_ROUNDEL)
                .add(ModBlocks.ORANGE_CONCRETE_ROUNDEL)
                .add(ModBlocks.OXIDIZED_COPPER_ROUNDEL)
                .add(ModBlocks.LIME_CONCRETE_ROUNDEL)
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_ROUNDEL)
                .add(ModBlocks.BLUE_CONCRETE_ROUNDEL)
                .add(ModBlocks.EXPOSED_COPPER_ROUNDEL)
                .add(ModBlocks.COPPER_ROUNDEL)
                .add(ModBlocks.HARTNELL_ROUNDEL)
                .add(ModBlocks.HARTNELL_WALL)
                .add(ModBlocks.PREHISTORIC_BLOCK)
                .add(ModBlocks.PREHISTORIC_ORE)
                .add(ModBlocks.DEEPSLATE_PREHISTORIC_ORE)
                .add(ModBlocks.DALEKANIUM_BLOCK)
                .add(ModBlocks.DALEKANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_DALEKANIUM_ORE)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.METALERTANIUM_BLOCK)
                .add(ModBlocks.COBBLED_KALETITE)
                .add(ModBlocks.KALETITE)
                .add(ModBlocks.KALETITE_BRICKS)
        ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.STRIPPED_ACACIA_LOG_ROUNDEL)
                .add(ModBlocks.STRIPPED_BIRCH_LOG_ROUNDEL)
                .add(ModBlocks.STRIPPED_CHERRY_LOG_ROUNDEL)
                .add(ModBlocks.STRIPPED_DARK_OAK_LOG_ROUNDEL)
                .add(ModBlocks.STRIPPED_JUNGLE_LOG_ROUNDEL)
                .add(ModBlocks.STRIPPED_MANGROVE_LOG_ROUNDEL)
                .add(ModBlocks.STRIPPED_OAK_LOG_ROUNDEL)
                .add(ModBlocks.STRIPPED_SPRUCE_LOG_ROUNDEL)
                .add(ModBlocks.PREHISTORIC_PLANKS)
                .add(ModBlocks.PREHISTORIC_LOG)
                .add(ModBlocks.PREHISTORIC_STAIRS)
                .add(ModBlocks.PREHISTORIC_SLAB)
              //  .add(ModBlocks.WASTED_BUTTON)
               // .add(ModBlocks.WASTED_DOOR)
                .add(ModBlocks.WASTED_LEAVES)
              //  .add(ModBlocks.WASTED_BUSH_PLANT)
                .add(ModBlocks.WASTED_LOG)
                .add(ModBlocks.WASTED_PLANK_SLAB)
             //   .add(ModBlocks.WASTED_PLANK_STAIRS)
                .add(ModBlocks.WASTED_PLANKS)
              //  .add(ModBlocks.WASTED_PRESSURE_PLATE)
              //  .add(ModBlocks.WASTED_TRAP_DOOR)
        ;



        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.MOSS_ROUNDEL)
                .add(ModBlocks.DIRT_ROUNDEL)
                .add(ModBlocks.WASTED_DIRT)
              //  .add(ModBlocks.WASTED_GRASS)
        ;

    }
}