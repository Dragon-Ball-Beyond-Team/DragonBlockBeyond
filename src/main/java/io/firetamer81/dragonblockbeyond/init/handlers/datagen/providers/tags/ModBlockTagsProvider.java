package io.firetamer81.dragonblockbeyond.init.handlers.datagen.providers.tags;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {


    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DragonBlockBeyond.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
       /*
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(StrongBlockModule.WARENAI_FULL_BLOCK.get())
            .add(StrongBlockModule.WARENAI_STAIRS_BLOCK.get())
            .add(StrongBlockModule.WARENAI_SLAB_BLOCK.get())
            .add(StrongBlockModule.WARENAI_FENCE_BLOCK.get())
            .add(StrongBlockModule.WARENAI_GLASS.get())
            .add(StrongBlockModule.WARENAI_GLASS_SLAB.get())
            .add(StrongBlockModule.WARENAI_GLASS_STAIRS.get());

        this.tag(BlockTags.WALLS)
            .add(StrongBlockModule.WARENAI_WALL_BLOCK.get());

        this.tag(BlockTags.FENCES)
            .add(StrongBlockModule.WARENAI_FENCE_BLOCK.get());

        this.tag(BlockTags.LOGS)
            .add(NamekModule.NAMEK_LOG.get());
         */
    }
}
