package io.firetamer81.dragonblockbeyond.util.datagen.providers.loot;

import io.firetamer81.dragonblockbeyond.init.handlers.RegistryHandler;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

//TODO Every single registered block requires a loot table to be done here. Otherwise, an error will occur when generating data
public class ModBlockLootTables extends VanillaBlockLoot {


    @Override
    protected void generate() {
        //this.dropSelf(Blocks.COBBLESTONE);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegistryHandler.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
