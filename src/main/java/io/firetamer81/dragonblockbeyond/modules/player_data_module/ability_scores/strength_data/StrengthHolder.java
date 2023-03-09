package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.strength_data;

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

public class StrengthHolder extends PlayerCapability {
    protected StrengthHolder(Player player) {
        super(player);
    }

    private int overallStrengthAbilityScore;
    public int getStrengthAbilityScore() { return overallStrengthAbilityScore; }
    public void updateStrengthAbilityScore() {
        List<Integer> nums = Arrays.asList(
                this.overallStrengthAbilityScore,
                this.neckStrength,
                this.pectoralisStrength,
                this.backStrength,
                this.rightUpperArmStrength,
                this.leftUpperArmStrength,
                this.rightForearmStrength,
                this.leftForearmStrength,
                this.coreStrength,
                this.rightThighStrength,
                this.leftThighStrength,
                this.rightLowerLegStrength,
                this.leftLowerLegStrength
        );

        this.overallStrengthAbilityScore = MathHelper.sumIntList(nums);
    }

    /*--------------------------------------*/

    /**
     * Bite attacks?
     */
    private int jawStrength;
    private final int MINIMUM_JAW_STRENGTH = 1;
    private final int MAXIMUM_JAW_STRENGTH = 10000;
    public int getJawStrength() { return jawStrength; }
    public void addToJawStrength(int add) {
        this.jawStrength = Math.min(jawStrength + add, MAXIMUM_JAW_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromJawStrength(int sub) {
        this.jawStrength = Math.max(jawStrength - sub, MINIMUM_JAW_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    /**
     * Headbutts?
     */
    private int neckStrength;
    private final int MINIMUM_NECK_STRENGTH = 1;
    private final int MAXIMUM_NECK_STRENGTH = 10000;
    public int getNeckStrength() { return neckStrength; }
    public void addToNeckStrength(int add) {
        this.neckStrength = Math.min(neckStrength + add, MAXIMUM_NECK_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromNeckStrength(int sub) {
        this.neckStrength = Math.max(neckStrength - sub, MINIMUM_NECK_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int pectoralisStrength;
    private final int MINIMUM_PECTORALIS_STRENGTH = 1;
    private final int MAXIMUM_PECTORALIS_STRENGTH = 10000;
    public int getPectoralisStrength() { return pectoralisStrength; }
    public void addToPectoralisStrength(int add) {
        this.pectoralisStrength = Math.min(pectoralisStrength + add, MAXIMUM_PECTORALIS_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromPectoralisStrength(int sub) {
        this.pectoralisStrength = Math.max(pectoralisStrength - sub, MINIMUM_PECTORALIS_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int backStrength;
    private final int MINIMUM_BACK_STRENGTH = 1;
    private final int MAXIMUM_BACK_STRENGTH = 10000;
    public int getBackStrength() { return backStrength; }
    public void addToBackStrength(int add) {
        this.backStrength = Math.min(backStrength + add, MAXIMUM_BACK_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromBackStrength(int sub) {
        this.backStrength = Math.max(backStrength - sub, MINIMUM_BACK_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightUpperArmStrength;
    private final int MINIMUM_RIGHT_UPPER_ARM_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_UPPER_ARM_STRENGTH = 10000;
    public int getRightUpperArmStrength() { return rightUpperArmStrength; }
    public void addToRightUpperArmStrength(int add) {
        this.rightUpperArmStrength = Math.min(rightUpperArmStrength + add, MAXIMUM_RIGHT_UPPER_ARM_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromRightUpperArmStrength(int sub) {
        this.rightUpperArmStrength = Math.max(rightUpperArmStrength - sub, MINIMUM_RIGHT_UPPER_ARM_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftUpperArmStrength;
    private final int MINIMUM_LEFT_UPPER_ARM_STRENGTH = 1;
    private final int MAXIMUM_LEFT_UPPER_ARM_STRENGTH = 10000;
    public int getLeftUpperArmStrength() { return leftUpperArmStrength; }
    public void addToLeftUpperArmStrength(int add) {
        this.leftUpperArmStrength = Math.min(leftUpperArmStrength + add, MAXIMUM_LEFT_UPPER_ARM_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromLeftUpperArmStrength(int sub) {
        this.leftUpperArmStrength = Math.max(leftUpperArmStrength - sub, MINIMUM_LEFT_UPPER_ARM_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightForearmStrength; //(RightHandGripStrength)
    private final int MINIMUM_RIGHT_FOREARM_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_FOREARM_STRENGTH = 10000;
    public int getRightForearmStrength() { return rightForearmStrength; }
    public void addToRightForearmStrength(int add) {
        this.rightForearmStrength = Math.min(rightForearmStrength + add, MAXIMUM_RIGHT_FOREARM_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromRightForearmStrength(int sub) {
        this.rightForearmStrength = Math.max(rightForearmStrength - sub, MINIMUM_RIGHT_FOREARM_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftForearmStrength; //(LeftHandGripStrength)
    private final int MINIMUM_LEFT_FOREARM_STRENGTH = 1;
    private final int MAXIMUM_LEFT_FOREARM_STRENGTH = 10000;
    public int getLeftForearmStrength() { return leftForearmStrength; }
    public void addToLeftForearmStrength(int add) {
        this.leftForearmStrength = Math.min(leftForearmStrength + add, MAXIMUM_LEFT_FOREARM_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromLeftForearmStrength(int sub) {
        this.leftForearmStrength = Math.max(leftForearmStrength - sub, MINIMUM_LEFT_FOREARM_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int coreStrength;
    private final int MINIMUM_CORE_STRENGTH = 1;
    private final int MAXIMUM_CORE_STRENGTH = 10000;
    public int getCoreStrength() { return coreStrength; }
    public void addToCoreStrength(int add) {
        this.coreStrength = Math.min(coreStrength + add, MAXIMUM_CORE_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromCoreStrength(int sub) {
        this.coreStrength = Math.max(coreStrength - sub, MINIMUM_CORE_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightThighStrength;
    private final int MINIMUM_RIGHT_THIGH_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_THIGH_STRENGTH = 10000;
    public int getRightThighStrength() { return rightThighStrength; }
    public void addToRightThighStrength(int add) {
        this.rightThighStrength = Math.min(rightThighStrength + add, MAXIMUM_RIGHT_THIGH_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromRightThighStrength(int sub) {
        this.rightThighStrength = Math.max(rightThighStrength - sub, MINIMUM_RIGHT_THIGH_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftThighStrength;
    private final int MINIMUM_LEFT_THIGH_STRENGTH = 1;
    private final int MAXIMUM_LEFT_THIGH_STRENGTH = 10000;
    public int getLeftThighStrength() { return leftThighStrength; }
    public void addToLeftThighStrength(int add) {
        this.leftThighStrength = Math.min(leftThighStrength + add, MAXIMUM_LEFT_THIGH_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromLeftThighStrength(int sub) {
        this.leftThighStrength = Math.max(leftThighStrength - sub, MINIMUM_LEFT_THIGH_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLowerLegStrength;
    private final int MINIMUM_RIGHT_LOWER_LEG_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_LOWER_LEG_STRENGTH = 10000;
    public int getRightLowerLegStrength() { return rightLowerLegStrength; }
    public void addToRightLowerLegStrength(int add) {
        this.rightLowerLegStrength = Math.min(rightLowerLegStrength + add, MAXIMUM_RIGHT_LOWER_LEG_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromRightLowerLegStrength(int sub) {
        this.rightLowerLegStrength = Math.max(rightLowerLegStrength - sub, MINIMUM_RIGHT_LOWER_LEG_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLowerLegStrength;
    private final int MINIMUM_LEFT_LOWER_LEG_STRENGTH = 1;
    private final int MAXIMUM_LEFT_LOWER_LEG_STRENGTH = 10000;
    public int getLeftLowerLegStrength() { return leftLowerLegStrength; }
    public void addToLeftLowerLegStrength(int add) {
        this.leftLowerLegStrength = Math.min(leftLowerLegStrength + add, MAXIMUM_LEFT_LOWER_LEG_STRENGTH);
        updateStrengthAbilityScore();
        updateTracking();
    }
    public void subFromLeftLowerLegStrength(int sub) {
        this.leftLowerLegStrength = Math.max(leftLowerLegStrength - sub, MINIMUM_LEFT_LOWER_LEG_STRENGTH);
        updateStrengthAbilityScore();
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
        tag.putInt("rightBicepStrength", this.rightUpperArmStrength);
        tag.putInt("leftBicepStrength", this.leftUpperArmStrength);
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
        this.rightUpperArmStrength = nbt.getInt("rightBicepStrength");
        this.leftUpperArmStrength = nbt.getInt("leftBicepStrength");
        this.rightForearmStrength = nbt.getInt("rightForearmStrength");
        this.leftForearmStrength = nbt.getInt("leftForearmStrength");
        this.coreStrength = nbt.getInt("coreStrength");
        this.rightThighStrength = nbt.getInt("rightThighStrength");
        this.leftThighStrength = nbt.getInt("leftThighStrength");
        this.rightLowerLegStrength = nbt.getInt("rightCalfStrength");
        this.leftLowerLegStrength = nbt.getInt("leftCalfStrength");
    }
}
