package io.firetamer81.dragonblockbeyond.network.packets.clienttoserver;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.modules.playerdatamodule.abilityscores.AbilityScoresHolderAttacher;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

public record PlayerResilienceDataPacket() implements IPacket {


    public PlayerResilienceDataPacket(FriendlyByteBuf packetBuf) { this(); }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            AbilityScoresHolderAttacher.getHolder(player).ifPresent(abilityScores -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Resilience Score = " + abilityScores.getResilienceAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                                "   - Current Head Resilience = " + abilityScores.getHeadResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Neck Resilience = " + abilityScores.getNeckResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Chest Resilience = " + abilityScores.getChestResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Back Resilience = " + abilityScores.getBackResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Upper Arm Resilience = " + abilityScores.getRightUpperArmResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Upper Arm Resilience = " + abilityScores.getLeftUpperArmResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Forearm Resilience = " + abilityScores.getRightForearmResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Forearm Resilience = " + abilityScores.getLeftForearmResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Hand Resilience = " + abilityScores.getRightHandResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Hand Resilience = " + abilityScores.getLeftHandResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Core Resilience = " + abilityScores.getCoreResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Thigh Resilience = " + abilityScores.getRightThighResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Thigh Resilience = " + abilityScores.getLeftThighResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Lower Leg Resilience = " + abilityScores.getRightLowerLegResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Lower Leg Resilience = " + abilityScores.getLeftLowerLegResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Foot Resilience = " + abilityScores.getRightFootResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Foot Resilience = " + abilityScores.getLeftFootResilience())
                        .withStyle(ChatFormatting.YELLOW));

                abilityScores.addToHeadResilience(1);
                abilityScores.addToNeckResilience(1);
                abilityScores.addToChestResilience(1);
                abilityScores.addToBackResilience(1);
                abilityScores.addToRightUpperArmResilience(1);
                abilityScores.addToLeftUpperArmResilience(1);
                abilityScores.addToRightForearmResilience(1);
                abilityScores.addToLeftForearmResilience(1);
                abilityScores.addToRightHandResilience(1);
                abilityScores.addToLeftHandResilience(1);
                abilityScores.addToCoreResilience(1);
                abilityScores.addToRightThighResilience(1);
                abilityScores.addToLeftThighResilience(1);
                abilityScores.addToRightLowerLegResilience(1);
                abilityScores.addToLeftLowerLegResilience(1);
                abilityScores.addToRightFootResilience(1);
                abilityScores.addToLeftFootResilience(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerResilienceDataPacket.class, PlayerResilienceDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {}
}
