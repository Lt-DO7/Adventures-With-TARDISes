package net.awt.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleTypes;

public class MondasStormClient {

    private static int tickCounter = 0;

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> tick(client));
    }

    private static void tick(MinecraftClient client) {
        if (client.world == null || client.player == null) return;

        ClientWorld world = client.world;

        if (!world.getRegistryKey().getValue().getPath().equals("mondas")) return;

        tickCounter++;

        // spawn snow every few ticks (performance safe)
        if (tickCounter % 2 == 0) {

            double x = client.player.getX() + (world.random.nextDouble() * 20 - 10);
            double y = client.player.getY() + 10;
            double z = client.player.getZ() + (world.random.nextDouble() * 20 - 10);

            world.addParticle(
                    ParticleTypes.SNOWFLAKE,
                    x, y, z,
                    0, -0.3, 0
            );
        }
    }
}