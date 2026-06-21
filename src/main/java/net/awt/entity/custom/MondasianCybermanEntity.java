package net.awt.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MondasianCybermanEntity extends AbstractCybermanEntity {
    public MondasianCybermanEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected LaserEntity.LaserColor getLaserColor() {
        return LaserEntity.LaserColor.YELLOW;
    }

    @Override
    protected Vec3d getLaserMuzzlePos() {
        Vec3d forward = this.getRotationVec(1.0F).normalize().multiply(0.25D);
        return this.getPos().add(0.0D, 2.15D, 0.0D).add(forward);
    }
}
