package net.awt.TARDIS.console.variants;


import dev.amble.ait.data.schema.console.ConsoleVariantSchema;
import net.awt.AdventuresWithTARDISes;
import net.awt.TARDIS.console.types.DiceType;
import net.minecraft.util.Identifier;

public class DiceVariant extends ConsoleVariantSchema {
    public static final Identifier REFERENCE = AdventuresWithTARDISes.id("console/dice");

    public DiceVariant() {
        super(DiceType.REFERENCE, REFERENCE);
    }

}
