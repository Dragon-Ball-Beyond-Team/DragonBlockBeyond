package io.firetamer81.dragonblockbeyond.util.datagen.providers.loot;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.data.loot.packs.VanillaChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ModChestLootTables extends VanillaChestLoot {
    private static final ResourceLocation CUSTOM_CHEST_LOOT =
            new ResourceLocation(DragonBlockBeyond.MODID, "chests/custom_chest_loot");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> lootTableBuilder) {
        /*
        lootTableBuilder.accept(CUSTOM_CHEST_LOOT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0F, 3.0F))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                ));
        */
    }
}
