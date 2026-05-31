package net.awt.TARDIS.console;

import dev.amble.ait.data.schema.console.ConsoleVariantSchema;
import net.awt.TARDIS.console.variants.*;

import static dev.amble.ait.registry.impl.console.variant.ConsoleVariantRegistry.registerStatic;

public class AWTConsoleVariantRegistry {
    public static ConsoleVariantSchema DICE;
    public static ConsoleVariantSchema JUNKGLASS;
    public static ConsoleVariantSchema BLOCK;
    public static ConsoleVariantSchema BLOCK2;
    public static ConsoleVariantSchema BLOCK3;
    public static ConsoleVariantSchema BLOCK4;

    public static void init() {
    }

    public static void registerConsoleVariants() {
        AWTConsoleVariantRegistry.DICE = registerStatic(new DiceVariant());
        AWTConsoleVariantRegistry.JUNKGLASS = registerStatic(new JunkGlassVariant());
        AWTConsoleVariantRegistry.BLOCK = registerStatic(new BlockVariant());
        AWTConsoleVariantRegistry.BLOCK2 = registerStatic(new BlockVariant2());
        AWTConsoleVariantRegistry.BLOCK3 = registerStatic(new BlockVariant3());
        AWTConsoleVariantRegistry.BLOCK4 = registerStatic(new BlockVariant4());
    }
}
