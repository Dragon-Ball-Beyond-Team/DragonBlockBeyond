package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._alphacomponents;

import com.mojang.blaze3d.vertex.PoseStack;

public class FireLibTextInputField extends _TestScreenComponent {
    public FireLibTextInputField(int xIn, int yIn, int widthIn, int heightIn) {
        super(xIn, yIn, widthIn, heightIn);
    }

    @Override
    public void render(PoseStack var1, int var2, int var3, float var4) {}

    @Override
    public void mouseClick(double var1, double var3, int var5) {}

    @Override
    public void mouseRelease(double var1, double var3, int var5) {}

    @Override
    public boolean charTyped(char var1, int var2) { return false; }

    @Override
    public boolean canHaveTooltip() { return false; }
}
