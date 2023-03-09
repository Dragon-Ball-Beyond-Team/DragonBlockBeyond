package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.strength_data;

import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class StrengthHolderAttacher extends CapabilityAttacher {
    public static final Capability<StrengthHolder> CAPABILITY = getCapability(new CapabilityToken<>() {});
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(DragonBlockBeyond.MODID, "strength");
    private static final Class<StrengthHolder> CAPABILITY_CLASS = StrengthHolder.class;

    @SuppressWarnings("ConstantConditions")
    public static StrengthHolder getHolderUnwrap(Player player) {
        return getHolder(player).orElse(null);
    }

    public static LazyOptional<StrengthHolder> getHolder(Player player) {
        return player.getCapability(CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Player entity) {
        genericAttachCapability(event, new StrengthHolder(entity), CAPABILITY, RESOURCE_LOCATION);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerPlayerAttacher(StrengthHolderAttacher::attach, StrengthHolderAttacher::getHolder, true);
    }
}
