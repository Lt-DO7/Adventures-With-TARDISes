package net.awt;

import dev.amble.ait.core.AITSounds;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.awt.TARDIS.console.client.AWTClientConsoleVariantRegistry;
import net.awt.TARDIS.exterior.TardisExteriorRegistry;
import net.awt.block.ModBlocks;
import net.awt.client.models.armor.PrehistoricBootsArmorModel;
import net.awt.client.models.armor.PrehistoricChestplateArmorModel;
import net.awt.client.models.armor.PrehistoricHelmetArmorModel;
import net.awt.client.models.armor.PrehistoricLeggingsArmorModel;
import net.awt.client.renderers.PrehistoricArmorRenderer;
import net.awt.components.ModComponents;
import net.awt.entity.ModEntities;
import net.awt.entity.client.*;
import net.awt.entity.custom.K9Entity;
import net.awt.entity.custom.CybermatEntity;
import net.awt.fluid.ModFluids;
import net.awt.item.ModItems;
import net.awt.item.custom.sonicglasses.SonicGlassesOverlay;
import net.awt.networking.ModPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.command.CommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;

public class AdventureWithTARDISesClient implements ClientModInitializer {
    public static KeyBinding SwitchGlassesMode;

    @Override
    public void onInitializeClient() {
        TardisExteriorRegistry.registerClientAddonExteriors();
        AWTClientConsoleVariantRegistry.init();

        TrinketRendererRegistry.registerRenderer(ModItems.SONIC_GLASSES, (TrinketRenderer) ModItems.SONIC_GLASSES);
        HudRenderCallback.EVENT.register(new SonicGlassesOverlay());

        TrinketRendererRegistry.registerRenderer(ModItems.DBZ_SCOUTER, (TrinketRenderer) ModItems.DBZ_SCOUTER);
        TrinketRendererRegistry.registerRenderer(ModItems.TRUSTABLE_HAT, (TrinketRenderer) ModItems.TRUSTABLE_HAT);

        TrinketRendererRegistry.registerRenderer(ModItems.BOWTIE, (TrinketRenderer) ModItems.BOWTIE);
        TrinketRendererRegistry.registerRenderer(ModItems.PURPLEBOWTIE, (TrinketRenderer) ModItems.PURPLEBOWTIE);
        TrinketRendererRegistry.registerRenderer(ModItems.MAGENTABOWTIE, (TrinketRenderer) ModItems.MAGENTABOWTIE);
        TrinketRendererRegistry.registerRenderer(ModItems.ORANGEBOWTIE, (TrinketRenderer) ModItems.ORANGEBOWTIE);
        TrinketRendererRegistry.registerRenderer(ModItems.GREYBOWTIE, (TrinketRenderer) ModItems.GREYBOWTIE);
        TrinketRendererRegistry.registerRenderer(ModItems.GREENBOWTIE, (TrinketRenderer) ModItems.GREENBOWTIE);
        TrinketRendererRegistry.registerRenderer(ModItems.CYANBOWTIE, (TrinketRenderer) ModItems.CYANBOWTIE);
        TrinketRendererRegistry.registerRenderer(ModItems.BLUEBOWTIE, (TrinketRenderer) ModItems.BLUEBOWTIE);

        TrinketRendererRegistry.registerRenderer(ModItems.EYESTALK, (TrinketRenderer) ModItems.EYESTALK);

        TrinketRendererRegistry.registerRenderer(ModItems.FEZ, (TrinketRenderer) ModItems.FEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.FANCYFEZ, (TrinketRenderer) ModItems.FANCYFEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.PURPLEFEZ, (TrinketRenderer) ModItems.PURPLEFEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.PINKFEZ, (TrinketRenderer) ModItems.PINKFEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.ORANGEFEZ, (TrinketRenderer) ModItems.ORANGEFEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.GREENFEZ, (TrinketRenderer) ModItems.GREENFEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.GREYFEZ, (TrinketRenderer) ModItems.GREYFEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.BLUEFEZ, (TrinketRenderer) ModItems.BLUEFEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.DARKBLUEFEZ, (TrinketRenderer) ModItems.DARKBLUEFEZ);
        TrinketRendererRegistry.registerRenderer(ModItems.YELLOWFEZ, (TrinketRenderer) ModItems.YELLOWFEZ);


        ModPackets.registerS2CPackets();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRATE_BLOCK,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.THICK_GRATE_BLOCK,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUSTY_GRATE_BLOCK,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUSTY_THICK_GRATE_BLOCK,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PREHISTORIC_LEAVES,RenderLayer.getCutout());
      //  BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WASTED_BUSH_PLANT,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WASTED_LEAVES,RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_RADIATION, ModFluids.FLOWING_RADIATION);
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_RADIATION, ModFluids.FLOWING_RADIATION,
                new SimpleFluidRenderHandler(
                        new Identifier(AdventuresWithTARDISes.MOD_ID, "fluid/radiation_still"),
                        new Identifier(AdventuresWithTARDISes.MOD_ID, "fluid/radiation_flow")
                ));

        EntityRendererRegistry.register(ModEntities.K9, K9Renderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.K9, K9Model::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.LASER, LaserRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LASER, LaserModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PROTO_CYBERMAN, ProtoCybermanRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PROTO_CYBERMAN, ProtoCybermanModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MONDASIAN_CYBERMAN, MondasianCybermanRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MONDASIAN_CYBERMAN, MondasianCybermanModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CYBERMAT, CybermatRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CYBERMAT, CybermatModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PREHISTORIC_HELMET_ARMOR, PrehistoricHelmetArmorModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PREHISTORIC_CHESTPLATE_ARMOR, PrehistoricChestplateArmorModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PREHISTORIC_LEGGINGS_ARMOR, PrehistoricLeggingsArmorModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PREHISTORIC_BOOTS_ARMOR, PrehistoricBootsArmorModel::getTexturedModelData);
        PrehistoricArmorRenderer.register();

        SonicGlassesKeybind();
        registerEncDataCommands();

        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelIdentifier(AdventuresWithTARDISes.MOD_ID, "fez3d", "inventory"));
    }

    private void SonicGlassesKeybind() {
        SwitchGlassesMode = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.awt.sgm",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "category.awt"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (SwitchGlassesMode.wasPressed() && minecraftClient.player != null) {
                if (minecraftClient.player.isSneaking()) {
                    ClientPlayNetworking.send(ModPackets.SGSM_PACKET, new PacketByteBuf(PacketByteBufs.create()));
                    minecraftClient.player.playSound(AITSounds.SONIC_SWITCH, 1, 1);
                } else {
                    Entity entity = MinecraftClient.getInstance().getCameraEntity();
                    HitResult blockHit = entity.raycast(5.0, 0.0F, false);

                    if (blockHit.getType() == net.minecraft.util.hit.HitResult.Type.BLOCK) {
                        BlockPos hitblock = ((BlockHitResult) blockHit).getBlockPos();
                        ClientPlayNetworking.send(ModPackets.SGU_PACKET, new PacketByteBuf(PacketByteBufs.create().writeBlockPos(hitblock).writeBoolean(true)));
                    } else {
                        ClientPlayNetworking.send(ModPackets.SGU_PACKET, new PacketByteBuf(PacketByteBufs.create().writeBlockPos(new BlockPos(0,0,0)).writeBoolean(false)));
                    }
                }
            }
        });
    }

    private void registerEncDataCommands() {
        // EncData-only client test command for driving the Vortex Manipulator teleport flow directly.
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommandManager.literal("VortexManipulatorTP")
                    .requires(source -> source.getPlayer() != null && awt$isVmDev(source.getPlayer().getUuid()))
                    .then(ClientCommandManager.argument("x", com.mojang.brigadier.arguments.DoubleArgumentType.doubleArg())
                            .then(ClientCommandManager.argument("y", com.mojang.brigadier.arguments.DoubleArgumentType.doubleArg())
                                    .then(ClientCommandManager.argument("z", com.mojang.brigadier.arguments.DoubleArgumentType.doubleArg())
                                            .then(ClientCommandManager.argument("dimension", com.mojang.brigadier.arguments.StringArgumentType.word())
                                                    .suggests((context, builder) -> CommandSource.suggestIdentifiers(
                                                            context.getSource().getClient().getNetworkHandler().getWorldKeys().stream()
                                                                    .map(net.minecraft.registry.RegistryKey::getValue),
                                                            builder
                                                    ))
                                                    .executes(context -> {
                                                        double x = com.mojang.brigadier.arguments.DoubleArgumentType.getDouble(context, "x");
                                                        double y = com.mojang.brigadier.arguments.DoubleArgumentType.getDouble(context, "y");
                                                        double z = com.mojang.brigadier.arguments.DoubleArgumentType.getDouble(context, "z");
                                                        String dimension = com.mojang.brigadier.arguments.StringArgumentType.getString(context, "dimension").trim();

                                                        PacketByteBuf payload = PacketByteBufs.create();
                                                        payload.writeBoolean(false);
                                                        payload.writeString(dimension);
                                                        payload.writeDouble(x);
                                                        payload.writeDouble(y);
                                                        payload.writeDouble(z);
                                                        ClientPlayNetworking.send(ModPackets.VM_PACKET, payload);
                                                        return 1;
                                                    })))))
            );

            dispatcher.register(ClientCommandManager.literal("VortexManipulatorTPPlayer")
                    .requires(source -> source.getPlayer() != null && awt$isVmDev(source.getPlayer().getUuid()))
                    .then(ClientCommandManager.argument("player", com.mojang.brigadier.arguments.StringArgumentType.word())
                            .suggests((context, builder) -> CommandSource.suggestMatching(
                                    context.getSource().getClient().getNetworkHandler().getPlayerList().stream()
                                            .map(entry -> entry.getProfile().getName()),
                                    builder
                            ))
                            .executes(context -> {
                                String playerName = com.mojang.brigadier.arguments.StringArgumentType.getString(context, "player");

                                PacketByteBuf payload = PacketByteBufs.create();
                                payload.writeBoolean(true);
                                payload.writeString(playerName);
                                ClientPlayNetworking.send(ModPackets.VM_PACKET, payload);
                                return 1;
                            }))
            );
        });
    }

    private static boolean awt$isVmDev(java.util.UUID uuid) {
        return AWTDevTeam.ENCDATA.equals(uuid) || AWTDevTeam.DEO.equals(uuid);
    }
}
