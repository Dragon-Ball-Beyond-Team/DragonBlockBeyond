package io.firetamer81.dragonblockbeyond.modules.player_data_module.strength_data;

import dev._100media.capabilitysyncer.core.PlayerCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.simple.SimpleChannel;

public class StrengthHolder extends PlayerCapability {
    protected StrengthHolder(Player player) {
        super(player);
    }

    private int overallStrengthAbilityScore;
    private final int MINIMUM_STRENGTH = 1;
    private final int MAXIMUM_STRENGTH = 130000;
    public int getStrengthAbilityScore() { return overallStrengthAbilityScore; }

    public void addToStrengthAbilityScore(int add) {
        this.overallStrengthAbilityScore = Math.min(overallStrengthAbilityScore + add, MAXIMUM_STRENGTH);
        updateTracking();
    }
    public void subFromStrengthAbilityScore(int sub) {
        this.overallStrengthAbilityScore = Math.max(overallStrengthAbilityScore - sub, MINIMUM_STRENGTH);
        updateTracking();
    }

    /*--------------------------------------*/

    private int jawStrength;
    private final int MINIMUM_JAW_STRENGTH = 1;
    private final int MAXIMUM_JAW_STRENGTH = 10000;
    public int getJawStrength() { return jawStrength; }
    public void addToJawStrength(int add) {
        this.jawStrength = Math.min(jawStrength + add, MAXIMUM_JAW_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromJawStrength(int sub) {
        this.jawStrength = Math.max(jawStrength - sub, MINIMUM_JAW_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int neckStrength;
    private final int MINIMUM_NECK_STRENGTH = 1;
    private final int MAXIMUM_NECK_STRENGTH = 10000;
    public int getNeckStrength() { return neckStrength; }
    public void addToNeckStrength(int add) {
        this.neckStrength = Math.min(neckStrength + add, MAXIMUM_NECK_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromNeckStrength(int sub) {
        this.neckStrength = Math.max(neckStrength - sub, MINIMUM_NECK_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int pectoralisStrength;
    private final int MINIMUM_PECTORALIS_STRENGTH = 1;
    private final int MAXIMUM_PECTORALIS_STRENGTH = 10000;
    public int getPectoralisStrength() { return pectoralisStrength; }
    public void addToPectoralisStrength(int add) {
        this.pectoralisStrength = Math.min(pectoralisStrength + add, MAXIMUM_PECTORALIS_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromPectoralisStrength(int sub) {
        this.pectoralisStrength = Math.max(pectoralisStrength - sub, MINIMUM_PECTORALIS_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int backStrength;
    private final int MINIMUM_BACK_STRENGTH = 1;
    private final int MAXIMUM_BACK_STRENGTH = 10000;
    public int getBackStrength() { return backStrength; }
    public void addToBackStrength(int add) {
        this.backStrength = Math.min(backStrength + add, MAXIMUM_BACK_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromBackStrength(int sub) {
        this.backStrength = Math.max(backStrength - sub, MINIMUM_BACK_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightBicepStrength;
    private final int MINIMUM_RIGHT_BICEP_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_BICEP_STRENGTH = 10000;
    public int getRightBicepStrength() { return rightBicepStrength; }
    public void addToRightBicepStrength(int add) {
        this.rightBicepStrength = Math.min(rightBicepStrength + add, MAXIMUM_RIGHT_BICEP_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromRightBicepStrength(int sub) {
        this.rightBicepStrength = Math.max(rightBicepStrength - sub, MINIMUM_RIGHT_BICEP_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftBicepStrength;
    private final int MINIMUM_LEFT_BICEP_STRENGTH = 1;
    private final int MAXIMUM_LEFT_BICEP_STRENGTH = 10000;
    public int getLeftBicepStrength() { return leftBicepStrength; }
    public void addToLeftBicepStrength(int add) {
        this.leftBicepStrength = Math.min(leftBicepStrength + add, MAXIMUM_LEFT_BICEP_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromLeftBicepStrength(int sub) {
        this.leftBicepStrength = Math.max(leftBicepStrength - sub, MINIMUM_LEFT_BICEP_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightForearmStrength; //(RightHandGripStrength)
    private final int MINIMUM_RIGHT_FOREARM_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_FOREARM_STRENGTH = 10000;
    public int getRightForearmStrength() { return rightForearmStrength; }
    public void addToRightForearmStrength(int add) {
        this.rightForearmStrength = Math.min(rightForearmStrength + add, MAXIMUM_RIGHT_FOREARM_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromRightForearmStrength(int sub) {
        this.rightForearmStrength = Math.max(rightForearmStrength - sub, MINIMUM_RIGHT_FOREARM_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftForearmStrength; //(LeftHandGripStrength)
    private final int MINIMUM_LEFT_FOREARM_STRENGTH = 1;
    private final int MAXIMUM_LEFT_FOREARM_STRENGTH = 10000;
    public int getLeftForearmStrength() { return leftForearmStrength; }
    public void addToLeftForearmStrength(int add) {
        this.leftForearmStrength = Math.min(leftForearmStrength + add, MAXIMUM_LEFT_FOREARM_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromLeftForearmStrength(int sub) {
        this.leftForearmStrength = Math.max(leftForearmStrength - sub, MINIMUM_LEFT_FOREARM_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int coreStrength;
    private final int MINIMUM_CORE_STRENGTH = 1;
    private final int MAXIMUM_CORE_STRENGTH = 10000;
    public int getCoreStrength() { return coreStrength; }
    public void addToCoreStrength(int add) {
        this.coreStrength = Math.min(coreStrength + add, MAXIMUM_CORE_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromCoreStrength(int sub) {
        this.coreStrength = Math.max(coreStrength - sub, MINIMUM_CORE_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightThighStrength;
    private final int MINIMUM_RIGHT_THIGH_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_THIGH_STRENGTH = 10000;
    public int getRightThighStrength() { return rightThighStrength; }
    public void addToRightThighStrength(int add) {
        this.rightThighStrength = Math.min(rightThighStrength + add, MAXIMUM_RIGHT_THIGH_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromRightThighStrength(int sub) {
        this.rightThighStrength = Math.max(rightThighStrength - sub, MINIMUM_RIGHT_THIGH_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftThighStrength;
    private final int MINIMUM_LEFT_THIGH_STRENGTH = 1;
    private final int MAXIMUM_LEFT_THIGH_STRENGTH = 10000;
    public int getLeftThighStrength() { return leftThighStrength; }
    public void addToLeftThighStrength(int add) {
        this.leftThighStrength = Math.min(leftThighStrength + add, MAXIMUM_LEFT_THIGH_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromLeftThighStrength(int sub) {
        this.leftThighStrength = Math.max(leftThighStrength - sub, MINIMUM_LEFT_THIGH_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLowerLegStrength;
    private final int MINIMUM_RIGHT_LOWER_LEG_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_LOWER_LEG_STRENGTH = 10000;
    public int getRightLowerLegStrength() { return rightLowerLegStrength; }
    public void addToRightLowerLegStrength(int add) {
        this.rightLowerLegStrength = Math.min(rightLowerLegStrength + add, MAXIMUM_RIGHT_LOWER_LEG_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromRightLowerLegStrength(int sub) {
        this.rightLowerLegStrength = Math.max(rightLowerLegStrength - sub, MINIMUM_RIGHT_LOWER_LEG_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLowerLegStrength;
    private final int MINIMUM_LEFT_LOWER_LEG_STRENGTH = 1;
    private final int MAXIMUM_LEFT_LOWER_LEG_STRENGTH = 10000;
    public int getLeftLowerLegStrength() { return leftLowerLegStrength; }
    public void addToLeftLowerLegStrength(int add) {
        this.leftLowerLegStrength = Math.min(leftLowerLegStrength + add, MAXIMUM_LEFT_LOWER_LEG_STRENGTH);
        addToStrengthAbilityScore(add);
        updateTracking();
    }
    public void subFromLeftLowerLegStrength(int sub) {
        this.leftLowerLegStrength = Math.max(leftLowerLegStrength - sub, MINIMUM_LEFT_LOWER_LEG_STRENGTH);
        subFromStrengthAbilityScore(sub);
        updateTracking();
    }


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(this.player.getId(), StrengthHolderAttacher.RESOURCE_LOCATION, this);
    }

    @Override
    public SimpleChannel getNetworkChannel() {
        return NetworkHandler.INSTANCE;
    }

    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();

        tag.putInt("overallStrengthAbilityScore", this.overallStrengthAbilityScore);
        tag.putInt("neckStrength", this.neckStrength);
        tag.putInt("pectoralisStrength", this.pectoralisStrength);
        tag.putInt("backStrength", this.backStrength);
        tag.putInt("rightBicepStrength", this.rightBicepStrength);
        tag.putInt("leftBicepStrength", this.leftBicepStrength);
        tag.putInt("rightForearmStrength", this.rightForearmStrength);
        tag.putInt("leftForearmStrength", this.leftForearmStrength);
        tag.putInt("coreStrength", this.coreStrength);
        tag.putInt("rightThighStrength", this.rightThighStrength);
        tag.putInt("leftThighStrength", this.leftThighStrength);
        tag.putInt("rightCalfStrength", this.rightLowerLegStrength);
        tag.putInt("leftCalfStrength", this.leftLowerLegStrength);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        this.overallStrengthAbilityScore = nbt.getInt("overallStrengthAbilityScore");
        this.neckStrength = nbt.getInt("neckStrength");
        this.pectoralisStrength = nbt.getInt("pectoralisStrength");
        this.backStrength = nbt.getInt("backStrength");
        this.rightBicepStrength = nbt.getInt("rightBicepStrength");
        this.leftBicepStrength = nbt.getInt("leftBicepStrength");
        this.rightForearmStrength = nbt.getInt("rightForearmStrength");
        this.leftForearmStrength = nbt.getInt("leftForearmStrength");
        this.coreStrength = nbt.getInt("coreStrength");
        this.rightThighStrength = nbt.getInt("rightThighStrength");
        this.leftThighStrength = nbt.getInt("leftThighStrength");
        this.rightLowerLegStrength = nbt.getInt("rightCalfStrength");
        this.leftLowerLegStrength = nbt.getInt("leftCalfStrength");
    }
}
