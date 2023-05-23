package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestEnumSlider extends TestSlider {
    private final Runnable action;
    private final Enum<?>[] enumValues;
    private Enum<?> enumValue;
    private int prevIndex;

    public <T extends Enum<T>> TestEnumSlider(int xPos, int yPos, String prefix, Class<T> enumClass, T currentVal, Runnable changeAction) {
        this(xPos, yPos, 150, 20, prefix, "", enumClass, currentVal, true, changeAction);
    }

    public <T extends Enum<T>> TestEnumSlider(int xPos, int yPos, int width, int height, String prefix, String suf, Class<T> enumClass, T currentVal, boolean drawStr) {
        this(xPos, yPos, width, height, prefix, suf, enumClass, currentVal, drawStr, (Runnable)null);
    }

    public <T extends Enum<T>> TestEnumSlider(int xPos, int yPos, int width, int height, String prefix, String suf, Class<T> enumClass, T currentVal, boolean drawStr, Runnable changeAction) {
        super(xPos, yPos, width, height, prefix, suf, -1.0, -1.0, -1.0, false, drawStr, (Runnable)null);
        this.action = changeAction;
        this.enumValue = currentVal;
        this.enumValues = (Enum[])enumClass.getEnumConstants();
        this.maxValue = (double)this.enumValues.length;
        this.showDecimal = false;
        this.minValue = 0.0;
        this.sliderValue = ((double)this.getCurrentIndex() - this.minValue) / (this.maxValue - this.minValue);
        this.prevIndex = this.getCurrentIndex();
        String val = "";
        Method[] var12 = this.enumValue.getClass().getMethods();
        int var13 = var12.length;

        for(int var14 = 0; var14 < var13; ++var14) {
            Method m = var12[var14];
            if (m.getName().equals("getName") && m.getParameterTypes().length == 0 && m.getReturnType() == String.class) {
                if (!m.isAccessible()) {
                    m.setAccessible(true);
                }

                try {
                    val = (String)m.invoke(this.enumValue);
                } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException var17) {
                    var17.printStackTrace();
                }
            }
        }

        String var10001 = this.dispString;
        this.displayString = var10001 + (val.isEmpty() ? this.enumValue.name() : val) + this.suffix;
        this.drawString = drawStr;
        if (!this.drawString) {
            this.displayString = "";
        }

    }

    public Enum<?> getEnum() {
        return this.enumValue;
    }

    public void setEnum(Enum<?> value) {
        this.enumValue = value;
        this.sliderValue = ((double)this.getCurrentIndex() - this.minValue) / (this.maxValue - this.minValue);
        this.prevIndex = this.getCurrentIndex();
    }

    public void updateSlider() {
        if (this.sliderValue < 0.0) {
            this.sliderValue = 0.0;
        }

        if (this.sliderValue > 1.0) {
            this.sliderValue = 1.0;
        }

        String val = this.enumValue.name();
        Method[] var2 = this.enumValue.getClass().getMethods();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Method m = var2[var4];
            if (m.getName().equals("getName") && m.getParameterTypes().length == 0 && m.getReturnType() == String.class) {
                if (!m.isAccessible()) {
                    m.setAccessible(true);
                }

                try {
                    val = (String)m.invoke(this.enumValue);
                } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException var7) {
                    var7.printStackTrace();
                }
            }
        }

        if (this.drawString) {
            this.displayString = this.dispString + val + this.suffix;
        }

        if (this.prevIndex != this.getCurrentIndex()) {
            this.onValueChanged();
        }

        this.prevIndex = this.getCurrentIndex();
    }

    public void onValueChanged() {
        if (this.action != null) {
            this.action.run();
        }

    }

    private int getCurrentIndex() {
        int out = 0;
        Enum[] var2 = this.enumValues;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Enum<?> e = var2[var4];
            if (e.name().equals(this.enumValue.name())) {
                return out;
            }

            ++out;
        }

        return -1;
    }

    public void mouseClick(double mouseX, double mouseY, int mouseButton) {
        this.playPressSound();
        if (this.isEnabled()) {
            this.updateSlider();
            this.dragging = true;
        }

    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partial) {
        if (this.dragging) {
            int index = this.getCurrentIndex();
            this.sliderValue = (double)((float)(mouseX - (this.getX() + 4)) / (float)(this.width - 8));
            int sliderValue = (int)Math.round(this.sliderValue * (this.maxValue - this.minValue) + this.minValue);
            if (sliderValue < 0) {
                sliderValue = 0;
            }

            if (index == -1) {
                this.enumValue = this.enumValues[0];
            } else if (sliderValue < this.enumValues.length) {
                this.enumValue = this.enumValues[sliderValue];
            }
        }

        GlStateManager._clearColor(1.0F, 1.0F, 1.0F, 1.0F);
        super.render(poseStack, mouseX, mouseY, partial);
    }
}
