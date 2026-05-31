package net.awt.TARDIS.console.variants;


import dev.amble.ait.data.schema.console.ConsoleVariantSchema;
import net.awt.AdventuresWithTARDISes;
import net.awt.TARDIS.console.types.JunkGlassType;
import net.minecraft.util.Identifier;

public class JunkGlassVariant extends ConsoleVariantSchema {
    public static final Identifier REFERENCE = AdventuresWithTARDISes.id("console/junkglass");

    public JunkGlassVariant() {
        super(JunkGlassType.REFERENCE, REFERENCE);
    }

}
