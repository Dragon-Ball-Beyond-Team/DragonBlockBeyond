package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.dexterity_data;

import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class DexterityHolderAttacher extends CapabilityAttacher {
    public static final Capability<DexterityHolder> CAPABILITY = getCapability(new CapabilityToken<>() {});
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(DragonBlockBeyond.MODID, "dexterity");
    private static final Class<DexterityHolder> CAPABILITY_CLASS = DexterityHolder.class;

    @SuppressWarnings("ConstantConditions")
    public static DexterityHolder getHolderUnwrap(Player player) {
        return getHolder(player).orElse(null);
    }

    public static LazyOptional<DexterityHolder> getHolder(Player player) {
        return player.getCapability(CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Player entity) {
        genericAttachCapability(event, new DexterityHolder(entity), CAPABILITY, RESOURCE_LOCATION);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerPlayerAttacher(DexterityHolderAttacher::attach, DexterityHolderAttacher::getHolder, true);
    }
}
