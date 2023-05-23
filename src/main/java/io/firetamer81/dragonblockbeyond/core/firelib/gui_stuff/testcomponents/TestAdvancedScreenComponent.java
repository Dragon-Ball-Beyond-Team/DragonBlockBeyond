package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;


public abstract class TestAdvancedScreenComponent extends AbstractWidget {
    protected static final ResourceLocation WIDGETS_LOCATION = new ResourceLocation("textures/gui/widgets.png");
    protected static final ResourceLocation errorIcon = new ResourceLocation("dragonblockbeyond", "textures/gui/firelibguistuff/imgerror.png");
    protected final Font renderer;
    protected Minecraft mc = Minecraft.getInstance();
    protected int id;
    protected boolean hovered;
    protected boolean visible = true;
    protected boolean enabled = true;
    int scrollOffsetX = 0;
    int scrollOffsetY = 0;
    private String[] tooltips = new String[0];
    private int assignedPage = -1;

    public TestAdvancedScreenComponent(int xIn, int yIn, int widthIn, int heightIn) {
        super(xIn, yIn, widthIn, heightIn, (Component)Component.literal((String)""));
        this.renderer = Minecraft.getInstance().font;
        this.setX(xIn);
        this.setY(yIn);
        this.width = widthIn;
        this.height = heightIn;
    }

    public boolean canHaveTooltip() {
        return true;
    }

    public String[] getTooltips() {
        return this.tooltips;
    }

    public final void setTooltips(String ... strings) {
        this.tooltips = strings;
    }

    public final boolean isVisible() {
        return this.visible;
    }

    public final void setVisible(boolean visible) {
        this.visible = visible;
    }

    public final boolean isEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean enable) {
        this.enabled = enable;
    }

    protected int getYImage(boolean isHovered) {
        int i = 1;
        if (!this.isEnabled()) {
            i = 0;
        } else if (isHovered) {
            i = 2;
        }
        return i;
    }

    public final int getX() {
        return super.getX() + this.scrollOffsetX;
    }

    public void setX(int x) {
        super.setX(x);
    }

    public final int getY() {
        return super.getY() + this.scrollOffsetY;
    }

    public void setY(int y) {
        super.setY(y);
    }

    protected void updateWidgetNarration(NarrationElementOutput p_259858_) {
    }

    public final int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getComponentHeight() {
        return this.getHeight();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void playPressSound() {
        this.mc.getSoundManager().play((SoundInstance)SimpleSoundInstance.forUI((Holder)SoundEvents.UI_BUTTON_CLICK, (float)(this.enabled ? 1.0f : 0.5f)));
    }

    public abstract void render(PoseStack var1, int var2, int var3, float var4);

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return true;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClick(mouseX, mouseY, button);
        return true;
    }

    public abstract void mouseClick(double var1, double var3, int var5);

    public boolean clicked(double mouseX, double mouseY) {
        return this.isVisible() && mouseX >= (double)this.getX() && mouseY >= (double)this.getY() && mouseX < (double)(this.getX() + this.getWidth()) && mouseY < (double)(this.getY() + this.getComponentHeight());
    }

    public boolean mouseReleased(double mouseX, double mouseY, int state) {
        this.mouseRelease(mouseX, mouseY, state);
        return true;
    }

    public abstract void mouseRelease(double var1, double var3, int var5);

    public abstract boolean charTyped(char var1, int var2);

    public final void disable() {
        this.setEnabled(false);
    }

    public final void enable() {
        this.setEnabled(true);
    }

    public final void hide() {
        this.setVisible(false);
    }

    public final void show() {
        this.setVisible(true);
    }

    public final void assignToPage(int page) {
        this.assignedPage = page;
    }

    public final int getAssignedPage() {
        return this.assignedPage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void unload() {
    }
}
