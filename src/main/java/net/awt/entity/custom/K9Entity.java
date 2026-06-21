package net.awt.entity.custom;

import net.awt.entity.ModEntities;
import net.awt.item.ModItems;
import net.awt.sound.AWTSound;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class K9Entity extends TameableEntity implements RangedAttackMob {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public K9Entity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    /* ================= ANIMATION ================= */

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING
                ? Math.min(posDelta * 6.0F, 1.0F)
                : 0.0F;
        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setupAnimationStates();
        }
    }

    /* ================= AI GOALS ================= */

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
        this.goalSelector.add(3, new ProjectileAttackGoal(this, 1.0D, 20, 16.0F));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));

        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, new RevengeGoal(this));
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.isSitting()) {
            this.getNavigation().stop();
        }
    }

    /* ================= TAME / INTERACTION ================= */

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (this.getWorld().isClient) {
            return ActionResult.SUCCESS;
        }

        // Taming with Processing unit
        if (!this.isTamed() && stack.isOf(ModItems.PROCESSINGUNIT)) {
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }

            if (this.random.nextInt(3) == 0) {
                this.setOwner(player);
                this.setSitting(true);
                this.navigation.stop();
                this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
                this.playSound(AWTSound.K9TAME, 1.0F, 1.0F);
            } else {
                this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
            }

            return ActionResult.CONSUME;
        }

        // Owner interaction
        if (this.isTamed() && this.isOwner(player)) {

            // Sit toggle
            this.setSitting(!this.isSitting());
            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    /* ================= ATTRIBUTES ================= */

    public static DefaultAttributeContainer.Builder createK9Attributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_ARMOR, 1.0);
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(50.0);
            this.setHealth(50.0F);
        }
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(10.0);
    }

    /* ================= COMBAT ================= */

    @Override
    public boolean tryAttack(Entity target) {
        boolean success = target.damage(
                this.getDamageSources().mobAttack(this),
                (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)
        );

        if (success) {
            this.applyDamageEffects(this, target);
        }
        return success;
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        if (this.getWorld().isClient()) {
            return;
        }

        Vec3d forward = this.getRotationVec(1.0F).normalize().multiply(0.8D);
        Vec3d muzzle = this.getPos().add(0.0D, 0.62D, 0.0D).add(forward);
        Vec3d targetPos = target.getPos().add(0.0D, target.getHeight() * 0.5D, 0.0D);

        LaserEntity.fire(this.getWorld(), this, muzzle, targetPos.subtract(muzzle), LaserEntity.LaserColor.RED, 5.0D, 1.9F, 1.0F);
        this.playSound(SoundEvents.ENTITY_GUARDIAN_ATTACK, 0.8F, 1.5F);
    }

    /* ================= BREEDING ================= */

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.K9.create(world);
    }

    /* ================= SOUNDS ================= */

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return AWTSound.K9DIE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return AWTSound.K9HURT;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    /* ================= LEASH ================= */

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return super.canBeLeashedBy(player);
    }

    @Override
    public Vec3d getLeashOffset() {
        return new Vec3d(0.0, 0.6F * this.getStandingEyeHeight(), this.getWidth() * 0.4F);
    }

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }


}
