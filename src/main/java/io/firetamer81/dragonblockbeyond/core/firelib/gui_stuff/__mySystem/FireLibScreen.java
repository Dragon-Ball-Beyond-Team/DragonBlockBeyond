package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.__mySystem;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._alphacomponents.FireLibTextInputField;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._alphacomponents._TestScreenComponent;
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
public abstract class FireLibScreen extends Screen {
    private final List<FireLibGUIComponent> componentList = new ArrayList<>();
    private final int nextComponentID = 0;
    private int currentPage = 0;
    private Screen parentGui;
    private BooleanConsumer confirmCallback;
    private boolean shouldUnloadOnClose = true;

    public FireLibScreen() {
        super(Component.empty());

        this.parentGui = Minecraft.getInstance().screen;

        this.buildGui();
    }

    public FireLibScreen(Screen parentScreenIn) {
        super(Component.empty());

        this.parentGui = parentScreenIn;

        this.buildGui();
    }

    //<editor-fold desc="Abstract Methods">
        //<editor-fold desc="Screen Behaviour Abstract Methods">
        public abstract boolean doesGuiPauseGame();

        public abstract boolean doesEscCloseGui();

        public abstract boolean shouldDrawDirtBackground();
        //</editor-fold>

        //<editor-fold desc="Build & Update Methods">
        /**
         * <pre> This Method should contain variable definitions of GUI Components that set colors, content, dimensions, etc.
         *
         *Dimensions can be set relative to another component as well, such as being 60% the width of a given component.
         *
         *If a component has children such as a scrollable panel, set the children here as well.</pre>
         */
        public abstract void buildGui();

        /**
         * <pre> This is where you should set component positions as positions are relative to the size of the component and Minecraft's main screen
         *
         *In other words, it's a value that updates very regularly.
         *
         *So, position setting methods will not be in a components builder class, only outside of it.</pre>
         */
        public abstract void updateGui();
        //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Screen Control Methods">
    public int getCurrentPage() { return this.currentPage; }

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

    public final void openGui(Screen gui) {
        this.minecraft.setScreen(gui);
    }

    public void closeThisGUI() {
        this.openGui(this.parentGui);
    }
    //</editor-fold>

    //<editor-fold desc="Component List Methods">
    public final FireLibGUIComponent getComponent(int index) { return this.componentList.get(index); }

    public final void addComponent(FireLibGUIComponent component) { this.componentList.add(component); }

    public final void addComponent(FireLibGUIComponent component, int page) {
        this.componentList.add(component);
        component.assignToPage(page);
    }

    public final void addAllComponents(FireLibGUIComponent... components) {
        for (FireLibGUIComponent c : components) {
            this.addComponent(c);
        }
    }

    public void assignComponentToPage(FireLibGUIComponent comp, int page) { comp.assignToPage(page); }
    //</editor-fold>

