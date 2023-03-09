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

public record PlayerStrengthDataPacket() implements IPacket {

    public PlayerStrengthDataPacket(FriendlyByteBuf packetBuf) { this(); }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            AbilityScoresHolderAttacher.getHolder(player).ifPresent(abilityScores -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Strength = " + abilityScores.getStrengthAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                        "   - Current Jaw Strength = " + abilityScores.getJawStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Neck Strength = " + abilityScores.getNeckStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Pectoralis Strength = " + abilityScores.getPectoralisStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Back Strength = " + abilityScores.getBackStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Upper Arm Strength = " + abilityScores.getRightUpperArmStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Upper Arm Strength = " + abilityScores.getLeftUpperArmStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Forearm Strength = " + abilityScores.getRightForearmStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Forearm Strength = " + abilityScores.getLeftForearmStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Core Strength = " + abilityScores.getCoreStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Thigh Strength = " + abilityScores.getRightThighStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Thigh Strength = " + abilityScores.getLeftThighStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Lower Leg Strength = " + abilityScores.getRightLowerLegStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Lower Leg Strength = " + abilityScores.getLeftLowerLegStrength())
                        .withStyle(ChatFormatting.YELLOW));

                abilityScores.addToJawStrength(1);
                abilityScores.addToNeckStrength(1);
                abilityScores.addToPectoralisStrength(1);
                abilityScores.addToBackStrength(1);
                abilityScores.addToRightUpperArmStrength(1);
                abilityScores.addToLeftUpperArmStrength(1);
                abilityScores.addToRightForearmStrength(1);
                abilityScores.addToLeftForearmStrength(1);
                abilityScores.addToCoreStrength(1);
                abilityScores.addToRightThighStrength(1);
                abilityScores.addToLeftThighStrength(1);
                abilityScores.addToRightLowerLegStrength(1);
                abilityScores.addToLeftLowerLegStrength(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerStrengthDataPacket.class, PlayerStrengthDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {

    }
}
