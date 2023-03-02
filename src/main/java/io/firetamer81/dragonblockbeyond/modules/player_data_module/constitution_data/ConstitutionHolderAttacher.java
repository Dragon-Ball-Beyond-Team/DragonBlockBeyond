package io.firetamer81.dragonblockbeyond.modules.player_data_module.constitution_data;

import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.strength_data.StrengthHolder;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.strength_data.StrengthHolderAttacher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class ConstitutionHolderAttacher extends CapabilityAttacher {
    public static final Capability<ConstitutionHolder> CAPABILITY = getCapability(new CapabilityToken<ConstitutionHolder>() {});
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(DragonBlockBeyond.MODID, "constitution");
    private static final Class<ConstitutionHolder> CAPABILITY_CLASS = ConstitutionHolder.class;

    @SuppressWarnings("ConstantConditions")
    public static ConstitutionHolder getHolderUnwrap(Player player) {
        return getHolder(player).orElse(null);
    }

    public static LazyOptional<ConstitutionHolder> getHolder(Player player) {
        return player.getCapability(CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Player entity) {
        genericAttachCapability(event, new ConstitutionHolder(entity), CAPABILITY, RESOURCE_LOCATION);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerPlayerAttacher(ConstitutionHolderAttacher::attach, ConstitutionHolderAttacher::getHolder, true);
    }
}
