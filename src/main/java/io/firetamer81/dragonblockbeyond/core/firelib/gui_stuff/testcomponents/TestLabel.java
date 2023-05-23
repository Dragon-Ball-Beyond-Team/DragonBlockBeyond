package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.resources.language.I18n;

import java.util.Arrays;
import java.util.List;

public class TestLabel extends TestAdvancedScreenComponent {
    private final List<String> labels;
    private final int textColor;
    private boolean centered;
    private int backColor;
    private int ulColor;
    private int brColor;
    private int border;

    public TestLabel(int x, int y, int color) {
        super(x, y, 0, 0);
        this.labels = Lists.newArrayList();
        this.textColor = color;
        this.setX(x);
        this.setY(y);
        this.visible = true;
    }

    public TestLabel(int x, int y) {
        this(x, y, -1);
    }

    public TestLabel(String text, int x, int y) {
        this(x, y);
        this.addLine(text);
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partial) {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        int i = this.getY() + this.height / 2 + this.border / 2;
        int j = i - this.labels.size() * 10 / 2;

        for(int k = 0; k < this.labels.size(); ++k) {
            if (this.centered) {
                drawCenteredString(poseStack, this.renderer, (String)this.labels.get(k), this.getX(), j + k * 10, this.textColor);
            } else {
                drawString(poseStack, this.renderer, (String)this.labels.get(k), this.getX(), j + k * 10, this.textColor);
            }
        }

    }

    public void addLine(String p_175202_1_) {
        this.labels.add(I18n.get(p_175202_1_, new Object[0]));
    }

    public void setText(String text) {
        this.labels.clear();
        this.labels.addAll(Arrays.asList(text.split("\n")));
    }

    public void setCentered() {
        this.centered = true;
    }

    public void mouseClick(double mouseX, double mouseY, int mouseButton) {}

    public void mouseRelease(double mouseX, double mouseY, int state) {}

    public boolean charTyped(char typedChar, int keyCode) { return false; }
}
