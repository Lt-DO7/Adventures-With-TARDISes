package net.awt.TARDIS.console;

import dev.amble.ait.data.schema.console.ConsoleTypeSchema;
import dev.amble.ait.registry.impl.console.ConsoleRegistry;
import net.awt.TARDIS.console.types.BlockConsoleType;
import net.awt.TARDIS.console.types.JunkGlassType;

public class AWTConsoleRegistry {
    public static ConsoleTypeSchema JUNKGLASS;
    public static ConsoleTypeSchema BLOCK;

    public static void init() {
    }

    public static void registerConsoles() {
        AWTConsoleRegistry.JUNKGLASS = ConsoleRegistry.getInstance().register(new JunkGlassType());
        AWTConsoleRegistry.BLOCK = ConsoleRegistry.getInstance().register(new BlockConsoleType());
    }
}
