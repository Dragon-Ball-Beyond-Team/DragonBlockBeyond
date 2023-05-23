package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._alphacomponents;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;

public abstract class _TestScreenComponent extends AbstractWidget {
    protected Minecraft mc = Minecraft.getInstance();
    protected String[] tooltips = new String[0];
    protected boolean visible = true;
    protected boolean enabled = true;
    private int assignedPage = -1;
    protected boolean hovered;
    int scrollOffsetX = 0;
    int scrollOffsetY = 0;
    protected final Font renderer;

    public _TestScreenComponent(int xIn, int yIn, int widthIn, int heightIn) {
        super(xIn, yIn, widthIn, heightIn, Component.literal(""));

        this.renderer = Minecraft.getInstance().font;
        this.setX(xIn);
        this.setY(yIn);
        this.width = widthIn;
        this.height = heightIn;
    }

    //<editor-fold desc="Abstract Methods">
    public abstract void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick);

    public abstract void mouseClick(double var1, double var3, int var5);

    public abstract void mouseRelease(double var1, double var3, int var5);

    public abstract boolean charTyped(char var1, int var2);

    public abstract boolean canHaveTooltip();
    //</editor-fold>

    //<editor-fold desc="Get Methods">
    public String[] getTooltips() { return this.tooltips; }

    public final boolean isVisible() { return this.visible; }

    public final boolean isEnabled() { return this.enabled; }

    public final int getX() { return super.getX() + this.scrollOffsetX; }

    public final int getY() { return super.getY() + this.scrollOffsetY; }

    public final int getWidth() { return this.width; }

    public final int getHeight() { return this.height; }
    //</editor-fold>

    //<editor-fold desc="Set Methods">
    /**
     * This method is made private so each child of this class can have a version of it that returns themselves for the nice
     * ".setText(blah...)" type methods.
     * Simply make a set Tooltips method in a child class and have super.setTooltips at the top.
     */
    protected final void setComponentTooltips(String[] strings) { this.tooltips = strings; }

    private void setVisible(boolean visible) { this.visible = visible; }

    private void setEnabled(boolean enable) { this.enabled = enable; }

    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void setX(int x) { super.setX(x); }

    public void setY(int y) { super.setY(y); }

    public void setWidth(int width) { this.width = width; }

    public void setHeight(int height) { this.height = height; }
    //</editor-fold>

    //<editor-fold desc="Outside Interaction Methods">
    /**
     * These methods are not able to be used like ".setText(blah...)" methods on elements.
     * Rather, they are used for interconnectivity. (Like a button that disables a panel),
     * and general logic of the overall gui.
     */
    public final void disable() { this.setEnabled(false); }

    public final void enable() { this.setEnabled(true); }

    public final void hide() { this.setVisible(false); }

    public final void show() { this.setVisible(true); }

    public void playPressSound() {
        this.mc.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, (this.enabled ? 1.0f : 0.5f)));
    }
    //</editor-fold>

    //<editor-fold desc="Input Tracking">
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) { return true; }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClick(mouseX, mouseY, button);
        return true;
    }

    public boolean clicked(double mouseX, double mouseY) {
        return this.isVisible() && mouseX >= (double)this.getX() && mouseY >= (double)this.getY() && mouseX < (double)(this.getX() + this.getWidth()) && mouseY < (double)(this.getY() + this.getHeight());
    }

    public boolean mouseReleased(double mouseX, double mouseY, int state) {
        this.mouseRelease(mouseX, mouseY, state);
        return true;
    }
    //</editor-fold>

    //<editor-fold desc="Page Methods">
    public final void assignToPage(int page) {
        this.assignedPage = page;
    }

    public final int getAssignedPage() {
        return this.assignedPage;
    }
    //</editor-fold>

    //<editor-fold desc="Misc. Methods">
    @Deprecated
    protected int getYImage(boolean isHovered) {
        int i = 1;
        if (!this.isEnabled()) {
            i = 0;
        } else if (isHovered) {
            i = 2;
        }
        return i;
    }

    /**
     * I think this is only here to prevent it needing to be done in every class that extends this one.
     */
    protected void updateWidgetNarration(@NotNull NarrationElementOutput p_259858_) {}

    public void unload() {}
    //</editor-fold>
}
