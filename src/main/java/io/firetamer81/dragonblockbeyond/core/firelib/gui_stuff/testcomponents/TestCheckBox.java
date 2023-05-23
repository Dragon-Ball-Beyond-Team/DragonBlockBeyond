package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.ScreenUtils;

public class TestCheckBox extends TestAdvancedScreenComponent {
    private static final ResourceLocation CHECKBOX_LOCATION = new ResourceLocation("minecraft", "textures/gui/checkbox.png");
    private final int boxWidth;
    private final String displayString;
    private Runnable callback;
    private boolean isChecked;

    public TestCheckBox(int xPos, int yPos, String displayString, boolean isChecked) {
        super(xPos, yPos, 0, 0);
        this.displayString = displayString;
        this.isChecked = isChecked;
        this.boxWidth = 11;
        this.height = 11;
        this.width = this.boxWidth + 2 + Minecraft.getInstance().font.width(displayString);
    }

    public TestCheckBox(int xPos, int yPos, String displayString) {
        this(xPos, yPos, displayString, false);
    }

    public TestCheckBox(int xPos, int yPos) {
        this(xPos, yPos, "", false);
    }

    public TestCheckBox(int xPos, int yPos, int width, int height) {
        this(xPos, yPos, "", false);
        this.width = width;
        this.height = height;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void onChange() {
        if (this.callback != null) {
            this.callback.run();
        }

    }

    public final void setChangeListener(Runnable r) {
        this.callback = r;
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partial) {
        this.isHovered = mouseX >= this.getX() && mouseY >= this.getY() && mouseX < this.getX() + this.width && mouseY < this.getY() + this.height;
        int color = 14737632;
        if (this.packedFGColor != 0) {
            color = this.packedFGColor;
        } else if (!this.enabled) {
            color = 10526880;
        } else if (this.hovered) {
            color = 16777120;
        }

        ScreenUtils.blitWithBorder(poseStack, WIDGETS_LOCATION, this.getX(), this.getY(), 0, 46, this.boxWidth, this.height, 200, 20, 2, 3, 2, 2, (float)this.getBlitOffset());
        if (this.isChecked) {
            drawCenteredString(poseStack, this.mc.font, "x", this.getX() + this.boxWidth / 2 + 1, this.getY() + 1, 14737632);
        }

        drawString(poseStack, this.mc.font, this.displayString, this.getX() + this.boxWidth + 2, this.getY() + 2, color);
    }

    public void mouseClick(double mouseX, double mouseY, int mouseButton) {
        this.playPressSound();
        if (this.isEnabled()) {
            this.setIsChecked(!this.isChecked());
            this.onChange();
        }

    }

    public void mouseRelease(double mouseX, double mouseY, int state) {
    }

    public boolean charTyped(char typedChar, int keyCode) {
        return false;
    }
}
