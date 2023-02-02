package io.firetamer81.dragonblockbeyond.modules.player_data_module.ki;

import dev._100media.capabilitysyncer.core.PlayerCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.simple.SimpleChannel;

public class KiHolder extends PlayerCapability {
    private int ki;
    private final int MINIMUM_KI = 0;
    private final int MAXIMUM_KI = 10;

    protected KiHolder(Player player) {
        super(player);
    }

    public int getKi() { return ki; }

    public void addKi(int add) {
        this.ki = Math.min(ki + add, MAXIMUM_KI);
        updateTracking();
    }

    public void subKi(int sub) {
        this.ki = Math.max(ki - sub, MINIMUM_KI);
        updateTracking();
    }

    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(this.player.getId(), KiHolderAttacher.RESOURCE_LOCATION, this);
    }

    @Override
    public SimpleChannel getNetworkChannel() {
        return NetworkHandler.INSTANCE;
    }

    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();
        tag.putInt("ki", this.ki);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        this.ki = nbt.getInt("ki");
    }
}
