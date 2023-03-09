package io.firetamer81.dragonblockbeyond.modules.player_data_module.player_condition;

import dev._100media.capabilitysyncer.core.PlayerCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.simple.SimpleChannel;

/**
 * The purpose of this class is to hold data on the players "condition".
 * What's their health at, are they missing limbs, how much ki do they have, etc.
 *
 * This is planned to be done through math and packets determining minimums and maximums
 * while taking into account ability scores and such.
 */
public class PlayerConditionHolder extends PlayerCapability {

    protected PlayerConditionHolder(Player player) {
        super(player);
    }


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    private int health;
    private final int MINIMUM_HEALTH = 0;
    private final int MAXIMUM_HEALTH = 10;
    public int getHealth() { return health; }
    public void addHealth(int add) {
        this.health = Math.min(health + add, MAXIMUM_HEALTH);
        updateTracking();
    }
    public void subHealth(int sub) {
        this.health = Math.max(health - sub, MINIMUM_HEALTH);
        updateTracking();
    }


    /*--------------------------------------*/


    private int ki;
    private final int MINIMUM_KI = 0;
    private final int MAXIMUM_KI = 10;
    public int getKi() { return ki; }
    public void addKi(int add) {
        this.ki = Math.min(ki + add, MAXIMUM_KI);
        updateTracking();
    }
    public void subKi(int sub) {
        this.ki = Math.max(ki - sub, MINIMUM_KI);
        updateTracking();
    }


    /*--------------------------------------*/

    //TODO Flesh Out the Ki Instability Data points & Math here.

    private float totalKiInstability;
    private final float MINIMUM_KI_INSTABILITY = 0;
    private final float MAXIMUM_KI_INSTABILITY = 100.00f;

    /**
     * This data point is meant to be "sticky" and negative. You DON'T want this to score
     * to be high, and it is difficult to get rid of.
     *
     * This data point is meant to be interconnected to the "softKiInstability" data point
     * in some way.
     */
    private float hardKiInstability;
    public float getHardKiInstability() { return hardKiInstability; }
    public void addToHardKiInstability(float add) {
        this.hardKiInstability = Math.min(hardKiInstability + add, MAXIMUM_KI_INSTABILITY);
        //addToKiMasteryAbilityScore(add);
        updateTracking();
    }
    public void subFromHardKiInstability(float sub) {
        this.hardKiInstability = Math.max(hardKiInstability - sub, MINIMUM_KI_INSTABILITY);
        //subFromKiMasteryAbilityScore(sub);
        updateTracking();
    }

    /**
     * This data point is meant to slowly degrade over time. This will be gotten by overcharging
     * ki skills/attacks & other things like kaio-ken.
     */
    private float kiInstability;
    public float getKiInstability() { return kiInstability; }
    public void addToKiInstability(float add) {
        this.kiInstability = Math.min(kiInstability + add, MAXIMUM_KI_INSTABILITY);
        //addToKiMasteryAbilityScore(add);
        updateTracking();
    }
    public void subFromKiInstability(float sub) {
        this.kiInstability = Math.max(kiInstability - sub, MINIMUM_KI_INSTABILITY);
        //subFromKiMasteryAbilityScore(sub);
        updateTracking();
    }


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(this.player.getId(), PlayerConditionHolderAttacher.RESOURCE_LOCATION, this);
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
