package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;

public class TestSlider extends TestAdvancedScreenComponent {
    protected final String dispString;
    protected final String suffix;
    protected final int precision;
    protected Runnable action;
    protected double prevValue;
    protected double minValue;
    protected double maxValue;
    protected double sliderValue;
    protected boolean showDecimal;
    protected String displayString;
    protected boolean drawString;
    protected boolean dragging;

    public TestSlider(int xPos, int yPos, String prefix, double minVal, double maxVal, double currentVal, Runnable changeAction) {
        this(xPos, yPos, 150, 20, prefix, "", minVal, maxVal, currentVal, true, true, changeAction);
    }

    public TestSlider(int xPos, int yPos, int width, int height, String prefix, String suf, double minVal, double maxVal, double currentVal, boolean showDec, boolean drawStr) {
        this(xPos, yPos, width, height, prefix, suf, minVal, maxVal, currentVal, showDec, drawStr, (Runnable)null);
    }

    public TestSlider(int xPos, int yPos, int width, int height, String prefix, String suf, double minVal, double maxVal, double currentVal, boolean showDec, boolean drawStr, Runnable changeAction) {
        super(xPos, yPos, width, height);
        this.dragging = false;
        this.action = changeAction;
        this.minValue = minVal;
        this.maxValue = maxVal;
        this.sliderValue = this.prevValue = (currentVal - this.minValue) / (this.maxValue - this.minValue);
        this.dispString = prefix;
        this.suffix = suf;
        this.showDecimal = showDec;
        String val;
        if (this.showDecimal) {
            val = Double.toString(this.sliderValue * (this.maxValue - this.minValue) + this.minValue);
            this.precision = Math.min(val.substring(val.indexOf(".") + 1).length(), 4);
        } else {
            val = Integer.toString((int)Math.round(this.sliderValue * (this.maxValue - this.minValue) + this.minValue));
            this.precision = 0;
        }

        this.displayString = this.dispString + val + this.suffix;
        this.drawString = drawStr;
        if (!this.drawString) {
            this.displayString = "";
        }

    }

    public void setAction(Runnable action) {
        this.action = action;
    }

    public void setShowDecimal(boolean showDecimal) {
        this.showDecimal = showDecimal;
    }

    public void updateSlider() {
        if (this.sliderValue < 0.0) {
            this.sliderValue = 0.0;
        }

        if (this.sliderValue > 1.0) {
            this.sliderValue = 1.0;
        }

        String val;
        if (this.showDecimal) {
            val = Double.toString(this.sliderValue * (this.maxValue - this.minValue) + this.minValue);
            if (val.substring(val.indexOf(".") + 1).length() > this.precision) {
                val = val.substring(0, val.indexOf(".") + this.precision + 1);
                if (val.endsWith(".")) {
                    val = val.substring(0, val.indexOf(".") + this.precision);
                }
            } else {
                while(val.substring(val.indexOf(".") + 1).length() < this.precision) {
                    val = val + "0";
                }
            }
        } else {
            val = Integer.toString((int)Math.round(this.sliderValue * (this.maxValue - this.minValue) + this.minValue));
        }

        if (this.drawString) {
            this.displayString = this.dispString + val + this.suffix;
            this.setMessage(Component.literal(this.displayString));
        }

        if (this.prevValue != this.getValue()) {
            this.onValueChanged();
        }

        this.prevValue = this.getValue();
    }

    public int getValueInt() {
        return (int)Math.round(this.sliderValue * (this.maxValue - this.minValue) + this.minValue);
    }

    public double getValue() {
        return this.sliderValue * (this.maxValue - this.minValue) + this.minValue;
    }

    public void setValue(double d) {
        this.sliderValue = (d - this.minValue) / (this.maxValue - this.minValue);
        this.updateSlider();
    }

    public void onValueChanged() {
        if (this.action != null) {
            this.action.run();
        }

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
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        this.blit(poseStack, this.getX(), this.getY(), 0, 46, this.width / 2, this.height);
        this.blit(poseStack, this.getX() + this.width / 2, this.getY(), 200 - this.width / 2, 46, this.width / 2, this.height);
        if (this.dragging) {
            this.sliderValue = (double)((float)(mouseX - (this.getX() + 4)) / (float)(this.width - 8));
            this.updateSlider();
        }

        int bx;
        if (this.isEnabled()) {
            bx = (this.isHoveredOrFocused() ? 2 : 1) * 20;
            this.blit(poseStack, this.getX() + (int)(this.sliderValue * (double)(this.width - 8)), this.getY(), 0, 46 + bx, 4, 20);
            this.blit(poseStack, this.getX() + (int)(this.sliderValue * (double)(this.width - 8)) + 4, this.getY(), 196, 46 + bx, 4, 20);
        }

        bx = this.getX();
        int mwidth = this.width;
        String buttonText = this.displayString;
        int strWidth = this.mc.font.width(buttonText);
        int ellipsisWidth = this.mc.font.width("...");
        if (strWidth > mwidth - 6 && strWidth > ellipsisWidth) {
            String var10000 = this.mc.font.plainSubstrByWidth(buttonText, mwidth - 6 - ellipsisWidth);
            buttonText = var10000.trim() + "...";
        }

        drawCenteredString(poseStack, this.mc.font, buttonText, bx + mwidth / 2, this.getY() + (this.height - 8) / 2, color);
    }

    public void mouseClick(double mouseX, double mouseY, int mouseButton) {
        this.playPressSound();
        if (this.isEnabled()) {
            this.sliderValue = (mouseX - (double)(this.getX() + 4)) / (double)(this.width - 8);
            this.updateSlider();
            this.dragging = true;
        }

    }

    public void mouseRelease(double mouseX, double mouseY, int state) {
        this.dragging = false;
    }

    public boolean charTyped(char typedChar, int keyCode) {
        return false;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
        if (this.sliderValue > maxValue) {
            this.sliderValue = maxValue;
        }

        this.updateSlider();
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
        if (this.sliderValue < minValue) {
            this.sliderValue = minValue;
        }

        this.updateSlider();
    }
}
