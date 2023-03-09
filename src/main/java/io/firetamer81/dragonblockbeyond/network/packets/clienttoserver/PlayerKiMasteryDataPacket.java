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

public record PlayerKiMasteryDataPacket() implements IPacket {

    public PlayerKiMasteryDataPacket(FriendlyByteBuf packetBuf) { this(); }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();

            AbilityScoresHolderAttacher.getHolder(player).ifPresent(abilityScores -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Ki Mastery = " + abilityScores.getKiMasteryAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Manipulation Ability = " + abilityScores.getKiManipulationAbility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Mastery Compression Ability = " + abilityScores.getKiCompressionAbility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Vitality = " + abilityScores.getKiVitality())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Overcharge Ability = " + abilityScores.getKiSkillOverchargeAbility())
                        .withStyle(ChatFormatting.YELLOW));

                abilityScores.addToKiManipulationAbility(1);
                abilityScores.addToKiCompressionAbility(1);
                abilityScores.addToKiVitality(1);
                abilityScores.addToKiSkillOverchargeAbility(1);
            });
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerKiMasteryDataPacket.class, PlayerKiMasteryDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {

    }
}
