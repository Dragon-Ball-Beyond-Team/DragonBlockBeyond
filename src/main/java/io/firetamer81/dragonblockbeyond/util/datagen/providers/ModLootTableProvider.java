package io.firetamer81.dragonblockbeyond.util.datagen.providers;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import io.firetamer81.dragonblockbeyond.util.datagen.providers.loot.ModBlockLootTables;
import io.firetamer81.dragonblockbeyond.util.datagen.providers.loot.ModChestLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>>
            loot_tables = ImmutableList.of(Pair.of(ModBlockLootTables::new, LootContextParamSets.BLOCK),
            Pair.of(ModChestLootTables::new, LootContextParamSets.CHEST));

    public ModLootTableProvider(PackOutput p_254123_, Set<ResourceLocation> p_254481_, List<SubProviderEntry> p_253798_) {
        super(p_254123_, p_254481_, p_253798_);
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return loot_tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationcontext) {
        map.forEach((id, table) -> LootTables.validate(validationcontext, id, table));
    }
}
