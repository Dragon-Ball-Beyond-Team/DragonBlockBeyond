package io.firetamer81.dragonblockbeyond.handlers.datagen;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.handlers.datagen.providers.ModItemModelProvider;
import io.firetamer81.dragonblockbeyond.handlers.datagen.providers.ModRecipeProvider;
import io.firetamer81.dragonblockbeyond.handlers.datagen.providers.lang.EnUSLangDataProvider;
import io.firetamer81.dragonblockbeyond.handlers.datagen.providers.tags.*;
import io.firetamer81.dragonblockbeyond.handlers.datagen.providers.ModBlockStateProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.*;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = DragonBlockBeyond.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneratorHandler {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper =event.getExistingFileHelper();

        //Client Data Providers
        generator.addProvider(event.includeClient(), new EnUSLangDataProvider(packOutput));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        //Object Tag Providers
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutput, lookupProvider, blockTags, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModEntityTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModBiomeTagsProvider(packOutput, lookupProvider, existingFileHelper));

        //Server Data Providers
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));

        //TODO Figure out how to do a loot table provider; Example - package net.minecraftforge.common.data.ForgeLootTableProvider;
        //TODO Look into the "SpriteSourceProvider" thing as it could be a replacement for my existing sprite system; Example - package net.minecraftforge.common.data.ForgeSpriteSourceProvider;
    }
}
