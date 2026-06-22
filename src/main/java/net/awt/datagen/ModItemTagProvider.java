package net.awt.datagen;


import net.awt.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)  {
        super(output, completableFuture);}

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.DRWHOVALE_MUSIC_DISC)
                .add(ModItems.DOCTORWHOXV_MUSIC_DISC)
                .add(ModItems.PARALYZER_MUSIC_DISC)
                .add(ModItems.DOCTORWHO1411_MUSIC_DISC)
                .add(ModItems.DUGGA_DOO_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.DRWHOVALE_MUSIC_DISC)
                .add(ModItems.DOCTORWHOXV_MUSIC_DISC)
                .add(ModItems.PARALYZER_MUSIC_DISC)
                .add(ModItems.DOCTORWHO1411_MUSIC_DISC)
                .add(ModItems.DUGGA_DOO_MUSIC_DISC);


        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.DALEKANIUM_HELMET, ModItems.DALEKANIUM_CHESTPLATE, ModItems.DALEKANIUM_LEGGINGS, ModItems.DALEKANIUM_BOOTS)
                .add(ModItems.STEEL_HELMET, ModItems.STEEL_CHESTPLATE, ModItems.STEEL_LEGGINGS, ModItems.STEEL_BOOTS)
                .add(ModItems.METALERTANIUM_HELMET, ModItems.METALERTANIUM_CHESTPLATE, ModItems.METALERTANIUM_LEGGINGS, ModItems.METALERTANIUM_BOOTS);

    }
}
