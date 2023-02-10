package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.texture_objects;

import net.minecraft.resources.ResourceLocation;

public class BorderTextureObject {
    ResourceLocation textureResource;

    /**
     * The X & Y Offsets are mainly for when a corner has a texture that goes outside the rest of the border texture,
     * which would cause the helper methods that draw the borders to place the corner to far in or out.
     * The offset values would be used in the method to counteract this.
     * I went ahead and just put the value for the bars too in-case some other situation required it.
     */
    /**
     * int0 = XOrigin
     * int1 = Width
     * int2 = YOrigin
     * int3 = Height
     * int4 = xOffset
     * int5 = yOffset
     */
    int[] topLeftCornerData = new int[6];
    int[] topBarData = new int[6];
    int[] topRightCornerData = new int[6];
    int[] rightBarData = new int[6];
    int[] bottomRightCornerData = new int[6];
    int[] bottomBarData = new int[6];
    int[] bottomLeftCornerData = new int[6];
    int[] leftBarData = new int[6];

    public BorderTextureObject(ResourceLocation textureResource,
                               int topLeftCornerXOrigin, int topLeftCornerWidth, int topLeftCornerYOrigin, int topLeftCornerHeight, int topLeftCornerOffsetX, int topLeftCornerOffsetY,
                               int topBarXOrigin, int topBarWidth, int topBarYOrigin, int topBarHeight, int topBarOffsetX, int topBarOffsetY,
                               int topRightCornerXOrigin, int topRightCornerWidth, int topRightCornerYOrigin, int topRightCornerHeight, int topRightCornerOffsetX, int topRightCornerOffsetY,
                               int rightBarXOrigin, int rightBarWidth, int rightBarYOrigin, int rightBarHeight, int rightBarOffsetX, int rightBarOffsetY,
                               int bottomRightCornerXOrigin, int bottomRightCornerWidth, int bottomRightCornerYOrigin, int bottomRightCornerHeight, int bottomRightCornerOffsetX, int bottomRightCornerOffsetY,
                               int bottomBarXOrigin, int bottomBarWidth, int bottomBarYOrigin, int bottomBarHeight, int bottomBarOffsetX, int bottomBarOffsetY,
                               int bottomLeftCornerXOrigin, int bottomLeftCornerWidth, int bottomLeftCornerYOrigin, int bottomLeftCornerHeight, int bottomLeftCornerOffsetX, int bottomLeftCornerOffsetY,
                               int leftBarXOrigin, int leftBarWidth, int leftBarYOrigin, int leftBarHeight, int leftBarOffsetX, int leftBarOffsetY) {

        this.textureResource= textureResource;

        topLeftCornerData[0] = topLeftCornerXOrigin;
        topLeftCornerData[1] = topLeftCornerWidth;
        topLeftCornerData[2] = topLeftCornerYOrigin;
        topLeftCornerData[3] = topLeftCornerHeight;
        topLeftCornerData[4] = topLeftCornerOffsetX;
        topLeftCornerData[5] = topLeftCornerOffsetY;

        topBarData[0] = topBarXOrigin;
        topBarData[1] = topBarWidth;
        topBarData[2] = topBarYOrigin;
        topBarData[3] = topBarHeight;
        topBarData[4] = topBarOffsetX;
        topBarData[5] = topBarOffsetY;

        topRightCornerData[0] = topRightCornerXOrigin;
        topRightCornerData[1] = topRightCornerWidth;
        topRightCornerData[2] = topRightCornerYOrigin;
        topRightCornerData[3] = topRightCornerHeight;
        topRightCornerData[4] = topRightCornerOffsetX;
        topRightCornerData[5] = topRightCornerOffsetY;

        rightBarData[0] = rightBarXOrigin;
        rightBarData[1] = rightBarWidth;
        rightBarData[2] = rightBarYOrigin;
        rightBarData[3] = rightBarHeight;
        rightBarData[4] = rightBarOffsetX;
        rightBarData[5] = rightBarOffsetY;

        bottomRightCornerData[0] = bottomRightCornerXOrigin;
        bottomRightCornerData[1] = bottomRightCornerWidth;
        bottomRightCornerData[2] = bottomRightCornerYOrigin;
        bottomRightCornerData[3] = bottomRightCornerHeight;
        bottomRightCornerData[4] = bottomRightCornerOffsetX;
        bottomRightCornerData[5] = bottomRightCornerOffsetY;

        bottomBarData[0] = bottomBarXOrigin;
        bottomBarData[1] = bottomBarWidth;
        bottomBarData[2] = bottomBarYOrigin;
        bottomBarData[3] = bottomBarHeight;
        bottomBarData[4] = bottomBarOffsetX;
        bottomBarData[5] = bottomBarOffsetY;

        bottomLeftCornerData[0] = bottomLeftCornerXOrigin;
        bottomLeftCornerData[1] = bottomLeftCornerWidth;
        bottomLeftCornerData[2] = bottomLeftCornerYOrigin;
        bottomLeftCornerData[3] = bottomLeftCornerHeight;
        bottomLeftCornerData[4] = bottomLeftCornerOffsetX;
        bottomLeftCornerData[5] = bottomLeftCornerOffsetY;

        leftBarData[0] = leftBarXOrigin;
        leftBarData[1] = leftBarWidth;
        leftBarData[2] = leftBarYOrigin;
        leftBarData[3] = leftBarHeight;
        leftBarData[4] = leftBarOffsetX;
        leftBarData[5] = leftBarOffsetY;
    }


    public ResourceLocation getTextureResource() { return textureResource; }

    public int[] getTopLeftCornerTextureData() { return topLeftCornerData; }

    public int[] getTopBarTextureData() { return topBarData; }

    public int[] getTopRightCornerTextureData() { return topRightCornerData; }

    public int[] getRightBarTextureData() { return rightBarData; }

    public int[] getBottomRightCornerTextureData() { return bottomRightCornerData; }

    public int[] getBottomBarTextureData() { return bottomBarData; }

    public int[] getBottomLeftCornerTextureData() { return bottomLeftCornerData; }

    public int[] getLeftBarTextureData() { return leftBarData; }
}
