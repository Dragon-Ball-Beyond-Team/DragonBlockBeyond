package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.ScreenUtils;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class TestScrollPanel extends TestAdvancedScreenComponent {
    protected final int border = 4;
    private final int barWidth = 6;
    private final ArrayList<TestAdvancedScreenComponent> components = new ArrayList();
    protected int top;
    protected int bottom;
    protected int right;
    protected int left;
    protected float scrollDistance;
    protected boolean captureMouse = true;
    private ResourceLocation BACKGROUND_LOCATION = new ResourceLocation("minecraft", "textures/gui/options_background.png");
    private int barLeft;
    private boolean scrolling;
    private int contentHeight;
    private final ArrayList<String> tooltips = new ArrayList();

    public TestScrollPanel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.contentHeight = height;
        this.recalc();
    }

    private void recalc() {
        this.top = this.getY();
        this.left = this.getX();
        this.bottom = this.height + this.top;
        this.right = this.width + this.left;
        this.barLeft = this.left + this.getWidth() - 6;
    }

    public void setX(int x) {
        super.setX(x);
        this.recalc();
    }

    public void setY(int y) {
        super.setY(y);
        this.recalc();
    }

    public void setBackgroundTexture(ResourceLocation bg) {
        this.BACKGROUND_LOCATION = bg;
    }

    public void unload() {
        Iterator var1 = this.components.iterator();

        while(var1.hasNext()) {
            TestAdvancedScreenComponent c = (TestAdvancedScreenComponent)var1.next();
            c.unload();
        }

    }

    public void setWidth(int width) {
        super.setWidth(width);
        this.recalc();
    }

    public void setHeight(int height) {
        super.setHeight(height);
        this.recalc();
    }

    protected int getContentHeight() {
        return this.contentHeight;
    }

    public void setContentHeight(int contentHeight) {
        this.contentHeight = contentHeight;
        this.recalc();
    }

    public final void addComponent(TestAdvancedScreenComponent component) {
        this.components.add(component);
    }

    protected void drawBackground() {
    }

    private int getMaxScroll() {
        int var10000 = this.getContentHeight();
        int var10001 = this.height;
        Objects.requireNonNull(this);
        return var10000 - (var10001 - 4);
    }

    private void applyScrollLimits() {
        int max = this.getMaxScroll();
        if (max < 0) {
            max /= 2;
        }

        if (this.scrollDistance < 0.0F) {
            this.scrollDistance = 0.0F;
        }

        if (this.scrollDistance > (float)max) {
            this.scrollDistance = (float)max;
        }

    }

    public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
        if (scroll != 0.0) {
            this.scrollDistance = (float)((double)this.scrollDistance + -scroll * (double)this.getScrollAmount());
            this.applyScrollLimits();
            return true;
        } else {
            return false;
        }
    }

    protected int getScrollAmount() {
        return 20;
    }

    protected void drawPanel(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        Iterator var5 = this.components.iterator();

        while(var5.hasNext()) {
            TestAdvancedScreenComponent c = (TestAdvancedScreenComponent)var5.next();
            c.scrollOffsetY = this.getY() - (int)this.scrollDistance;
            c.scrollOffsetX = this.getX();
            if (c.isVisible()) {
                c.render(poseStack, mouseX, mouseY, partialTicks);
            }
        }

    }

    public void fitContent() {
        Iterator var1 = this.components.iterator();

        while(var1.hasNext()) {
            TestAdvancedScreenComponent c = (TestAdvancedScreenComponent)var1.next();
            if (c.getY() - c.scrollOffsetY + c.getComponentHeight() + 10 > this.contentHeight) {
                this.contentHeight = c.getY() - c.scrollOffsetY + c.getComponentHeight() + 10;
            }
        }

    }

    public boolean canHaveTooltip() {
        return true;
    }

    public void mouseRelease(double mouseX, double mouseY, int state) {
        this.scrolling = false;
        if (mouseX >= (double)this.left && mouseX <= (double)this.right) {
            Iterator var6 = this.components.iterator();

            while(var6.hasNext()) {
                TestAdvancedScreenComponent comp = (TestAdvancedScreenComponent)var6.next();
                if (comp.isVisible()) {
                    comp.mouseReleased(mouseX, mouseY, state);
                }
            }
        }

    }

    public final void addAllComponents(TestAdvancedScreenComponent... components) {
        TestAdvancedScreenComponent[] var2 = components;
        int var3 = components.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            TestAdvancedScreenComponent c = var2[var4];
            this.addComponent(c);
        }

    }

    public boolean charTyped(char typedChar, int keyCode) {
        if (this.isEnabled()) {
            Iterator var3 = this.components.iterator();

            while(var3.hasNext()) {
                TestAdvancedScreenComponent comp = (TestAdvancedScreenComponent)var3.next();
                comp.charTyped(typedChar, keyCode);
            }
        }

        return true;
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.isEnabled()) {
            Iterator var4 = this.components.iterator();

            while(var4.hasNext()) {
                TestAdvancedScreenComponent comp = (TestAdvancedScreenComponent)var4.next();
                comp.keyPressed(keyCode, scanCode, modifiers);
            }
        }

        return true;
    }

    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        Iterator var4 = this.components.iterator();

        while(var4.hasNext()) {
            TestAdvancedScreenComponent comp = (TestAdvancedScreenComponent)var4.next();
            comp.keyReleased(keyCode, scanCode, modifiers);
        }

        return true;
    }

    private boolean isMouseInComponent(double mouseX, double mouseY, TestAdvancedScreenComponent comp) {
        return mouseX >= (double)comp.getX() && mouseY >= (double)comp.getY() && mouseX < (double)(comp.getX() + comp.getWidth()) && mouseY < (double)(comp.getY() + comp.getComponentHeight());
    }

    private int getBarHeight() {
        int barHeight = this.height * this.height / this.getContentHeight();
        if (barHeight < 32) {
            barHeight = 32;
        }

        if (barHeight > this.height - 8) {
            barHeight = this.height - 8;
        }

        return barHeight;
    }

    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.isEnabled() && this.scrolling) {
            int maxScroll = this.height - this.getBarHeight();
            double moved = deltaY / (double)maxScroll;
            this.scrollDistance = (float)((double)this.scrollDistance + (double)this.getMaxScroll() * moved);
            this.applyScrollLimits();
            return true;
        } else {
            return false;
        }
    }

    protected ResourceLocation getBackground() {
        return this.BACKGROUND_LOCATION;
    }

    public final void mouseClick(double mouseX, double mouseY, int mouseButton) {
        if (this.isEnabled()) {
            this.scrolling = mouseButton == 0 && mouseX >= (double)this.barLeft && mouseX < (double)(this.barLeft + 6);
            if (this.scrolling) {
                return;
            }

            if (mouseX >= (double)this.left && mouseX <= (double)this.right) {
                Iterator var6 = this.components.iterator();

                while(true) {
                    TestAdvancedScreenComponent comp;
                    do {
                        if (!var6.hasNext()) {
                            return;
                        }

                        comp = (TestAdvancedScreenComponent)var6.next();
                    } while((!comp.isVisible() || !this.isMouseInComponent(mouseX, mouseY, comp)) && !(comp instanceof TestTextField));

                    comp.mouseClicked(mouseX, mouseY, mouseButton);
                }
            }
        }

    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.drawBackground();
        Tesselator tess = Tesselator.getInstance();
        BufferBuilder worldr = tess.getBuilder();
        double scale = this.mc.getWindow().getGuiScale();
        GL11.glEnable(3089);
        GL11.glScissor((int)((double)this.left * scale), (int)((double)this.mc.getWindow().getHeight() - (double)this.bottom * scale), (int)((double)this.width * scale), (int)((double)this.height * scale));
        if (this.mc.level != null) {
            this.drawGradientRect(poseStack, this.left, this.top, this.right, this.bottom, -1072689136, -804253680);
        } else {
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            RenderSystem.setShaderTexture(0, this.getBackground());
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            float texScale = 32.0F;
            worldr.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            worldr.vertex((double)this.left, (double)this.bottom, 0.0).uv((float)this.left / 32.0F, (float)(this.bottom + (int)this.scrollDistance) / 32.0F).color(32, 32, 32, 255).endVertex();
            worldr.vertex((double)this.right, (double)this.bottom, 0.0).uv((float)this.right / 32.0F, (float)(this.bottom + (int)this.scrollDistance) / 32.0F).color(32, 32, 32, 255).endVertex();
            worldr.vertex((double)this.right, (double)this.top, 0.0).uv((float)this.right / 32.0F, (float)(this.top + (int)this.scrollDistance) / 32.0F).color(32, 32, 32, 255).endVertex();
            worldr.vertex((double)this.left, (double)this.top, 0.0).uv((float)this.left / 32.0F, (float)(this.top + (int)this.scrollDistance) / 32.0F).color(32, 32, 32, 255).endVertex();
            tess.end();
        }

        this.drawPanel(poseStack, mouseX, mouseY, partialTicks);
        RenderSystem.disableDepthTest();
        int extraHeight = this.getContentHeight() + 4 - this.height;
        if (extraHeight > 0) {
            int barHeight = this.getBarHeight();
            int barTop = (int)this.scrollDistance * (this.height - barHeight) / extraHeight + this.top;
            if (barTop < this.top) {
                barTop = this.top;
            }

            RenderSystem.disableTexture();
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
            worldr.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
            worldr.vertex((double)this.barLeft, (double)this.bottom, 0.0).uv(0.0F, 1.0F).color(0, 0, 0, 255).endVertex();
            worldr.vertex((double)(this.barLeft + 6), (double)this.bottom, 0.0).uv(1.0F, 1.0F).color(0, 0, 0, 255).endVertex();
            worldr.vertex((double)(this.barLeft + 6), (double)this.top, 0.0).uv(1.0F, 0.0F).color(0, 0, 0, 255).endVertex();
            worldr.vertex((double)this.barLeft, (double)this.top, 0.0).uv(0.0F, 0.0F).color(0, 0, 0, 255).endVertex();
            worldr.vertex((double)this.barLeft, (double)(barTop + barHeight), 0.0).uv(0.0F, 1.0F).color(128, 128, 128, 255).endVertex();
            worldr.vertex((double)(this.barLeft + 6), (double)(barTop + barHeight), 0.0).uv(1.0F, 1.0F).color(128, 128, 128, 255).endVertex();
            worldr.vertex((double)(this.barLeft + 6), (double)barTop, 0.0).uv(1.0F, 0.0F).color(128, 128, 128, 255).endVertex();
            worldr.vertex((double)this.barLeft, (double)barTop, 0.0).uv(0.0F, 0.0F).color(128, 128, 128, 255).endVertex();
            worldr.vertex((double)this.barLeft, (double)(barTop + barHeight - 1), 0.0).uv(0.0F, 1.0F).color(192, 192, 192, 255).endVertex();
            worldr.vertex((double)(this.barLeft + 6 - 1), (double)(barTop + barHeight - 1), 0.0).uv(1.0F, 1.0F).color(192, 192, 192, 255).endVertex();
            worldr.vertex((double)(this.barLeft + 6 - 1), (double)barTop, 0.0).uv(1.0F, 0.0F).color(192, 192, 192, 255).endVertex();
            worldr.vertex((double)this.barLeft, (double)barTop, 0.0).uv(0.0F, 0.0F).color(192, 192, 192, 255).endVertex();
            tess.end();
        }

        RenderSystem.enableTexture();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        GL11.glDisable(3089);
        Iterator var13 = Lists.reverse(this.components).iterator();

        while(var13.hasNext()) {
            TestAdvancedScreenComponent comp = (TestAdvancedScreenComponent)var13.next();
            this.tooltips.clear();
            if (comp.isVisible() && comp.canHaveTooltip() && this.isMouseInComponent((double)mouseX, (double)mouseY, comp) && comp.getTooltips() != null) {
                this.tooltips.addAll(Arrays.asList(comp.getTooltips()));
                break;
            }
        }

    }

    public String[] getTooltips() {
        return (String[])this.tooltips.toArray(new String[0]);
    }

    protected void drawGradientRect(PoseStack poseStack, int left, int top, int right, int bottom, int color1, int color2) {
        ScreenUtils.drawGradientRect(poseStack.last().pose(), 0, left, top, right, bottom, color1, color2);
    }
}
