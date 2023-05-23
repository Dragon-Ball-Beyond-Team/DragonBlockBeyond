package io.firetamer81.dragonblockbeyond.modules.playerdatamodule.abilityscores;

import dev._100media.capabilitysyncer.core.PlayerCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import io.firetamer81.dragonblockbeyond.core.firelib.util.MathHelper;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Arrays;
import java.util.List;

public class AbilityScoresHolder extends PlayerCapability {

    protected AbilityScoresHolder(Player player) { super(player); }


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    //<editor-fold desc="Strength Scores Data Methods">
    private int overallStrengthAbilityScore;
    public int getStrengthAbilityScore() {
        updateStrengthAbilityScore();

        return overallStrengthAbilityScore;
    }
    public void updateStrengthAbilityScore() {
        List<Integer> nums = Arrays.asList(
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

        updateTracking();
    }
    public void subFromJawStrength(int sub) {
        this.jawStrength = Math.max(jawStrength - sub, MINIMUM_JAW_STRENGTH);

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

        updateTracking();
    }
    public void subFromNeckStrength(int sub) {
        this.neckStrength = Math.max(neckStrength - sub, MINIMUM_NECK_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int pectoralisStrength;
    private final int MINIMUM_PECTORALIS_STRENGTH = 1;
    private final int MAXIMUM_PECTORALIS_STRENGTH = 10000;
    public int getPectoralisStrength() { return pectoralisStrength; }
    public void addToPectoralisStrength(int add) {
        this.pectoralisStrength = Math.min(pectoralisStrength + add, MAXIMUM_PECTORALIS_STRENGTH);

        updateTracking();
    }
    public void subFromPectoralisStrength(int sub) {
        this.pectoralisStrength = Math.max(pectoralisStrength - sub, MINIMUM_PECTORALIS_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int backStrength;
    private final int MINIMUM_BACK_STRENGTH = 1;
    private final int MAXIMUM_BACK_STRENGTH = 10000;
    public int getBackStrength() { return backStrength; }
    public void addToBackStrength(int add) {
        this.backStrength = Math.min(backStrength + add, MAXIMUM_BACK_STRENGTH);

        updateTracking();
    }
    public void subFromBackStrength(int sub) {
        this.backStrength = Math.max(backStrength - sub, MINIMUM_BACK_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightUpperArmStrength;
    private final int MINIMUM_RIGHT_UPPER_ARM_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_UPPER_ARM_STRENGTH = 10000;
    public int getRightUpperArmStrength() { return rightUpperArmStrength; }
    public void addToRightUpperArmStrength(int add) {
        this.rightUpperArmStrength = Math.min(rightUpperArmStrength + add, MAXIMUM_RIGHT_UPPER_ARM_STRENGTH);

        updateTracking();
    }
    public void subFromRightUpperArmStrength(int sub) {
        this.rightUpperArmStrength = Math.max(rightUpperArmStrength - sub, MINIMUM_RIGHT_UPPER_ARM_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftUpperArmStrength;
    private final int MINIMUM_LEFT_UPPER_ARM_STRENGTH = 1;
    private final int MAXIMUM_LEFT_UPPER_ARM_STRENGTH = 10000;
    public int getLeftUpperArmStrength() { return leftUpperArmStrength; }
    public void addToLeftUpperArmStrength(int add) {
        this.leftUpperArmStrength = Math.min(leftUpperArmStrength + add, MAXIMUM_LEFT_UPPER_ARM_STRENGTH);

        updateTracking();
    }
    public void subFromLeftUpperArmStrength(int sub) {
        this.leftUpperArmStrength = Math.max(leftUpperArmStrength - sub, MINIMUM_LEFT_UPPER_ARM_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightForearmStrength; //(RightHandGripStrength)
    private final int MINIMUM_RIGHT_FOREARM_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_FOREARM_STRENGTH = 10000;
    public int getRightForearmStrength() { return rightForearmStrength; }
    public void addToRightForearmStrength(int add) {
        this.rightForearmStrength = Math.min(rightForearmStrength + add, MAXIMUM_RIGHT_FOREARM_STRENGTH);

        updateTracking();
    }
    public void subFromRightForearmStrength(int sub) {
        this.rightForearmStrength = Math.max(rightForearmStrength - sub, MINIMUM_RIGHT_FOREARM_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftForearmStrength; //(LeftHandGripStrength)
    private final int MINIMUM_LEFT_FOREARM_STRENGTH = 1;
    private final int MAXIMUM_LEFT_FOREARM_STRENGTH = 10000;
    public int getLeftForearmStrength() { return leftForearmStrength; }
    public void addToLeftForearmStrength(int add) {
        this.leftForearmStrength = Math.min(leftForearmStrength + add, MAXIMUM_LEFT_FOREARM_STRENGTH);

        updateTracking();
    }
    public void subFromLeftForearmStrength(int sub) {
        this.leftForearmStrength = Math.max(leftForearmStrength - sub, MINIMUM_LEFT_FOREARM_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int coreStrength;
    private final int MINIMUM_CORE_STRENGTH = 1;
    private final int MAXIMUM_CORE_STRENGTH = 10000;
    public int getCoreStrength() { return coreStrength; }
    public void addToCoreStrength(int add) {
        this.coreStrength = Math.min(coreStrength + add, MAXIMUM_CORE_STRENGTH);

        updateTracking();
    }
    public void subFromCoreStrength(int sub) {
        this.coreStrength = Math.max(coreStrength - sub, MINIMUM_CORE_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightThighStrength;
    private final int MINIMUM_RIGHT_THIGH_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_THIGH_STRENGTH = 10000;
    public int getRightThighStrength() { return rightThighStrength; }
    public void addToRightThighStrength(int add) {
        this.rightThighStrength = Math.min(rightThighStrength + add, MAXIMUM_RIGHT_THIGH_STRENGTH);

        updateTracking();
    }
    public void subFromRightThighStrength(int sub) {
        this.rightThighStrength = Math.max(rightThighStrength - sub, MINIMUM_RIGHT_THIGH_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftThighStrength;
    private final int MINIMUM_LEFT_THIGH_STRENGTH = 1;
    private final int MAXIMUM_LEFT_THIGH_STRENGTH = 10000;
    public int getLeftThighStrength() { return leftThighStrength; }
    public void addToLeftThighStrength(int add) {
        this.leftThighStrength = Math.min(leftThighStrength + add, MAXIMUM_LEFT_THIGH_STRENGTH);

        updateTracking();
    }
    public void subFromLeftThighStrength(int sub) {
        this.leftThighStrength = Math.max(leftThighStrength - sub, MINIMUM_LEFT_THIGH_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLowerLegStrength;
    private final int MINIMUM_RIGHT_LOWER_LEG_STRENGTH = 1;
    private final int MAXIMUM_RIGHT_LOWER_LEG_STRENGTH = 10000;
    public int getRightLowerLegStrength() { return rightLowerLegStrength; }
    public void addToRightLowerLegStrength(int add) {
        this.rightLowerLegStrength = Math.min(rightLowerLegStrength + add, MAXIMUM_RIGHT_LOWER_LEG_STRENGTH);

        updateTracking();
    }
    public void subFromRightLowerLegStrength(int sub) {
        this.rightLowerLegStrength = Math.max(rightLowerLegStrength - sub, MINIMUM_RIGHT_LOWER_LEG_STRENGTH);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLowerLegStrength;
    private final int MINIMUM_LEFT_LOWER_LEG_STRENGTH = 1;
    private final int MAXIMUM_LEFT_LOWER_LEG_STRENGTH = 10000;
    public int getLeftLowerLegStrength() { return leftLowerLegStrength; }
    public void addToLeftLowerLegStrength(int add) {
        this.leftLowerLegStrength = Math.min(leftLowerLegStrength + add, MAXIMUM_LEFT_LOWER_LEG_STRENGTH);

        updateTracking();
    }
    public void subFromLeftLowerLegStrength(int sub) {
        this.leftLowerLegStrength = Math.max(leftLowerLegStrength - sub, MINIMUM_LEFT_LOWER_LEG_STRENGTH);

        updateTracking();
    }
    //</editor-fold>

    //<editor-fold desc="Resilience Scores Data Methods">
    private int overallResilienceAbilityScore;
    public int getResilienceAbilityScore() {
        updateResilienceAbilityScore();

        return overallResilienceAbilityScore;
    }
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

        updateTracking();
    }
    public void subFromHeadResilience(int sub) {
        this.headResilience = Math.max(headResilience - sub, MINIMUM_HEAD_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int neckResilience;
    private final int MINIMUM_NECK_RESILIENCE = 1;
    private final int MAXIMUM_NECK_RESILIENCE = 10000;
    public int getNeckResilience() { return neckResilience; }
    public void addToNeckResilience(int add) {
        this.neckResilience = Math.min(neckResilience + add, MAXIMUM_NECK_RESILIENCE);

        updateTracking();
    }
    public void subFromNeckResilience(int sub) {
        this.neckResilience = Math.max(neckResilience - sub, MINIMUM_NECK_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int chestResilience;
    private final int MINIMUM_CHEST_RESILIENCE = 1;
    private final int MAXIMUM_CHEST_RESILIENCE = 10000;
    public int getChestResilience() { return chestResilience; }
    public void addToChestResilience(int add) {
        this.chestResilience = Math.min(chestResilience + add, MAXIMUM_CHEST_RESILIENCE);

        updateTracking();
    }
    public void subFromChestResilience(int sub) {
        this.chestResilience = Math.max(chestResilience - sub, MINIMUM_CHEST_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int backResilience;
    private final int MINIMUM_BACK_RESILIENCE = 1;
    private final int MAXIMUM_BACK_RESILIENCE = 10000;
    public int getBackResilience() { return backResilience; }
    public void addToBackResilience(int add) {
        this.backResilience = Math.min(backResilience + add, MAXIMUM_BACK_RESILIENCE);

        updateTracking();
    }
    public void subFromBackResilience(int sub) {
        this.backResilience = Math.max(backResilience - sub, MINIMUM_BACK_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightUpperArmResilience;
    private final int MINIMUM_RIGHT_UPPER_ARM_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_UPPER_ARM_RESILIENCE = 10000;
    public int getRightUpperArmResilience() { return rightUpperArmResilience; }
    public void addToRightUpperArmResilience(int add) {
        this.rightUpperArmResilience = Math.min(rightUpperArmResilience + add, MAXIMUM_RIGHT_UPPER_ARM_RESILIENCE);

        updateTracking();
    }
    public void subFromRightUpperArmResilience(int sub) {
        this.rightUpperArmResilience = Math.max(rightUpperArmResilience - sub, MINIMUM_RIGHT_UPPER_ARM_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftUpperArmResilience;
    private final int MINIMUM_LEFT_UPPER_ARM_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_UPPER_ARM_RESILIENCE = 10000;
    public int getLeftUpperArmResilience() { return leftUpperArmResilience; }
    public void addToLeftUpperArmResilience(int add) {
        this.leftUpperArmResilience = Math.min(leftUpperArmResilience + add, MAXIMUM_LEFT_UPPER_ARM_RESILIENCE);

        updateTracking();
    }
    public void subFromLeftUpperArmResilience(int sub) {
        this.leftUpperArmResilience = Math.max(leftUpperArmResilience - sub, MINIMUM_LEFT_UPPER_ARM_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightForearmResilience;
    private final int MINIMUM_RIGHT_FOREARM_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_FOREARM_RESILIENCE = 10000;
    public int getRightForearmResilience() { return rightForearmResilience; }
    public void addToRightForearmResilience(int add) {
        this.rightForearmResilience = Math.min(rightForearmResilience + add, MAXIMUM_RIGHT_FOREARM_RESILIENCE);

        updateTracking();
    }
    public void subFromRightForearmResilience(int sub) {
        this.rightForearmResilience = Math.max(rightForearmResilience - sub, MINIMUM_RIGHT_FOREARM_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftForearmResilience;
    private final int MINIMUM_LEFT_FOREARM_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_FOREARM_RESILIENCE = 10000;
    public int getLeftForearmResilience() { return leftForearmResilience; }
    public void addToLeftForearmResilience(int add) {
        this.leftForearmResilience = Math.min(leftForearmResilience + add, MAXIMUM_LEFT_FOREARM_RESILIENCE);

        updateTracking();
    }
    public void subFromLeftForearmResilience(int sub) {
        this.leftForearmResilience = Math.max(leftForearmResilience - sub, MINIMUM_LEFT_FOREARM_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightHandResilience;
    private final int MINIMUM_RIGHT_HAND_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_HAND_RESILIENCE = 10000;
    public int getRightHandResilience() { return rightHandResilience; }
    public void addToRightHandResilience(int add) {
        this.rightHandResilience = Math.min(rightHandResilience + add, MAXIMUM_RIGHT_HAND_RESILIENCE);

        updateTracking();
    }
    public void subFromRightHandResilience(int sub) {
        this.rightHandResilience = Math.max(rightHandResilience - sub, MINIMUM_RIGHT_HAND_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftHandResilience;
    private final int MINIMUM_LEFT_HAND_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_HAND_RESILIENCE = 10000;
    public int getLeftHandResilience() { return leftHandResilience; }
    public void addToLeftHandResilience(int add) {
        this.leftHandResilience = Math.min(leftHandResilience + add, MAXIMUM_LEFT_HAND_RESILIENCE);

        updateTracking();
    }
    public void subFromLeftHandResilience(int sub) {
        this.leftHandResilience = Math.max(leftHandResilience - sub, MINIMUM_LEFT_HAND_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int coreResilience;
    private final int MINIMUM_CORE_RESILIENCE = 1;
    private final int MAXIMUM_CORE_RESILIENCE = 10000;
    public int getCoreResilience() { return coreResilience; }
    public void addToCoreResilience(int add) {
        this.coreResilience = Math.min(coreResilience + add, MAXIMUM_CORE_RESILIENCE);

        updateTracking();
    }
    public void subFromCoreResilience(int sub) {
        this.coreResilience = Math.max(coreResilience - sub, MINIMUM_CORE_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightThighResilience;
    private final int MINIMUM_RIGHT_THIGH_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_THIGH_RESILIENCE = 10000;
    public int getRightThighResilience() { return rightThighResilience; }
    public void addToRightThighResilience(int add) {
        this.rightThighResilience = Math.min(rightThighResilience + add, MAXIMUM_RIGHT_THIGH_RESILIENCE);

        updateTracking();
    }
    public void subFromRightThighResilience(int sub) {
        this.rightThighResilience = Math.max(rightThighResilience - sub, MINIMUM_RIGHT_THIGH_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftThighResilience;
    private final int MINIMUM_LEFT_THIGH_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_THIGH_RESILIENCE = 10000;
    public int getLeftThighResilience() { return leftThighResilience; }
    public void addToLeftThighResilience(int add) {
        this.leftThighResilience = Math.min(leftThighResilience + add, MAXIMUM_LEFT_THIGH_RESILIENCE);

        updateTracking();
    }
    public void subFromLeftThighResilience(int sub) {
        this.leftThighResilience = Math.max(leftThighResilience - sub, MINIMUM_LEFT_THIGH_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLowerLegResilience;
    private final int MINIMUM_RIGHT_LOWER_LEG_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_LOWER_LEG_RESILIENCE = 10000;
    public int getRightLowerLegResilience() { return rightLowerLegResilience; }
    public void addToRightLowerLegResilience(int add) {
        this.rightLowerLegResilience = Math.min(rightLowerLegResilience + add, MAXIMUM_RIGHT_LOWER_LEG_RESILIENCE);

        updateTracking();
    }
    public void subFromRightLowerLegResilience(int sub) {
        this.rightLowerLegResilience = Math.max(rightLowerLegResilience - sub, MINIMUM_RIGHT_LOWER_LEG_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLowerLegResilience;
    private final int MINIMUM_LEFT_LOWER_LEG_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_LOWER_LEG_RESILIENCE = 10000;
    public int getLeftLowerLegResilience() { return leftLowerLegResilience; }
    public void addToLeftLowerLegResilience(int add) {
        this.leftLowerLegResilience = Math.min(leftLowerLegResilience + add, MAXIMUM_LEFT_LOWER_LEG_RESILIENCE);

        updateTracking();
    }
    public void subFromLeftLowerLegResilience(int sub) {
        this.leftLowerLegResilience = Math.max(leftLowerLegResilience - sub, MINIMUM_LEFT_LOWER_LEG_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightFootResilience;
    private final int MINIMUM_RIGHT_FOOT_RESILIENCE = 1;
    private final int MAXIMUM_RIGHT_FOOT_RESILIENCE = 10000;
    public int getRightFootResilience() { return rightFootResilience; }
    public void addToRightFootResilience(int add) {
        this.rightFootResilience = Math.min(rightFootResilience + add, MAXIMUM_RIGHT_FOOT_RESILIENCE);

        updateTracking();
    }
    public void subFromRightFootResilience(int sub) {
        this.rightFootResilience = Math.max(rightFootResilience - sub, MINIMUM_RIGHT_FOOT_RESILIENCE);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftFootResilience;
    private final int MINIMUM_LEFT_FOOT_RESILIENCE = 1;
    private final int MAXIMUM_LEFT_FOOT_RESILIENCE = 10000;
    public int getLeftFootResilience() { return leftFootResilience; }
    public void addToLeftFootResilience(int add) {
        this.leftFootResilience = Math.min(leftFootResilience + add, MAXIMUM_LEFT_FOOT_RESILIENCE);

        updateTracking();
    }
    public void subFromLeftFootResilience(int sub) {
        this.leftFootResilience = Math.max(leftFootResilience - sub, MINIMUM_LEFT_FOOT_RESILIENCE);

        updateTracking();
    }
    //</editor-fold>

    //<editor-fold desc="Constitution Scores Data Methods">
    private int overallConstitutionAbilityScore;
    public int getConstitutionAbilityScore() {
        updateConstitutionAbilityScore();

        return overallConstitutionAbilityScore;
    }
    public void updateConstitutionAbilityScore() {
        List<Integer> nums = Arrays.asList(
                this.headConstitution,
                this.neckConstitution,
                this.chestConstitution,
                this.backConstitution,
                this.rightUpperArmConstitution,
                this.leftUpperArmConstitution,
                this.rightForearmConstitution,
                this.leftForearmConstitution,
                this.rightHandConstitution,
                this.leftHandConstitution,
                this.coreConstitution,
                this.rightThighConstitution,
                this.leftThighConstitution,
                this.rightLowerLegConstitution,
                this.leftLowerLegConstitution,
                this.rightFootConstitution,
                this.leftFootConstitution
        );

        this.overallConstitutionAbilityScore = MathHelper.sumIntList(nums);
    }

    /*--------------------------------------*/

    private int headConstitution;
    private final int MINIMUM_HEAD_CONSTITUTION = 1;
    private final int MAXIMUM_HEAD_CONSTITUTION = 10000;
    public int getHeadConstitution() { return headConstitution; }
    public void addToHeadConstitution(int add) {
        this.headConstitution = Math.min(headConstitution + add, MAXIMUM_HEAD_CONSTITUTION);

        updateTracking();
    }
    public void subFromHeadConstitution(int sub) {
        this.headConstitution = Math.max(headConstitution - sub, MINIMUM_HEAD_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int neckConstitution;
    private final int MINIMUM_NECK_CONSTITUTION = 1;
    private final int MAXIMUM_NECK_CONSTITUTION = 10000;
    public int getNeckConstitution() { return neckConstitution; }
    public void addToNeckConstitution(int add) {
        this.neckConstitution = Math.min(neckConstitution + add, MAXIMUM_NECK_CONSTITUTION);

        updateTracking();
    }
    public void subFromNeckConstitution(int sub) {
        this.neckConstitution = Math.max(neckConstitution - sub, MINIMUM_NECK_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int chestConstitution;
    private final int MINIMUM_CHEST_CONSTITUTION = 1;
    private final int MAXIMUM_CHEST_CONSTITUTION = 10000;
    public int getChestConstitution() { return chestConstitution; }
    public void addToChestConstitution(int add) {
        this.chestConstitution = Math.min(chestConstitution + add, MAXIMUM_CHEST_CONSTITUTION);

        updateTracking();
    }
    public void subFromChestConstitution(int sub) {
        this.chestConstitution = Math.max(chestConstitution - sub, MINIMUM_CHEST_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int backConstitution;
    private final int MINIMUM_BACK_CONSTITUTION = 1;
    private final int MAXIMUM_BACK_CONSTITUTION = 10000;
    public int getBackConstitution() { return backConstitution; }
    public void addToBackConstitution(int add) {
        this.backConstitution = Math.min(backConstitution + add, MAXIMUM_BACK_CONSTITUTION);

        updateTracking();
    }
    public void subFromBackConstitution(int sub) {
        this.backConstitution = Math.max(backConstitution - sub, MINIMUM_BACK_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightUpperArmConstitution;
    private final int MINIMUM_RIGHT_UPPER_ARM_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_UPPER_ARM_CONSTITUTION = 10000;
    public int getRightUpperArmConstitution() { return rightUpperArmConstitution; }
    public void addToRightUpperArmConstitution(int add) {
        this.rightUpperArmConstitution = Math.min(rightUpperArmConstitution + add, MAXIMUM_RIGHT_UPPER_ARM_CONSTITUTION);

        updateTracking();
    }
    public void subFromRightUpperArmConstitution(int sub) {
        this.rightUpperArmConstitution = Math.max(rightUpperArmConstitution - sub, MINIMUM_RIGHT_UPPER_ARM_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftUpperArmConstitution;
    private final int MINIMUM_LEFT_UPPER_ARM_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_UPPER_ARM_CONSTITUTION = 10000;
    public int getLeftUpperArmConstitution() { return leftUpperArmConstitution; }
    public void addToLeftUpperArmConstitution(int add) {
        this.leftUpperArmConstitution = Math.min(leftUpperArmConstitution + add, MAXIMUM_LEFT_UPPER_ARM_CONSTITUTION);

        updateTracking();
    }
    public void subFromLeftUpperArmConstitution(int sub) {
        this.leftUpperArmConstitution = Math.max(leftUpperArmConstitution - sub, MINIMUM_LEFT_UPPER_ARM_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightForearmConstitution;
    private final int MINIMUM_RIGHT_FOREARM_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_FOREARM_CONSTITUTION = 10000;
    public int getRightForearmConstitution() { return rightForearmConstitution; }
    public void addToRightForearmConstitution(int add) {
        this.rightForearmConstitution = Math.min(rightForearmConstitution + add, MAXIMUM_RIGHT_FOREARM_CONSTITUTION);

        updateTracking();
    }
    public void subFromRightForearmConstitution(int sub) {
        this.rightForearmConstitution = Math.max(rightForearmConstitution - sub, MINIMUM_RIGHT_FOREARM_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftForearmConstitution;
    private final int MINIMUM_LEFT_FOREARM_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_FOREARM_CONSTITUTION = 10000;
    public int getLeftForearmConstitution() { return leftForearmConstitution; }
    public void addToLeftForearmConstitution(int add) {
        this.leftForearmConstitution = Math.min(leftForearmConstitution + add, MAXIMUM_LEFT_FOREARM_CONSTITUTION);

        updateTracking();
    }
    public void subFromLeftForearmConstitution(int sub) {
        this.leftForearmConstitution = Math.max(leftForearmConstitution - sub, MINIMUM_LEFT_FOREARM_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightHandConstitution;
    private final int MINIMUM_RIGHT_HAND_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_HAND_CONSTITUTION = 10000;
    public int getRightHandConstitution() { return rightHandConstitution; }
    public void addToRightHandConstitution(int add) {
        this.rightHandConstitution = Math.min(rightHandConstitution + add, MAXIMUM_RIGHT_HAND_CONSTITUTION);

        updateTracking();
    }
    public void subFromRightHandConstitution(int sub) {
        this.rightHandConstitution = Math.max(rightHandConstitution - sub, MINIMUM_RIGHT_HAND_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftHandConstitution;
    private final int MINIMUM_LEFT_HAND_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_HAND_CONSTITUTION = 10000;
    public int getLeftHandConstitution() { return leftHandConstitution; }
    public void addToLeftHandConstitution(int add) {
        this.leftHandConstitution = Math.min(leftHandConstitution + add, MAXIMUM_LEFT_HAND_CONSTITUTION);

        updateTracking();
    }
    public void subFromLeftHandConstitution(int sub) {
        this.leftHandConstitution = Math.max(leftHandConstitution - sub, MINIMUM_LEFT_HAND_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int coreConstitution;
    private final int MINIMUM_CORE_CONSTITUTION = 1;
    private final int MAXIMUM_CORE_CONSTITUTION = 10000;
    public int getCoreConstitution() { return coreConstitution; }
    public void addToCoreConstitution(int add) {
        this.coreConstitution = Math.min(coreConstitution + add, MAXIMUM_CORE_CONSTITUTION);

        updateTracking();
    }
    public void subFromCoreConstitution(int sub) {
        this.coreConstitution = Math.max(coreConstitution - sub, MINIMUM_CORE_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightThighConstitution;
    private final int MINIMUM_RIGHT_THIGH_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_THIGH_CONSTITUTION = 10000;
    public int getRightThighConstitution() { return rightThighConstitution; }
    public void addToRightThighConstitution(int add) {
        this.rightThighConstitution = Math.min(rightThighConstitution + add, MAXIMUM_RIGHT_THIGH_CONSTITUTION);

        updateTracking();
    }
    public void subFromRightThighConstitution(int sub) {
        this.rightThighConstitution = Math.max(rightThighConstitution - sub, MINIMUM_RIGHT_THIGH_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftThighConstitution;
    private final int MINIMUM_LEFT_THIGH_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_THIGH_CONSTITUTION = 10000;
    public int getLeftThighConstitution() { return leftThighConstitution; }
    public void addToLeftThighConstitution(int add) {
        this.leftThighConstitution = Math.min(leftThighConstitution + add, MAXIMUM_LEFT_THIGH_CONSTITUTION);

        updateTracking();
    }
    public void subFromLeftThighConstitution(int sub) {
        this.leftThighConstitution = Math.max(leftThighConstitution - sub, MINIMUM_LEFT_THIGH_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLowerLegConstitution;
    private final int MINIMUM_RIGHT_LOWER_LEG_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_LOWER_LEG_CONSTITUTION = 10000;
    public int getRightLowerLegConstitution() { return rightLowerLegConstitution; }
    public void addToRightLowerLegConstitution(int add) {
        this.rightLowerLegConstitution = Math.min(rightLowerLegConstitution + add, MAXIMUM_RIGHT_LOWER_LEG_CONSTITUTION);

        updateTracking();
    }
    public void subFromRightLowerLegConstitution(int sub) {
        this.rightLowerLegConstitution = Math.max(rightLowerLegConstitution - sub, MINIMUM_RIGHT_LOWER_LEG_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLowerLegConstitution;
    private final int MINIMUM_LEFT_LOWER_LEG_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_LOWER_LEG_CONSTITUTION = 10000;
    public int getLeftLowerLegConstitution() { return leftLowerLegConstitution; }
    public void addToLeftLowerLegConstitution(int add) {
        this.leftLowerLegConstitution = Math.min(leftLowerLegConstitution + add, MAXIMUM_LEFT_LOWER_LEG_CONSTITUTION);

        updateTracking();
    }
    public void subFromLeftLowerLegConstitution(int sub) {
        this.leftLowerLegConstitution = Math.max(leftLowerLegConstitution - sub, MINIMUM_LEFT_LOWER_LEG_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightFootConstitution;
    private final int MINIMUM_RIGHT_FOOT_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_FOOT_CONSTITUTION = 10000;
    public int getRightFootConstitution() { return rightFootConstitution; }
    public void addToRightFootConstitution(int add) {
        this.rightFootConstitution = Math.min(rightFootConstitution + add, MAXIMUM_RIGHT_FOOT_CONSTITUTION);

        updateTracking();
    }
    public void subFromRightFootConstitution(int sub) {
        this.rightFootConstitution = Math.max(rightFootConstitution - sub, MINIMUM_RIGHT_FOOT_CONSTITUTION);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftFootConstitution;
    private final int MINIMUM_LEFT_FOOT_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_FOOT_CONSTITUTION = 10000;
    public int getLeftFootConstitution() { return leftFootConstitution; }
    public void addToLeftFootConstitution(int add) {
        this.leftFootConstitution = Math.min(leftFootConstitution + add, MAXIMUM_LEFT_FOOT_CONSTITUTION);

        updateTracking();
    }
    public void subFromLeftFootConstitution(int sub) {
        this.leftFootConstitution = Math.max(leftFootConstitution - sub, MINIMUM_LEFT_FOOT_CONSTITUTION);

        updateTracking();
    }
    //</editor-fold>

    //<editor-fold desc="Agility Scores Data Methods">
    /**
     * This score is the overall ability a player possesses in controlling and drawing in ki.
     * This determines the power of you ki skills, the speed of their movement, the complexity
     * of their design/function, and more.
     */
    private int overallDexAbilityScore;
    public int getDexAbilityScore() {
        updateDexterityAbilityScore();

        return overallDexAbilityScore;
    }
    public void updateDexterityAbilityScore() {
        List<Integer> nums = Arrays.asList(
                this.neckAgility,
                this.backAgility,
                this.rightArmAgility,
                this.leftArmAgility,
                this.rightWristAgility,
                this.leftWristAgility,
                this.rightHandDexterity,
                this.leftHandDexterity,
                this.rightLegAgility,
                this.leftLegAgility,
                this.rightAnkleAgility,
                this.leftAnkleAgility
        );

        this.overallDexAbilityScore = MathHelper.sumIntList(nums);
    }

    /*--------------------------------------*/

    private int neckAgility;
    private final int MINIMUM_NECK_AGILITY = 0;
    private final int MAXIMUM_NECK_AGILITY = 10000;
    public int getNeckAgility() { return neckAgility; }
    public void addToNeckAgility(int add) {
        this.neckAgility = Math.min(neckAgility + add, MAXIMUM_NECK_AGILITY);

        updateTracking();
    }
    public void subFromNeckAgility(int sub) {
        this.neckAgility = Math.max(neckAgility - sub, MINIMUM_NECK_AGILITY);

        updateTracking();
    }


    /*--------------------------------------*/

    private int backAgility;
    private final int MINIMUM_BACK_AGILITY = 0;
    private final int MAXIMUM_BACK_AGILITY = 10000;
    public int getBackAgility() { return backAgility; }
    public void addToBackAgility(int add) {
        this.backAgility = Math.min(backAgility + add, MAXIMUM_BACK_AGILITY);

        updateTracking();
    }
    public void subFromBackAgility(int sub) {
        this.backAgility = Math.max(backAgility - sub, MINIMUM_BACK_AGILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightArmAgility;
    private final int MINIMUM_LEFT_ARM_AGILITY = 0;
    private final int MAXIMUM_LEFT_ARM_AGILITY = 10000;
    public int getRightArmAgility() { return rightArmAgility; }
    public void addToRightArmAgility(int add) {
        this.rightArmAgility = Math.min(rightArmAgility + add, MAXIMUM_LEFT_ARM_AGILITY);

        updateTracking();
    }
    public void subFromRightArmAgility(int sub) {
        this.rightArmAgility = Math.max(rightArmAgility - sub, MINIMUM_LEFT_ARM_AGILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftArmAgility;
    private final int MINIMUM_RIGHT_ARM_AGILITY = 0;
    private final int MAXIMUM_RIGHT_ARM_AGILITY = 10000;
    public int getLeftArmAgility() { return leftArmAgility; }
    public void addToLeftArmAgility(int add) {
        this.leftArmAgility = Math.min(leftArmAgility + add, MAXIMUM_RIGHT_ARM_AGILITY);

        updateTracking();
    }
    public void subFromLeftArmAgility(int sub) {
        this.leftArmAgility = Math.max(leftArmAgility - sub, MINIMUM_RIGHT_ARM_AGILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightWristAgility;
    private final int MINIMUM_LEFT_WRIST_AGILITY = 0;
    private final int MAXIMUM_LEFT_WRIST_AGILITY = 10000;
    public int getRightWristAgility() { return rightWristAgility; }
    public void addToRightWristAgility(int add) {
        this.rightWristAgility = Math.min(rightWristAgility + add, MAXIMUM_LEFT_WRIST_AGILITY);

        updateTracking();
    }
    public void subFromRightWristAgility(int sub) {
        this.rightWristAgility = Math.max(rightWristAgility - sub, MINIMUM_LEFT_WRIST_AGILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftWristAgility;
    private final int MINIMUM_RIGHT_WRIST_AGILITY = 0;
    private final int MAXIMUM_RIGHT_WRIST_AGILITY = 10000;
    public int getLeftWristAgility() { return leftWristAgility; }
    public void addToLeftWristAgility(int add) {
        this.leftWristAgility = Math.min(leftWristAgility + add, MAXIMUM_RIGHT_WRIST_AGILITY);

        updateTracking();
    }
    public void subFromLeftWristAgility(int sub) {
        this.leftWristAgility = Math.max(leftWristAgility - sub, MINIMUM_RIGHT_WRIST_AGILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightHandDexterity;
    private final int MINIMUM_LEFT_HAND_DEXTERITY = 0;
    private final int MAXIMUM_LEFT_HAND_DEXTERITY = 10000;
    public int getRightHandDexterity() { return rightHandDexterity; }
    public void addToRightHandDexterity(int add) {
        this.rightHandDexterity = Math.min(rightHandDexterity + add, MAXIMUM_LEFT_HAND_DEXTERITY);

        updateTracking();
    }
    public void subFromRightHandDexterity(int sub) {
        this.rightHandDexterity = Math.max(rightHandDexterity - sub, MINIMUM_LEFT_HAND_DEXTERITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftHandDexterity;
    private final int MINIMUM_RIGHT_HAND_DEXTERITY = 0;
    private final int MAXIMUM_RIGHT_HAND_DEXTERITY = 10000;
    public int getLeftHandDexterity() { return leftHandDexterity; }
    public void addToLeftHandDexterity(int add) {
        this.leftHandDexterity = Math.min(leftHandDexterity + add, MAXIMUM_RIGHT_HAND_DEXTERITY);

        updateTracking();
    }
    public void subFromLeftHandDexterity(int sub) {
        this.leftHandDexterity = Math.max(leftHandDexterity - sub, MINIMUM_RIGHT_HAND_DEXTERITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLegAgility;
    private final int MINIMUM_LEFT_LEG_AGILITY = 0;
    private final int MAXIMUM_LEFT_LEG_AGILITY = 10000;
    public int getRightLegAgility() { return rightLegAgility; }
    public void addToRightLegAgility(int add) {
        this.rightLegAgility = Math.min(rightLegAgility + add, MAXIMUM_LEFT_LEG_AGILITY);

        updateTracking();
    }
    public void subFromRightLegAgility(int sub) {
        this.rightLegAgility = Math.max(rightLegAgility - sub, MINIMUM_LEFT_LEG_AGILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLegAgility;
    private final int MINIMUM_RIGHT_LEG_AGILITY = 0;
    private final int MAXIMUM_RIGHT_LEG_AGILITY = 10000;
    public int getLeftLegAgility() { return leftLegAgility; }
    public void addToLeftLegAgility(int add) {
        this.leftLegAgility = Math.min(leftLegAgility + add, MAXIMUM_RIGHT_LEG_AGILITY);

        updateTracking();
    }
    public void subFromLeftLegAgility(int sub) {
        this.leftLegAgility = Math.max(leftLegAgility - sub, MINIMUM_RIGHT_LEG_AGILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int rightAnkleAgility;
    private final int MINIMUM_LEFT_ANKLE_AGILITY = 0;
    private final int MAXIMUM_LEFT_ANKLE_AGILITY = 10000;
    public int getRightAnkleAgility() { return rightAnkleAgility; }
    public void addToRightAnkleAgility(int add) {
        this.rightAnkleAgility = Math.min(rightAnkleAgility + add, MAXIMUM_LEFT_ANKLE_AGILITY);

        updateTracking();
    }
    public void subFromRightAnkleAgility(int sub) {
        this.rightAnkleAgility = Math.max(rightAnkleAgility - sub, MINIMUM_LEFT_ANKLE_AGILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    private int leftAnkleAgility;
    private final int MINIMUM_RIGHT_ANKLE_AGILITY = 0;
    private final int MAXIMUM_RIGHT_ANKLE_AGILITY = 10000;
    public int getLeftAnkleAgility() { return leftAnkleAgility; }
    public void addToLeftAnkleAgility(int add) {
        this.leftAnkleAgility = Math.min(leftAnkleAgility + add, MAXIMUM_RIGHT_ANKLE_AGILITY);

        updateTracking();
    }
    public void subFromLeftAnkleAgility(int sub) {
        this.leftAnkleAgility = Math.max(leftAnkleAgility - sub, MINIMUM_RIGHT_ANKLE_AGILITY);

        updateTracking();
    }
    //</editor-fold>

    //<editor-fold desc="Ki Mastery Scores Data Methods">
    /**
     * This score is the overall ability a player possesses in controlling and drawing in ki.
     * This determines the power of you ki skills, the speed of their movement, the complexity
     * of their design/function, and more.
     */
    private int overallKiMasteryAbilityScore;
    public int getKiMasteryAbilityScore() {
        updateKiMasteryAbilityScore();

        return overallKiMasteryAbilityScore;
    }
    public void updateKiMasteryAbilityScore() {
        List<Integer> nums = Arrays.asList(
                this.kiManipulationAbility,
                this.kiCompressionAbility,
                this.kiVitality,
                (int) this.kiSkillOverchargeAbility
        );

        this.overallKiMasteryAbilityScore = MathHelper.sumIntList(nums);
    }


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    /**
     * Controls the complexity of ki skills you can use, as well as the speed
     * you can charge it or activate it. For instance, the higher your ability in this score,
     * the faster you cna transform into a super form (changes based on the super form's tier).
     */
    private int kiManipulationAbility;
    private final int MINIMUM_KI_MANIPULATION_ABILITY = 0;
    private final int MAXIMUM_KI_MANIPULATION_ABILITY = 100;
    public int getKiManipulationAbility() { return kiManipulationAbility; }
    public void addToKiManipulationAbility(int add) {
        this.kiManipulationAbility = Math.min(kiManipulationAbility + add, MAXIMUM_KI_MANIPULATION_ABILITY);

        updateTracking();
    }
    public void subFromKiManipulationAbility(int sub) {
        this.kiManipulationAbility = Math.max(kiManipulationAbility - sub, MINIMUM_KI_MANIPULATION_ABILITY);

        updateTracking();
    }


    /*--------------------------------------*/


    /**
     * This score controls how much ki you can put into a single attack.
     * It might seem to clash with overcharge ability, but they are different.
     * Overcharge references how much you can put into an attack, at the cost of adding ki instability.
     * (More overcharge, more instability). This is how much you can put into an attack
     * WITHOUT overcharging it. Also, because overcharge is a multiplier, this increases
     * the effectiveness of overcharge as well.
     */
    private int kiCompressionAbility;
    private final int MINIMUM_KI_COMPRESSION_ABILITY = 0;
    private final int MAXIMUM_KI_COMPRESSION_ABILITY = 100;
    public int getKiCompressionAbility() { return kiCompressionAbility; }
    public void addToKiCompressionAbility(int add) {
        this.kiCompressionAbility = Math.min(kiCompressionAbility + add, MAXIMUM_KI_COMPRESSION_ABILITY);

        updateTracking();
    }
    public void subFromKiCompressionAbility(int sub) {
        this.kiCompressionAbility = Math.max(kiCompressionAbility - sub, MINIMUM_KI_COMPRESSION_ABILITY);

        updateTracking();
    }


    /*--------------------------------------*/


    /**
     * This is essentially how much Ki you cna hold at one time.
     * The name might change, but it's essentially the max you can draw in/hold.
     */
    private int kiVitality;
    private final int MINIMUM_KI_VITALITY = 0;
    private final int MAXIMUM_KI_VITALITY = 100;
    public int getKiVitality() { return kiVitality; }
    public void addToKiVitality(int add) {
        this.kiVitality = Math.min(kiVitality + add, MAXIMUM_KI_VITALITY);

        updateTracking();
    }
    public void subFromKiVitality(int sub) {
        this.kiVitality = Math.max(kiVitality - sub, MINIMUM_KI_VITALITY);

        updateTracking();
    }


    /*--------------------------------------*/


    /**
     * This should only go to 4.0 as that references a multiplier.
     * A ki attack like a blast should only have a maximum multiplier of 4x
     */
    private float kiSkillOverchargeAbility;
    private final float MINIMUM_KI_SKILL_OVERCHARGE_ABILITY = 0;
    private final float MAXIMUM_KI_SKILL_OVERCHARGE_ABILITY = 4.0f;
    public float getKiSkillOverchargeAbility() { return kiSkillOverchargeAbility; }
    public void addToKiSkillOverchargeAbility(float add) {
        this.kiSkillOverchargeAbility = Math.min(kiSkillOverchargeAbility + add, MAXIMUM_KI_SKILL_OVERCHARGE_ABILITY);

        updateTracking();
    }
    public void subFromKiSkillOverchargeAbility(float sub) {
        this.kiSkillOverchargeAbility = Math.max(kiSkillOverchargeAbility - sub, MINIMUM_KI_SKILL_OVERCHARGE_ABILITY);

        updateTracking();
    }
    //</editor-fold>

    //<editor-fold desc="Intellect Scores Data Methods">
    /**
     * This score is the overall ability a player possesses in controlling and drawing in ki.
     * This determines the power of you ki skills, the speed of their movement, the complexity
     * of their design/function, and more.
     */
    private int overallIntellectAbilityScore;
    public int getIntellectAbilityScore() {
        updateIntellectAbilityScore();

        return overallIntellectAbilityScore;
    }
    public void updateIntellectAbilityScore() {
        List<Integer> nums = Arrays.asList(
                this.analysisAbility,
                this.craftingAbility,
                this.technicalKnowledgeAbility,
                this.instinctualMovementAbility
        );

        this.overallIntellectAbilityScore = MathHelper.sumIntList(nums);
    }

    /*--------------------------------------*/

    /**
     * Used in combat to assess the ability of opponents at a glance.
     * Can given limited information about a player/entities data without
     * the use of skills like ki-sense.
     */
    private int analysisAbility;
    private final int MINIMUM_ANALYSIS_ABILITY = 0;
    private final int MAXIMUM_ANALYSIS_ABILITY = 1000;
    public int getAnalysisAbility() { return analysisAbility; }
    public void addToAnalysisAbility(int add) {
        this.analysisAbility = Math.min(analysisAbility + add, MAXIMUM_ANALYSIS_ABILITY);

        updateTracking();
    }
    public void subFromAnalysisAbility(int sub) {
        this.analysisAbility = Math.max(analysisAbility - sub, MINIMUM_ANALYSIS_ABILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    /**
     * Paired with hand/arm dexterity, this determines how easily you can craft
     * something manually. The lower hand/arm dexterity, the higher the chance
     * a craft will fail. [Incentives getting automatic crafting machines]
     */
    private int craftingAbility;
    private final int MINIMUM_CRAFTING_ABILITY = 0;
    private final int MAXIMUM_CRAFTING_ABILITY = 1000;
    public int getCraftingAbility() { return craftingAbility; }
    public void addToCraftingAbility(int add) {
        this.craftingAbility = Math.min(craftingAbility + add, MAXIMUM_CRAFTING_ABILITY);

        updateTracking();
    }
    public void subFromCraftingAbility(int sub) {
        this.craftingAbility = Math.max(craftingAbility - sub, MINIMUM_CRAFTING_ABILITY);

        updateTracking();
    }

    /*--------------------------------------*/

    /**
     * Part of a crafting system using "tiers of crafting".
     * This stat allows a player to learn how to craft a specific item
     * faster/easier with less failed crafts.
     */
    private int technicalKnowledgeAbility;
    private final int MINIMUM_TECHNICAL_KNOWLEDGE = 0;
    private final int MAXIMUM_TECHNICAL_KNOWLEDGE = 1000;
    public int getTechnicalKnowledge() { return technicalKnowledgeAbility; }
    public void addToTechnicalKnowledge(int add) {
        this.technicalKnowledgeAbility = Math.min(technicalKnowledgeAbility + add, MAXIMUM_TECHNICAL_KNOWLEDGE);

        updateTracking();
    }
    public void subFromTechnicalKnowledge(int sub) {
        this.technicalKnowledgeAbility = Math.max(technicalKnowledgeAbility - sub, MINIMUM_TECHNICAL_KNOWLEDGE);

        updateTracking();
    }

    /*--------------------------------------*/

    /**
     * This stat is essentially a part of training for Ultra Instinct.
     * The increase in battle ability is negligible until it's put together in
     * the ultra instinct state.
     * Beyond that, this increase the chance of the player dodging a surprise attack
     * even if they aren't in battle mode.
     */
    private int instinctualMovementAbility;
    private final int MINIMUM_INSTINCTUAL_MOVEMENT = 0;
    private final int MAXIMUM_INSTINCTUAL_MOVEMENT = 1000;
    public int getInstinctualMovement() { return instinctualMovementAbility; }
    public void addToInstinctualMovement(int add) {
        this.instinctualMovementAbility = Math.min(instinctualMovementAbility + add, MAXIMUM_INSTINCTUAL_MOVEMENT);

        updateTracking();
    }
    public void subFromInstinctualMovement(int sub) {
        this.instinctualMovementAbility = Math.max(instinctualMovementAbility - sub, MINIMUM_INSTINCTUAL_MOVEMENT);

        updateTracking();
    }
    //</editor-fold>


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(this.player.getId(), AbilityScoresHolderAttacher.RESOURCE_LOCATION, this);
    }

    @Override
    public SimpleChannel getNetworkChannel() { return NetworkHandler.INSTANCE; }

    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();

        /*--------------------------------------*/

        //<editor-fold desc="Strength Scores Data">
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
        //</editor-fold>

        //<editor-fold desc="Resilience Scores Data">
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
        //</editor-fold>

        //<editor-fold desc="Constitution Scores Data">
        tag.putInt("overallConstitutionAbilityScore", this.overallConstitutionAbilityScore);
        tag.putInt("headConstitution", this.headConstitution);
        tag.putInt("neckConstitution", this.neckConstitution);
        tag.putInt("chestConstitution", this.chestConstitution);
        tag.putInt("backConstitution", this.backConstitution);
        tag.putInt("rightBicepConstitution", this.rightUpperArmConstitution);
        tag.putInt("leftBicepConstitution", this.leftUpperArmConstitution);
        tag.putInt("rightForearmConstitution", this.rightForearmConstitution);
        tag.putInt("leftForearmConstitution", this.leftForearmConstitution);
        tag.putInt("rightHandConstitution", this.rightHandConstitution);
        tag.putInt("leftHandConstitution", this.leftHandConstitution);
        tag.putInt("coreConstitution", this.coreConstitution);
        tag.putInt("rightThighConstitution", this.rightThighConstitution);
        tag.putInt("leftThighConstitution", this.leftThighConstitution);
        tag.putInt("rightLowerLegConstitution", this.rightLowerLegConstitution);
        tag.putInt("leftLowerLegConstitution", this.leftLowerLegConstitution);
        tag.putInt("rightFootConstitution", this.rightFootConstitution);
        tag.putInt("leftFootConstitution", this.leftFootConstitution);
        //</editor-fold>

        //<editor-fold desc="Agility/Dexterity Scores Data">
        tag.putInt("neckAgility", this.neckAgility);
        tag.putInt("backAgility", this.backAgility);
        tag.putInt("rightArmAgility", this.rightArmAgility);
        tag.putInt("leftArmAgility", this.leftArmAgility);
        tag.putInt("rightWristAgility", this.rightWristAgility);
        tag.putInt("leftWristAgility", this.leftWristAgility);
        tag.putInt("rightHandDexterity", this.rightHandDexterity);
        tag.putInt("leftHandDexterity", this.leftHandDexterity);
        tag.putInt("rightLegAgility", this.rightLegAgility);
        tag.putInt("leftLegAgility", this.leftLegAgility);
        tag.putInt("rightAnkleAgility", this.rightAnkleAgility);
        tag.putInt("leftAnkleAgility", this.leftAnkleAgility);
        //</editor-fold>

        //<editor-fold desc="Ki Mastery Scores Data">
        tag.putInt("overallKiMasteryAbilityScore", this.overallKiMasteryAbilityScore);
        tag.putInt("kiManipulationAbility", this.kiManipulationAbility);
        tag.putInt("kiCompressionAbility", this.kiCompressionAbility);
        tag.putInt("kiVitality", this.kiVitality);
        tag.putFloat("kiSkillOverchargeAbility", this.kiSkillOverchargeAbility);
        //</editor-fold>

        //<editor-fold desc="Intellect Scores Data">
        tag.putInt("overallIntellectAbilityScore", this.overallIntellectAbilityScore);
        tag.putInt("analysisAbility", this.analysisAbility);
        tag.putInt("craftingAbility", this.craftingAbility);
        tag.putInt("technicalKnowledgeAbility", this.technicalKnowledgeAbility);
        tag.putInt("instinctualMovementAbility", this.instinctualMovementAbility);
        //</editor-fold>

        /*--------------------------------------*/

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        //<editor-fold desc="Strength Scores Data">
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
        //</editor-fold>

        //<editor-fold desc="Resilience Scores Data">
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
        //</editor-fold>

        //<editor-fold desc="Constitution Scores Data">
        this.overallConstitutionAbilityScore = nbt.getInt("overallConstitutionAbilityScore");
        this.headConstitution = nbt.getInt("headConstitution");
        this.neckConstitution = nbt.getInt("neckConstitution");
        this.chestConstitution = nbt.getInt("chestConstitution");
        this.backConstitution = nbt.getInt("backConstitution");
        this.rightUpperArmConstitution = nbt.getInt("rightBicepConstitution");
        this.leftUpperArmConstitution = nbt.getInt("leftBicepConstitution");
        this.rightForearmConstitution = nbt.getInt("rightForearmConstitution");
        this.leftForearmConstitution = nbt.getInt("leftForearmConstitution");
        this.rightHandConstitution = nbt.getInt("rightHandConstitution");
        this.leftHandConstitution = nbt.getInt("leftHandConstitution");
        this.coreConstitution = nbt.getInt("coreConstitution");
        this.rightThighConstitution = nbt.getInt("rightThighConstitution");
        this.leftThighConstitution = nbt.getInt("leftThighConstitution");
        this.rightLowerLegConstitution = nbt.getInt("rightLowerLegConstitution");
        this.leftLowerLegConstitution = nbt.getInt("leftLowerLegConstitution");
        this.rightFootConstitution = nbt.getInt("rightFootConstitution");
        this.leftFootConstitution = nbt.getInt("leftFootConstitution");
        //</editor-fold>

        //<editor-fold desc="Agility/Dexterity Scores Data">
        this.neckAgility = nbt.getInt("neckAgility");
        this.backAgility = nbt.getInt("backAgility");
        this.rightArmAgility = nbt.getInt("rightArmAgility");
        this.leftArmAgility = nbt.getInt("leftArmAgility");
        this.rightWristAgility = nbt.getInt("rightWristAgility");
        this.leftWristAgility = nbt.getInt("leftWristAgility");
        this.rightHandDexterity = nbt.getInt("rightHandDexterity");
        this.leftHandDexterity = nbt.getInt("leftHandDexterity");
        this.rightLegAgility = nbt.getInt("rightLegAgility");
        this.leftLegAgility = nbt.getInt("leftLegAgility");
        this.rightAnkleAgility = nbt.getInt("rightAnkleAgility");
        this.leftAnkleAgility = nbt.getInt("leftAnkleAgility");
        //</editor-fold>

        //<editor-fold desc="Ki Mastery Scores Data">
        this.overallKiMasteryAbilityScore = nbt.getInt("overallKiMasteryAbilityScore");
        this.kiManipulationAbility = nbt.getInt("kiManipulationAbility");
        this.kiCompressionAbility = nbt.getInt("kiCompressionAbility");
        this.kiVitality = nbt.getInt("kiVitality");
        this.kiSkillOverchargeAbility = nbt.getFloat("kiSkillOverchargeAbility");
        //</editor-fold>

        //<editor-fold desc="Intellect Scores Data">
        this.overallIntellectAbilityScore = nbt.getInt("overallIntellectAbilityScore");
        this.analysisAbility = nbt.getInt("analysisAbility");
        this.craftingAbility = nbt.getInt("craftingAbility");
        this.technicalKnowledgeAbility = nbt.getInt("technicalKnowledgeAbility");
        this.instinctualMovementAbility = nbt.getInt("instinctualMovementAbility");
        //</editor-fold>
    }
}
