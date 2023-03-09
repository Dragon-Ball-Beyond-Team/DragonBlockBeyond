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

public record PlayerDexterityDataPacket() implements IPacket {
    
    public PlayerDexterityDataPacket(FriendlyByteBuf packetBuf) { this(); }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            AbilityScoresHolderAttacher.getHolder(player).ifPresent(abilityScores -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Dexterity Score = " + abilityScores.getDexAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                                "   - Current Neck Agility = " + abilityScores.getNeckAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Neck Agility = " + abilityScores.getBackAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Chest Agility = " + abilityScores.getRightArmAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Back Agility = " + abilityScores.getLeftArmAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Wrist Agility = " + abilityScores.getRightWristAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Wrist Agility = " + abilityScores.getLeftWristAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Hand Dexterity = " + abilityScores.getRightHandDexterity())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Hand Dexterity = " + abilityScores.getLeftHandDexterity())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Leg Agility = " + abilityScores.getRightLegAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Leg Agility = " + abilityScores.getLeftLegAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Ankle Agility = " + abilityScores.getRightAnkleAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Ankle Agility = " + abilityScores.getLeftAnkleAgility())
                        .withStyle(ChatFormatting.YELLOW));

                abilityScores.addToNeckAgility(1);
                abilityScores.addToBackAgility(1);
                abilityScores.addToRightArmAgility(1);
                abilityScores.addToLeftArmAgility(1);
                abilityScores.addToRightWristAgility(1);
                abilityScores.addToLeftWristAgility(1);
                abilityScores.addToRightHandDexterity(1);
                abilityScores.addToLeftHandDexterity(1);
                abilityScores.addToRightLegAgility(1);
                abilityScores.addToLeftLegAgility(1);
                abilityScores.addToRightAnkleAgility(1);
                abilityScores.addToLeftAnkleAgility(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerDexterityDataPacket.class, PlayerDexterityDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {}
}
