package io.firetamer81.dragonblockbeyond.network;

import com.google.common.collect.ImmutableList;
import dev._100media.capabilitysyncer.network.SimpleEntityCapabilityStatusPacket;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.modules.playerdatamodule.abilityscores.AbilityScoresHolderAttacher;
import io.firetamer81.dragonblockbeyond.modules.playerdatamodule.playercondition.PlayerConditionHolderAttacher;
import io.firetamer81.dragonblockbeyond.network.packets.clienttoserver.*;
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
                .add(PlayerConditionDataPacket::register)
                .add(PlayerStrengthDataPacket::register)
                .add(PlayerConstitutionDataPacket::register)
                .add(PlayerResilienceDataPacket::register)
                .add(PlayerKiMasteryDataPacket::register)
                .add(PlayerDexterityDataPacket::register)
                .add(PlayerIntelligenceDataPacket::register)
                .build();

        SimpleEntityCapabilityStatusPacket.registerRetriever(PlayerConditionHolderAttacher.RESOURCE_LOCATION, PlayerConditionHolderAttacher::getHolderUnwrap);
        SimpleEntityCapabilityStatusPacket.registerRetriever(AbilityScoresHolderAttacher.RESOURCE_LOCATION, AbilityScoresHolderAttacher::getHolderUnwrap);

        packets.forEach(consumer -> consumer.accept(INSTANCE, getNextId()));
    }

    private static int getNextId() {
        return nextId++;
    }
}
