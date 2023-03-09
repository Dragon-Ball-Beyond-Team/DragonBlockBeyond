package io.firetamer81.dragonblockbeyond.network.packets.ClientToServer;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.resilience_data.ResilienceHolderAttacher;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.resilience_data.ResilienceHolderAttacher;
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

            ResilienceHolderAttacher.getHolder(player).ifPresent(resilience -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Resilience Score = " + resilience.getResilienceAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                                "   - Current Head Resilience = " + resilience.getHeadResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Neck Resilience = " + resilience.getNeckResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Chest Resilience = " + resilience.getChestResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Back Resilience = " + resilience.getBackResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Upper Arm Resilience = " + resilience.getRightUpperArmResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Upper Arm Resilience = " + resilience.getLeftUpperArmResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Forearm Resilience = " + resilience.getRightForearmResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Forearm Resilience = " + resilience.getLeftForearmResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Hand Resilience = " + resilience.getRightHandResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Hand Resilience = " + resilience.getLeftHandResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Core Resilience = " + resilience.getCoreResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Thigh Resilience = " + resilience.getRightThighResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Thigh Resilience = " + resilience.getLeftThighResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Lower Leg Resilience = " + resilience.getRightLowerLegResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Lower Leg Resilience = " + resilience.getLeftLowerLegResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Foot Resilience = " + resilience.getRightFootResilience())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Foot Resilience = " + resilience.getLeftFootResilience())
                        .withStyle(ChatFormatting.YELLOW));

                resilience.addToHeadResilience(1);
                resilience.addToNeckResilience(1);
                resilience.addToChestResilience(1);
                resilience.addToBackResilience(1);
                resilience.addToRightUpperArmResilience(1);
                resilience.addToLeftUpperArmResilience(1);
                resilience.addToRightForearmResilience(1);
                resilience.addToLeftForearmResilience(1);
                resilience.addToRightHandResilience(1);
                resilience.addToLeftHandResilience(1);
                resilience.addToCoreResilience(1);
                resilience.addToRightThighResilience(1);
                resilience.addToLeftThighResilience(1);
                resilience.addToRightLowerLegResilience(1);
                resilience.addToLeftLowerLegResilience(1);
                resilience.addToRightFootResilience(1);
                resilience.addToLeftFootResilience(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerResilienceDataPacket.class, PlayerResilienceDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {}
}
