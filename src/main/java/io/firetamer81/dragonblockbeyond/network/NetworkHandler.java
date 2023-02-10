package io.firetamer81.dragonblockbeyond.network;

import com.google.common.collect.ImmutableList;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.ki_test.KiHolderAttacher;
import io.firetamer81.dragonblockbeyond.modules.player_data_module.strength_data.StrengthHolderAttacher;
import io.firetamer81.dragonblockbeyond.network.packets.ClientToServer.PlayerKiPacket;
import io.firetamer81.dragonblockbeyond.network.packets.ClientToServer.PlayerStrengthDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.List;
import java.util.function.BiConsumer;

public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1.0";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(DragonBlockBeyond.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int nextId = 0;

    public static void register() {
        List<BiConsumer<SimpleChannel, Integer>> packets = ImmutableList.<BiConsumer<SimpleChannel, Integer>>builder()
                .add(SimpleEntityCapabilityStatusPacket::register)
                .add(PlayerKiPacket::register)
                .add(PlayerStrengthDataPacket::register)
                .build();

        SimpleEntityCapabilityStatusPacket.registerRetriever(KiHolderAttacher.RESOURCE_LOCATION, KiHolderAttacher::getHolderUnwrap);
        SimpleEntityCapabilityStatusPacket.registerRetriever(StrengthHolderAttacher.RESOURCE_LOCATION, StrengthHolderAttacher::getHolderUnwrap);

        packets.forEach(consumer -> consumer.accept(INSTANCE, getNextId()));
    }

    private static int getNextId() {
        return nextId++;
    }
}
