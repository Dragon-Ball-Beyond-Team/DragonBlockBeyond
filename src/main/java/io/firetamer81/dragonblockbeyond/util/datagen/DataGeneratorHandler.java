package io.firetamer81.dragonblockbeyond.util.datagen;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.util.datagen.providers.*;
import io.firetamer81.dragonblockbeyond.util.datagen.providers.lang.EnUSLangDataProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DragonBlockBeyond.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneratorHandler {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper =event.getExistingFileHelper();

        generator.addProvider(new ModRecipeProvider(packOutput));

        if (event.includeClient()) {
            generator.addProvider(new EnUSLangDataProvider(generator));
            generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
            generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
        }
        if (event.includeServer()) {
            generator.addProvider(new ModLootTableProvider(generator));
            generator.addProvider(new ModBlockTagsProvider(generator, existingFileHelper));
        }
    }
}
