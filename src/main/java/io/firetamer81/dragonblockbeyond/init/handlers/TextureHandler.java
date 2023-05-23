package io.firetamer81.dragonblockbeyond.init.handlers;

import net.minecraft.resources.ResourceLocation;

public class TextureHandler {
    /**
    public static final ResourceLocation STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static SimpleSpriteObject BLUE_KI_BLAST_SPRITE;

    private static final ResourceLocation BORDER_MAP_1 = new ResourceLocation(DragonBlockBeyond.MOD_ID, "textures/gui/border_styles_map_1.png");
    public static BorderTextureObject BORDER_1;
    public static BorderTextureObject BORDER_2;
     **/


    public TextureHandler() {}

    public static void init() {
        //createGUIBorderTextureData();
        //createSpriteTextureData();
    }

    /**
    private static void createSpriteTextureData() {
        BLUE_KI_BLAST_SPRITE = new SimpleSpriteObject(new ResourceLocation(DragonBlockBeyond.MOD_ID, "textures/sprites/blue_ki_blast_sprite.png"),
                0, 0, 32, 32);
    }

    private static void createGUIBorderTextureData() {
        BORDER_1 = new BorderTextureObject(BORDER_MAP_1,
                0, 8, 0, 8, 0, 0,
                9, 12, 0, 8, 0, 0,
                22, 8, 0, 8, 0, 0,
                22, 8, 9, 12, 0, 0,
                22, 8, 22, 8, 0, 0,
                9, 12, 22, 8, 0, 0,
                0, 8, 22, 8, 0, 0,
                0, 8, 9, 12, 0, 0);

        BORDER_2 = new BorderTextureObject(BORDER_MAP_1,
                33, 10, 0, 10, 0, 0,
                44, 12, 2, 8, 0, 2,
                57, 10, 0, 10, 0, 0,
                57, 8, 11, 12, 0, 0,
                57, 10, 24, 10, 0, 0,
                44, 12, 24, 8, 0, 0,
                33, 10, 24, 10, 0, 0,
                35, 8, 11, 12, 2, 0);
    }
    **/
}
