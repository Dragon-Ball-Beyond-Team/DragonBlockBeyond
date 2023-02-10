package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.texture_objects;

import net.minecraft.resources.ResourceLocation;

public class SimpleSpriteObject {
    ResourceLocation textureResource;
    int[] textureData = new int[4];

    public SimpleSpriteObject(ResourceLocation textureResourceIn,
                              int textureXOriginIn, int textureYOriginIn, int textureWidthIn, int textureHeightIn) {

        this.textureResource = textureResourceIn;

        textureData[0] = textureXOriginIn;
        textureData[1] = textureYOriginIn;
        textureData[2] = textureWidthIn;
        textureData[3] = textureHeightIn;
    }

    public ResourceLocation getTextureResource() { return textureResource; }

    public int getTextureXOrigin()  { return textureData[0]; }
    public int getTextureYOrigin()  { return textureData[1]; }
    public int getTextureWidth()    { return textureData[2]; }
    public int getTextureHeight()   { return textureData[3]; }
}
