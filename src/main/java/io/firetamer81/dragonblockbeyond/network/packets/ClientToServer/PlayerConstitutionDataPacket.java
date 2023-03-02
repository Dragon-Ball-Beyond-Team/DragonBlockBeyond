package io.firetamer81.dragonblockbeyond.network.packets.ClientToServer;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.constitution_data.ConstitutionHolderAttacher;
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

            ConstitutionHolderAttacher.getHolder(player).ifPresent(constitution -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Constitution Score = " + constitution.getConstitutionAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                                "   - Current Head Constitution = " + constitution.getHeadConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Neck Constitution = " + constitution.getNeckConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Chest Constitution = " + constitution.getChestConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Back Constitution = " + constitution.getBackConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Bicep Constitution = " + constitution.getRightBicepConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Bicep Constitution = " + constitution.getLeftBicepConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Forearm Constitution = " + constitution.getRightForearmConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Forearm Constitution = " + constitution.getLeftForearmConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Hand Constitution = " + constitution.getRightHandConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Hand Constitution = " + constitution.getLeftHandConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Core Constitution = " + constitution.getCoreConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Thigh Constitution = " + constitution.getRightThighConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Thigh Constitution = " + constitution.getLeftThighConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Lower Leg Constitution = " + constitution.getRightLowerLegConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Lower Leg Constitution = " + constitution.getLeftLowerLegConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Right Foot Constitution = " + constitution.getRightFootConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                                "   - Current Left Foot Constitution = " + constitution.getLeftFootConstitution())
                        .withStyle(ChatFormatting.YELLOW));

                constitution.addToHeadConstitution(1);
                constitution.addToNeckConstitution(1);
                constitution.addToChestConstitution(1);
                constitution.addToBackConstitution(1);
                constitution.addToRightBicepConstitution(1);
                constitution.addToLeftBicepConstitution(1);
                constitution.addToRightForearmConstitution(1);
                constitution.addToLeftForearmConstitution(1);
                constitution.addToRightHandConstitution(1);
                constitution.addToLeftHandConstitution(1);
                constitution.addToCoreConstitution(1);
                constitution.addToRightThighConstitution(1);
                constitution.addToLeftThighConstitution(1);
                constitution.addToRightLowerLegConstitution(1);
                constitution.addToLeftLowerLegConstitution(1);
                constitution.addToRightFootConstitution(1);
                constitution.addToLeftFootConstitution(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerConstitutionDataPacket.class, PlayerConstitutionDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {}
}
