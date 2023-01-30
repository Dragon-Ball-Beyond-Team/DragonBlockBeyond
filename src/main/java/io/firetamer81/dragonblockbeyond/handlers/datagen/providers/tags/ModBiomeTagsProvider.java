package io.firetamer81.dragonblockbeyond.handlers.datagen.providers.tags;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagsProvider extends BiomeTagsProvider {
    public ModBiomeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, DragonBlockBeyond.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        //tag(Biomes.PLAINS, Tags.Biomes.IS_PLAINS);
        //tag(Biomes.DESERT, Tags.Biomes.IS_HOT_OVERWORLD, Tags.Biomes.IS_DRY_OVERWORLD, Tags.Biomes.IS_SANDY, Tags.Biomes.IS_DESERT);

        //tag(Tags.Biomes.IS_COLD).addTag(Tags.Biomes.IS_COLD_OVERWORLD).addOptionalTag(Tags.Biomes.IS_COLD_NETHER.location()).addTag(Tags.Biomes.IS_COLD_END);
    }

    @SafeVarargs
    private void tag(ResourceKey<Biome> biome, TagKey<Biome>... tags) {
        for(TagKey<Biome> key : tags) {
            tag(key).add(biome);
        }
    }

    @Override
    public String getName() { return "DragonBlockBeyond Biome Tags"; }
}

