package io.firetamer81.dragonblockbeyond.network.packets.ClientToServer;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.ability_scores.ki_mastery_data.KiMasteryHolderAttacher;
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

            KiMasteryHolderAttacher.getHolder(player).ifPresent(kiMastery -> {

                player.sendSystemMessage(Component.literal(
                        "Current Overall Ki Mastery = " + kiMastery.getKiMasteryAbilityScore()
                ).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.UNDERLINE));


                /*-------------------------------*/


                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Manipulation Ability = " + kiMastery.getKiManipulationAbility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Mastery Compression Ability = " + kiMastery.getKiCompressionAbility())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Vitality = " + kiMastery.getKiVitality())
                        .withStyle(ChatFormatting.YELLOW));

                player.sendSystemMessage(Component.literal(
                        "   - Current Ki Overcharge Ability = " + kiMastery.getKiSkillOverchargeAbility())
                        .withStyle(ChatFormatting.YELLOW));

                kiMastery.addToKiManipulationAbility(1);
                kiMastery.addToKiCompressionAbility(1);
                kiMastery.addToKiVitality(1);
                kiMastery.addToKiSkillOverchargeAbility(1);
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
