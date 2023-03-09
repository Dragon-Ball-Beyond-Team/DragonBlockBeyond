package io.firetamer81.dragonblockbeyond.modules.namekmodule;

import io.firetamer81.dragonblockbeyond.core.firelib.ModuleBase;
import io.firetamer81.dragonblockbeyond.init.handlers.RegistryHandler;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class NamekModule extends ModuleBase {
    public static void init() {}

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public static final RegistryObject<Item> AJISA_FLOWERS = registerItem("ajisa_flowers",
            () -> new Item(new Item.Properties()), RegistryHandler.ITEMS);

    public static final RegistryObject<Item> NAMEK_KELP_BUDS = registerItem("namek_kelp_buds",
            () -> new Item(new Item.Properties()), RegistryHandler.ITEMS);

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    //hi

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    //hi

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    //hi

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    //hi

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}
