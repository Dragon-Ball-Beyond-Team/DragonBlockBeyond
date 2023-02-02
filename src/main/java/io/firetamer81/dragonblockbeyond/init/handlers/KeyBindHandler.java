package io.firetamer81.dragonblockbeyond.init.handlers;

import com.mojang.blaze3d.platform.InputConstants;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import io.firetamer81.dragonblockbeyond.network.packets.PlayerKiPacket_CtoS;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = DragonBlockBeyond.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KeyBindHandler {
    private KeyBindHandler() {}

    public static final String KEY_CATEGORY_DBB = "key.category.dragonblockbeyond.keybinds";
    public static final String TEST_KEYBIND_KEYSTRING = "key.dragonblockbeyond.test_key";

    public static KeyMapping TEST_KEY = new KeyMapping(TEST_KEYBIND_KEYSTRING, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, KEY_CATEGORY_DBB);



    public static void KeyBindActions() {
        if (TEST_KEY.consumeClick()) {
            /*Minecraft.getInstance().player.sendSystemMessage(
                    Component.literal("Pressed a Key!"));*/

            NetworkHandler.INSTANCE.sendToServer(new PlayerKiPacket_CtoS());
        }
    }

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(KeyBindHandler.TEST_KEY);
    }
}
