package io.firetamer81.dragonblockbeyond.init.handlers;

import com.mojang.blaze3d.platform.InputConstants;
import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.network.NetworkHandler;
import io.firetamer81.dragonblockbeyond.network.packets.ClientToServer.PlayerConstitutionDataPacket;
import io.firetamer81.dragonblockbeyond.network.packets.ClientToServer.PlayerKiPacket;
import io.firetamer81.dragonblockbeyond.network.packets.ClientToServer.PlayerStrengthDataPacket;
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
    public static final String TEST_STAT_DISPLAY_BUTTON = "key.dragonblockbeyond.test_key2";

    public static KeyMapping KI_TEST_BUTTON = new KeyMapping(TEST_KEYBIND_KEYSTRING,
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_X, KEY_CATEGORY_DBB);

    public static KeyMapping STAT_DISPLAY_BUTTON = new KeyMapping(TEST_STAT_DISPLAY_BUTTON,
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_Z, KEY_CATEGORY_DBB);


    /*----------------------------------------------------------------*/
    /*----------------------------------------------------------------*/


    public static void KeyBindActions() {
        if (KI_TEST_BUTTON.consumeClick()) {
            NetworkHandler.INSTANCE.sendToServer(new PlayerKiPacket());
        }

        if (STAT_DISPLAY_BUTTON.consumeClick()) {
            NetworkHandler.INSTANCE.sendToServer(new PlayerConstitutionDataPacket());
        }
    }

    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event) {
        event.register(KeyBindHandler.KI_TEST_BUTTON);
        event.register(KeyBindHandler.STAT_DISPLAY_BUTTON);
    }
}
