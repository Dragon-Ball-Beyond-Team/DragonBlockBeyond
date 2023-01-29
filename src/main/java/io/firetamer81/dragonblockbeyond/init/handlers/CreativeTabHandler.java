package io.firetamer81.dragonblockbeyond.init.handlers;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DragonBlockBeyond.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabHandler {

    @SubscribeEvent
    public static void addCreativeTabItems(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeTabHandler.MOD_BUILDING_BLOCKS) {
            event.accept(Items.ACACIA_LOG);
        }

        if (event.getTab() == CreativeTabHandler.MOD_ENVIRONMENTAL_BLOCKS) {
            event.accept(Items.ACACIA_LOG);
        }

        if (event.getTab() == CreativeTabHandler.MOD_MACHINE_BLOCKS) {
            event.accept(Items.ACACIA_LOG);
        }

        if (event.getTab() == CreativeTabHandler.MOD_RECIPE_ITEMS) {
            event.accept(Items.ACACIA_LOG);
        }

        if (event.getTab() == CreativeTabHandler.MOD_ARMOUR_ITEMS) {
            event.accept(Items.ACACIA_LOG);
        }

        if (event.getTab() == CreativeTabHandler.MOD_TOOLS_ITEMS) {
            event.accept(Items.ACACIA_LOG);
        }

        if (event.getTab() == CreativeTabHandler.MOD_WIP_OBJECTS) {
            event.accept(Items.ACACIA_LOG);
        }
    }


    /****************************************************************/
    //--------------------------------------------------------------//


    public static CreativeModeTab MOD_BUILDING_BLOCKS;
    public static CreativeModeTab MOD_ENVIRONMENTAL_BLOCKS;
    public static CreativeModeTab MOD_MACHINE_BLOCKS;
    public static CreativeModeTab MOD_RECIPE_ITEMS;
    public static CreativeModeTab MOD_ARMOUR_ITEMS;
    public static CreativeModeTab MOD_TOOLS_ITEMS;
    public static CreativeModeTab MOD_WIP_OBJECTS;

    @SubscribeEvent
    public static void registerCreativeTabs(CreativeModeTabEvent.Register event) {
        MOD_BUILDING_BLOCKS = event.registerCreativeModeTab(new ResourceLocation(DragonBlockBeyond.MODID, "dbb_build_tab"),
                builder -> builder.icon(() -> new ItemStack(Items.STONE_BRICKS)).build());

        MOD_ENVIRONMENTAL_BLOCKS = event.registerCreativeModeTab(new ResourceLocation(DragonBlockBeyond.MODID, "dbb_environmental_tab"),
                builder -> builder.icon(() -> new ItemStack(Items.WEEPING_VINES)).build());

        MOD_MACHINE_BLOCKS = event.registerCreativeModeTab(new ResourceLocation(DragonBlockBeyond.MODID, "dbb_machines_tab"),
                builder -> builder.icon(() -> new ItemStack(Items.FURNACE)).build());

        MOD_RECIPE_ITEMS = event.registerCreativeModeTab(new ResourceLocation(DragonBlockBeyond.MODID, "dbb_recipe_items_tab"),
                builder -> builder.icon(() -> new ItemStack(Items.CRAFTING_TABLE)).build());

        MOD_ARMOUR_ITEMS = event.registerCreativeModeTab(new ResourceLocation(DragonBlockBeyond.MODID, "dbb_armour_tab"),
                builder -> builder.icon(() -> new ItemStack(Items.ARMOR_STAND)).build());

        MOD_TOOLS_ITEMS = event.registerCreativeModeTab(new ResourceLocation(DragonBlockBeyond.MODID, "dbb_tools_tab"),
                builder -> builder.icon(() -> new ItemStack(Items.NETHERITE_PICKAXE)).build());

        MOD_WIP_OBJECTS = event.registerCreativeModeTab(new ResourceLocation(DragonBlockBeyond.MODID, "dbb_wip_tab"),
                builder -> builder.icon(() -> new ItemStack(Items.BARRIER)).build());
    }
}
