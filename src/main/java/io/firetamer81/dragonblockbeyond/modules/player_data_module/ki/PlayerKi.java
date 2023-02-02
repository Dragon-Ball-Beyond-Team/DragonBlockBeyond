package io.firetamer81.dragonblockbeyond.modules.player_data_module.ki;

import net.minecraft.nbt.CompoundTag;

public class PlayerKi {
    private int ki;
    private final int MINIMUM_KI = 0;
    private final int MAXIMUM_KI = 10;

    public int getKi() { return ki; }

    public void addKi(int add) { this.ki = Math.min(ki + add, MAXIMUM_KI); }

    public void subKi(int sub) { this.ki = Math.max(ki - sub, MINIMUM_KI); }

    public void copyFrom(PlayerKi source) { this.ki = source.ki; }

    public void saveNBTData(CompoundTag nbt) { nbt.putInt("ki", ki); }

    public void loadNBTData(CompoundTag nbt) { ki = nbt.getInt("ki"); }
}
