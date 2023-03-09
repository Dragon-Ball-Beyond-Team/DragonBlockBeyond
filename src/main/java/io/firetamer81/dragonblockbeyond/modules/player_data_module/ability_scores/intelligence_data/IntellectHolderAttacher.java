package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.intelligence_data;

import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class IntellectHolderAttacher extends CapabilityAttacher {
    public static final Capability<IntellectHolder> CAPABILITY = getCapability(new CapabilityToken<>() {});
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(DragonBlockBeyond.MODID, "intellect");
    private static final Class<IntellectHolder> CAPABILITY_CLASS = IntellectHolder.class;

    @SuppressWarnings("ConstantConditions")
    public static IntellectHolder getHolderUnwrap(Player player) {
        return getHolder(player).orElse(null);
    }

    public static LazyOptional<IntellectHolder> getHolder(Player player) {
        return player.getCapability(CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Player entity) {
        genericAttachCapability(event, new IntellectHolder(entity), CAPABILITY, RESOURCE_LOCATION);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerPlayerAttacher(IntellectHolderAttacher::attach, IntellectHolderAttacher::getHolder, true);
    }
}
