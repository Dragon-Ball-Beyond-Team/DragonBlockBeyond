package io.firetamer81.dragonblockbeyond;

import com.mojang.logging.LogUtils;
import io.firetamer81.dragonblockbeyond.init.handlers.RegistryHandler;
import io.firetamer81.dragonblockbeyond.init.handlers.TextureHandler;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DragonBlockBeyond.MODID)
public class DragonBlockBeyond {
    public static final String MODID = "dragonblockbeyond";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DragonBlockBeyond() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegistryHandler.init(modEventBus);
        //TextureHandler.init();

        //modEventBus.addListener(this::setup);
        //modEventBus.addListener(this::enqueueIMC);
        modEventBus.register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }



    /*
    public void setup(final FMLCommonSetupEvent event) {
        PacketHandler.register();

        event.enqueueWork(() -> DispenserBlock.registerBehavior(StrongBlockModule.PAINT_BUCKET.get(),
                new DispensePaintbucketBehaviour()));
    }

    public void enqueueIMC(final InterModEnqueueEvent event) {
        if (ModList.get().isLoaded("theoneprobe")) {
            InterModComms.sendTo("theoneprobe", "getTheOneProbe", TOPMain::new);
        }
    }
    */
}
