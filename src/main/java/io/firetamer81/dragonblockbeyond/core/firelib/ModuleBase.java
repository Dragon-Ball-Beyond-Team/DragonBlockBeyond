package io.firetamer81.dragonblockbeyond.core.firelib;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModuleBase {


    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /**
     * Used for registering blocks without a corresponding blockItem.
     */
    protected static <T extends Block> RegistryObject<T> registerBlockNoItem(String name, Supplier<T> block, DeferredRegister<Block> blockRegister) {
        return blockRegister.register(name, block);
    }

    /**
     * Used when you want to automatically register a block and a corresponding basic block item
     */
    protected static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, DeferredRegister<Block> blockRegister, DeferredRegister<Item> itemRegister) {
        return registerBlock(name, block, b -> () -> new BlockItem(b.get(), getItemProperties()), blockRegister, itemRegister);
    }

    /**
     * Can be used on it's own when registering a block and a custom blockItem (useful for making a block that stores data in it's blockItem). Otherwise it is the inner method of the above registerBlock
     */
    protected static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Function<RegistryObject<T>, Supplier<? extends BlockItem>> item,
                                                                       DeferredRegister<Block> blockRegister, DeferredRegister<Item> itemRegister) {
        var reg = blockRegister.register(name, block);
        itemRegister.register(name, () -> item.apply(reg).get());
        return reg;
    }


    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /**
     * Registers Items to a given Deferred Register
     */
    protected static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item, DeferredRegister<Item> itemRegister) {
        var reg = itemRegister.register(name, item);
        return reg;
    }

    /**
     * More methods of this type could possibly be made for commonly used Item.Property configurations
     * @return a new blank Item.Properties
     */
    public static Item.Properties getItemProperties() {
        return new Item.Properties();
    }


    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /**
     * Registers Fluids to a given Deferred Register
     */
    protected static <T extends FlowingFluid> RegistryObject<T> registerFluid(String name, Supplier<T> fluid, DeferredRegister<Fluid> fluidRegister) {
        var reg = fluidRegister.register(name, fluid);
        return reg;
    }

    /**
     * Creates a tag key for Fluids from a resource location. Used to reference fluids without using blockstates.
     */
    public static TagKey<Fluid> createFluidKey(String modid, String name) {
        return FluidTags.create(new ResourceLocation(modid, name));
    }


    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /**
     * registerMenuType - Used to create a GUI for containers(Holds item data. Possibly other types of data Too?)
     */
    protected static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name, DeferredRegister<MenuType<?>> containerMenuRegister) {
        return containerMenuRegister.register(name, () -> IForgeMenuType.create(factory));
    }
}
