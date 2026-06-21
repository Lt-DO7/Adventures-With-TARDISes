package net.awt.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractCybermanEntity extends HostileEntity implements RangedAttackMob {
    protected AbstractCybermanEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 8;
    }

    public static DefaultAttributeContainer.Builder createCybermanAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 6.0D);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.0D, 24, 18.0F));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<TameableEntity>(this, TameableEntity.class, 10, true, false,
                target -> target instanceof TameableEntity tameableEntity && tameableEntity.isTamed()));
    }

    @Override
    public boolean canTarget(LivingEntity target) {
        return !(target instanceof AbstractCybermanEntity) && super.canTarget(target);
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        super.setTarget(target instanceof AbstractCybermanEntity ? null : target);
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        if (this.getWorld().isClient()) {
            return;
        }

        Vec3d muzzle = this.getLaserMuzzlePos();
        Vec3d targetPos = target.getPos().add(0.0D, target.getHeight() * 0.6D, 0.0D);
        Vec3d direction = targetPos.subtract(muzzle);

        LaserEntity.fire(this.getWorld(), this, muzzle, direction, this.getLaserColor(), this.getLaserDamage(), 1.75F, 0.75F);
        this.playSound(SoundEvents.ENTITY_GUARDIAN_ATTACK, 1.0F, 1.1F + this.random.nextFloat() * 0.1F);
    }

    protected double getLaserDamage() {
        return 6.0D;
    }

    protected abstract LaserEntity.LaserColor getLaserColor();

    protected abstract Vec3d getLaserMuzzlePos();
}
