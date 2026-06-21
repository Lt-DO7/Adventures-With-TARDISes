package net.awt;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;

public class MondasWeatherController {

    public static void init() {
        ServerTickEvents.END_SERVER_TICK.register(MondasWeatherController::onTick);
    }

    private static void onTick(MinecraftServer server) {
        for (ServerWorld world : server.getWorlds()) {

            if (world.getRegistryKey().getValue().getPath().equals("mondas")) {

                // Force constant rain (becomes snow in cold biomes)
                world.setWeather(0, 1000000, true, false);

                // Optional: lock weather cycle
                server.getGameRules()
                        .get(net.minecraft.world.GameRules.DO_WEATHER_CYCLE)
                        .set(false, server);
            }
        }
    }
}