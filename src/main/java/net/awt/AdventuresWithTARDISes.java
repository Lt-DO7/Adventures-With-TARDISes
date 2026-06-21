package net.awt;

import dev.amble.ait.core.AITItems;
import dev.amble.ait.core.tardis.handler.SelfDestructHandler;
import dev.amble.ait.core.handles.HandlesResponse;
import dev.amble.ait.core.handles.HandlesSound;
import dev.amble.ait.core.tardis.ServerTardis;
import dev.amble.ait.core.tardis.handler.TardisCrashHandler;
import dev.amble.ait.registry.impl.HandlesResponseRegistry;
import dev.amble.ait.data.properties.bool.BoolProperty;
import dev.amble.ait.data.properties.bool.BoolValue;

import net.awt.TARDIS.console.AWTConsoleRegistry;
import net.awt.TARDIS.console.AWTConsoleVariantRegistry;
import net.awt.TARDIS.exterior.TardisExteriorRegistry;
import net.awt.TARDIS.exterior.category.AWTCategoryRegistry;
import net.awt.block.ModBlocks;
import net.awt.effect.ModEffects;
import net.awt.entity.ModEntities;
import net.awt.entity.custom.CybermatEntity;
import net.awt.entity.custom.K9Entity;
import net.awt.entity.custom.MondasianCybermanEntity;
import net.awt.entity.custom.ProtoCybermanEntity;
import net.awt.events.UseEvent;
import net.awt.events.UseItemEvent;
import net.awt.item.ModItemGroups;
import net.awt.item.ModItems;
import net.awt.networking.ModPackets;
import net.awt.sound.AWTSound;
import net.awt.world.ModEntitySpawns;
import net.awt.world.gen.ModWorldGeneration;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AdventuresWithTARDISes implements ModInitializer {
    public static final String MOD_ID = "awt";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static final String ENCDATA_JOIN_GIFT_TAG = MOD_ID + ".encdata_join_gift";
    private static final String DEO_JOIN_GIFT_TAG = MOD_ID + ".deo_join_gift";
    private static final String SCARFO_JOIN_GIFT_TAG = MOD_ID + ".scarfo_join_gift";
    private static final String BLUEBERRY_JOIN_GIFT_TAG = MOD_ID + ".blueberry_join_gift";
    private static final String RHAMMII_JOIN_GIFT_TAG = MOD_ID + ".rhammii_join_gift";

    @Override
    public void onInitialize() {

        AWTSound.init();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModEffects.registerEffects();

        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        //wood roundels
        registry.add(ModBlocks.STRIPPED_ACACIA_LOG_ROUNDEL, 5, 5);
        registry.add(ModBlocks.STRIPPED_BIRCH_LOG_ROUNDEL, 5, 5);
        registry.add(ModBlocks.STRIPPED_CHERRY_LOG_ROUNDEL, 5, 5);
        registry.add(ModBlocks.STRIPPED_DARK_OAK_LOG_ROUNDEL, 5, 5);
        registry.add(ModBlocks.STRIPPED_JUNGLE_LOG_ROUNDEL, 5, 5);
        registry.add(ModBlocks.STRIPPED_MANGROVE_LOG_ROUNDEL, 5, 5);
        registry.add(ModBlocks.STRIPPED_OAK_LOG_ROUNDEL, 5, 5);
        registry.add(ModBlocks.STRIPPED_SPRUCE_LOG_ROUNDEL, 5, 5);

        // wood
        registry.add(ModBlocks.PREHISTORIC_PLANKS, 5, 20);
        registry.add(ModBlocks.PREHISTORIC_LOG, 5, 20);
        registry.add(ModBlocks.PREHISTORIC_STAIRS, 5, 20);
        registry.add(ModBlocks.PREHISTORIC_SLAB, 5, 20);
        registry.add(ModBlocks.PREHISTORIC_LEAVES, 10, 50);


        SpawnRestriction.register(
                ModEntities.CYBERMAT,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                MobEntity::canMobSpawn
        );

        ModEntitySpawns.addSpawns();

        TardisExteriorRegistry.onInitialize();
        AWTConsoleRegistry.init();
        AWTConsoleVariantRegistry.init();
        AWTCategoryRegistry.init();

        // Fuel
        FuelRegistry.INSTANCE.add(ModItems.ATRIUM_FUEL, 6400);

        // Handles
        HandlesResponseRegistry.register(new HandlesResponse() {
            @Override
            public boolean run(ServerPlayerEntity player, HandlesSound sound, ServerTardis tardis) {
                tardis.selfDestruct().boom();
                this.sendChat(player, Text.literal("Killing myself."));
                return this.success(sound);
            }

            @Override
            public List<String> getCommandWords() {
                return List.of("kill yourself", "kys");
            }

            @Override
            public Identifier id() {
                return new Identifier(MOD_ID, "kill_yourself");
            }
        });

        UseBlockCallback.EVENT.register(UseEvent.EVENT.invoker());
        UseItemCallback.EVENT.register(UseItemEvent.EVENT.invoker());
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> giveEncDataJoinGift(handler.player));
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> giveDeoJoinGift(handler.player));
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> giveScarfoJoinGift(handler.player));
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> giveBlueBerryJoinGift(handler.player));
        ServerPlayConnectionEvents.JOIN.register((handler, packetSender, minecraftServer) -> giveRhamnousJoinGift(handler.player));

        ModWorldGeneration.generateModWorldGen();
        ModPackets.registerC2SPackets();

        FabricDefaultAttributeRegistry.register(ModEntities.K9, K9Entity.createK9Attributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CYBERMAT, CybermatEntity.createCybermatAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PROTO_CYBERMAN, ProtoCybermanEntity.createCybermanAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MONDASIAN_CYBERMAN, MondasianCybermanEntity.createCybermanAttributes());

        // Resource Packs
        var modContainer = FabricLoader.getInstance().getModContainer("awt").orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt","awtmenubackground"),
                modContainer,
                Text.literal("AWT - Menu Panorama"),
                ResourcePackActivationType.ALWAYS_ENABLED
        );

        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt", "awtmenu2026"),
                modContainer,
                Text.literal("AWT - Main Menu Music (2026)"),
                ResourcePackActivationType.ALWAYS_ENABLED
        );

        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt","awtmenu"),
                modContainer,
                Text.literal("AWT - Main Menu Music (2025)"),
                ResourcePackActivationType.NORMAL
        );

        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt", "awttesterrorsound"),
                modContainer,
                Text.literal("AWT - Alternate Error Sound"),
                ResourcePackActivationType.DEFAULT_ENABLED
        );

        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt", "blueshiftgui"),
                modContainer,
                Text.literal("AWT - Blueshift"),
                ResourcePackActivationType.NORMAL
        );

        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt", "feztastlealt"),
                modContainer,
                Text.literal("Alt Fez Tastle"),
                ResourcePackActivationType.DEFAULT_ENABLED
        );

        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt", "greyedgui"),
                modContainer,
                Text.literal("Grey Shift GUI"),
                ResourcePackActivationType.NORMAL
        );
        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt", "lebronjamesgui"),
                modContainer,
                Text.literal("Lebron James GUI"),
                ResourcePackActivationType.NORMAL
        );

        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier("awt", "redshiftgui"),
                modContainer,
                Text.literal("Red Shift GUI"),
                ResourcePackActivationType.NORMAL
        );

    }

    public static Identifier id(String path) {
        return new Identifier("awt", path);
    }

    private static void giveEncDataJoinGift(ServerPlayerEntity player) {
        if (!player.getUuid().equals(AWTDevTeam.ENCDATA) || player.getCommandTags().contains(ENCDATA_JOIN_GIFT_TAG)) {
            return;
        }

        giveOrDrop(player, new ItemStack(ModItems.VORTEX_MANIPULATOR));
        giveOrDrop(player, new ItemStack(AITItems.TARDIS_ITEM));
        player.addCommandTag(ENCDATA_JOIN_GIFT_TAG);
    }

    private static void giveDeoJoinGift(ServerPlayerEntity player) {
        if (!player.getUuid().equals(AWTDevTeam.DEO) || player.getCommandTags().contains(DEO_JOIN_GIFT_TAG)) {
            return;
        }

        giveOrDrop(player, new ItemStack(AITItems.SONIC_SCREWDRIVER));
        giveOrDrop(player, new ItemStack(AITItems.SKELETON_KEY));
        giveOrDrop(player, new ItemStack(ModItems.VORTEX_MANIPULATOR2));
        giveOrDrop(player, new ItemStack(AITItems.TARDIS_ITEM));
        player.addCommandTag(DEO_JOIN_GIFT_TAG);
    }

    private static void giveScarfoJoinGift(ServerPlayerEntity player) {
        if (!player.getUuid().equals(AWTDevTeam.SCARFO) || player.getCommandTags().contains(SCARFO_JOIN_GIFT_TAG)) {
            return;
        }

        giveOrDrop(player, new ItemStack(AITItems.SKELETON_KEY));
        giveOrDrop(player, new ItemStack(AITItems.SONIC_SCREWDRIVER));
        giveOrDrop(player, new ItemStack(AITItems.TARDIS_ITEM));
        player.addCommandTag(SCARFO_JOIN_GIFT_TAG);
    }


    private static void giveBlueBerryJoinGift(ServerPlayerEntity player) {
        if (!player.getUuid().equals(AWTDevTeam.BLUEBERRY) || player.getCommandTags().contains(BLUEBERRY_JOIN_GIFT_TAG)) {
            return;
        }

        giveOrDrop(player, new ItemStack(AITItems.SONIC_SCREWDRIVER));
        giveOrDrop(player, new ItemStack(AITItems.SKELETON_KEY));
        giveOrDrop(player, new ItemStack(ModItems.VORTEX_MANIPULATOR));
        giveOrDrop(player, new ItemStack(AITItems.TARDIS_ITEM));
        player.addCommandTag(BLUEBERRY_JOIN_GIFT_TAG);
    }

    private static void giveRhamnousJoinGift(ServerPlayerEntity player) {
        if (!player.getUuid().equals(AWTDevTeam.RHAMMII) || player.getCommandTags().contains(RHAMMII_JOIN_GIFT_TAG)) {
    return;
        }

        giveOrDrop(player, new ItemStack(AITItems.SONIC_SCREWDRIVER));
        giveOrDrop(player, new ItemStack(AITItems.GOOD_MAN_MUSIC_DISC));
        giveOrDrop(player, new ItemStack(AITItems.SKELETON_KEY));
        giveOrDrop(player, new ItemStack(AITItems.TARDIS_ITEM));
        player.addCommandTag(RHAMMII_JOIN_GIFT_TAG);
    }
    private static void giveOrDrop(ServerPlayerEntity player, ItemStack stack) {
        if (!player.getInventory().insertStack(stack)) {
            player.dropItem(stack, false);
        }
    }
}
