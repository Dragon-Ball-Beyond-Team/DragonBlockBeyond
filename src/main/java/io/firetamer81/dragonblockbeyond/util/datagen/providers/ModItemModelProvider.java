package io.firetamer81.dragonblockbeyond.util.datagen.providers;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.modules.namek_module.NamekModule;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(NamekModule.AJISA_FLOWERS.get());
        basicItem(NamekModule.NAMEK_KELP_BUDS.get());
    }

    /*
    private ItemModelBuilder handheldItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DragonBlockBeyond.MODID,"item/" + item.getRegistryName().getPath()));
    }
    */
}
