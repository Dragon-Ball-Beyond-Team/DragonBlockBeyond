package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.dexterity_data;

import dev._100media.capabilitysyncer.core.PlayerCapability;
import dev._100media.capabilitysyncer.network.EntityCapabilityStatusPacket;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import io.firetamer81.dragonblockbeyond.core.firelib.math.MathHelper;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.strength_data.StrengthHolderAttacher;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Arrays;
import java.util.List;

public class DexterityHolder extends PlayerCapability {

    protected DexterityHolder(Player player) {
        super(player);
    }

    /**
     * This score is the overall ability a player possesses in controlling and drawing in ki.
     * This determines the power of you ki skills, the speed of their movement, the complexity
     * of their design/function, and more.
     */
    private int overallDexAbilityScore;
    public int getDexAbilityScore() { return overallDexAbilityScore; }
    public void updateKiMasteryAbilityScore() {
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


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    private int neckAgility;
    private final int MINIMUM_NECK_AGILITY = 0;
    private final int MAXIMUM_NECK_AGILITY = 1000;
    public int getNeckAgility() { return neckAgility; }
    public void addToNeckAgility(int add) {
        this.neckAgility = Math.min(neckAgility + add, MAXIMUM_NECK_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromNeckAgility(int sub) {
        this.neckAgility = Math.max(neckAgility - sub, MINIMUM_NECK_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }


    /*--------------------------------------*/

    private int backAgility;
    private final int MINIMUM_BACK_AGILITY = 0;
    private final int MAXIMUM_BACK_AGILITY = 1000;
    public int getBackAgility() { return backAgility; }
    public void addToBackAgility(int add) {
        this.backAgility = Math.min(backAgility + add, MAXIMUM_BACK_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromBackAgility(int sub) {
        this.backAgility = Math.max(backAgility - sub, MINIMUM_BACK_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightArmAgility;
    private final int MINIMUM_LEFT_ARM_AGILITY = 0;
    private final int MAXIMUM_LEFT_ARM_AGILITY = 1000;
    public int getRightArmAgility() { return rightArmAgility; }
    public void addToRightArmAgility(int add) {
        this.rightArmAgility = Math.min(rightArmAgility + add, MAXIMUM_LEFT_ARM_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromRightArmAgility(int sub) {
        this.rightArmAgility = Math.max(rightArmAgility - sub, MINIMUM_LEFT_ARM_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftArmAgility;
    private final int MINIMUM_RIGHT_ARM_AGILITY = 0;
    private final int MAXIMUM_RIGHT_ARM_AGILITY = 1000;
    public int getLeftArmAgility() { return leftArmAgility; }
    public void addToLeftArmAgility(int add) {
        this.leftArmAgility = Math.min(leftArmAgility + add, MAXIMUM_RIGHT_ARM_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromLeftArmAgility(int sub) {
        this.leftArmAgility = Math.max(leftArmAgility - sub, MINIMUM_RIGHT_ARM_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightWristAgility;
    private final int MINIMUM_LEFT_WRIST_AGILITY = 0;
    private final int MAXIMUM_LEFT_WRIST_AGILITY = 1000;
    public int getRightWristAgility() { return rightWristAgility; }
    public void addToRightWristAgility(int add) {
        this.rightWristAgility = Math.min(rightWristAgility + add, MAXIMUM_LEFT_WRIST_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromRightWristAgility(int sub) {
        this.rightWristAgility = Math.max(rightWristAgility - sub, MINIMUM_LEFT_WRIST_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftWristAgility;
    private final int MINIMUM_RIGHT_WRIST_AGILITY = 0;
    private final int MAXIMUM_RIGHT_WRIST_AGILITY = 1000;
    public int getLeftWristAgility() { return leftWristAgility; }
    public void addToLeftWristAgility(int add) {
        this.leftWristAgility = Math.min(leftWristAgility + add, MAXIMUM_RIGHT_WRIST_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromLeftWristAgility(int sub) {
        this.leftWristAgility = Math.max(leftWristAgility - sub, MINIMUM_RIGHT_WRIST_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightHandDexterity;
    private final int MINIMUM_LEFT_HAND_DEXTERITY = 0;
    private final int MAXIMUM_LEFT_HAND_DEXTERITY = 1000;
    public int getRightHandDexterity() { return rightHandDexterity; }
    public void addToRightHandDexterity(int add) {
        this.rightHandDexterity = Math.min(rightHandDexterity + add, MAXIMUM_LEFT_HAND_DEXTERITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromRightHandDexterity(int sub) {
        this.rightHandDexterity = Math.max(rightHandDexterity - sub, MINIMUM_LEFT_HAND_DEXTERITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftHandDexterity;
    private final int MINIMUM_RIGHT_HAND_DEXTERITY = 0;
    private final int MAXIMUM_RIGHT_HAND_DEXTERITY = 1000;
    public int getLeftHandDexterity() { return leftHandDexterity; }
    public void addToLeftHandDexterity(int add) {
        this.leftHandDexterity = Math.min(leftHandDexterity + add, MAXIMUM_RIGHT_HAND_DEXTERITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromLeftHandDexterity(int sub) {
        this.leftHandDexterity = Math.max(leftHandDexterity - sub, MINIMUM_RIGHT_HAND_DEXTERITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightLegAgility;
    private final int MINIMUM_LEFT_LEG_AGILITY = 0;
    private final int MAXIMUM_LEFT_LEG_AGILITY = 1000;
    public int getRightLegAgility() { return rightLegAgility; }
    public void addToRightLegAgility(int add) {
        this.rightLegAgility = Math.min(rightLegAgility + add, MAXIMUM_LEFT_LEG_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromRightLegAgility(int sub) {
        this.rightLegAgility = Math.max(rightLegAgility - sub, MINIMUM_LEFT_LEG_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftLegAgility;
    private final int MINIMUM_RIGHT_LEG_AGILITY = 0;
    private final int MAXIMUM_RIGHT_LEG_AGILITY = 1000;
    public int getLeftLegAgility() { return leftLegAgility; }
    public void addToLeftLegAgility(int add) {
        this.leftLegAgility = Math.min(leftLegAgility + add, MAXIMUM_RIGHT_LEG_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromLeftLegAgility(int sub) {
        this.leftLegAgility = Math.max(leftLegAgility - sub, MINIMUM_RIGHT_LEG_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int rightAnkleAgility;
    private final int MINIMUM_LEFT_ANKLE_AGILITY = 0;
    private final int MAXIMUM_LEFT_ANKLE_AGILITY = 1000;
    public int getRightAnkleAgility() { return rightAnkleAgility; }
    public void addToRightAnkleAgility(int add) {
        this.rightAnkleAgility = Math.min(rightAnkleAgility + add, MAXIMUM_LEFT_ANKLE_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromRightAnkleAgility(int sub) {
        this.rightAnkleAgility = Math.max(rightAnkleAgility - sub, MINIMUM_LEFT_ANKLE_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }

    /*--------------------------------------*/

    private int leftAnkleAgility;
    private final int MINIMUM_RIGHT_ANKLE_AGILITY = 0;
    private final int MAXIMUM_RIGHT_ANKLE_AGILITY = 1000;
    public int getLeftAnkleAgility() { return leftAnkleAgility; }
    public void addToLeftAnkleAgility(int add) {
        this.leftAnkleAgility = Math.min(leftAnkleAgility + add, MAXIMUM_RIGHT_ANKLE_AGILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromLeftAnkleAgility(int sub) {
        this.leftAnkleAgility = Math.max(leftAnkleAgility - sub, MINIMUM_RIGHT_ANKLE_AGILITY);
        updateKiMasteryAbilityScore();
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

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
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
    }
}
