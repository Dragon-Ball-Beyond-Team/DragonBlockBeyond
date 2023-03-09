package io.firetamer81.dragonblockbeyond.network.packets.ClientToServer;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.dexterity_data.DexterityHolderAttacher;
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

            DexterityHolderAttacher.getHolder(player).ifPresent(dexterity -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Dexterity Score = " + dexterity.getDexAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                                "   - Current Neck Agility = " + dexterity.getNeckAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Neck Agility = " + dexterity.getBackAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Chest Agility = " + dexterity.getRightArmAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Back Agility = " + dexterity.getLeftArmAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Wrist Agility = " + dexterity.getRightWristAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Wrist Agility = " + dexterity.getLeftWristAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Hand Dexterity = " + dexterity.getRightHandDexterity())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Hand Dexterity = " + dexterity.getLeftHandDexterity())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Leg Agility = " + dexterity.getRightLegAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Leg Agility = " + dexterity.getLeftLegAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Ankle Agility = " + dexterity.getRightAnkleAgility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Ankle Agility = " + dexterity.getLeftAnkleAgility())
                        .withStyle(ChatFormatting.YELLOW));

                dexterity.addToNeckAgility(1);
                dexterity.addToBackAgility(1);
                dexterity.addToRightArmAgility(1);
                dexterity.addToLeftArmAgility(1);
                dexterity.addToRightWristAgility(1);
                dexterity.addToLeftWristAgility(1);
                dexterity.addToRightHandDexterity(1);
                dexterity.addToLeftHandDexterity(1);
                dexterity.addToRightLegAgility(1);
                dexterity.addToLeftLegAgility(1);
                dexterity.addToRightAnkleAgility(1);
                dexterity.addToLeftAnkleAgility(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerDexterityDataPacket.class, PlayerDexterityDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {}
}