    //<editor-fold desc="Mouse/Key Tracking & Actions">
    public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
        for (FireLibGUIComponent comp : this.componentList) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage ||
                    !comp.isVisible() ||
                    !(mouseX >= (double)comp.getX()) ||
                    !(mouseY >= (double)comp.getY()) ||
                    !(mouseX < (double)(comp.getX() + comp.getWidth())) ||
                    !(mouseY < (double)(comp.getY() + comp.getHeight()))
            ) continue;

            comp.mouseScrolled(mouseX, mouseY, scroll);
        }

        return true;
    }

    public boolean mouseDragged(double mouseX, double mouseY, int mouseButton, double deltaX, double deltaY) {
        for (FireLibGUIComponent comp : this.componentList) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage
                    || !comp.isVisible()
            ) continue;

            comp.mouseDragged(mouseX, mouseY, mouseButton, deltaX, deltaY);
        }

        return false;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        for (FireLibGUIComponent comp : this.componentList) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage ||
                    !comp.clicked(mouseX, mouseY) && !(comp instanceof FireLibTextInputField)
            ) continue;

            comp.mouseClicked(mouseX, mouseY, mouseButton);
        }

        return true;
    }

    public boolean mouseReleased(double mouseX, double mouseY, int mouseButton) {
        for (FireLibGUIComponent comp : this.componentList) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) continue;

            comp.mouseRelease(mouseX, mouseY, mouseButton);
        }

        return true;
    }

    public boolean charTyped(char character, int keyCode) {
        for (FireLibGUIComponent comp : this.componentList) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) continue;

            comp.charTyped(character, keyCode);
        }

        return true;
    }

    public boolean keyPressed(int keyCode, int p_keyPressed_2_, int p_keyPressed_3_) {
        if (keyCode == 256 && this.doesEscCloseGui()) {
            this.minecraft.setScreen(null);

            if (this.minecraft.screen == null) {
                this.minecraft.setWindowActive(true);
            }
        }

        for (FireLibGUIComponent comp : this.componentList) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) continue;

            comp.keyPressed(keyCode, p_keyPressed_2_, p_keyPressed_3_);
        }

        return true;
    }

    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        for (FireLibGUIComponent comp : this.componentList) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) continue;

            comp.keyReleased(keyCode, scanCode, modifiers);
        }

        return false;
    }
    //</editor-fold>

    //<editor-fold desc="Rendering Methods">
    public final void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.updateGui();
        this.renderBackground(poseStack);

        for (FireLibGUIComponent comp : this.componentList) {
            if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage
                    || !comp.isVisible()
            ) continue;

            comp.render(poseStack, mouseX, mouseY, partialTicks);
        }

        for (FireLibGUIComponent comp : Lists.reverse(this.componentList)) {
            if (!comp.isVisible() || comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage ||
                    !comp.canHaveTooltip() || !this.isHovered(comp, mouseX, mouseY)
            ) continue;

            MutableComponent txt = Component.literal("");

            if (comp.getTooltips() != null) {
                for (int i = 0; i < comp.getTooltips().length; ++i) {
                    txt.append(Component.literal(comp.getTooltips()[i] + (i == comp.getTooltips().length - 1 ? "" : "\n")));
                }
            }

            if (txt.getSiblings().isEmpty()) continue;

            this.renderTooltip(poseStack, this.minecraft.font.split((FormattedText)txt, Math.max(this.width / 2, 220)), mouseX, mouseY);

            break;
        }
    }

    public void renderBackground(PoseStack poseStack) {
        if (this.minecraft.level != null && !shouldDrawDirtBackground()) {
            this.fillGradient(poseStack, 0, 0, this.width, this.height, -1072689136, -804253680);
        } else {
            Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder bufferbuilder = tesselator.getBuilder();
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            RenderSystem.setShaderTexture(0, BACKGROUND_LOCATION);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            float f = 32.0f;

            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
            bufferbuilder.vertex(0.0, this.height, 0.0).uv(0.0f, (float)this.height / 32.0f + 0.0f).color(64, 64, 64, 255).endVertex();
            bufferbuilder.vertex(this.width, this.height, 0.0).uv((float)this.width / 32.0f, (float)this.height / 32.0f + 0.0f).color(64, 64, 64, 255).endVertex();
            bufferbuilder.vertex(this.width, 0.0, 0.0).uv((float)this.width / 32.0f, 0.0f).color(64, 64, 64, 255).endVertex();
            bufferbuilder.vertex(0.0, 0.0, 0.0).uv(0.0f, 0.0f).color(64, 64, 64, 255).endVertex();
            tesselator.end();

            MinecraftForge.EVENT_BUS.post(new ScreenEvent.BackgroundRendered(this, poseStack));
        }
    }
    //</editor-fold>

    public void setParentGui(Screen parentGui) {
        this.parentGui = parentGui;
    }

    public Screen getParentGui() { return this.parentGui; }

    private boolean isHovered(FireLibGUIComponent comp, int mouseX, int mouseY) {
        if (comp.getAssignedPage() != -1 && comp.getAssignedPage() != this.currentPage) { return false; }

        int x = comp.getX();
        int y = comp.getY();
        int w = comp.getWidth();
        int h = comp.getHeight();

        return mouseX >= x && mouseY >= y && mouseX < x + w && mouseY < y + h;
    }

    public boolean isPauseScreen() { return this.doesGuiPauseGame(); }



    protected ResourceLocation getVanillaOptionsBackground() { return BACKGROUND_LOCATION; }

    public boolean handleComponentClicked(Style style) { return super.handleComponentClicked(style); }

    public void onClose() {
        if (this.shouldUnloadOnClose) {
            for (FireLibGUIComponent comp : this.componentList) {
                comp.unload();
            }
        }
    }

    private void confirmed(boolean confirmed) {
        this.confirmCallback.accept(confirmed);
        this.openGui(this);
        this.confirmCallback = null;
        this.shouldUnloadOnClose = true;
    }

    public final void openURL(String URL) {
        this.confirmCallback = b -> this.runUrl(b, URL);
        this.shouldUnloadOnClose = false;
        ConfirmLinkScreen s = new ConfirmLinkScreen(this::confirmed, URL, true);
        this.openGui(s);
    }

    private void runUrl(boolean bool, String URL) {
        if (bool) {
            Util.getPlatform().openUri(URL);
        }
    }

    public final void openYesNoScreen(String title, String text, BooleanConsumer callback) {
        this.confirmCallback = callback;
        this.shouldUnloadOnClose = false;
        ConfirmScreen s = new ConfirmScreen(this::confirmed, Component.literal(title), Component.literal(text));
        this.openGui(s);
    }

    public final void openConfirmationScreen(String title, String text, String trueButton, String falseButton, BooleanConsumer callback) {
        this.confirmCallback = callback;
        this.shouldUnloadOnClose = false;

        ConfirmScreen s = new ConfirmScreen(
                this::confirmed,
                Component.literal(title),
                Component.literal(text),
                Component.literal(trueButton),
                Component.literal(falseButton)
        );

        this.openGui(s);
    }
}
