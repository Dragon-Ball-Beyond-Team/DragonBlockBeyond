package io.firetamer81.dragonblockbeyond.handlers.datagen.providers;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DragonBlockBeyond.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //simpleBlock(Blocks.AMETHYST_BLOCK);
    }
}
