package io.firetamer81.dragonblockbeyond.init.events;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.modules.playerdatamodule.playercondition.PlayerConditionHolderAttacher;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DragonBlockBeyond.MODID)
public class CommonModEvents {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            PlayerConditionHolderAttacher.getHolder(event.player).ifPresent(ki -> {
                if(ki.getKi() > 0 && event.player.getRandom().nextFloat() < 0.005f) { // Once Every 10 Seconds on Avg
                    ki.subKi(1);
                    event.player.sendSystemMessage(Component.literal("Subtracted Ki"));
                }
            });
        }
    }
}
