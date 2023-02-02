package io.firetamer81.dragonblockbeyond.init.events;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.init.handlers.KeyBindHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DragonBlockBeyond.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        //ItemBlockRenderTypes.setRenderLayer(NamekModule.SHORT_NAMEK_GRASS.get(), RenderType.cutoutMipped());

        //ItemBlockRenderTypes.setRenderLayer(NamekModule.NAMEK_FLUID_SOURCE.get(), RenderType.translucent());
        //ItemBlockRenderTypes.setRenderLayer(NamekModule.NAMEK_FLUID_FLOWING.get(), RenderType.translucent());
        //ItemBlockRenderTypes.setRenderLayer(NamekModule.NAMEK_FLUID_BLOCK.get(), RenderType.translucent());
    }
}
