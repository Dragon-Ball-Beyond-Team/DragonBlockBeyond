package io.firetamer81.dragonblockbeyond.core.firelib;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class KeyBindsUtil {
    /**
     * Returns if the key is down by its keycode.
     * Does not support mouse keys.
     *
     * @param keycode the keycode.
     * @return true if the key is down.
     */
    public static boolean isKeyDown(int keycode) {
        Minecraft minecraft = Minecraft.getInstance();
        return InputConstants.isKeyDown(minecraft.getWindow().getWindow(), keycode);
    }

    /**
     * Returns if the key is down by its keyBinding.
     *
     * @param keyBinding the keybinding.
     * @return true if the key is down.
     */
    public static boolean isKeyDown(KeyMapping keyBinding) {
        Minecraft minecraft = Minecraft.getInstance();
        int keycode = keyBinding.getKey().getValue();
        if (keyBinding.isUnbound())
            return false;

        boolean keyIsDown;
        if (keyBinding.getKey().getType() == InputConstants.Type.MOUSE) {
            keyIsDown = GLFW.glfwGetMouseButton(minecraft.getWindow().getWindow(), keycode) == 1;
        } else {
            keyIsDown = InputConstants.isKeyDown(minecraft.getWindow().getWindow(), keycode);
        }

        boolean conflictContextActive = keyBinding.getKeyConflictContext().isActive();
        boolean keyModifierActivate = keyBinding.getKeyModifier().isActive(keyBinding.getKeyConflictContext());

        return keyIsDown && conflictContextActive && keyModifierActivate;
    }
}
