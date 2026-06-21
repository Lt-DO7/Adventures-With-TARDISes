package net.awt.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class CybermatEntity extends SilverfishEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public CybermatEntity(EntityType<? extends SilverfishEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setupAnimationStates();
        }
    }

    public static DefaultAttributeContainer.Builder createCybermatAttributes() {
        return SilverfishEntity.createSilverfishAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4);
    }

    @Override
    protected void initGoals() {
        // ----- General AI Goals -----
        this.goalSelector.add(0, new SwimGoal(this)); // Swim if in water
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0, true)); // Melee attack
        this.goalSelector.add(2, new WanderAroundGoal(this, 1.0)); // Random wandering
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F)); // Look at players
        this.goalSelector.add(4, new LookAroundGoal(this)); // Look around when idle

        // ----- Targeting AI Goals -----
        // Revenge goal: attack entities that harm this Cybermat
        this.targetSelector.add(0, new RevengeGoal(this));

        // Active targeting: attack all living entities except itself and other Cybermats
        this.targetSelector.add(1, new ActiveTargetGoal<>(
                this,
                LivingEntity.class,
                10,
                true,
                true,
                target ->
                        target != this
                                && !(target instanceof CybermatEntity)
                                && !(target instanceof ProtoCybermanEntity)
                                && !(target instanceof MondasianCybermanEntity)
        ));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null; // No idle sound
    }
}
