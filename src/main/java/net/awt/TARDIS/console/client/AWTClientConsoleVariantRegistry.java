package net.awt.TARDIS.console.client;

import dev.amble.ait.data.schema.console.ClientConsoleVariantSchema;
import dev.amble.lib.register.datapack.DatapackRegistry;
import net.awt.TARDIS.console.client.clientvariants.*;

public class AWTClientConsoleVariantRegistry  {
    public static ClientConsoleVariantSchema DICE;
    public static ClientConsoleVariantSchema JUNKGLASS;
    public static ClientConsoleVariantSchema BLOCK;
    public static ClientConsoleVariantSchema BLOCK2;
    public static ClientConsoleVariantSchema BLOCK3;
    public static ClientConsoleVariantSchema BLOCK4;


    public static void init() {
    }

    public static void registerClientConsoleVariants(DatapackRegistry<ClientConsoleVariantSchema> instance) {
        AWTClientConsoleVariantRegistry.DICE = instance.register(new ClientDiceVariant());
        AWTClientConsoleVariantRegistry.JUNKGLASS = instance.register(new ClientJunkGlassVariant());
        AWTClientConsoleVariantRegistry.BLOCK = instance.register(new ClientBlockVariant());
        AWTClientConsoleVariantRegistry.BLOCK2 = instance.register(new ClientBlockVariant2());
        AWTClientConsoleVariantRegistry.BLOCK3 = instance.register(new ClientBlockVariant3());
        AWTClientConsoleVariantRegistry.BLOCK4 = instance.register(new ClientBlockVariant4());
    }
}
