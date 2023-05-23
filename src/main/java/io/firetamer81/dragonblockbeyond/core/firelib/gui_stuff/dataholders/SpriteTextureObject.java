package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders;

import net.minecraft.resources.ResourceLocation;

import java.awt.*;

public class SpriteTextureObject {
    ResourceLocation textureResource;
    int[] positionAndSizeData = new int[4];

    public SpriteTextureObject(ResourceLocation textureResourceIn) {
        this.textureResource= textureResourceIn;

        positionAndSizeData[0] = 0;     //Top Left X Position
        positionAndSizeData[1] = 0;     //Top Left Y Position
        positionAndSizeData[2] = 16;    //Width
        positionAndSizeData[3] = 16;    //Height
    }

    public SpriteTextureObject(ResourceLocation textureResourceIn, int widthIn, int heightIn) {
        this.textureResource= textureResourceIn;

        positionAndSizeData[0] = 0;     //Top Left X Position
        positionAndSizeData[1] = 0;     //Top Left Y Position
        positionAndSizeData[2] = widthIn;    //Width
        positionAndSizeData[3] = heightIn;    //Height
    }

    //<editor-fold desc="Get Methods">
    public ResourceLocation getTextureResource() { return textureResource; }

    public int[] getPositionAndSizeData() { return positionAndSizeData; }

    public int  getWidth() {
        int[] positionAndSizeData = getPositionAndSizeData();

        return positionAndSizeData[2];
    }

    public int  getHeight() {
        int[] positionAndSizeData = getPositionAndSizeData();

        return positionAndSizeData[3];
    }
    //</editor-fold>

    //<editor-fold desc="Set Methods">
    public SpriteTextureObject setTopLeftCornerTexturePosition(int xPosIn, int yPosIn) {
        positionAndSizeData[0] = xPosIn;     //Top Left X Position
        positionAndSizeData[1] = yPosIn;     //Top Left Y Position

        return this;
    }

    public SpriteTextureObject setTextureWidthAndHeight(int widthIn, int heightIn) {
        positionAndSizeData[2] = widthIn;    //Width
        positionAndSizeData[3] = heightIn;    //Height

        return this;
    }
    //</editor-fold>
}
