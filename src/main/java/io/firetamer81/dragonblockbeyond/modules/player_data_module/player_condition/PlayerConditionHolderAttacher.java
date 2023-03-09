package io.firetamer81.dragonblockbeyond.modules.player_data_module.player_condition;

import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class PlayerConditionHolderAttacher extends CapabilityAttacher {
    public static final Capability<PlayerConditionHolder> CAPABILITY = getCapability(new CapabilityToken<>() {});
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(DragonBlockBeyond.MODID, "player_condition");
    private static final Class<PlayerConditionHolder> CAPABILITY_CLASS = PlayerConditionHolder.class;

    @SuppressWarnings("ConstantConditions")
    public static PlayerConditionHolder getHolderUnwrap(Player player) {
        return getHolder(player).orElse(null);
    }

    public static LazyOptional<PlayerConditionHolder> getHolder(Player player) {
        return player.getCapability(CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Player entity) {
        genericAttachCapability(event, new PlayerConditionHolder(entity), CAPABILITY, RESOURCE_LOCATION);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerPlayerAttacher(PlayerConditionHolderAttacher::attach, PlayerConditionHolderAttacher::getHolder, true);
    }
}