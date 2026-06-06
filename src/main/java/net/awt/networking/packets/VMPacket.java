package net.awt.networking.packets;

import net.awt.AWTDevTeam;
import net.awt.item.ModItems;
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
import net.minecraft.text.Text;
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

                if (pending.phase() == TeleportPhase.SOURCE_LIGHTNING) {
                    ServerWorld sourceWorld = server.getWorld(pending.sourceWorldKey());
                    if (sourceWorld == null) {
                        player.removeStatusEffect(StatusEffects.INVISIBILITY);
                        iterator.remove();
                        continue;
                    }

                    if (pending.ticksRemaining() > 0) {
                        entry.setValue(pending.tickDown());
                        continue;
                    }

                    summonCosmeticLightning(sourceWorld, pending.sourcePosition());
                    entry.setValue(pending.nextPhase(TeleportPhase.TELEPORT, 20));
                    continue;
                }

                if (pending.phase() == TeleportPhase.TELEPORT) {
                    ServerWorld targetWorld = server.getWorld(pending.targetWorldKey());
                    if (targetWorld == null) {
                        player.removeStatusEffect(StatusEffects.INVISIBILITY);
                        iterator.remove();
                        continue;
                    }

                    if (pending.ticksRemaining() > 0) {
                        entry.setValue(pending.tickDown());
                        continue;
                    }

                    if (!targetWorld.isChunkLoaded(pending.targetChunkPos().x(), pending.targetChunkPos().z())) {
                        continue;
                    }

                    FabricDimensions.teleport(player, targetWorld, new TeleportTarget(
                        pending.targetPosition(),
                        player.getVelocity(),
                        player.getYaw(),
                        player.getPitch()
                    ));
                    entry.setValue(pending.nextPhase(TeleportPhase.TARGET_LIGHTNING, 20));
                    continue;
                }

                ServerWorld world = server.getWorld(pending.targetWorldKey());
                if (world == null) {
                    player.removeStatusEffect(StatusEffects.INVISIBILITY);
                    iterator.remove();
                    continue;
                }

                if (pending.ticksRemaining() > 0) {
                    entry.setValue(pending.tickDown());
                    continue;
                }

                if (player.getServerWorld() != world) {
                    continue;
                }

                if (!world.isChunkLoaded(pending.targetChunkPos().x(), pending.targetChunkPos().z())) {
                    continue;
                }

                summonCosmeticLightning(world, pending.targetPosition());
                player.removeStatusEffect(StatusEffects.INVISIBILITY);
                iterator.remove();
            }
        });
    }

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        boolean targetPlayerMode = buf.readBoolean();

        if (PENDING_EFFECTS.containsKey(player.getUuid())) {
            player.sendMessage(Text.literal("Vortex Manipulator teleport already in progress."), true);
            return;
        }

        if (!AWTDevTeam.ENCDATA.equals(player.getUuid()) && !awt$hasVortexManipulator(player)) {
            player.sendMessage(Text.literal("You need a Vortex Manipulator to use this teleport."), true);
            return;
        }

        ServerWorld targetWorld;
        Vec3d targetPos;

        if (targetPlayerMode) {
            String targetPlayerName = buf.readString();
            ServerPlayerEntity targetPlayer = server.getPlayerManager().getPlayer(targetPlayerName);
            if (targetPlayer == null) {
                player.sendMessage(Text.literal("Player not found: " + targetPlayerName), true);
                return;
            }

            targetWorld = targetPlayer.getServerWorld();
            targetPos = targetPlayer.getPos();
        } else {
            String dim = buf.readString().toLowerCase();
            double x = buf.readDouble();
            double y = buf.readDouble();
            double z = buf.readDouble();

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

            targetWorld = serverWorld;
            targetPos = new Vec3d(x, y, z);
        }

        ServerWorld finalServerWorld = targetWorld;
        Vec3d finalTargetPos = targetPos;
        server.execute(() -> {
            ServerWorld sourceWorld = player.getServerWorld();
            Vec3d sourcePos = player.getPos();
            BlockPos targetBlockPos = BlockPos.ofFloored(finalTargetPos);

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 45, 0, false, false, false));

            PENDING_EFFECTS.put(player.getUuid(), new PendingTeleportEffect(
                    sourceWorld.getRegistryKey(),
                    sourcePos,
                    finalServerWorld.getRegistryKey(),
                    finalTargetPos,
                    new ChunkPosKey(targetBlockPos.getX() >> 4, targetBlockPos.getZ() >> 4),
                    TeleportPhase.SOURCE_LIGHTNING,
                    1
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

    private static boolean awt$hasVortexManipulator(ServerPlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getInventory().getStack(i).isOf(ModItems.VORTEX_MANIPULATOR)
                || player.getInventory().getStack(i).isOf(ModItems.VORTEX_MANIPULATOR2)) {
                return true;
            }
        }
        return false;
    }

    private record ChunkPosKey(int x, int z) {
    }

    private enum TeleportPhase {
        SOURCE_LIGHTNING,
        TELEPORT,
        TARGET_LIGHTNING
    }

    private record PendingTeleportEffect(RegistryKey<World> sourceWorldKey, Vec3d sourcePosition,
                                         RegistryKey<World> targetWorldKey, Vec3d targetPosition,
                                         ChunkPosKey targetChunkPos, TeleportPhase phase, int ticksRemaining) {
        private PendingTeleportEffect tickDown() {
            return new PendingTeleportEffect(sourceWorldKey, sourcePosition, targetWorldKey, targetPosition,
                targetChunkPos, phase, ticksRemaining - 1);
        }

        private PendingTeleportEffect nextPhase(TeleportPhase nextPhase, int nextTicksRemaining) {
            return new PendingTeleportEffect(sourceWorldKey, sourcePosition, targetWorldKey, targetPosition,
                targetChunkPos, nextPhase, nextTicksRemaining);
        }
    }
}
