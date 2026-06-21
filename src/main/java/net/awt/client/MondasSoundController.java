package net.awt.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class MondasSoundController {

    private static int tick = 0;
    private static final Random random = new Random();

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(MondasSoundController::tick);
    }

    private static void tick(MinecraftClient client) {
        if (client.world == null || client.player == null) return;

        if (!client.world.getRegistryKey().getValue().getPath().equals("mondas")) return;

        tick++;

        BlockPos pos = client.player.getBlockPos();
        boolean underground = pos.getY() < 60;

        if (tick % (120 + random.nextInt(120)) == 0) {
            client.world.playSound(
                    client.player,
                    pos,
                    SoundEvents.ENTITY_PHANTOM_AMBIENT,
                    net.minecraft.sound.SoundCategory.AMBIENT,
                    1.2f,
                    0.4f
            );
        }

        if (underground && tick % (300 + random.nextInt(200)) == 0) {
            client.world.playSound(
                    client.player,
                    pos,
                    SoundEvents.ENTITY_PHANTOM_AMBIENT,
                    net.minecraft.sound.SoundCategory.AMBIENT,
                    1.5f,
                    0.4f
            );
        }
    }
}