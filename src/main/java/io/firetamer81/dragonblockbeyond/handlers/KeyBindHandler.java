package io.firetamer81.dragonblockbeyond.handlers;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.glfw.GLFW;

/**
 * Keybinds are client side only. From what I understand, packets are required to do server side stuff with keybinds
 */
public class KeyBindHandler {
    private KeyBindHandler() {}

    public static final String KEY_CATEGORY_DBB = "key.category.dragonblockbeyond.keybinds";

    public static KeyMapping testKey;
    public static final String TEST_KEYBIND_KEYSTRING = "key.dragonblockbeyond.test_key";


    /****************************************************************/
    //--------------------------------------------------------------//


    public static void init() {
        testKey = registerKeyBind(TEST_KEYBIND_KEYSTRING, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, KEY_CATEGORY_DBB);
    }

    public static void KeyBindActions() {
        if (testKey.consumeClick()) {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a Key!"));
        }

        //More Keybind Actions can go here, and they will automatically be put into the EventsHandler.
    }

    public static KeyMapping registerKeyBind(String keyString, KeyConflictContext conflictContext, InputConstants.Type inputConstantType, int keycode, String category) {
        final var key = new KeyMapping(keyString, conflictContext, inputConstantType, keycode, category);

        Minecraft.getInstance().options.keyMappings = ArrayUtils.add(
                Minecraft.getInstance().options.keyMappings, key);

        return key;
    }
}
