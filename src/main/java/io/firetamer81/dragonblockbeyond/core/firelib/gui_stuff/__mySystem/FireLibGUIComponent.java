package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.__mySystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;

public abstract class FireLibGUIComponent extends AbstractWidget {
    protected Minecraft mc = Minecraft.getInstance();
    protected String[] tooltips = new String[0];
    protected boolean visible = true;
    protected boolean enabled = true;
    private int assignedPage = -1;
    protected boolean hovered;
    int scrollOffsetX = 0;
    int scrollOffsetY = 0;
    protected final Font renderer;

    public FireLibGUIComponent(int xIn, int yIn, int widthIn, int heightIn) {
        super(xIn, yIn, widthIn, heightIn, Component.literal(""));

        this.renderer = Minecraft.getInstance().font;
        this.setX(xIn);
        this.setY(yIn);
        this.width = widthIn;
        this.height = heightIn;
    }





    public abstract void mouseClick(double var1, double var3, int var5);

    public abstract void mouseRelease(double var1, double var3, int var5);

    public abstract boolean charTyped(char var1, int var2);
}
