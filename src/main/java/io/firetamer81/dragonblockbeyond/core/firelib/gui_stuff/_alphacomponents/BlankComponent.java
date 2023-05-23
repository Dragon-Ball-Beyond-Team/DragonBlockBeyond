package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._alphacomponents;

import com.mojang.blaze3d.vertex.PoseStack;
import io.firetamer81.dragonblockbeyond.core.firelib.FireLibColor;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders.BorderStyle;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders.BoundingBox;
import net.minecraft.client.Minecraft;

public class BlankComponent extends _TestScreenComponent {
    private BoundingBox boundingBox;

    public BlankComponent(BlankComponentBuilder builder) {
        super(builder.componentOriginX, builder.componentOriginY, builder.componentWidth, builder.componentHeight);
    }

    protected void horizontalLine(PoseStack pPoseStack, int pMinX, int pMaxX, int pY, int pColor) {
        if (pMaxX < pMinX) {
            int i = pMinX;
            pMinX = pMaxX;
            pMaxX = i;
        }

        fill(pPoseStack, pMinX, pY, pMaxX + 1, pY + 1, pColor);
    }

    protected void verticalLine(PoseStack pPoseStack, int pX, int pMinY, int pMaxY, int pColor) {
        if (pMaxY < pMinY) {
            int i = pMinY;
            pMinY = pMaxY;
            pMaxY = i;
        }

        fill(pPoseStack, pX, pMinY + 1, pX + 1, pMaxY, pColor);
    }

    protected void drawBoundLines(PoseStack poseStack, BoundingBox boundingBoxIn, int color) {


        //Left Bound Vertical Line
        fill(poseStack, boundingBoxIn.getLeftBound() - 1, 0,
                boundingBoxIn.getLeftBound() + 1, boundingBoxIn.getBottomBound() + 1, color);

        //Top Bound Horizontal Line
        fill(poseStack, 0, boundingBoxIn.getTopBound() - 1,
                boundingBoxIn.getRightBound() + 1, boundingBoxIn.getTopBound(), color);

        //Right Bound Vertical Line
        fill(poseStack, boundingBoxIn.getRightBound(), 0,
                boundingBoxIn.getRightBound() + 1, boundingBoxIn.getBottomBound() + 1, color);

        //Bottom Bound Horizontal Line
        fill(poseStack, 0, boundingBoxIn.getBottomBound(),
                boundingBoxIn.getRightBound() + 1, boundingBoxIn.getBottomBound() + 1, color);
    }

    //<editor-fold desc="Component Methods">
    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float var4) {
        this.boundingBox = new BoundingBox(
                this.getX(),
                this.getY(),
                this.getX() + this.getWidth(),
                this.getY() + this.getHeight()
        );

        drawBoundLines(poseStack, boundingBox, new FireLibColor(255, 0, 0).getRGBA());

        fillGradient(poseStack, boundingBox.getLeftBound(), boundingBox.getTopBound(), boundingBox.getRightBound(),
                boundingBox.getBottomBound(), new FireLibColor(255, 0, 0, 50).getRGBA(), new FireLibColor(0, 255, 0, 50).getRGBA());

        drawString(
                poseStack,
                Minecraft.getInstance().font,
                "Position: (" + this.getX() + ", " + this.getY() + ")",
                this.getX(),
                (this.getY() + this.getHeight() + 8),
                new FireLibColor(255, 255, 255).getRGBA()
        );
    }

    @Override
    public void mouseClick(double var1, double var3, int var5) {}

    @Override
    public void mouseRelease(double var1, double var3, int var5) {}

    @Override
    public boolean charTyped(char var1, int var2) { return false; }

    @Override
    public boolean canHaveTooltip() { return false; }
    //</editor-fold>

    public static class BlankComponentBuilder {
        private int componentOriginX = 0;
        private int componentOriginY = 0;
        private int componentWidth = 64;
        private int componentHeight = 48;

        private boolean shouldDrawBackground = false;
        private FireLibColor color1 = new FireLibColor(255, 255, 255, 255);
        private FireLibColor color2 = new FireLibColor(255, 255, 255, 255);

        private boolean shouldDrawBorder = false;
        private BorderStyle borderStyle;

        public BlankComponentBuilder setPos(int xIn, int yIn) {
            this.componentOriginX = xIn;
            this.componentOriginY = yIn;

            return this;
        }

        public BlankComponentBuilder setDimensions(int widthIn, int heightIn) {
            this.componentWidth = widthIn;
            this.componentHeight = heightIn;

            return this;
        }

        private boolean validateSettings() {
            return true;
        }

        public BlankComponent build() {
            if (validateSettings()) {
                return new BlankComponent(this);
            } else {
                return new BlankComponent(new BlankComponentBuilder());
            }
        }
    }
}
