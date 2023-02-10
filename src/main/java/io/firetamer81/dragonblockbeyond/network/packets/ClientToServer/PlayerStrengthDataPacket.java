package io.firetamer81.dragonblockbeyond.network.packets.ClientToServer;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.strength_data.StrengthHolderAttacher;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
                        "Current Overall Strength = " + strength.getStrengthAbilityScore())
                        .withStyle(ChatFormatting.DARK_RED));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                        "   - Current Neck Strength = " + strength.getNeckStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Pectoralis Strength = " + strength.getPectoralisStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Back Strength = " + strength.getBackStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Bicep Strength = " + strength.getRightBicepStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Bicep Strength = " + strength.getLeftBicepStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Forearm Strength = " + strength.getRightForearmStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Forearm Strength = " + strength.getLeftForearmStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Core Strength = " + strength.getCoreStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Thigh Strength = " + strength.getRightThighStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Thigh Strength = " + strength.getLeftThighStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Right Calf Strength = " + strength.getRightCalfStrength())
                        .withStyle(ChatFormatting.RED));

                player.sendSystemMessage(Component.literal(
                        "   - Current Left Calf Strength = " + strength.getLeftCalfStrength())
                        .withStyle(ChatFormatting.RED));

                strength.addToNeckStrength(1);
                strength.addToPectoralisStrength(1);
                strength.addToBackStrength(1);
                strength.addToRightBicepStrength(1);
                strength.addToLeftBicepStrength(1);
                strength.addToRightForearmStrength(1);
                strength.addToLeftForearmStrength(1);
                strength.addToCoreStrength(1);
                strength.addToRightThighStrength(1);
                strength.addToLeftThighStrength(1);
                strength.addToRightCalfStrength(1);
                strength.addToLeftCalfStrength(1);
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
