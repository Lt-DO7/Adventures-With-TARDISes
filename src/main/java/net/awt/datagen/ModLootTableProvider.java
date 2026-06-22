package net.awt.datagen;

import net.awt.block.ModBlocks;
import net.awt.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ATRIUM_BLOCK);
        addDrop(ModBlocks.ATRIUM_ORE, oreDrops(ModBlocks.ATRIUM_ORE, ModItems.ATRIUM));
        addDrop(ModBlocks.DEEPSLATE_ATRIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_ATRIUM_ORE, ModItems.ATRIUM));

        addDrop(ModBlocks.WHITE_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.BLACK_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.END_STONE_BRICKS_ROUNDEL);
        addDrop(ModBlocks.GRAY_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.GREEN_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.LIGHT_GRAY_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.POLISHED_ANDESITE_ROUNDEL);
        addDrop(ModBlocks.POLISHED_DEEPSLATE_ROUNDEL);
        addDrop(ModBlocks.POLISHED_GRANITE_ROUNDEL);
        addDrop(ModBlocks.POLISHED_DIORITE_ROUNDEL);
        addDrop(ModBlocks.QUARTZ_ROUNDEL);
        addDrop(ModBlocks.AMBQUARTZ_ROUNDEL);
        addDrop(ModBlocks.BLUEQUARTZ_ROUNDEL);
        addDrop(ModBlocks.CRIMQUARTZ_ROUNDEL);
        addDrop(ModBlocks.VERDQUARTZ_ROUNDEL);
        addDrop(ModBlocks.VIOQUARTZ_ROUNDEL);
        addDrop(ModBlocks.OBSIQUARTZ_ROUNDEL);
        addDrop(ModBlocks.SANDSTONE_ROUNDEL);
        addDrop(ModBlocks.CYAN_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.YELLOW_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.WEATHERED_COPPER_ROUNDEL);
        addDrop(ModBlocks.RED_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.PURPLE_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.PINK_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.BROWN_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.ORANGE_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.OXIDIZED_COPPER_ROUNDEL);
        addDrop(ModBlocks.LIME_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.LIGHT_BLUE_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.BLUE_CONCRETE_ROUNDEL);
        addDrop(ModBlocks.EXPOSED_COPPER_ROUNDEL);
        addDrop(ModBlocks.COPPER_ROUNDEL);
        addDrop(ModBlocks.HARTNELL_ROUNDEL);
        addDrop(ModBlocks.HARTNELL_WALL);
        addDrop(ModBlocks.THE_MOMENT);

        addDrop(ModBlocks.PREHISTORIC_BLOCK);
        addDrop(ModBlocks.PREHISTORIC_ORE, oreDrops(ModBlocks.PREHISTORIC_ORE, ModItems.PREHISTORIC_INGOT));
        addDrop(ModBlocks.DEEPSLATE_PREHISTORIC_ORE, oreDrops(ModBlocks.DEEPSLATE_PREHISTORIC_ORE, ModItems.PREHISTORIC_INGOT));
        addDrop(ModBlocks.PREHISTORIC_PLANKS);
        addDrop(ModBlocks.PREHISTORIC_LOG);
        addDrop(ModBlocks.PREHISTORIC_STAIRS);
        addDrop(ModBlocks.PREHISTORIC_SLAB);
        addDrop(ModBlocks.PREHISTORIC_LEAVES);

        addDrop(ModBlocks.DALEKANIUM_BLOCK);
        addDrop(ModBlocks.DALEKANIUM_ORE, oreDrops(ModBlocks.DALEKANIUM_ORE, ModItems.DALEKANIUM_INGOT));
        addDrop(ModBlocks.DEEPSLATE_DALEKANIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_DALEKANIUM_ORE, ModItems.DALEKANIUM_INGOT));

        addDrop(ModBlocks.STEEL_BLOCK);
        addDrop(ModBlocks.METALERTANIUM_BLOCK);

        addDrop(ModBlocks.WASTED_LEAVES);
        addDrop(ModBlocks.WASTED_DIRT);
        addDrop(ModBlocks.WASTED_LOG);
        addDrop(ModBlocks.WASTED_PLANK_SLAB);
        addDrop(ModBlocks.WASTED_PLANKS);
        addDrop(ModBlocks.KALETITE);
        addDrop(ModBlocks.KALETITE_BRICKS);
        addDrop(ModBlocks.COBBLED_KALETITE);
        addDrop(ModBlocks.ECAT);
        addDrop(ModBlocks.GOODHEAVENS);
        addDrop(ModBlocks.LOST_DIRT);
        addDrop(ModBlocks.WASTED_GRASS);

    }
}