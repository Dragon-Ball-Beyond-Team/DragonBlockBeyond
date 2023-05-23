package io.firetamer81.dragonblockbeyond;

import com.mojang.logging.LogUtils;
import io.firetamer81.dragonblockbeyond.init.handlers.RegistryHandler;
import io.firetamer81.dragonblockbeyond.init.handlers.TextureHandler;
import io.firetamer81.dragonblockbeyond.modules.playerdatamodule.abilityscores.AbilityScoresHolderAttacher;
import io.firetamer81.dragonblockbeyond.modules.playerdatamodule.playercondition.PlayerConditionHolderAttacher;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DragonBlockBeyond.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DragonBlockBeyond {
    public static final String MODID = "dragonblockbeyond";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DragonBlockBeyond() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RegistryHandler.init(modEventBus);
        TextureHandler.init();

        /*--------------------------------------*/

        modEventBus.register(this);
        MinecraftForge.EVENT_BUS.register(this);

        /*--------------------------------------*/

        PlayerConditionHolderAttacher.register();
        AbilityScoresHolderAttacher.register();
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        NetworkHandler.register();
    }
}
