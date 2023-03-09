package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.resilience_data;

import dev._100media.capabilitysyncer.core.PlayerCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import io.firetamer81.dragonblockbeyond.core.firelib.math.MathHelper;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Arrays;
import java.util.List;

public class ResilienceHolder extends PlayerCapability {

    protected ResilienceHolder(Player player) {
        super(player);
    }

    private int overallResilienceAbilityScore;
    public int getResilienceAbilityScore() { return overallResilienceAbilityScore; }
    public void updateResilienceAbilityScore() {
        List<Integer> nums = Arrays.asList(
                this.headResilience,
                this.neckResilience,
                this.chestResilience,
                this.backResilience,
                this.rightUpperArmResilience,
                this.leftUpperArmResilience,
                this.rightForearmResilience,
                this.leftForearmResilience,
                this.rightHandResilience,
                this.leftHandResilience,
                this.coreResilience,
                this.rightThighResilience,
                this.leftThighResilience,
                this.rightLowerLegResilience,
                this.leftLowerLegResilience,
                this.rightFootResilience,
                this.leftFootResilience
        );

        this.overallResilienceAbilityScore = MathHelper.sumIntList(nums);
    }


    /*--------------------------------------*/

    private int headResilience;
    private final int MINIMUM_HEAD_RESILIENCE = 1;
    private final int MAXIMUM_HEAD_RESILIENCE = 10000;
    public int getHeadResilience() { return headResilience; }
    public void addToHeadResilience(int add) {
        this.headResilience = Math.min(headResilience + add, MAXIMUM_HEAD_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromHeadResilience(int sub) {
        this.headResilience = Math.max(headResilience - sub, MINIMUM_HEAD_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int neckResilience;
    private final int MINIMUM_NECK_RESILIENCE = 1;
    private final int MAXIMUM_NECK_RESILIENCE = 10000;
    public int getNeckResilience() { return neckResilience; }
    public void addToNeckResilience(int add) {
        this.neckResilience = Math.min(neckResilience + add, MAXIMUM_NECK_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromNeckResilience(int sub) {
        this.neckResilience = Math.max(neckResilience - sub, MINIMUM_NECK_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int chestResilience;
    private final int MINIMUM_CHEST_RESILIENCE = 1;
    private final int MAXIMUM_CHEST_RESILIENCE = 10000;
    public int getChestResilience() { return chestResilience; }
    public void addToChestResilience(int add) {
        this.chestResilience = Math.min(chestResilience + add, MAXIMUM_CHEST_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromChestResilience(int sub) {
        this.chestResilience = Math.max(chestResilience - sub, MINIMUM_CHEST_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int backResilience;
    private final int MINIMUM_BACK_RESILIENCE = 1;
    private final int MAXIMUM_BACK_RESILIENCE = 10000;
    public int getBackResilience() { return backResilience; }
    public void addToBackResilience(int add) {
        this.backResilience = Math.min(backResilience + add, MAXIMUM_BACK_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromBackResilience(int sub) {
        this.backResilience = Math.max(backResilience - sub, MINIMUM_BACK_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightUpperArmResilience;
    private final int MINIMUM_RIGHT_UPPER_ARM_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_UPPER_ARM_RESILIENCE = 10000;
    public int getRightUpperArmResilience() { return rightUpperArmResilience; }
    public void addToRightUpperArmResilience(int add) {
        this.rightUpperArmResilience = Math.min(rightUpperArmResilience + add, MAXIMUM_RIGHT_UPPER_ARM_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromRightUpperArmResilience(int sub) {
        this.rightUpperArmResilience = Math.max(rightUpperArmResilience - sub, MINIMUM_RIGHT_UPPER_ARM_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftUpperArmResilience;
    private final int MINIMUM_LEFT_UPPER_ARM_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_UPPER_ARM_RESILIENCE = 10000;
    public int getLeftUpperArmResilience() { return leftUpperArmResilience; }
    public void addToLeftUpperArmResilience(int add) {
        this.leftUpperArmResilience = Math.min(leftUpperArmResilience + add, MAXIMUM_LEFT_UPPER_ARM_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromLeftUpperArmResilience(int sub) {
        this.leftUpperArmResilience = Math.max(leftUpperArmResilience - sub, MINIMUM_LEFT_UPPER_ARM_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightForearmResilience;
    private final int MINIMUM_RIGHT_FOREARM_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_FOREARM_RESILIENCE = 10000;
    public int getRightForearmResilience() { return rightForearmResilience; }
    public void addToRightForearmResilience(int add) {
        this.rightForearmResilience = Math.min(rightForearmResilience + add, MAXIMUM_RIGHT_FOREARM_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromRightForearmResilience(int sub) {
        this.rightForearmResilience = Math.max(rightForearmResilience - sub, MINIMUM_RIGHT_FOREARM_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftForearmResilience;
    private final int MINIMUM_LEFT_FOREARM_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_FOREARM_RESILIENCE = 10000;
    public int getLeftForearmResilience() { return leftForearmResilience; }
    public void addToLeftForearmResilience(int add) {
        this.leftForearmResilience = Math.min(leftForearmResilience + add, MAXIMUM_LEFT_FOREARM_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromLeftForearmResilience(int sub) {
        this.leftForearmResilience = Math.max(leftForearmResilience - sub, MINIMUM_LEFT_FOREARM_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightHandResilience;
    private final int MINIMUM_RIGHT_HAND_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_HAND_RESILIENCE = 10000;
    public int getRightHandResilience() { return rightHandResilience; }
    public void addToRightHandResilience(int add) {
        this.rightHandResilience = Math.min(rightHandResilience + add, MAXIMUM_RIGHT_HAND_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromRightHandResilience(int sub) {
        this.rightHandResilience = Math.max(rightHandResilience - sub, MINIMUM_RIGHT_HAND_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftHandResilience;
    private final int MINIMUM_LEFT_HAND_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_HAND_RESILIENCE = 10000;
    public int getLeftHandResilience() { return leftHandResilience; }
    public void addToLeftHandResilience(int add) {
        this.leftHandResilience = Math.min(leftHandResilience + add, MAXIMUM_LEFT_HAND_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromLeftHandResilience(int sub) {
        this.leftHandResilience = Math.max(leftHandResilience - sub, MINIMUM_LEFT_HAND_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int coreResilience;
    private final int MINIMUM_CORE_RESILIENCE = 1;
    private final int MAXIMUM_CORE_RESILIENCE = 10000;
    public int getCoreResilience() { return coreResilience; }
    public void addToCoreResilience(int add) {
        this.coreResilience = Math.min(coreResilience + add, MAXIMUM_CORE_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromCoreResilience(int sub) {
        this.coreResilience = Math.max(coreResilience - sub, MINIMUM_CORE_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightThighResilience;
    private final int MINIMUM_RIGHT_THIGH_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_THIGH_RESILIENCE = 10000;
    public int getRightThighResilience() { return rightThighResilience; }
    public void addToRightThighResilience(int add) {
        this.rightThighResilience = Math.min(rightThighResilience + add, MAXIMUM_RIGHT_THIGH_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromRightThighResilience(int sub) {
        this.rightThighResilience = Math.max(rightThighResilience - sub, MINIMUM_RIGHT_THIGH_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftThighResilience;
    private final int MINIMUM_LEFT_THIGH_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_THIGH_RESILIENCE = 10000;
    public int getLeftThighResilience() { return leftThighResilience; }
    public void addToLeftThighResilience(int add) {
        this.leftThighResilience = Math.min(leftThighResilience + add, MAXIMUM_LEFT_THIGH_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromLeftThighResilience(int sub) {
        this.leftThighResilience = Math.max(leftThighResilience - sub, MINIMUM_LEFT_THIGH_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLowerLegResilience;
    private final int MINIMUM_RIGHT_LOWER_LEG_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_LOWER_LEG_RESILIENCE = 10000;
    public int getRightLowerLegResilience() { return rightLowerLegResilience; }
    public void addToRightLowerLegResilience(int add) {
        this.rightLowerLegResilience = Math.min(rightLowerLegResilience + add, MAXIMUM_RIGHT_LOWER_LEG_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromRightLowerLegResilience(int sub) {
        this.rightLowerLegResilience = Math.max(rightLowerLegResilience - sub, MINIMUM_RIGHT_LOWER_LEG_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLowerLegResilience;
    private final int MINIMUM_LEFT_LOWER_LEG_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_LOWER_LEG_RESILIENCE = 10000;
    public int getLeftLowerLegResilience() { return leftLowerLegResilience; }
    public void addToLeftLowerLegResilience(int add) {
        this.leftLowerLegResilience = Math.min(leftLowerLegResilience + add, MAXIMUM_LEFT_LOWER_LEG_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromLeftLowerLegResilience(int sub) {
        this.leftLowerLegResilience = Math.max(leftLowerLegResilience - sub, MINIMUM_LEFT_LOWER_LEG_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightFootResilience;
    private final int MINIMUM_RIGHT_FOOT_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_FOOT_RESILIENCE = 10000;
    public int getRightFootResilience() { return rightFootResilience; }
    public void addToRightFootResilience(int add) {
        this.rightFootResilience = Math.min(rightFootResilience + add, MAXIMUM_RIGHT_FOOT_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromRightFootResilience(int sub) {
        this.rightFootResilience = Math.max(rightFootResilience - sub, MINIMUM_RIGHT_FOOT_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftFootResilience;
    private final int MINIMUM_LEFT_FOOT_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_FOOT_RESILIENCE = 10000;
    public int getLeftFootResilience() { return leftFootResilience; }
    public void addToLeftFootResilience(int add) {
        this.leftFootResilience = Math.min(leftFootResilience + add, MAXIMUM_LEFT_FOOT_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }
    public void subFromLeftFootResilience(int sub) {
        this.leftFootResilience = Math.max(leftFootResilience - sub, MINIMUM_LEFT_FOOT_RESILIENCE);
        updateResilienceAbilityScore();
        updateTracking();
    }


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(this.player.getId(), ResilienceHolderAttacher.RESOURCE_LOCATION, this);
    }

    @Override
    public SimpleChannel getNetworkChannel() {
        return NetworkHandler.INSTANCE;
    }

    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();

        tag.putInt("overallResilienceAbilityScore", this.overallResilienceAbilityScore);
        tag.putInt("headResilience", this.headResilience);
        tag.putInt("neckResilience", this.neckResilience);
        tag.putInt("chestResilience", this.chestResilience);
        tag.putInt("backResilience", this.backResilience);
        tag.putInt("rightBicepResilience", this.rightUpperArmResilience);
        tag.putInt("leftBicepResilience", this.leftUpperArmResilience);
        tag.putInt("rightForearmResilience", this.rightForearmResilience);
        tag.putInt("leftForearmResilience", this.leftForearmResilience);
        tag.putInt("rightHandResilience", this.rightHandResilience);
        tag.putInt("leftHandResilience", this.leftHandResilience);
        tag.putInt("coreResilience", this.coreResilience);
        tag.putInt("rightThighResilience", this.rightThighResilience);
        tag.putInt("leftThighResilience", this.leftThighResilience);
        tag.putInt("rightLowerLegResilience", this.rightLowerLegResilience);
        tag.putInt("leftLowerLegResilience", this.leftLowerLegResilience);
        tag.putInt("rightFootResilience", this.rightFootResilience);
        tag.putInt("leftFootResilience", this.leftFootResilience);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        this.overallResilienceAbilityScore = nbt.getInt("overallResilienceAbilityScore");
        this.headResilience = nbt.getInt("headResilience");
        this.neckResilience = nbt.getInt("neckResilience");
        this.chestResilience = nbt.getInt("chestResilience");
        this.backResilience = nbt.getInt("backResilience");
        this.rightUpperArmResilience = nbt.getInt("rightBicepResilience");
        this.leftUpperArmResilience = nbt.getInt("leftBicepResilience");
        this.rightForearmResilience = nbt.getInt("rightForearmResilience");
        this.leftForearmResilience = nbt.getInt("leftForearmResilience");
        this.rightHandResilience = nbt.getInt("rightHandResilience");
        this.leftHandResilience = nbt.getInt("leftHandResilience");
        this.coreResilience = nbt.getInt("coreResilience");
        this.rightThighResilience = nbt.getInt("rightThighResilience");
        this.leftThighResilience = nbt.getInt("leftThighResilience");
        this.rightLowerLegResilience = nbt.getInt("rightLowerLegResilience");
        this.leftLowerLegResilience = nbt.getInt("leftLowerLegResilience");
        this.rightFootResilience = nbt.getInt("rightFootResilience");
        this.leftFootResilience = nbt.getInt("leftFootResilience");
    }
}
