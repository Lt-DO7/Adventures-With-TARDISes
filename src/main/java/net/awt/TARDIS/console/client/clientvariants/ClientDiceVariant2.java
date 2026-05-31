package net.awt.TARDIS.console.client.clientvariants;

import dev.amble.ait.client.models.consoles.ConsoleModel;
import dev.amble.ait.data.schema.console.ClientConsoleVariantSchema;
import net.awt.AdventuresWithTARDISes;
import net.awt.TARDIS.console.client.models.DiceConsoleModel;
import net.awt.TARDIS.console.variants.DiceVariant2;
import net.minecraft.util.Identifier;
import org.joml.Vector3f;

public class ClientDiceVariant2 extends ClientConsoleVariantSchema {
    public static final Identifier TEXTURE = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/blockentities/consoles/toyota_rhamnous.png");
    public static final Identifier EMISSION = new Identifier(AdventuresWithTARDISes.MOD_ID, "textures/blockentities/consoles/toyota_rhamnous_emission.png");

    public ClientDiceVariant2() {
        super(DiceVariant2.REFERENCE, DiceVariant2.REFERENCE);
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
        return new DiceConsoleModel(DiceConsoleModel.getTexturedModelData().createModel());
    }

    public Vector3f sonicItemTranslations() {
        return new Vector3f(-0.5275F, 1.35F, 0.7F);
    }

    public float[] sonicItemRotations() {
        return new float[]{-120.0F, -45.0F};
    }

    public Vector3f handlesTranslations() {
        return new Vector3f(0.05F, 1.75F, 0.36F);
    }

    public float[] handlesRotations() {
        return new float[]{60.0F, 135.0F};
    }
}
