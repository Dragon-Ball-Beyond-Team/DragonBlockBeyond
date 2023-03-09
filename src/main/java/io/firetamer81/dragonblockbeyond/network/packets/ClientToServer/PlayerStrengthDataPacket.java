package io.firetamer81.dragonblockbeyond.network.packets.ClientToServer;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.strength_data.StrengthHolderAttacher;
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

            StrengthHolderAttacher.getHolder(player).ifPresent(strength -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Strength = " + strength.getStrengthAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                        "   - Current Jaw Strength = " + strength.getJawStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Neck Strength = " + strength.getNeckStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Pectoralis Strength = " + strength.getPectoralisStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Back Strength = " + strength.getBackStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Upper Arm Strength = " + strength.getRightUpperArmStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Upper Arm Strength = " + strength.getLeftUpperArmStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Forearm Strength = " + strength.getRightForearmStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Forearm Strength = " + strength.getLeftForearmStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Core Strength = " + strength.getCoreStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Thigh Strength = " + strength.getRightThighStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Thigh Strength = " + strength.getLeftThighStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Lower Leg Strength = " + strength.getRightLowerLegStrength())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Lower Leg Strength = " + strength.getLeftLowerLegStrength())
                        .withStyle(ChatFormatting.YELLOW));

                strength.addToJawStrength(1);
                strength.addToNeckStrength(1);
                strength.addToPectoralisStrength(1);
                strength.addToBackStrength(1);
                strength.addToRightUpperArmStrength(1);
                strength.addToLeftUpperArmStrength(1);
                strength.addToRightForearmStrength(1);
                strength.addToLeftForearmStrength(1);
                strength.addToCoreStrength(1);
                strength.addToRightThighStrength(1);
                strength.addToLeftThighStrength(1);
                strength.addToRightLowerLegStrength(1);
                strength.addToLeftLowerLegStrength(1);
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
