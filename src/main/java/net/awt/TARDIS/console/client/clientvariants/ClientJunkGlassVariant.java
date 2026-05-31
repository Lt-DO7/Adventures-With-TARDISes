package net.awt.TARDIS.console.client.clientvariants;

import dev.amble.ait.client.models.consoles.ConsoleModel;
import dev.amble.ait.data.schema.console.ClientConsoleVariantSchema;
import net.awt.AdventuresWithTARDISes;
import net.awt.TARDIS.console.client.models.JunkGlassModel;
import net.awt.TARDIS.console.variants.JunkGlassVariant;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;

public class ClientJunkGlassVariant extends ClientConsoleVariantSchema {
    public static final Identifier TEXTURE = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/blockentities/consoles/junkglass.png");
    public static final Identifier EMISSION = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/blockentities/consoles/junkglass_emission.png");

    public ClientJunkGlassVariant() {
        super(JunkGlassVariant.REFERENCE, JunkGlassVariant.REFERENCE);
    }

    @Override
    public Identifier texture() {
        return TEXTURE;
    }

    @Override
    public Identifier emission() {
        return EMISSION;
    }

    @Override
    public ConsoleModel model() {
        return new JunkGlassModel(JunkGlassModel.getTexturedModelData().createModel());
    }

    public Vector3f sonicItemTranslations() {
        return new Vector3f(-0.94F, 1.4F, 0.494F);
    }

    public float[] sonicItemRotations() {
        return new float[]{90.0F, -210.0F};
    }

    public Vector3f handlesTranslations() {
        return new Vector3f(0.01F, 1.75F, 0.7F);
    }

    public float[] handlesRotations() {
        return new float[]{60.0F, 135.0F};
    }
}
