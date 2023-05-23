package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._alphacomponents._TestScreenComponent;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._alphacomponents.FireLibTextInputField;
import io.firetamer81.dragonblockbeyond.core.firelib.util.BooleanConsumer;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(value= Dist.CLIENT)
public abstract class AdvancedScreenBase extends Screen {
    private final List<_TestScreenComponent> components = new ArrayList<_TestScreenComponent>();
    private final int nextComponentID = 0;
    private int currentPage = 0;
    private Screen parentGui;
    private boolean unloadOnClose = true;
    private BooleanConsumer confirmCallback;

    public AdvancedScreenBase(/*Screen parentGui*/) {
        super(Component.literal("An GUI"));

        if (isTopLevelGui()) {
            this.parentGui = Minecraft.getInstance().screen;
        }

        this.buildGui();
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    //<editor-fold desc="Abstract Methods">

    /**
     * <pre>
     *     This is the method where you build GUI components (determining dimensions, which page they belong too, etc.)
     *
     *     You will not define the position of elements in the method as one of the major purposes of this GUI system is to provide relative positions and sized components of GUIs in a streamlined way.
     *
     *     Setting Dimensions for a component should be done in this method relative to another component through parenting.
     * </pre>
     */
    public abstract void buildGui();

    /**
     * <pre>
     *     This is the method that should be used for positioning, as that changes based on the window size.
     *
     *     When the
     * </pre>
     */
    public abstract void updateGui();

    public abstract boolean isTopLevelGui();

    public abstract boolean doesGuiPauseGame();

    public abstract boolean doesEscCloseGui();
    //</editor-fold>

    public boolean isPauseScreen() {
        return this.doesGuiPauseGame();
    }

    public void nextPage() {
        if (this.currentPage < Integer.MAX_VALUE) {
            ++this.currentPage;
        }
    }

    public void prevPage() {
        if (this.currentPage > 0) {
            --this.currentPage;
        }
    }

    public void setPage(int page) {
        if (page < Integer.MAX_VALUE) {
            this.currentPage = page;
        }
    }

    public final void addComponent(_TestScreenComponent component) {
        this.components.add(component);
    }

    public final void addComponent(_TestScreenComponent component, int page) {
        this.components.add(component);
        component.assignToPage(page);
    }

    public final void addAllComponents(_TestScreenComponent... components) {
        for (_TestScreenComponent c : components) {
            this.addComponent(c);
        }
    }

    public void assignComponentToPage(_TestScreenComponent comp, int page) {
        comp.assignToPage(page);
    }

    public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
        for (_TestScreenComponent comp : this.components) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage || !comp.isVisible() || !(mouseX >= (double)comp.getX()) || !(mouseY >= (double)comp.getY()) || !(mouseX < (double)(comp.getX() + comp.getWidth())) || !(mouseY < (double)(comp.getY() + comp.getHeight()))) continue;
            comp.mouseScrolled(mouseX, mouseY, scroll);
        }
        return true;
    }

    public boolean mouseDragged(double mouseX, double mouseY, int mouseButton, double deltaX, double deltaY) {
        for (_TestScreenComponent comp : this.components) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage || !comp.isVisible()) continue;
            comp.mouseDragged(mouseX, mouseY, mouseButton, deltaX, deltaY);
        }
        return false;
    }

    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        for (_TestScreenComponent comp : this.components) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) continue;
            comp.keyReleased(keyCode, scanCode, modifiers);
        }
        return false;
    }

    public Screen getParentGui() {
        return this.parentGui;
    }

    public void setParentGui(Screen parentGui) {
        this.parentGui = parentGui;
    }

    public final void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.updateGui();
        this.renderBackground(poseStack);

        for (_TestScreenComponent comp : this.components) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage || !comp.isVisible()) continue;
            comp.render(poseStack, mouseX, mouseY, partialTicks);
        }

        for (_TestScreenComponent comp : Lists.reverse(this.components)) {
            if (!comp.isVisible() || comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage || !comp.canHaveTooltip() || !this.isHovered(comp, mouseX, mouseY)) continue;

            MutableComponent txt = Component.literal((String)"");

            if (comp.getTooltips() != null) {
                for (int i = 0; i < comp.getTooltips().length; ++i) {
                    txt.append((Component)Component.literal((String)(comp.getTooltips()[i] + (i == comp.getTooltips().length - 1 ? "" : "\n"))));
                }
            }

            if (txt.getSiblings().isEmpty()) continue;
            this.renderTooltip(poseStack, this.minecraft.font.split((FormattedText)txt, Math.max(this.width / 2, 220)), mouseX, mouseY);
            break;
        }
    }

    protected boolean forceDirtBackground() {
        return false;
    }

    protected ResourceLocation getBackground() {
        return BACKGROUND_LOCATION;
    }

    private boolean isHovered(_TestScreenComponent comp, int mouseX, int mouseY) {
        if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) {
            return false;
        }
        int x = comp.getX();
        int y = comp.getY();
        int w = comp.getWidth();
        int h = comp.getHeight();
        return mouseX >= x && mouseY >= y && mouseX < x + w && mouseY < y + h;
    }

    public final _TestScreenComponent getComponent(int index) {
        return this.components.get(index);
    }

    public final void openGui(Screen gui) {
        this.minecraft.setScreen(gui);
    }

    public void close() {
        this.openGui(this.parentGui);
    }

    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        for (_TestScreenComponent comp : this.components) {
            if (comp.getAssignedPage() != -1
                    && comp.getAssignedPage() != this.currentPage ||
                    !comp.clicked(mouseX, mouseY) && !(comp instanceof FireLibTextInputField)) {
                continue;
            }

            comp.mouseClicked(mouseX, mouseY, mouseButton);
        }
        return true;
    }

    public boolean charTyped(char character, int keyCode) {
        for (_TestScreenComponent comp : this.components) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) continue;
            comp.charTyped(character, keyCode);
        }
        return true;
    }

    public boolean mouseReleased(double mouseX, double mouseY, int mouseButton) {
        for (_TestScreenComponent comp : this.components) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) continue;
            comp.mouseRelease(mouseX, mouseY, mouseButton);
        }
        return true;
    }

    public boolean keyPressed(int keyCode, int p_keyPressed_2_, int p_keyPressed_3_) {
        if (keyCode == 256 && this.doesEscCloseGui()) {
            this.minecraft.setScreen((Screen)null);
            if (this.minecraft.screen == null) {
                this.minecraft.setWindowActive(true);
            }
        }
        for (_TestScreenComponent comp : this.components) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) continue;
            comp.keyPressed(keyCode, p_keyPressed_2_, p_keyPressed_3_);
        }
        return true;
    }

    public void renderBackground(PoseStack poseStack) {
        if (this.minecraft.level != null && !this.forceDirtBackground()) {
            this.fillGradient(poseStack, 0, 0, this.width, this.height, -1072689136, -804253680);
        } else {
            Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder bufferbuilder = tesselator.getBuilder();
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            RenderSystem.setShaderTexture((int)0, (ResourceLocation)BACKGROUND_LOCATION);
            RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            float f = 32.0f;
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferbuilder.vertex(0.0, (double)this.height, 0.0).uv(0.0f, (float)this.height / 32.0f + 0.0f).color(64, 64, 64, 255).endVertex();
            bufferbuilder.vertex((double)this.width, (double)this.height, 0.0).uv((float)this.width / 32.0f, (float)this.height / 32.0f + 0.0f).color(64, 64, 64, 255).endVertex();
            bufferbuilder.vertex((double)this.width, 0.0, 0.0).uv((float)this.width / 32.0f, 0.0f).color(64, 64, 64, 255).endVertex();
            bufferbuilder.vertex(0.0, 0.0, 0.0).uv(0.0f, 0.0f).color(64, 64, 64, 255).endVertex();
            tesselator.end();
            MinecraftForge.EVENT_BUS.post((Event)new ScreenEvent.BackgroundRendered((Screen)this, poseStack));
        }
    }

    public boolean handleComponentClicked(Style style) {
        return super.handleComponentClicked(style);
    }

    public void onClose() {
        if (this.unloadOnClose) {
            for (_TestScreenComponent comp : this.components) {
                comp.unload();
            }
        }
    }

    private void confirmed(boolean confirmed) {
        this.confirmCallback.accept(confirmed);
        this.openGui(this);
        this.confirmCallback = null;
        this.unloadOnClose = true;
    }

    public final void openURL(String URL) {
        this.confirmCallback = b -> this.runUrl(b, URL);
        this.unloadOnClose = false;
        ConfirmLinkScreen s = new ConfirmLinkScreen(this::confirmed, URL, true);
        this.openGui((Screen)s);
    }

    private void runUrl(boolean bool, String URL) {
        if (bool) {
            Util.getPlatform().openUri(URL);
        }
    }

    public final void openYesNo(String title, String text, BooleanConsumer callback) {
        this.confirmCallback = callback;
        this.unloadOnClose = false;
        ConfirmScreen s = new ConfirmScreen(this::confirmed, (Component)Component.literal((String)title), (Component)Component.literal((String)text));
        this.openGui((Screen)s);
    }

    public final void openConfirmation(String title, String text, String trueButton, String falseButton, BooleanConsumer callback) {
        this.confirmCallback = callback;
        this.unloadOnClose = false;
        ConfirmScreen s = new ConfirmScreen(this::confirmed, (Component)Component.literal((String)title), (Component)Component.literal((String)text), (Component)Component.literal((String)trueButton), (Component)Component.literal((String)falseButton));
        this.openGui((Screen)s);
    }
}
