package net.awt.TARDIS.console.variants;


import dev.amble.ait.data.schema.console.ConsoleVariantSchema;
import net.awt.AdventuresWithTARDISes;
import net.awt.TARDIS.console.types.BlockConsoleType;
import net.minecraft.util.Identifier;

public class BlockVariant extends ConsoleVariantSchema {
    public static final Identifier REFERENCE = AdventuresWithTARDISes.id("console/block");

    public BlockVariant() {
        super(BlockConsoleType.REFERENCE, REFERENCE);
    }

}
