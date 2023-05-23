package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.ImageUtil.ImageUtil;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.net.URL;

public class TestButton extends TestAdvancedScreenComponent {
    protected DynamicTexture BUTTON_ICON_IMAGE;
    protected ResourceLocation BUTTON_ICON;
    protected String displayString;
    private Runnable callback;
    private String errorTooltip;

    public TestButton(int xPos, int yPos, ResourceLocation icon) {
        this(xPos, yPos, 20, "", icon);
    }

    public TestButton(int xPos, int yPos, String displayString) {
        this(xPos, yPos, 100, displayString);
    }

    public TestButton(int xPos, int yPos, int width, String displayString) {
        this(xPos, yPos, width, 20, displayString);
    }

    public TestButton(int xPos, int yPos, String displayString, ResourceLocation icon) {
        this(xPos, yPos, 100, displayString, icon);
    }

    public TestButton(int xPos, int yPos, int width, String displayString, ResourceLocation icon) {
        this(xPos, yPos, width, 20, displayString, (ResourceLocation)icon);
    }

    public TestButton(int xPos, int yPos, int width, int height, String displayString) {
        this(xPos, yPos, width, height, displayString, (ResourceLocation)null);
    }

    public TestButton(int xPos, int yPos, int width, int height, String displayString, URL iconURL) {
        this(xPos, yPos, width, height, displayString, iconURL.toString());
    }



    public TestButton(int xPos, int yPos, int width, int height, String displayString, ResourceLocation icon) {
        super(xPos, yPos, width, height);
        this.errorTooltip = "";
        this.BUTTON_ICON = icon;
        this.displayString = displayString;
    }

    public TestButton(int xPos, int yPos, int width, int height, String displayString, String iconURL) {
        this(xPos, yPos, width, height, displayString);

        try {
            this.BUTTON_ICON_IMAGE = new DynamicTexture(ImageUtil.getImageFromIS(ImageUtil.getInputStreamFromImageURL(iconURL), false, 16, 16, true));
        } catch (IOException var8) {
            this.errorTooltip = var8.getCause().getLocalizedMessage();
        }

        this.displayString = displayString;
    }

    public TestButton(int xPos, int yPos, int width, int height, String displayString, NativeImage icon) {
        super(xPos, yPos, width, height);
        this.errorTooltip = "";
        this.BUTTON_ICON_IMAGE = new DynamicTexture(icon);
        this.displayString = displayString;
    }



    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partial) {
        int color = 14737632;
        this.isHovered = mouseX >= getX() && mouseY >= getY() && mouseX < this.getX() + this.width && mouseY < getY() + this.height;
        if (packedFGColor != 0) {
            color = packedFGColor;
        } else if (!this.isEnabled()) {
            color = 10526880;
        } else if (this.hovered) {
            color = 16777120;
        }
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
        int i = this.getYImage(this.isHoveredOrFocused());
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        this.blit(poseStack, getX(), getY(), 0, 46 + i * 20, this.width / 2, this.height);
        this.blit(poseStack, getX() + this.width / 2, getY(), 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
        this.renderBg(poseStack, mc, mouseX, mouseY);
        int j = getFGColor();
        int bx = this.getX();
        int mwidth = this.width;
        if (BUTTON_ICON != null && BUTTON_ICON_IMAGE == null) {

            RenderSystem.setShaderTexture(0, BUTTON_ICON);
            blit(poseStack, bx + 2, getY() + 2, 0, 0, 16, 16, 16, 16);

            // ! MODIFY X !
            bx += 2 + 16;
            mwidth -= 16;
        } else if (BUTTON_ICON_IMAGE != null && BUTTON_ICON == null) {
            RenderSystem.setShaderTexture(0, mc.getTextureManager().register("icon", BUTTON_ICON_IMAGE));
            blit(poseStack, bx + 2, getY(), 0, 0, 16, 16, 16, 16);
            bx += 2 + 16;
            mwidth -= 16;
        } else //noinspection ConstantConditions
            if (BUTTON_ICON_IMAGE == null && BUTTON_ICON == null && !errorTooltip.equals("")) {
                RenderSystem.setShaderTexture(0, errorIcon);
                blit(poseStack, bx + 2, getY(), 0, 0, 16, 16, 16, 16);
                bx += 2 + 16;
                mwidth -= 16;
            }
        String buttonText = this.displayString;
        int strWidth = mc.font.width(buttonText);
        int ellipsisWidth = mc.font.width("...");
        if (strWidth > mwidth - 6 && strWidth > ellipsisWidth)
            buttonText = mc.font.plainSubstrByWidth(buttonText, mwidth - 6 - ellipsisWidth).trim() + "...";

        drawCenteredString(poseStack, mc.font, buttonText, bx + mwidth / 2, this.getY() + (this.height - 8) / 2, color);
    }

    //<editor-fold desc="Interaction Methods">
    @Override
    public void mouseClick(double var1, double var3, int var5) {
        this.playPressSound();

        if (this.enabled) {
            this.onClick();
        }
    }

    @Override
    public void mouseRelease(double var1, double var3, int var5) {}

    @Override
    public boolean charTyped(char var1, int var2) { return false; }
    //</editor-fold>

    public final void setText(String text) { this.displayString = text; }

    public final void setClickListener(Runnable r) { this.callback = r; }

    public void onClick() {
        if (this.callback != null) {
            this.callback.run();
        }
    }

    public String[] getTooltips() {
        return this.BUTTON_ICON == null && this.BUTTON_ICON_IMAGE == null && !this.errorTooltip.isEmpty() ? (String[]) ArrayUtils.addAll(super.getTooltips(), new String[]{"", "§cError loading image:", "§c" + this.errorTooltip}) : super.getTooltips();
    }

    public static class DefaultButtonIcons {
        public static final ResourceLocation ADD = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/add.png");
        public static final ResourceLocation DELETE = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/delete.png");
        public static final ResourceLocation PLAY = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/play.png");
        public static final ResourceLocation PAUSE = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/pause.png");
        public static final ResourceLocation STOP = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/stop.png");
        public static final ResourceLocation SAVE = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/save.png");
        public static final ResourceLocation NEW = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/new.png");
        public static final ResourceLocation FILE = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/file.png");
        public static final ResourceLocation FILE_TXT = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/file_txt.png");
        public static final ResourceLocation FILE_NBT = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/file_nbt.png");
        public static final ResourceLocation FILE_BIN = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/file_bin.png");
        public static final ResourceLocation ARROW_RIGHT = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/arrow-right.png");
        public static final ResourceLocation ARROW_LEFT = new ResourceLocation("dragonblockbeyond:textures/gui/firelibguistuff/buttonicons/arrow-left.png");

        public DefaultButtonIcons() {}
    }
}
