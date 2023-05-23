package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.ScreenUtils;

import java.awt.*;

public class TestToggleButton extends TestButton {
    private boolean value;
    private TestToggleButton.DrawType drawType;
    private ResourceLocation offIcon;

    public TestToggleButton(int xPos, int yPos, String displayString) {
        this(xPos, yPos, 100, displayString);
    }

    public TestToggleButton(int xPos, int yPos, int width, String displayString) {
        this(xPos, yPos, width, 20, displayString);
    }

    public TestToggleButton(int xPos, int yPos, int width, String displayString, ResourceLocation icon) {
        this(xPos, yPos, width, 20, displayString, icon);
    }

    public TestToggleButton(int xPos, int yPos, int width, int height, String displayString) {
        this(xPos, yPos, width, height, displayString, (ResourceLocation)null);
    }

    public TestToggleButton(int xPos, int yPos, int width, int height, String displayString, ResourceLocation icon) {
        super(xPos, yPos, width, height, displayString, icon);
        this.value = false;
        this.drawType = TestToggleButton.DrawType.COLORED_LINE;
        this.offIcon = null;
    }

    public TestToggleButton(int xPos, int yPos, String string, ResourceLocation icon) {
        this(xPos, yPos, 100, string, icon);
    }

    public TestToggleButton(int xPos, int yPos, ResourceLocation onIcon, ResourceLocation offIcon) {
        this(xPos, yPos, 20, "", onIcon);
        this.offIcon = offIcon;
        this.drawType = TestToggleButton.DrawType.STRING_OR_ICON;
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partial) {
        int color = 14737632;
        this.isHovered = mouseX >= this.getX() && mouseY >= this.getY() && mouseX < this.getX() + this.width && mouseY < this.getY() + this.height;
        if (this.packedFGColor != 0) {
            color = this.packedFGColor;
        } else if (!this.enabled) {
            color = 10526880;
        } else if (this.hovered) {
            color = 16777120;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        int i = this.getYImage(this.isHoveredOrFocused());
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        this.blit(poseStack, this.getX(), this.getY(), 0, 46 + i * 20, this.width / 2, this.height);
        this.blit(poseStack, this.getX() + this.width / 2, this.getY(), 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
        this.renderBg(poseStack, this.mc, mouseX, mouseY);
        int j = this.getFGColor();
        int bx = this.getX();
        int mwidth = this.width;
        if (this.BUTTON_ICON != null) {
            RenderSystem.setShaderTexture(0, this.offIcon != null && (this.drawType == TestToggleButton.DrawType.STRING_OR_ICON || this.drawType == TestToggleButton.DrawType.BOTH) ? (this.value ? this.BUTTON_ICON : this.offIcon) : this.BUTTON_ICON);
            blit(poseStack, bx + 2, this.getY() + 2, 0.0F, 0.0F, 16, 16, 16, 16);
            bx += 18;
            mwidth -= 16;
        }

        String buttonText = this.displayString;
        int strWidth = this.mc.font.width(buttonText);
        int ellipsisWidth = this.mc.font.width("...");
        if (strWidth > mwidth - 6 && strWidth > ellipsisWidth) {
            String var10000 = this.mc.font.plainSubstrByWidth(buttonText, mwidth - 6 - ellipsisWidth);
            buttonText = var10000.trim() + "...";
        }

        drawCenteredString(poseStack, this.mc.font, buttonText + ((this.drawType == TestToggleButton.DrawType.STRING_OR_ICON || this.drawType == TestToggleButton.DrawType.BOTH) && this.offIcon == null ? (this.value ? "ON" : "OFF") : ""), bx + mwidth / 2, this.getY() + (this.height - 8) / 2, color);
        if (this.drawType == TestToggleButton.DrawType.COLORED_LINE || this.drawType == TestToggleButton.DrawType.BOTH) {
            int col = this.value ? Color.GREEN.getRGB() : Color.red.getRGB();
            RenderSystem.disableTexture();
            ScreenUtils.drawGradientRect(poseStack.last().pose(), this.getBlitOffset(), this.getX() + 6, this.getY() + this.height - 3, this.getX() + this.width - 6, this.getY() + this.height - 4, col, col);
        }

    }

    public void setDrawType(TestToggleButton.DrawType type) {
        this.drawType = type;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void mouseClick(double mouseX, double mouseY, int mouseButton) {
        if (this.visible && mouseX >= (double)this.getX() && mouseY >= (double)this.getY() && mouseX < (double)(this.getX() + this.width) && mouseY < (double)(this.getY() + this.height)) {
            this.playPressSound();
            this.value = !this.value;
            this.onClick();
        }

    }

    public static enum DrawType {
        COLORED_LINE,
        STRING_OR_ICON,
        BOTH;

        private DrawType() {
        }

        public String getName() {
            switch (this) {
                case COLORED_LINE:
                    return "Colored Line";
                case STRING_OR_ICON:
                    return "String or Icon";
                case BOTH:
                    return "All";
                default:
                    return this.name();
            }
        }
    }
}
