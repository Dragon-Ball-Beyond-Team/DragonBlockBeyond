package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.BossEvent;

public class TestProgressBar extends TestAdvancedScreenComponent {
    private static final ResourceLocation GUI_BARS_TEXTURES = new ResourceLocation("textures/gui/bars.png");
    private boolean showPercentText = true;
    private String text = "";
    private BossEvent.BossBarColor color;
    private int maxValue;
    private int value;
    private int precision;

    public TestProgressBar(int x, int y, int widthIn) {
        super(x, y, widthIn, 15);
        this.color = BossEvent.BossBarColor.BLUE;
        this.maxValue = 100;
        this.value = 0;
        this.precision = 1;
    }

    public void setMaxValue(int maxValue) {
        if (maxValue <= 0) {
            throw new IllegalArgumentException("Max value can not be smaller than 1");
        } else {
            this.maxValue = maxValue;
            if (this.value > maxValue) {
                this.value = maxValue;
            }

        }
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(BossEvent.BossBarColor color) {
        this.color = color;
    }

    public void setShowPercentText(boolean showPercentText) {
        this.showPercentText = showPercentText;
    }

    public void setHeight(int height) {
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partial) {
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.setShaderTexture(0, GUI_BARS_TEXTURES);
        int progress = (int)(this.getPercent() * (float)this.getWidth());

        for(int w = 0; w <= this.getWidth(); ++w) {
            if (w == 0) {
                this.blit(poseStack, this.getX(), this.getY() + 10, 0, this.color.ordinal() * 5 * 2, 1, 5);
                if (progress > 0) {
                    this.blit(poseStack, this.getX(), this.getY() + 10, 0, this.color.ordinal() * 5 * 2 + 5, 1, 5);
                }
            } else if (w == this.getWidth()) {
                this.blit(poseStack, this.getX() + w, this.getY() + 10, 182, this.color.ordinal() * 5 * 2, 1, 5);
                if ((float)progress == 1.0F) {
                    this.blit(poseStack, this.getX() + w, this.getY() + 10, 182, this.color.ordinal() * 5 * 2 + 5, 1, 5);
                }
            } else {
                this.blit(poseStack, this.getX() + w, this.getY() + 10, 5, this.color.ordinal() * 5 * 2, 1, 5);
                if (progress >= w) {
                    this.blit(poseStack, this.getX() + w, this.getY() + 10, 5, this.color.ordinal() * 5 * 2 + 5, 1, 5);
                }
            }
        }

        String val = String.valueOf(this.getPercent() * 100.0F);
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

        String var10000 = this.text;
        String s = var10000 + (this.showPercentText ? " " + val + "%" : "");
        int l = this.mc.font.width(s);
        this.mc.font.drawShadow(poseStack, s, (float)(this.getX() + (this.getWidth() / 2 - l / 2)), (float)this.getY(), 16777215);
    }

    private float getPercent() {
        return (float)this.value / (float)this.maxValue;
    }

    public void mouseClick(double mouseX, double mouseY, int mouseButton) {
    }

    public void mouseRelease(double mouseX, double mouseY, int state) {
    }

    public boolean charTyped(char typedChar, int keyCode) {
        return false;
    }

    public void increment(int value) {
        this.value = Math.min(this.maxValue, this.value + value);
    }

    public void decrement(int value) {
        this.value = Math.max(0, this.value - value);
    }

    public double getValue() {
        return (double)this.value;
    }

    public void setValue(int value) {
        this.value = Math.min(value, this.maxValue);
    }
}
