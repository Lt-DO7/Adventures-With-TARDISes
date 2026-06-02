package net.awt.item;

import net.awt.AdventuresWithTARDISes;
import net.awt.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ATRIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "atrium"),
            FabricItemGroup.builder().displayName(Text.translatable("item_group.Atrium"))
                    .icon(() -> new ItemStack(ModItems.ATRIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ATRIUM);
                        entries.add(ModItems.ENERGIZEDATRIUM);
                        entries.add(ModItems.ATRIUMCORE);
                        entries.add(ModItems.PROCESSINGUNIT);
                        entries.add(ModItems.ATRIUM_FUEL);
                        entries.add(ModItems.WEAPON_MATRIX);

                        //blocks
                        entries.add(ModBlocks.ATRIUM_BLOCK);
                        entries.add(ModBlocks.ATRIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ATRIUM_ORE);


                        //misc
                        // entries.add(ModBlocks.THE_MOMENT);

                        //useable items

                        entries.add(ModItems.SONIC_GLASSES);
                        entries.add(ModItems.DBZ_SCOUTER);

                        entries.add(ModItems.VORTEX_MANIPULATOR);
                        entries.add(ModItems.VORTEX_MANIPULATOR2);

                        entries.add(ModItems.SPOON);

                        //Dalekanium Shite

                        entries.add(ModItems.DALEKANIUM_INGOT);
                        entries.add(ModItems.LIQUID_DALEKANIUM);
                        entries.add(ModItems.DALEKANIUM_SWORD);
                        entries.add(ModItems.DALEKANIUM_PICKAXE);
                        entries.add(ModItems.DALEKANIUM_AXE);
                        entries.add(ModItems.DALEKANIUM_SHOVEL);
                        entries.add(ModItems.DALEKANIUM_HOE);
                        entries.add(ModItems.DALEKANIUM_HELMET);
                        entries.add(ModItems.DALEKANIUM_CHESTPLATE);
                        entries.add(ModItems.DALEKANIUM_LEGGINGS);
                        entries.add(ModItems.DALEKANIUM_BOOTS);

                        entries.add(ModBlocks.DALEKANIUM_BLOCK);
                        entries.add(ModBlocks.DALEKANIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_DALEKANIUM_ORE);

                        //Steel

                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.STEEL_TEMPLATE);
                        entries.add(ModItems.STEEL_SWORD);
                        entries.add(ModItems.STEEL_PICKAXE);
                        entries.add(ModItems.STEEL_AXE);
                        entries.add(ModItems.STEEL_SHOVEL);
                        entries.add(ModItems.STEEL_HOE);
                        entries.add(ModItems.STEEL_HELMET);
                        entries.add(ModItems.STEEL_CHESTPLATE);
                        entries.add(ModItems.STEEL_LEGGINGS);
                        entries.add(ModItems.STEEL_BOOTS);

                        entries.add(ModBlocks.STEEL_BLOCK);

                        //Metalertanium

                        entries.add(ModItems.METALERTANIUM_INGOT);
                        entries.add(ModItems.LIQUID_METALERTANIUM);
                        entries.add(ModItems.METALERTANIUM_SWORD);
                        entries.add(ModItems.METALERTANIUM_PICKAXE);
                        entries.add(ModItems.METALERTANIUM_AXE);
                        entries.add(ModItems.METALERTANIUM_SHOVEL);
                        entries.add(ModItems.METALERTANIUM_HOE);
                        entries.add(ModItems.METALERTANIUM_HELMET);
                        entries.add(ModItems.METALERTANIUM_CHESTPLATE);
                        entries.add(ModItems.METALERTANIUM_LEGGINGS);
                        entries.add(ModItems.METALERTANIUM_BOOTS);

                        entries.add(ModBlocks.METALERTANIUM_BLOCK);

                        //music discs
                        entries.add(ModItems.DRWHOVALE_MUSIC_DISC);
                        entries.add(ModItems.DUGGA_DOO_MUSIC_DISC);
                        entries.add(ModItems.DOCTORWHOXV_MUSIC_DISC);
                        entries.add(ModItems.PARALYZER_MUSIC_DISC);
                        entries.add(ModItems.DOCTORWHO1411_MUSIC_DISC);

                        //spawn eggs
                        entries.add(ModItems.K9_SPAWN_EGG);
                        entries.add(ModItems.CYBERMAT_SPAWN_EGG);

                    }).build());

    public static final ItemGroup ROUNDEL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "roundel"),
            FabricItemGroup.builder().displayName(Text.translatable("item_group.awt.Roundel"))
                    .icon(() -> new ItemStack(ModBlocks.HARTNELL_ROUNDEL)).entries((displayContext, entries) -> {

                        //roundels

                        entries.add(ModBlocks.HARTNELL_ROUNDEL);
                        entries.add(ModBlocks.WHITE_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.BLACK_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.CYAN_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.DIRT_ROUNDEL);
                        entries.add(ModBlocks.END_STONE_BRICKS_ROUNDEL);
                        entries.add(ModBlocks.GRAY_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.GREEN_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.LIGHT_GRAY_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.POLISHED_ANDESITE_ROUNDEL);
                        entries.add(ModBlocks.POLISHED_DEEPSLATE_ROUNDEL);
                        entries.add(ModBlocks.POLISHED_DIORITE_ROUNDEL);
                        entries.add(ModBlocks.POLISHED_GRANITE_ROUNDEL);
                        entries.add(ModBlocks.QUARTZ_ROUNDEL);
                        entries.add(ModBlocks.AMBQUARTZ_ROUNDEL);
                        entries.add(ModBlocks.BLUEQUARTZ_ROUNDEL);
                        entries.add(ModBlocks.CRIMQUARTZ_ROUNDEL);
                        entries.add(ModBlocks.VERDQUARTZ_ROUNDEL);
                        entries.add(ModBlocks.VIOQUARTZ_ROUNDEL);
                        entries.add(ModBlocks.OBSIQUARTZ_ROUNDEL);
                        entries.add(ModBlocks.SANDSTONE_ROUNDEL);
                        entries.add(ModBlocks.STRIPPED_ACACIA_LOG_ROUNDEL);
                        entries.add(ModBlocks.STRIPPED_BIRCH_LOG_ROUNDEL);
                        entries.add(ModBlocks.STRIPPED_CHERRY_LOG_ROUNDEL);
                        entries.add(ModBlocks.STRIPPED_DARK_OAK_LOG_ROUNDEL);
                        entries.add(ModBlocks.STRIPPED_JUNGLE_LOG_ROUNDEL);
                        entries.add(ModBlocks.STRIPPED_MANGROVE_LOG_ROUNDEL);
                        entries.add(ModBlocks.STRIPPED_OAK_LOG_ROUNDEL);
                        entries.add(ModBlocks.STRIPPED_SPRUCE_LOG_ROUNDEL);
                        entries.add(ModBlocks.BLUE_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.BROWN_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.COPPER_ROUNDEL);
                        entries.add(ModBlocks.EXPOSED_COPPER_ROUNDEL);
                        entries.add(ModBlocks.LIGHT_BLUE_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.LIME_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.MAGENTA_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.MOSS_ROUNDEL);
                        entries.add(ModBlocks.ORANGE_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.OXIDIZED_COPPER_ROUNDEL);
                        entries.add(ModBlocks.PINK_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.PURPLE_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.RED_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.YELLOW_CONCRETE_ROUNDEL);
                        entries.add(ModBlocks.WEATHERED_COPPER_ROUNDEL);
                        entries.add(ModItems.ROUNDELMOLD);

                        //none roundels

                        entries.add(ModBlocks.HARTNELL_WALL);
                        entries.add(ModBlocks.GRATE_BLOCK);
                        entries.add(ModBlocks.THICK_GRATE_BLOCK);
                        entries.add(ModBlocks.RUSTY_GRATE_BLOCK);
                        entries.add(ModBlocks.RUSTY_THICK_GRATE_BLOCK);

                    }).build());
    public static final ItemGroup CLOTHING_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "clothing"),
            FabricItemGroup.builder().displayName(Text.translatable("item_group.awt.Clothing"))
                    .icon(() -> new ItemStack(ModItems.FANCYFEZ)).entries((displayContext, entries) -> {
                        //fezzes
                        entries.add(ModItems.FEZ);
                        entries.add(ModItems.FANCYFEZ);
                        entries.add(ModItems.PURPLEFEZ);
                        entries.add(ModItems.GREENFEZ);
                        entries.add(ModItems.ORANGEFEZ);
                        entries.add(ModItems.PINKFEZ);
                        entries.add(ModItems.GREYFEZ);
                        entries.add(ModItems.BLUEFEZ);
                        entries.add(ModItems.DARKBLUEFEZ);
                        entries.add(ModItems.YELLOWFEZ);

                        //bowties
                        entries.add(ModItems.BOWTIE);
                        entries.add(ModItems.BLUEBOWTIE);
                        entries.add(ModItems.CYANBOWTIE);
                        entries.add(ModItems.ORANGEBOWTIE);
                        entries.add(ModItems.MAGENTABOWTIE);
                        entries.add(ModItems.PURPLEBOWTIE);
                        entries.add(ModItems.GREYBOWTIE);
                        entries.add(ModItems.GREENBOWTIE);

                        //misc
                        entries.add(ModItems.EYESTALK);
                        entries.add(ModItems.TRUSTABLE_HAT);

                    }).build());

    public static final ItemGroup PREHISTORIC_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdventuresWithTARDISes.MOD_ID, "prehistoric"),
            FabricItemGroup.builder().displayName(Text.translatable("item_group.awt.Prehistoric"))
                    .icon(() -> new ItemStack(ModBlocks.PREHISTORIC_BLOCK)).entries((displayContext, entries) -> {

                        //items
                        entries.add(ModItems.PREHISTORIC_INGOT);
                        entries.add(ModItems.PREHISTORIC_TEMPLATE);

                        //tools
                        entries.add(ModItems.PREHISTORIC_SWORD);
                        entries.add(ModItems.PREHISTORIC_PICKAXE);
                        entries.add(ModItems.PREHISTORIC_AXE);
                        entries.add(ModItems.PREHISTORIC_SHOVEL);
                        entries.add(ModItems.PREHISTORIC_HOE);

                        //armour
                        entries.add(ModItems.PREHISTORIC_HELMET);
                        entries.add(ModItems.PREHISTORIC_CHESTPLATE);
                        entries.add(ModItems.PREHISTORIC_LEGGINGS);
                        entries.add(ModItems.PREHISTORIC_BOOTS);


                        //blocks
                        entries.add(ModBlocks.PREHISTORIC_BLOCK);
                        entries.add(ModBlocks.PREHISTORIC_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PREHISTORIC_ORE);
                        entries.add(ModBlocks.PREHISTORIC_PLANKS);
                        entries.add(ModBlocks.PREHISTORIC_LOG);
                        entries.add(ModBlocks.PREHISTORIC_STAIRS);
                        entries.add(ModBlocks.PREHISTORIC_SLAB);
                        entries.add(ModBlocks.PREHISTORIC_LEAVES);

                    }).build());

    public static void registerItemGroups() {
        AdventuresWithTARDISes.LOGGER.info("Registering Item Groups for" + AdventuresWithTARDISes.MOD_ID);
    }
}
