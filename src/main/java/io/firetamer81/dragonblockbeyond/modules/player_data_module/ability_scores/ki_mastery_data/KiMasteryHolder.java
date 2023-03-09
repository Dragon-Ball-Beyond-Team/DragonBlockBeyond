package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.ki_mastery_data;

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

public class KiMasteryHolder extends PlayerCapability {

    protected KiMasteryHolder(Player player) {
        super(player);
    }

    /**
     * This score is the overall ability a player possesses in controlling and drawing in ki.
     * This determines the power of you ki skills, the speed of their movement, the complexity
     * of their design/function, and more.
     */
    private int overallKiMasteryAbilityScore;
    public int getKiMasteryAbilityScore() { return overallKiMasteryAbilityScore; }
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


    //Controls the complexity of ki skills you can use, as well as the speed
    //you can charge it or activate it. For instance, the higher your ability in this score,
    //the faster you cna transform into a super form (changes based on the super form's tier).
    private int kiManipulationAbility;
    private final int MINIMUM_KI_MANIPULATION_ABILITY = 0;
    private final int MAXIMUM_KI_MANIPULATION_ABILITY = 100;
    public int getKiManipulationAbility() { return kiManipulationAbility; }
    public void addToKiManipulationAbility(int add) {
        this.kiManipulationAbility = Math.min(kiManipulationAbility + add, MAXIMUM_KI_MANIPULATION_ABILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromKiManipulationAbility(int sub) {
        this.kiManipulationAbility = Math.max(kiManipulationAbility - sub, MINIMUM_KI_MANIPULATION_ABILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }


    /*--------------------------------------*/


    //This score controls how much ki you can put into a single attack.
    //It might seem to clash with overcharge ability, but they are different.
    //Overcharge references how much you can put into an attack, ignoring ki instability.
    //(More overcharge, more instability). This is how much you cna put into an attack
    //WITHOUT overcharging it. Also, because overcharge is a multiplier, this increases
    //the effectiveness of overcharge as well.
    private int kiCompressionAbility;
    private final int MINIMUM_KI_COMPRESSION_ABILITY = 0;
    private final int MAXIMUM_KI_COMPRESSION_ABILITY = 100;
    public int getKiCompressionAbility() { return kiCompressionAbility; }
    public void addToKiCompressionAbility(int add) {
        this.kiCompressionAbility = Math.min(kiCompressionAbility + add, MAXIMUM_KI_COMPRESSION_ABILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromKiCompressionAbility(int sub) {
        this.kiCompressionAbility = Math.max(kiCompressionAbility - sub, MINIMUM_KI_COMPRESSION_ABILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }


    /*--------------------------------------*/


    //This is essentially how much Ki you cna hold at one time.
    //The name might change, but it's essentially the max you can draw in/hold.
    private int kiVitality;
    private final int MINIMUM_KI_VITALITY = 0;
    private final int MAXIMUM_KI_VITALITY = 100;
    public int getKiVitality() { return kiVitality; }
    public void addToKiVitality(int add) {
        this.kiVitality = Math.min(kiVitality + add, MAXIMUM_KI_VITALITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromKiVitality(int sub) {
        this.kiVitality = Math.max(kiVitality - sub, MINIMUM_KI_VITALITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }


    /*--------------------------------------*/


    //This should only go to 4.0 as that references a multiplier.
    //A ki attack like a blast should only have a maximum multiplier of 4x
    private float kiSkillOverchargeAbility;
    private final float MINIMUM_KI_SKILL_OVERCHARGE_ABILITY = 0;
    private final float MAXIMUM_KI_SKILL_OVERCHARGE_ABILITY = 4.0f;
    public float getKiSkillOverchargeAbility() { return kiSkillOverchargeAbility; }
    public void addToKiSkillOverchargeAbility(float add) {
        this.kiSkillOverchargeAbility = Math.min(kiSkillOverchargeAbility + add, MAXIMUM_KI_SKILL_OVERCHARGE_ABILITY);
        updateKiMasteryAbilityScore();
        updateTracking();
    }
    public void subFromKiSkillOverchargeAbility(float sub) {
        this.kiSkillOverchargeAbility = Math.max(kiSkillOverchargeAbility - sub, MINIMUM_KI_SKILL_OVERCHARGE_ABILITY);
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

        tag.putInt("overallKiMasteryAbilityScore", this.overallKiMasteryAbilityScore);
        tag.putInt("kiManipulationAbility", this.kiManipulationAbility);
        tag.putInt("kiCompressionAbility", this.kiCompressionAbility);
        tag.putInt("kiVitality", this.kiVitality);
        tag.putFloat("kiSkillOverchargeAbility", this.kiSkillOverchargeAbility);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        this.overallKiMasteryAbilityScore = nbt.getInt("overallKiMasteryAbilityScore");
        this.kiManipulationAbility = nbt.getInt("kiManipulationAbility");
        this.kiCompressionAbility = nbt.getInt("kiCompressionAbility");
        this.kiVitality = nbt.getInt("kiVitality");
        this.kiSkillOverchargeAbility = nbt.getFloat("kiSkillOverchargeAbility");
    }
}
