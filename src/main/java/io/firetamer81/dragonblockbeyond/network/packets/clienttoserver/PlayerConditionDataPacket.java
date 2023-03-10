package io.firetamer81.dragonblockbeyond.network.packets.clienttoserver;

import dev._100media.capabilitysyncer.network.IPacket;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.modules.playerdatamodule.playercondition.PlayerConditionHolderAttacher;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

public record PlayerConditionDataPacket() implements IPacket {
    private static final String MESSAGE_ABSORB_KI = "message." + DragonBlockBeyond.MODID + ".add_ki";
    private static final String MESSAGE_UNABLE_TO_ABSORB_KI = "message." + DragonBlockBeyond.MODID + ".no_ki_to_absorb";

    public PlayerConditionDataPacket(FriendlyByteBuf packetBuf) { this(); }

    private boolean hasGrassAroundThem(ServerPlayer player, ServerLevel level, int size) {
        return level.getBlockStates(player.getBoundingBox().inflate(size))
                .filter(state -> state.is(Blocks.GRASS_BLOCK)).toArray().length > 0;
    }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            //Get the Server Level & Player
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            if(hasGrassAroundThem(player, level, 2)) {
                // Notify the player that ki has been absorbed
                player.sendSystemMessage(Component.translatable(MESSAGE_ABSORB_KI).withStyle(ChatFormatting.DARK_AQUA));
                // play a sound
                level.playSound(null, player.getOnPos(), SoundEvents.CONDUIT_ACTIVATE, SoundSource.PLAYERS,
                        0.5F, level.random.nextFloat() * 0.1F + 0.9F);

                PlayerConditionHolderAttacher.getHolder(player).ifPresent(ki -> {
                    // increase the player's ki
                    ki.addKi(1);

                    // Output the player's current ki
                    player.sendSystemMessage(Component.literal("Current Ki " + ki.getKi())
                            .withStyle(ChatFormatting.AQUA));
                });
            } else {
                // Notify the player that there is no grass around!
                player.sendSystemMessage(Component.translatable(MESSAGE_UNABLE_TO_ABSORB_KI).withStyle(ChatFormatting.RED));
                // Output the current Ki level
                PlayerConditionHolderAttacher.getHolder(player).ifPresent(ki -> {
                    player.sendSystemMessage(Component.literal("Current Ki " + ki.getKi())
                            .withStyle(ChatFormatting.AQUA));
                });
            }
        });
    }

    public static void register(SimpleChannel channel, int id) {
        IPacket.register(channel, id, NetworkDirection.PLAY_TO_SERVER, PlayerConditionDataPacket.class, PlayerConditionDataPacket::new);
    }

    @Override
    public void write(FriendlyByteBuf packetBuf) {

    }
}
