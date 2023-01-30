package io.firetamer81.dragonblockbeyond.handlers.datagen.providers;

import io.firetamer81.dragonblockbeyond.modules.namek_module.NamekModule;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    //TODO Possibly make 1 or more custom recipe categories for the mod.
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, NamekModule.NAMEK_KELP_BUDS.get())
                .define('E', Blocks.DIRT)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_dirt", inventoryTrigger(
                        ItemPredicate.Builder.item().of(Blocks.DIRT).build()))
                .save(finishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NamekModule.AJISA_FLOWERS.get())
                .requires(Blocks.COBBLESTONE)
                .unlockedBy("has_cobblestone_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Blocks.COBBLESTONE).build()))
                .save(finishedRecipeConsumer);
    }
}
