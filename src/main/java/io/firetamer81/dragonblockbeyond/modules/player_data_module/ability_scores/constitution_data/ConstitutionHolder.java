package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.constitution_data;

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

public class ConstitutionHolder extends PlayerCapability {

    protected ConstitutionHolder(Player player) {
        super(player);
    }

    private int overallConstitutionAbilityScore;
    public int getConstitutionAbilityScore() { return overallConstitutionAbilityScore; }
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


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/
    

    private int headConstitution;
    private final int MINIMUM_HEAD_CONSTITUTION = 1;
    private final int MAXIMUM_HEAD_CONSTITUTION = 10000;
    public int getHeadConstitution() { return headConstitution; }
    public void addToHeadConstitution(int add) {
        this.headConstitution = Math.min(headConstitution + add, MAXIMUM_HEAD_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromHeadConstitution(int sub) {
        this.headConstitution = Math.max(headConstitution - sub, MINIMUM_HEAD_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int neckConstitution;
    private final int MINIMUM_NECK_CONSTITUTION = 1;
    private final int MAXIMUM_NECK_CONSTITUTION = 10000;
    public int getNeckConstitution() { return neckConstitution; }
    public void addToNeckConstitution(int add) {
        this.neckConstitution = Math.min(neckConstitution + add, MAXIMUM_NECK_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromNeckConstitution(int sub) {
        this.neckConstitution = Math.max(neckConstitution - sub, MINIMUM_NECK_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int chestConstitution;
    private final int MINIMUM_CHEST_CONSTITUTION = 1;
    private final int MAXIMUM_CHEST_CONSTITUTION = 10000;
    public int getChestConstitution() { return chestConstitution; }
    public void addToChestConstitution(int add) {
        this.chestConstitution = Math.min(chestConstitution + add, MAXIMUM_CHEST_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromChestConstitution(int sub) {
        this.chestConstitution = Math.max(chestConstitution - sub, MINIMUM_CHEST_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int backConstitution;
    private final int MINIMUM_BACK_CONSTITUTION = 1;
    private final int MAXIMUM_BACK_CONSTITUTION = 10000;
    public int getBackConstitution() { return backConstitution; }
    public void addToBackConstitution(int add) {
        this.backConstitution = Math.min(backConstitution + add, MAXIMUM_BACK_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromBackConstitution(int sub) {
        this.backConstitution = Math.max(backConstitution - sub, MINIMUM_BACK_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightUpperArmConstitution;
    private final int MINIMUM_RIGHT_UPPER_ARM_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_UPPER_ARM_CONSTITUTION = 10000;
    public int getRightUpperArmConstitution() { return rightUpperArmConstitution; }
    public void addToRightUpperArmConstitution(int add) {
        this.rightUpperArmConstitution = Math.min(rightUpperArmConstitution + add, MAXIMUM_RIGHT_UPPER_ARM_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromRightUpperArmConstitution(int sub) {
        this.rightUpperArmConstitution = Math.max(rightUpperArmConstitution - sub, MINIMUM_RIGHT_UPPER_ARM_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftUpperArmConstitution;
    private final int MINIMUM_LEFT_UPPER_ARM_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_UPPER_ARM_CONSTITUTION = 10000;
    public int getLeftUpperArmConstitution() { return leftUpperArmConstitution; }
    public void addToLeftUpperArmConstitution(int add) {
        this.leftUpperArmConstitution = Math.min(leftUpperArmConstitution + add, MAXIMUM_LEFT_UPPER_ARM_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromLeftUpperArmConstitution(int sub) {
        this.leftUpperArmConstitution = Math.max(leftUpperArmConstitution - sub, MINIMUM_LEFT_UPPER_ARM_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightForearmConstitution;
    private final int MINIMUM_RIGHT_FOREARM_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_FOREARM_CONSTITUTION = 10000;
    public int getRightForearmConstitution() { return rightForearmConstitution; }
    public void addToRightForearmConstitution(int add) {
        this.rightForearmConstitution = Math.min(rightForearmConstitution + add, MAXIMUM_RIGHT_FOREARM_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromRightForearmConstitution(int sub) {
        this.rightForearmConstitution = Math.max(rightForearmConstitution - sub, MINIMUM_RIGHT_FOREARM_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftForearmConstitution;
    private final int MINIMUM_LEFT_FOREARM_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_FOREARM_CONSTITUTION = 10000;
    public int getLeftForearmConstitution() { return leftForearmConstitution; }
    public void addToLeftForearmConstitution(int add) {
        this.leftForearmConstitution = Math.min(leftForearmConstitution + add, MAXIMUM_LEFT_FOREARM_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromLeftForearmConstitution(int sub) {
        this.leftForearmConstitution = Math.max(leftForearmConstitution - sub, MINIMUM_LEFT_FOREARM_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightHandConstitution;
    private final int MINIMUM_RIGHT_HAND_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_HAND_CONSTITUTION = 10000;
    public int getRightHandConstitution() { return rightHandConstitution; }
    public void addToRightHandConstitution(int add) {
        this.rightHandConstitution = Math.min(rightHandConstitution + add, MAXIMUM_RIGHT_HAND_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromRightHandConstitution(int sub) {
        this.rightHandConstitution = Math.max(rightHandConstitution - sub, MINIMUM_RIGHT_HAND_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftHandConstitution;
    private final int MINIMUM_LEFT_HAND_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_HAND_CONSTITUTION = 10000;
    public int getLeftHandConstitution() { return leftHandConstitution; }
    public void addToLeftHandConstitution(int add) {
        this.leftHandConstitution = Math.min(leftHandConstitution + add, MAXIMUM_LEFT_HAND_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromLeftHandConstitution(int sub) {
        this.leftHandConstitution = Math.max(leftHandConstitution - sub, MINIMUM_LEFT_HAND_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int coreConstitution;
    private final int MINIMUM_CORE_CONSTITUTION = 1;
    private final int MAXIMUM_CORE_CONSTITUTION = 10000;
    public int getCoreConstitution() { return coreConstitution; }
    public void addToCoreConstitution(int add) {
        this.coreConstitution = Math.min(coreConstitution + add, MAXIMUM_CORE_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromCoreConstitution(int sub) {
        this.coreConstitution = Math.max(coreConstitution - sub, MINIMUM_CORE_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightThighConstitution;
    private final int MINIMUM_RIGHT_THIGH_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_THIGH_CONSTITUTION = 10000;
    public int getRightThighConstitution() { return rightThighConstitution; }
    public void addToRightThighConstitution(int add) {
        this.rightThighConstitution = Math.min(rightThighConstitution + add, MAXIMUM_RIGHT_THIGH_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromRightThighConstitution(int sub) {
        this.rightThighConstitution = Math.max(rightThighConstitution - sub, MINIMUM_RIGHT_THIGH_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftThighConstitution;
    private final int MINIMUM_LEFT_THIGH_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_THIGH_CONSTITUTION = 10000;
    public int getLeftThighConstitution() { return leftThighConstitution; }
    public void addToLeftThighConstitution(int add) {
        this.leftThighConstitution = Math.min(leftThighConstitution + add, MAXIMUM_LEFT_THIGH_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromLeftThighConstitution(int sub) {
        this.leftThighConstitution = Math.max(leftThighConstitution - sub, MINIMUM_LEFT_THIGH_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLowerLegConstitution;
    private final int MINIMUM_RIGHT_LOWER_LEG_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_LOWER_LEG_CONSTITUTION = 10000;
    public int getRightLowerLegConstitution() { return rightLowerLegConstitution; }
    public void addToRightLowerLegConstitution(int add) {
        this.rightLowerLegConstitution = Math.min(rightLowerLegConstitution + add, MAXIMUM_RIGHT_LOWER_LEG_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromRightLowerLegConstitution(int sub) {
        this.rightLowerLegConstitution = Math.max(rightLowerLegConstitution - sub, MINIMUM_RIGHT_LOWER_LEG_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLowerLegConstitution;
    private final int MINIMUM_LEFT_LOWER_LEG_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_LOWER_LEG_CONSTITUTION = 10000;
    public int getLeftLowerLegConstitution() { return leftLowerLegConstitution; }
    public void addToLeftLowerLegConstitution(int add) {
        this.leftLowerLegConstitution = Math.min(leftLowerLegConstitution + add, MAXIMUM_LEFT_LOWER_LEG_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromLeftLowerLegConstitution(int sub) {
        this.leftLowerLegConstitution = Math.max(leftLowerLegConstitution - sub, MINIMUM_LEFT_LOWER_LEG_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightFootConstitution;
    private final int MINIMUM_RIGHT_FOOT_CONSTITUTION = 1;
    private final int MAXIMUM_RIGHT_FOOT_CONSTITUTION = 10000;
    public int getRightFootConstitution() { return rightFootConstitution; }
    public void addToRightFootConstitution(int add) {
        this.rightFootConstitution = Math.min(rightFootConstitution + add, MAXIMUM_RIGHT_FOOT_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromRightFootConstitution(int sub) {
        this.rightFootConstitution = Math.max(rightFootConstitution - sub, MINIMUM_RIGHT_FOOT_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftFootConstitution;
    private final int MINIMUM_LEFT_FOOT_CONSTITUTION = 1;
    private final int MAXIMUM_LEFT_FOOT_CONSTITUTION = 10000;
    public int getLeftFootConstitution() { return leftFootConstitution; }
    public void addToLeftFootConstitution(int add) {
        this.leftFootConstitution = Math.min(leftFootConstitution + add, MAXIMUM_LEFT_FOOT_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    public void subFromLeftFootConstitution(int sub) {
        this.leftFootConstitution = Math.max(leftFootConstitution - sub, MINIMUM_LEFT_FOOT_CONSTITUTION);
        updateConstitutionAbilityScore();
        updateTracking();
    }
    

    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    @Override
    public EntityCapabilityStatusPacket createUpdatePacket() {
        return new SimpleEntityCapabilityStatusPacket(this.player.getId(), ConstitutionHolderAttacher.RESOURCE_LOCATION, this);
    }

    @Override
    public SimpleChannel getNetworkChannel() {
        return NetworkHandler.INSTANCE;
    }

    @Override
    public CompoundTag serializeNBT(boolean savingToDisk) {
        CompoundTag tag = new CompoundTag();

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

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
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
    }
}
