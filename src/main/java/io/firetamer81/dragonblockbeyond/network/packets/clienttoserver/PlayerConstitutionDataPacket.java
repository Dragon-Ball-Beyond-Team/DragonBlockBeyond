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

public record PlayerConstitutionDataPacket() implements IPacket {

    public PlayerConstitutionDataPacket(FriendlyByteBuf packetBuf) { this(); }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            AbilityScoresHolderAttacher.getHolder(player).ifPresent(abilityScores -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Constitution Score = " + abilityScores.getConstitutionAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                                "   - Current Head Constitution = " + abilityScores.getHeadConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Neck Constitution = " + abilityScores.getNeckConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Chest Constitution = " + abilityScores.getChestConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Back Constitution = " + abilityScores.getBackConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Upper Arm Constitution = " + abilityScores.getRightUpperArmConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Upper Arm Constitution = " + abilityScores.getLeftUpperArmConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Forearm Constitution = " + abilityScores.getRightForearmConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Forearm Constitution = " + abilityScores.getLeftForearmConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Hand Constitution = " + abilityScores.getRightHandConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Hand Constitution = " + abilityScores.getLeftHandConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Core Constitution = " + abilityScores.getCoreConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Thigh Constitution = " + abilityScores.getRightThighConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Thigh Constitution = " + abilityScores.getLeftThighConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Lower Leg Constitution = " + abilityScores.getRightLowerLegConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Lower Leg Constitution = " + abilityScores.getLeftLowerLegConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Foot Constitution = " + abilityScores.getRightFootConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Foot Constitution = " + abilityScores.getLeftFootConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                abilityScores.addToHeadConstitution(1);
                abilityScores.addToNeckConstitution(1);
                abilityScores.addToChestConstitution(1);
                abilityScores.addToBackConstitution(1);
                abilityScores.addToRightUpperArmConstitution(1);
                abilityScores.addToLeftUpperArmConstitution(1);
                abilityScores.addToRightForearmConstitution(1);
                abilityScores.addToLeftForearmConstitution(1);
                abilityScores.addToRightHandConstitution(1);
                abilityScores.addToLeftHandConstitution(1);
                abilityScores.addToCoreConstitution(1);
                abilityScores.addToRightThighConstitution(1);
                abilityScores.addToLeftThighConstitution(1);
                abilityScores.addToRightLowerLegConstitution(1);
                abilityScores.addToLeftLowerLegConstitution(1);
                abilityScores.addToRightFootConstitution(1);
                abilityScores.addToLeftFootConstitution(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerConstitutionDataPacket.class, PlayerConstitutionDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {}
}
