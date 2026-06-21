package net.awt.client.renderers;

import net.awt.AdventuresWithTARDISes;
import net.awt.client.models.armor.PrehistoricBootsArmorModel;
import net.awt.client.models.armor.PrehistoricChestplateArmorModel;
import net.awt.client.models.armor.PrehistoricHelmetArmorModel;
import net.awt.client.models.armor.PrehistoricLeggingsArmorModel;
import net.awt.entity.client.ModModelLayers;
import net.awt.item.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public final class PrehistoricArmorRenderer implements ArmorRenderer {
    private static final Identifier HELMET_TEXTURE = AdventuresWithTARDISes.id("textures/models/armor/prehistoric_helmet.png");
    private static final Identifier CHESTPLATE_TEXTURE = AdventuresWithTARDISes.id("textures/models/armor/prehistoric_chestplate.png");
    private static final Identifier LEGGINGS_TEXTURE = AdventuresWithTARDISes.id("textures/models/armor/prehistoric_leggings.png");
    private static final Identifier BOOTS_TEXTURE = AdventuresWithTARDISes.id("textures/models/armor/prehistoric_boots.png");

    private static PrehistoricHelmetArmorModel helmetModel;
    private static PrehistoricChestplateArmorModel chestplateModel;
    private static PrehistoricLeggingsArmorModel leggingsModel;
    private static PrehistoricBootsArmorModel bootsModel;

    public static void register() {
        ArmorRenderer renderer = new PrehistoricArmorRenderer();
        ArmorRenderer.register(renderer,
                ModItems.PREHISTORIC_HELMET,
                ModItems.PREHISTORIC_CHESTPLATE,
                ModItems.PREHISTORIC_LEGGINGS,
                ModItems.PREHISTORIC_BOOTS);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        BipedEntityModel<LivingEntity> model = getModel(slot);
        if (model == null) {
            return;
        }

        contextModel.copyBipedStateTo(model);
        setVisibleParts(model, slot);
        ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, model, getTexture(slot));
    }

    private static BipedEntityModel<LivingEntity> getModel(EquipmentSlot slot) {
        var loader = MinecraftClient.getInstance().getEntityModelLoader();

        return switch (slot) {
            case HEAD -> {
                if (helmetModel == null) {
                    helmetModel = new PrehistoricHelmetArmorModel(loader.getModelPart(ModModelLayers.PREHISTORIC_HELMET_ARMOR));
                }
                yield helmetModel;
            }
            case CHEST -> {
                if (chestplateModel == null) {
                    chestplateModel = new PrehistoricChestplateArmorModel(loader.getModelPart(ModModelLayers.PREHISTORIC_CHESTPLATE_ARMOR));
                }
                yield chestplateModel;
            }
            case LEGS -> {
                if (leggingsModel == null) {
                    leggingsModel = new PrehistoricLeggingsArmorModel(loader.getModelPart(ModModelLayers.PREHISTORIC_LEGGINGS_ARMOR));
                }
                yield leggingsModel;
            }
            case FEET -> {
                if (bootsModel == null) {
                    bootsModel = new PrehistoricBootsArmorModel(loader.getModelPart(ModModelLayers.PREHISTORIC_BOOTS_ARMOR));
                }
                yield bootsModel;
            }
            default -> null;
        };
    }

    private static Identifier getTexture(EquipmentSlot slot) {
        return switch (slot) {
            case HEAD -> HELMET_TEXTURE;
            case CHEST -> CHESTPLATE_TEXTURE;
            case LEGS -> LEGGINGS_TEXTURE;
            case FEET -> BOOTS_TEXTURE;
            default -> HELMET_TEXTURE;
        };
    }

    private static void setVisibleParts(BipedEntityModel<LivingEntity> model, EquipmentSlot slot) {
        model.setVisible(false);

        switch (slot) {
            case HEAD -> {
                model.head.visible = true;
                model.hat.visible = false;
            }
            case CHEST -> {
                model.body.visible = true;
                model.rightArm.visible = true;
                model.leftArm.visible = true;
            }
            case LEGS -> {
                model.body.visible = true;
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
            }
            case FEET -> {
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
            }
            default -> {
            }
        }
    }
}
