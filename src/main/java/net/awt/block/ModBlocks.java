package net.awt.block;

import net.awt.AdventuresWithTARDISes;
import net.awt.block.custom.RoundelBlock;
import net.awt.fluid.ModFluids;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //AWT

    public static final Block ATRIUM_BLOCK = registerBlock("atrium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block THE_MOMENT = registerBlock("the_moment",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.ANVIL).requiresTool()));

    public static final Block ATRIUM_ORE = registerBlock("atrium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block DEEPSLATE_ATRIUM_ORE = registerBlock("deepslate_atrium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block GRATE_BLOCK = registerBlock("grate_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BARS).sounds(BlockSoundGroup.CHAIN).requiresTool()));

    public static final Block THICK_GRATE_BLOCK = registerBlock("thick_grate_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BARS).sounds(BlockSoundGroup.CHAIN).requiresTool()));

    public static final Block RUSTY_GRATE_BLOCK = registerBlock("rusty_grate_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BARS).sounds(BlockSoundGroup.CHAIN).requiresTool()));

    public static final Block RUSTY_THICK_GRATE_BLOCK = registerBlock("rusty_thick_grate_block",
            new GlassBlock(FabricBlockSettings.copyOf(Blocks.IRON_BARS).sounds(BlockSoundGroup.CHAIN).requiresTool()));

    public static final Block LOST_DIRT = registerBlock("lost_dirt",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.GRASS)));


    //roundels

        //Misc Roundels
    public static final Block MOSS_ROUNDEL = registerBlock("moss_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK).sounds(BlockSoundGroup.MOSS_BLOCK)));

    public static final Block DIRT_ROUNDEL = registerBlock("dirt_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.GRASS)));

        //Sand Roundels
    public static final Block END_STONE_BRICKS_ROUNDEL = registerBlock("end_stone_bricks_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block POLISHED_ANDESITE_ROUNDEL = registerBlock("polished_andesite_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block POLISHED_DEEPSLATE_ROUNDEL = registerBlock("polished_deepslate_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.POLISHED_DEEPSLATE).requiresTool()));

    public static final Block POLISHED_DIORITE_ROUNDEL = registerBlock("polished_diorite_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block POLISHED_GRANITE_ROUNDEL = registerBlock("polished_granite_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block QUARTZ_ROUNDEL = registerBlock("quartz_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block SANDSTONE_ROUNDEL = registerBlock("sandstone_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));
        //Wood Roundels
    public static final Block STRIPPED_ACACIA_LOG_ROUNDEL = registerBlock("stripped_acacia_log_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_BIRCH_LOG_ROUNDEL = registerBlock("stripped_birch_log_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_CHERRY_LOG_ROUNDEL = registerBlock("stripped_cherry_log_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.CHERRY_WOOD)));

    public static final Block STRIPPED_DARK_OAK_LOG_ROUNDEL = registerBlock("stripped_dark_oak_log_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_JUNGLE_LOG_ROUNDEL = registerBlock("stripped_jungle_log_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_MANGROVE_LOG_ROUNDEL = registerBlock("stripped_mangrove_log_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_OAK_LOG_ROUNDEL = registerBlock("stripped_oak_log_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_SPRUCE_LOG_ROUNDEL = registerBlock("stripped_spruce_log_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.WOOD)));

        //Copper Roundels
    public static final Block COPPER_ROUNDEL = registerBlock("copper_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.COPPER).requiresTool()));

    public static final Block EXPOSED_COPPER_ROUNDEL = registerBlock("exposed_copper_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.COPPER).requiresTool()));

    public static final Block OXIDIZED_COPPER_ROUNDEL = registerBlock("oxidized_copper_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.COPPER).requiresTool()));

    public static final Block WEATHERED_COPPER_ROUNDEL = registerBlock("weathered_copper_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.COPPER).requiresTool()));

        //Concrete Roundels
    public static final Block ORANGE_CONCRETE_ROUNDEL = registerBlock("orange_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block PINK_CONCRETE_ROUNDEL = registerBlock("pink_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block PURPLE_CONCRETE_ROUNDEL = registerBlock("purple_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block RED_CONCRETE_ROUNDEL = registerBlock("red_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block YELLOW_CONCRETE_ROUNDEL = registerBlock("yellow_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block WHITE_CONCRETE_ROUNDEL = registerBlock("white_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block BLACK_CONCRETE_ROUNDEL = registerBlock("black_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block CYAN_CONCRETE_ROUNDEL = registerBlock("cyan_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block LIGHT_BLUE_CONCRETE_ROUNDEL = registerBlock("light_blue_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block LIME_CONCRETE_ROUNDEL = registerBlock("lime_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block MAGENTA_CONCRETE_ROUNDEL = registerBlock("magenta_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block BLUE_CONCRETE_ROUNDEL = registerBlock("blue_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block BROWN_CONCRETE_ROUNDEL = registerBlock("brown_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block GRAY_CONCRETE_ROUNDEL = registerBlock("gray_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block GREEN_CONCRETE_ROUNDEL = registerBlock("green_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block LIGHT_GRAY_CONCRETE_ROUNDEL = registerBlock("light_gray_concrete_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block BLUEQUARTZ_ROUNDEL = registerBlock("bluequartz_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block CRIMQUARTZ_ROUNDEL = registerBlock("crimquartz_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));

    public static final Block VERDQUARTZ_ROUNDEL = registerBlock("verdquartz_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));

    public static final Block AMBQUARTZ_ROUNDEL = registerBlock("ambquartz_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));

    public static final Block VIOQUARTZ_ROUNDEL = registerBlock("vioquartz_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));

    public static final Block OBSIQUARTZ_ROUNDEL = registerBlock("obsiquartz_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));

    public static final Block HARTNELL_ROUNDEL = registerBlock("hartnell_roundel",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block HARTNELL_WALL = registerBlock("hartnell_wall",
            new RoundelBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    //prehistoric blocks

    public static final Block PREHISTORIC_BLOCK = registerBlock("prehistoric_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.DEEPSLATE).requiresTool().strength(1.5F, 3.0F)));

    public static final Block PREHISTORIC_ORE = registerBlock("prehistoric_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.STONE).requiresTool().strength(1.5F, 3.0F)));

    public static final Block DEEPSLATE_PREHISTORIC_ORE = registerBlock("deepslate_prehistoric_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.STONE).requiresTool().strength(1.5F, 3.0F)));

    public static final Block PREHISTORIC_PLANKS = registerBlock("prehistoric_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS).sounds(BlockSoundGroup.WOOD)));

    public static final Block PREHISTORIC_LOG = registerBlock("prehistoric_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_LOG).sounds(BlockSoundGroup.WOOD)));

    public static final Block PREHISTORIC_STAIRS = registerBlock("prehistoric_stairs",
            new StairsBlock(ModBlocks.PREHISTORIC_PLANKS.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.SPRUCE_STAIRS)));

    public static final Block PREHISTORIC_SLAB = registerBlock("prehistoric_slab",
            new SlabBlock(FabricBlockSettings.copyOf(PREHISTORIC_PLANKS)));

    public static final Block PREHISTORIC_LEAVES = registerBlock("prehistoric_leaves",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_LEAVES).sounds(BlockSoundGroup.CHERRY_LEAVES)));

    //Dalekanium Blocks

    public static final Block DALEKANIUM_BLOCK = registerBlock("dalekanium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.DEEPSLATE).requiresTool().strength(1.5F, 3.0F)));

    public static final Block DALEKANIUM_ORE = registerBlock("dalekanium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE).sounds(BlockSoundGroup.STONE).requiresTool().strength(1.5F, 3.0F)));

    public static final Block DEEPSLATE_DALEKANIUM_ORE = registerBlock("deepslate_dalekanium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE).sounds(BlockSoundGroup.STONE).requiresTool().strength(1.5F, 3.0F)));

    //Steel Blocks

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.NETHERITE).requiresTool().strength(1.5F, 3.0F)));

    //Metalertanium Blocks

    public static final Block METALERTANIUM_BLOCK = registerBlock("metalertanium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.NETHERITE).requiresTool()));


    //Skaro

    public static final Block ECAT  = registerBlock("exquisite_cat",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));

    public static final Block GOODHEAVENS = registerBlock("good_heavens",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));

    public static final Block COBBLED_KALETITE = registerBlock("cobbled_kaletite",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block KALETITE = registerBlock("kaletite",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block KALETITE_BRICKS = registerBlock("kaletite_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE).requiresTool()));

  //  public static final Block WASTED_BUSH_PLANT = registerBlock("wasted_bush_plant",
  //          new RoundelBlock(FabricBlockSettings.copyOf(Blocks.GRASS).sounds(BlockSoundGroup.GRASS)));

 //   public static final Block WASTED_BUTTON = registerBlock("wasted_button",
   //         new RoundelBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON).sounds(BlockSoundGroup.WOOD)));

    public static final Block WASTED_DIRT = registerBlock("wasted_dirt",
            new GlassBlock(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.ROOTED_DIRT)));

  // public static final Block WASTED_DOOR = registerBlock("wasted_door",
         //  new DoorBlock(DoorBlocks.WASTED_DOOR.getDefaultState(),
               //    FabricBlockSettings.copyOf(Blocks.OAK_DOOR)));

    public static final Block WASTED_LEAVES = registerBlock("wasted_leaves",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.AZALEA_LEAVES)));

    public static final Block WASTED_LOG = registerBlock("wasted_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).sounds(BlockSoundGroup.WOOD)));

    public static final Block WASTED_PLANK_SLAB = registerBlock("wasted_plank_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).sounds(BlockSoundGroup.WOOD)));

  // public static final Block WASTED_PLANK_STAIRS = registerBlock("wasted_plank_stairs",
       //    new StairsBlock(ModBlocks.WASTED_PLANK_STAIRS.getDefaultState(),
             //      FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));

    public static final Block WASTED_PLANKS = registerBlock("wasted_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)));

  //  public static final Block WASTED_PRESSURE_PLATE = registerBlock("wasted_pressure_plate",
    //        new RoundelBlock(FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE).sounds(BlockSoundGroup.WOOD)));

   // public static final Block WASTED_TRAP_DOOR = registerBlock("wasted_trapdoor",
   //         new RoundelBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).sounds(BlockSoundGroup.WOOD).requiresTool()));

    public static final Block WASTED_GRASS = registerBlock("wastedgrass",
            new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).sounds(BlockSoundGroup.ROOTED_DIRT)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AdventuresWithTARDISes.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(AdventuresWithTARDISes.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(AdventuresWithTARDISes.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

    }

    public static void registerModBlocks() {
        AdventuresWithTARDISes.LOGGER.info("Registering ModBlocks for" + AdventuresWithTARDISes.MOD_ID);


    }
}
