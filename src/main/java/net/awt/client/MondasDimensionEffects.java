package net.awt.client;

import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.math.Vec3d;

public class MondasDimensionEffects extends DimensionEffects {

    public MondasDimensionEffects() {
        super(Float.NaN, false, SkyType.NORMAL, false, true);
    }

    @Override
    public float[] getFogColorOverride(float skyAngle, float tickDelta) {
        return new float[]{0.0F, 0.0F, 0.0F, 1.0F};
    }

    @Override
    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
        return Vec3d.ZERO;
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return false;
    }
}
