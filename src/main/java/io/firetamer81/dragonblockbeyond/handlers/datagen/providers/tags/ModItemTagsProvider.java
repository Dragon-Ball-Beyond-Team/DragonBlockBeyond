package io.firetamer81.dragonblockbeyond.handlers.datagen.providers.tags;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, TagsProvider<Block> blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, blockTagsProvider, DragonBlockBeyond.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //copy(Tags.Blocks.COBBLESTONE_DEEPSLATE, Tags.Items.COBBLESTONE_DEEPSLATE);
        //tag(Tags.Items.CROPS).addTags(Tags.Items.CROPS_BEETROOT, Tags.Items.CROPS_CARROT);
        //tag(Tags.Items.CROPS_BEETROOT).add(Items.BEETROOT);
    }
}
