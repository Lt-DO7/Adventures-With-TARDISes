package net.awt.item;

import net.awt.AdventuresWithTARDISes;
import net.awt.entity.ModEntities;
import net.awt.item.custom.AtriumFuel;
import net.awt.item.custom.clothing.Bowtie;
import net.awt.item.custom.clothing.EyeStalk;
import net.awt.item.custom.clothing.Fez;
import net.awt.item.custom.clothing.TrustableHat;
import net.awt.item.custom.sonicglasses.SonicGlasses;
import net.awt.item.custom.VortexManipulator;
import net.awt.item.spoon.Spoon;
import net.awt.sound.AWTSound;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    // Basic Items
    public static final Item ATRIUM = registerItem("atrium", new Item(new FabricItemSettings()));
    public static final Item LIGHTSABER = registerItem("lightsaber", new Item(new FabricItemSettings()));
    public static final Item PROCESSINGUNIT = registerItem("processing_unit", new Item(new FabricItemSettings()));
    public static final Item ENERGIZEDATRIUM = registerItem("energized_atrium", new Item(new FabricItemSettings()));
    public static final Item ATRIUMCORE = registerItem("atrium_core", new Item(new FabricItemSettings()));
    public static final Item ROUNDELMOLD = registerItem("roundel_mold", new Item(new FabricItemSettings()));

    //Prehistoric Items

    public static final Item PREHISTORIC_INGOT = registerItem("prehistoric_ingot", new Item(new FabricItemSettings()));
    public static final Item PREHISTORIC_TEMPLATE = registerItem("prehistoric_template", new Item(new FabricItemSettings()));

    //Prehistoric Armour

    public static final Item PREHISTORIC_HELMET = registerItem("prehistoric_helmet",
            new ArmorItem(ModArmourMaterials.PREHISTORIC, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item PREHISTORIC_CHESTPLATE = registerItem("prehistoric_chestplate",
            new ArmorItem(ModArmourMaterials.PREHISTORIC, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item PREHISTORIC_LEGGINGS = registerItem("prehistoric_leggings",
            new ArmorItem(ModArmourMaterials.PREHISTORIC, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item PREHISTORIC_BOOTS = registerItem("prehistoric_boots",
            new ArmorItem(ModArmourMaterials.PREHISTORIC, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Prehistoric Tools

    public static final Item PREHISTORIC_SWORD = registerItem("prehistoric_sword",
            new SwordItem(ModToolMaterials.PREHISTORIC, 6, -2.4f, new FabricItemSettings()));

    public static final Item PREHISTORIC_PICKAXE = registerItem("prehistoric_pickaxe",
            new PickaxeItem(ModToolMaterials.PREHISTORIC, 1, -2.8f, new FabricItemSettings()));

    public static final Item PREHISTORIC_AXE = registerItem("prehistoric_axe",
            new AxeItem(ModToolMaterials.PREHISTORIC, 9.0f, -3.0f, new FabricItemSettings()));

    public static final Item PREHISTORIC_SHOVEL = registerItem("prehistoric_shovel",
            new ShovelItem(ModToolMaterials.PREHISTORIC, 1.5f, -3.0f, new FabricItemSettings()));

    public static final Item PREHISTORIC_HOE = registerItem("prehistoric_hoe",
            new HoeItem(ModToolMaterials.PREHISTORIC, -4, 0.0f, new FabricItemSettings()));

    //Dalekanium Items

    public static final Item DALEKANIUM_INGOT = registerItem("dalekanium_ingot", new Item(new FabricItemSettings()));
    public static final Item LIQUID_DALEKANIUM = registerItem("liquid_dalekanium", new Item(new FabricItemSettings()));

    //Dalekanium Armour

    public static final Item DALEKANIUM_HELMET = registerItem("dalekanium_helmet",
            new ArmorItem(ModArmourMaterials.DALEKANIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item DALEKANIUM_CHESTPLATE = registerItem("dalekanium_chestplate",
            new ArmorItem(ModArmourMaterials.DALEKANIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item DALEKANIUM_LEGGINGS = registerItem("dalekanium_leggings",
            new ArmorItem(ModArmourMaterials.DALEKANIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item DALEKANIUM_BOOTS = registerItem("dalekanium_boots",
            new ArmorItem(ModArmourMaterials.DALEKANIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    //Dalekanium Tools

    public static final Item DALEKANIUM_SWORD = registerItem("dalekanium_sword",
            new SwordItem(ModToolMaterials.DALEKANIUM, 6, -2.4f, new FabricItemSettings()));

    public static final Item DALEKANIUM_PICKAXE = registerItem("dalekanium_pickaxe",
            new PickaxeItem(ModToolMaterials.DALEKANIUM, 1, -2.8f, new FabricItemSettings()));

    public static final Item DALEKANIUM_AXE = registerItem("dalekanium_axe",
            new AxeItem(ModToolMaterials.DALEKANIUM, 9.0f, -3.0f, new FabricItemSettings()));

    public static final Item DALEKANIUM_SHOVEL = registerItem("dalekanium_shovel",
            new ShovelItem(ModToolMaterials.DALEKANIUM, 1.5f, -3.0f, new FabricItemSettings()));

    public static final Item DALEKANIUM_HOE = registerItem("dalekanium_hoe",
            new HoeItem(ModToolMaterials.DALEKANIUM, -4, 0.0f, new FabricItemSettings()));

    //Steel Items

    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item STEEL_TEMPLATE = registerItem("steel_template", new Item(new FabricItemSettings()));

    //Steel Armour

    public static final Item STEEL_HELMET = registerItem("steel_helmet",
            new ArmorItem(ModArmourMaterials.STEEL, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate",
            new ArmorItem(ModArmourMaterials.STEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings",
            new ArmorItem(ModArmourMaterials.STEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item STEEL_BOOTS = registerItem("steel_boots",
            new ArmorItem(ModArmourMaterials.STEEL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Steel Tools

    public static final Item STEEL_SWORD = registerItem("steel_sword",
            new SwordItem(ModToolMaterials.STEEL, 6, -2.4f, new FabricItemSettings()));

    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            new PickaxeItem(ModToolMaterials.STEEL, 1, -2.8f, new FabricItemSettings()));

    public static final Item STEEL_AXE = registerItem("steel_axe",
            new AxeItem(ModToolMaterials.STEEL, 9.0f, -3.0f, new FabricItemSettings()));

    public static final Item STEEL_SHOVEL = registerItem("steel_shovel",
            new ShovelItem(ModToolMaterials.STEEL, 1.5f, -3.0f, new FabricItemSettings()));

    public static final Item STEEL_HOE = registerItem("steel_hoe",
            new HoeItem(ModToolMaterials.STEEL, -4, 0.0f, new FabricItemSettings()));

    //Metalertanium Items

    public static final Item METALERTANIUM_INGOT = registerItem("metalertanium_ingot", new Item(new FabricItemSettings()));
    public static final Item LIQUID_METALERTANIUM = registerItem("liquid_metalertanium", new Item(new FabricItemSettings()));

    //Metalertanium Armour

    public static final Item METALERTANIUM_HELMET = registerItem("metalertanium_helmet",
            new ArmorItem(ModArmourMaterials.METALERTANIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item METALERTANIUM_CHESTPLATE = registerItem("metalertanium_chestplate",
            new ArmorItem(ModArmourMaterials.METALERTANIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item METALERTANIUM_LEGGINGS = registerItem("metalertanium_leggings",
            new ArmorItem(ModArmourMaterials.METALERTANIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item METALERTANIUM_BOOTS = registerItem("metalertanium_boots",
            new ArmorItem(ModArmourMaterials.METALERTANIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    //Metalertanium Tools

    public static final Item METALERTANIUM_SWORD = registerItem("metalertanium_sword",
            new SwordItem(ModToolMaterials.METALERTANIUM, 6, -2.4f, new FabricItemSettings()));

    public static final Item METALERTANIUM_PICKAXE = registerItem("metalertanium_pickaxe",
            new PickaxeItem(ModToolMaterials.METALERTANIUM, 1, -2.8f, new FabricItemSettings()));

    public static final Item METALERTANIUM_AXE = registerItem("metalertanium_axe",
            new AxeItem(ModToolMaterials.METALERTANIUM, 9.0f, -3.0f, new FabricItemSettings()));

    public static final Item METALERTANIUM_SHOVEL = registerItem("metalertanium_shovel",
            new ShovelItem(ModToolMaterials.METALERTANIUM, 1.5f, -3.0f, new FabricItemSettings()));

    public static final Item METALERTANIUM_HOE = registerItem("metalertanium_hoe",
            new HoeItem(ModToolMaterials.METALERTANIUM, -4, 0.0f, new FabricItemSettings()));

    // Vortex Manipulator
    public static final Item VORTEX_MANIPULATOR = registerItem("vortex_manipulator", new VortexManipulator(new FabricItemSettings()));
    public static final Item VORTEX_MANIPULATOR2 = registerItem("vortex_manipulator2", new VortexManipulator(new FabricItemSettings()));

    // Weapon Matrix
    public static final Item WEAPON_MATRIX = registerItem("weapon_matrix", new Item(new FabricItemSettings()));

    // Music Discs
    public static final Item DRWHOVALE_MUSIC_DISC = registerItem("drwhovale_music_disc",
            new MusicDiscItem(10, AWTSound.DRWHOVALE, new FabricItemSettings().maxCount(1), 127));
    public static final Item DOCTORWHOXV_MUSIC_DISC = registerItem("doctorwhoxv_music_disc",
            new MusicDiscItem(15, AWTSound.doctorwhoxv, new FabricItemSettings().maxCount(1), 29));
    public static final Item PARALYZER_MUSIC_DISC = registerItem("paralyzer_music_disc",
            new MusicDiscItem(15, AWTSound.paralyzer, new FabricItemSettings().maxCount(1), 207));
    public static final Item DUGGA_DOO_MUSIC_DISC = registerItem("dugga_doo_music_disc",
            new MusicDiscItem(15, AWTSound.DUGGA_DOO, new FabricItemSettings().maxCount(1), 101));
    public static final Item DOCTORWHO1411_MUSIC_DISC = registerItem("doctorwho1411_music_disc",
            new MusicDiscItem(15, AWTSound.doctorwho1411, new FabricItemSettings().maxCount(1), 60));

    // Spawn Eggs
    public static final Item K9_SPAWN_EGG = registerItem("k9_spawn_egg",
            new SpawnEggItem(ModEntities.K9, 0xFFFFFF, 0xFFFFFFFF, new FabricItemSettings().maxCount(64)));
    public static final Item CYBERMAT_SPAWN_EGG = registerItem("cybermat_spawn_egg",
            new SpawnEggItem(ModEntities.CYBERMAT, 0xFFFFFF, 0xFFFFFFFF, new FabricItemSettings().maxCount(64)));

    // Custom Items
    public static final Item ATRIUM_FUEL = registerItem("atrium_fuel", new AtriumFuel(new FabricItemSettings()));

    public static final Item SONIC_GLASSES = registerItem("sonic_glasses",
            new SonicGlasses(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item DBZ_SCOUTER = registerItem("dbz_scouter",
            new SonicGlasses(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item TRUSTABLE_HAT = registerItem("trustable_hat",
            new TrustableHat(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item EYESTALK = registerItem("eyestalk",
            new EyeStalk(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    // Fez Variants
    public static final Item FEZ = registerItem("fez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item FANCYFEZ = registerItem("fancyfez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item PURPLEFEZ = registerItem("purplefez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item GREENFEZ = registerItem("greenfez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item ORANGEFEZ = registerItem("orangefez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item BLUEFEZ = registerItem("bluefez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item DARKBLUEFEZ = registerItem("darkbluefez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item PINKFEZ = registerItem("pinkfez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item GREYFEZ = registerItem("greyfez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item YELLOWFEZ = registerItem("yellowfez", new Fez(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    //Bowtie Variants
    public static final Item BOWTIE = registerItem("bowtie",
            new Bowtie(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item BLUEBOWTIE = registerItem("bluebowtie",
            new Bowtie(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item CYANBOWTIE = registerItem("cyanbowtie",
            new Bowtie(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item ORANGEBOWTIE = registerItem("orangebowtie",
            new Bowtie(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item MAGENTABOWTIE = registerItem("magentabowtie",
            new Bowtie(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item PURPLEBOWTIE = registerItem("purplebowtie",
            new Bowtie(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item GREENBOWTIE = registerItem("greenbowtie",
            new Bowtie(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item GREYBOWTIE = registerItem("greybowtie",
            new Bowtie(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));


    public static final Item SPOON = registerItem("spoon", new Spoon());

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AdventuresWithTARDISes.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AdventuresWithTARDISes.LOGGER.info("Registering Mod Items for " + AdventuresWithTARDISes.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
