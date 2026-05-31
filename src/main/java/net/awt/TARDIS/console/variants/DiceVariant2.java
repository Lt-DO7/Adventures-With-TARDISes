package net.awt.TARDIS.console.variants;


import dev.amble.ait.data.schema.console.ConsoleVariantSchema;
import net.awt.AdventuresWithTARDISes;
import net.awt.TARDIS.console.types.DiceType;
import net.minecraft.util.Identifier;

public class DiceVariant2 extends ConsoleVariantSchema {
    public static final Identifier REFERENCE = AdventuresWithTARDISes.id("console/dicealt");

    public DiceVariant2() {
        super(DiceType.REFERENCE, REFERENCE);
    }

}
