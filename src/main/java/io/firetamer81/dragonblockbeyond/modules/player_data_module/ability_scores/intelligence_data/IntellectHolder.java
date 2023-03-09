package io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.intelligence_data;

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

public class IntellectHolder extends PlayerCapability {

    protected IntellectHolder(Player player) {
        super(player);
    }

    /**
     * This score is the overall ability a player possesses in controlling and drawing in ki.
     * This determines the power of you ki skills, the speed of their movement, the complexity
     * of their design/function, and more.
     */
    private int overallIntellectAbilityScore;
    public int getIntellectAbilityScore() { return overallIntellectAbilityScore; }
    public void updateIntellectAbilityScore() {
        List<Integer> nums = Arrays.asList(
                this.overallIntellectAbilityScore,
                this.analysisAbility,
                this.craftingAbility,
                this.technicalKnowledgeAbility,
                this.instinctualMovementAbility
        );

        this.overallIntellectAbilityScore = MathHelper.sumIntList(nums);
    }


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/

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
        updateIntellectAbilityScore();
        updateTracking();
    }
    public void subFromAnalysisAbility(int sub) {
        this.analysisAbility = Math.max(analysisAbility - sub, MINIMUM_ANALYSIS_ABILITY);
        updateIntellectAbilityScore();
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
        updateIntellectAbilityScore();
        updateTracking();
    }
    public void subFromCraftingAbility(int sub) {
        this.craftingAbility = Math.max(craftingAbility - sub, MINIMUM_CRAFTING_ABILITY);
        updateIntellectAbilityScore();
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
        updateIntellectAbilityScore();
        updateTracking();
    }
    public void subFromTechnicalKnowledge(int sub) {
        this.technicalKnowledgeAbility = Math.max(technicalKnowledgeAbility - sub, MINIMUM_TECHNICAL_KNOWLEDGE);
        updateIntellectAbilityScore();
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
        updateIntellectAbilityScore();
        updateTracking();
    }
    public void subFromInstinctualMovement(int sub) {
        this.instinctualMovementAbility = Math.max(instinctualMovementAbility - sub, MINIMUM_INSTINCTUAL_MOVEMENT);
        updateIntellectAbilityScore();
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

        tag.putInt("overallIntellectAbilityScore", this.overallIntellectAbilityScore);
        tag.putInt("analysisAbility", this.analysisAbility);
        tag.putInt("craftingAbility", this.craftingAbility);
        tag.putInt("technicalKnowledgeAbility", this.technicalKnowledgeAbility);
        tag.putInt("instinctualMovementAbility", this.instinctualMovementAbility);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt, boolean readingFromDisk) {
        this.overallIntellectAbilityScore = nbt.getInt("overallIntellectAbilityScore");
        this.analysisAbility = nbt.getInt("analysisAbility");
        this.craftingAbility = nbt.getInt("craftingAbility");
        this.technicalKnowledgeAbility = nbt.getInt("technicalKnowledgeAbility");
        this.instinctualMovementAbility = nbt.getInt("instinctualMovementAbility");
    }
}
