package net.awt.networking.packets;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class VMPacket {
    private static final Map<UUID, PendingTeleportEffect> PENDING_EFFECTS = new ConcurrentHashMap<>();

    static {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            Iterator<Map.Entry<UUID, PendingTeleportEffect>> iterator = PENDING_EFFECTS.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<UUID, PendingTeleportEffect> entry = iterator.next();
                PendingTeleportEffect pending = entry.getValue();
                ServerPlayerEntity player = server.getPlayerManager().getPlayer(entry.getKey());

                if (player == null) {
                    iterator.remove();
                    continue;
                }

                ServerWorld world = server.getWorld(pending.worldKey());
                if (world == null) {
                    player.removeStatusEffect(StatusEffects.INVISIBILITY);
                    iterator.remove();
                    continue;
                }

                if (player.getServerWorld() != world) {
                    continue;
                }

                if (!world.isChunkLoaded(pending.chunkPos().x(), pending.chunkPos().z())) {
                    continue;
                }

                if (pending.ticksUntilLightning() > 0) {
                    entry.setValue(pending.tickDown());
                    continue;
                }

                summonCosmeticLightning(world, pending.position());
                player.removeStatusEffect(StatusEffects.INVISIBILITY);
                iterator.remove();
            }
        });
    }

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        String dim = buf.readString();
        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();


        dim = dim.toLowerCase();

        RegistryKey<World> overworldKey = RegistryKey.of(RegistryKeys.WORLD, new Identifier("minecraft:overworld"));
        RegistryKey<World> netherKey = RegistryKey.of(RegistryKeys.WORLD, new Identifier("minecraft:the_nether"));
        RegistryKey<World> endKey = RegistryKey.of(RegistryKeys.WORLD, new Identifier("minecraft:the_end"));
        RegistryKey<World> key = RegistryKey.of(RegistryKeys.WORLD, new Identifier(dim));

        ServerWorld overWorld = server.getWorld(overworldKey);
        ServerWorld netherWorld = server.getWorld(netherKey);
        ServerWorld endWorld = server.getWorld(endKey);

        ServerWorld serverWorld = server.getWorld(key);
        if (serverWorld == null) {
            if (dim.equalsIgnoreCase("nether")) {
                serverWorld = netherWorld;
            } else if (dim.equalsIgnoreCase("end")) {
                serverWorld = endWorld;
            } else if (dim.equalsIgnoreCase("overworld")) {
                serverWorld = overWorld;
            } else {
                serverWorld = player.getServerWorld();
            }
        }
        ServerWorld finalServerWorld = serverWorld;
        server.execute(() -> {
            Vec3d targetPos = new Vec3d(x, y, z);
            BlockPos targetBlockPos = BlockPos.ofFloored(targetPos);

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 20 * 30, 0, false, false, false));
            FabricDimensions.teleport(player, finalServerWorld, new TeleportTarget(
                    targetPos,
                    player.getVelocity(),
                    player.getYaw(),
                    player.getPitch()
            ));

            PENDING_EFFECTS.put(player.getUuid(), new PendingTeleportEffect(
                    finalServerWorld.getRegistryKey(),
                    targetPos,
                    new ChunkPosKey(targetBlockPos.getX() >> 4, targetBlockPos.getZ() >> 4),
                    30
            ));
        });


    }

    private static void summonCosmeticLightning(ServerWorld world, Vec3d pos) {
        LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
        if (lightning == null) {
            return;
        }

        lightning.setCosmetic(true);
        lightning.refreshPositionAfterTeleport(pos.x, pos.y, pos.z);
        world.spawnEntity(lightning);
    }

    private record ChunkPosKey(int x, int z) {
    }

    private record PendingTeleportEffect(RegistryKey<World> worldKey, Vec3d position, ChunkPosKey chunkPos,
                                         int ticksUntilLightning) {
        private PendingTeleportEffect tickDown() {
            return new PendingTeleportEffect(worldKey, position, chunkPos, ticksUntilLightning - 1);
        }
    }
}
