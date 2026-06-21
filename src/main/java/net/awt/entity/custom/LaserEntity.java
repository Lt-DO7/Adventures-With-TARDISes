package net.awt.entity.custom;

import net.awt.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

public class LaserEntity extends ProjectileEntity {
    private static final TrackedData<Integer> COLOR = DataTracker.registerData(LaserEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final String COLOR_KEY = "Color";
    private static final String DAMAGE_KEY = "Damage";
    private double damage = 6.0D;

    public LaserEntity(EntityType<? extends LaserEntity> entityType, World world) {
        super(entityType, world);
        this.noClip = true;
    }

    public LaserEntity(World world, LivingEntity owner) {
        this(ModEntities.LASER, world);
        this.setOwner(owner);
        this.refreshPositionAndAngles(owner.getX(), owner.getEyeY() - 0.1D, owner.getZ(), owner.getYaw(), owner.getPitch());
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(COLOR, LaserColor.RED.ordinal());
    }

    @Override
    public void tick() {
        super.tick();

        Vec3d velocity = this.getVelocity();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        if (hitResult.getType() != HitResult.Type.MISS) {
            this.onCollision(hitResult);
        }

        this.checkBlockCollision();
        this.setPosition(this.getPos().add(velocity));
        ProjectileUtil.setRotationFromVelocity(this, 1.0F);

        if (this.age > 40) {
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity owner = this.getOwner();
        Entity hit = entityHitResult.getEntity();
        DamageSource damageSource = owner instanceof LivingEntity livingOwner
                ? this.getDamageSources().mobProjectile(this, livingOwner)
                : this.getDamageSources().magic();

        if (hit.damage(damageSource, (float) this.damage) && !this.getWorld().isClient()) {
            this.getWorld().playSound(
                    null,
                    this.getBlockPos(),
                    net.minecraft.sound.SoundEvents.ENTITY_BLAZE_HURT,
                    SoundCategory.HOSTILE,
                    0.25F,
                    1.8F
            );
        }

        this.discard();
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        this.discard();
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    public boolean shouldRender(double distance) {
        return distance < 4096.0D;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.damage = nbt.getDouble(DAMAGE_KEY);
        if (nbt.contains(COLOR_KEY)) {
            this.setLaserColor(LaserColor.fromIndex(nbt.getInt(COLOR_KEY)));
        }
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putDouble(DAMAGE_KEY, this.damage);
        nbt.putInt(COLOR_KEY, this.getLaserColor().ordinal());
    }

    public LaserColor getLaserColor() {
        return LaserColor.fromIndex(this.dataTracker.get(COLOR));
    }

    public void setLaserColor(LaserColor color) {
        this.dataTracker.set(COLOR, color.ordinal());
    }

    public double getDamageAmount() {
        return this.damage;
    }

    public void setDamageAmount(double damage) {
        this.damage = damage;
    }

    public static LaserEntity fire(World world, LivingEntity shooter, Vec3d direction, LaserColor color, double damage, float speed, float divergence) {
        Vec3d normalized = direction.normalize();
        Vec3d origin = new Vec3d(
                shooter.getX() + normalized.x * 0.5D,
                shooter.getEyeY() - 0.1D,
                shooter.getZ() + normalized.z * 0.5D
        );
        return fire(world, shooter, origin, direction, color, damage, speed, divergence);
    }

    public static LaserEntity fire(World world, LivingEntity shooter, Vec3d origin, Vec3d direction, LaserColor color, double damage, float speed, float divergence) {
        LaserEntity laser = new LaserEntity(world, shooter);
        Vec3d normalized = direction.normalize();

        laser.setLaserColor(color);
        laser.setDamageAmount(damage);
        laser.refreshPositionAndAngles(
                origin.x,
                origin.y,
                origin.z,
                shooter.getYaw(),
                shooter.getPitch()
        );
        laser.setVelocity(normalized.x, normalized.y, normalized.z, speed, divergence);
        world.spawnEntity(laser);
        return laser;
    }

    public enum LaserColor {
        RED(new Vector3f(1.0F, 0.2F, 0.2F)),
        YELLOW(new Vector3f(1.0F, 0.85F, 0.2F)),
        BLUE(new Vector3f(0.3F, 0.6F, 1.0F));

        private final Vector3f particleColor;

        LaserColor(Vector3f particleColor) {
            this.particleColor = particleColor;
        }

        public Vector3f particleColor() {
            return this.particleColor;
        }

        public static LaserColor fromIndex(int index) {
            LaserColor[] values = values();
            return index >= 0 && index < values.length ? values[index] : RED;
        }
    }
}
