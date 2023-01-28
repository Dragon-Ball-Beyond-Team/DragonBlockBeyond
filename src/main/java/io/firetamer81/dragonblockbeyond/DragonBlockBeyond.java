package io.firetamer81.dragonblockbeyond;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DragonBlockBeyond.MODID)
public class DragonBlockBeyond {
    public static final String MODID = "dragonblockbeyond";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DragonBlockBeyond() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
