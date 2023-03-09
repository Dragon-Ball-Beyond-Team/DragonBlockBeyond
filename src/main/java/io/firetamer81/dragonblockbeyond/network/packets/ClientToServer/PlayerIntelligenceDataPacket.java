package io.firetamer81.dragonblockbeyond.network.packets.ClientToServer;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.intelligence_data.IntellectHolderAttacher;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

public record PlayerIntelligenceDataPacket() implements IPacket {

    public PlayerIntelligenceDataPacket(FriendlyByteBuf packetBuf) { this(); }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            IntellectHolderAttacher.getHolder(player).ifPresent(intelligence -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Intellect = " + intelligence.getIntellectAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Analysis Ability = " + intelligence.getAnalysisAbility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Crafting Ability = " + intelligence.getCraftingAbility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Technical Knowledge = " + intelligence.getTechnicalKnowledge())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Instinctual Movement Ability = " + intelligence.getInstinctualMovement())
                        .withStyle(ChatFormatting.YELLOW));

                intelligence.addToAnalysisAbility(1);
                intelligence.addToCraftingAbility(1);
                intelligence.addToTechnicalKnowledge(1);
                intelligence.addToInstinctualMovement(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerIntelligenceDataPacket.class, PlayerIntelligenceDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {

    }
}
