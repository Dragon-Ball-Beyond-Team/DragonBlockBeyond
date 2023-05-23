package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders;

import net.minecraft.resources.ResourceLocation;

public class BorderStyle {
    //<editor-fold desc="Data Variables">
    private ResourceLocation textureMap;

    /**
     * The int[]'s hold the relevant texture and rendering data. Get Methods will be provided to retrieve this data.
     * <pre>
     * int[0] = TextureBound_Left;
     * int[1] = TextureBound_Top;
     * int[2] = TextureBound_Right;
     * int[3] = TextureBound_Bottom;
     * int[4] = RenderOffsetX;
     * int[5] = RenderOffsetY;</pre>
     */
    //Top Left Corner
    private boolean isTLCPresent;
    private int[] TLC_Data;

    //Top Right Corner
    private boolean isTRCPresent;
    private int[] TRC_Data;

    //Bottom Right Corner
    private boolean isBRCPresent;
    private int[] BRC_Data;

    //Bottom Left Corner
    private boolean isBLCPresent;
    private int[] BLC_Data;

    /**
     * If a bar texture is uniform respective to its axis, stretching it along that axis wouldn't cause deformations.
     * So, a vertical bar texture being stretched on the Y axis instead of tiled would save rendering resources.
     * The same goes for a horizontal bar being stretched on the x-axis.
     */
    //Left Bar
    private boolean isLeftBarPresent;
    private boolean isLeftBarStretchable;
    private int[] LeftBar_Data;

    //Top Bar
    private boolean isTopBarPresent;
    private boolean isTopBarStretchable;
    private int[] TopBar_Data;

    //Right Bar
    private boolean isRightBarPresent;
    private boolean isRightBarStretchable;
    private int[] RightBar_Data;

    //Bottom Bar
    private boolean isBottomBarPresent;
    private boolean isBottomBarStretchable;
    private int[] BottomBar_Data;
    //</editor-fold>

    public BorderStyle(BorderStyleBuilder builder) {
        this.textureMap = builder.textureMap;

        //Top Left Corner
        this.isTLCPresent = builder.isTLCPresent;
        this.TLC_Data = builder.TLC_Data;

        //Top Right Corner
        this.isTRCPresent = builder.isTRCPresent;
        this.TRC_Data = builder.TRC_Data;

        //Bottom Right Corner
        this.isBRCPresent = builder.isBRCPresent;
        this.BRC_Data = builder.BRC_Data;

        //Bottom Left Corner
        this.isBLCPresent = builder.isBLCPresent;
        this.BLC_Data = builder.BLC_Data;

        //Left Bar
        this.isLeftBarPresent = builder.isLeftBarPresent;
        this.isLeftBarStretchable = builder.isLeftBarStretchable;
        this.LeftBar_Data = builder.LeftBar_Data;

        //Top Bar
        this.isTopBarPresent = builder.isTopBarPresent;
        this.isTopBarStretchable = builder.isTopBarStretchable;
        this.TopBar_Data = builder.TopBar_Data;

        //Right Bar
        this.isRightBarPresent = builder.isRightBarPresent;
        this.isRightBarStretchable = builder.isRightBarStretchable;
        this.RightBar_Data = builder.RightBar_Data;

        //Bottom Bar
        this.isBottomBarPresent = builder.isBottomBarPresent;
        this.isBottomBarStretchable = builder.isBottomBarStretchable;
        this.BottomBar_Data = builder.BottomBar_Data;
    }

    public ResourceLocation getTextureFile() {
        return this.textureMap;
    }

    public int[] getTopLeftCornerData() {
        return this.TLC_Data;
    }

    public static class BorderStyleBuilder {
        //<editor-fold desc="Data Variables">
        private ResourceLocation textureMap = null;

        private boolean isTLCPresent;
        private int[] TLC_Data = new int[6];

        private boolean isTRCPresent;
        private int[] TRC_Data = new int[6];

        private boolean isBRCPresent;
        private int[] BRC_Data = new int[6];

        private boolean isBLCPresent;
        private int[] BLC_Data = new int[6];

        private boolean isLeftBarPresent;
        private boolean isLeftBarStretchable;
        private int[] LeftBar_Data = new int[6];

        private boolean isTopBarPresent;
        private boolean isTopBarStretchable;
        private int[] TopBar_Data = new int[6];

        private boolean isRightBarPresent;
        private boolean isRightBarStretchable;
        private int[] RightBar_Data = new int[6];

        private boolean isBottomBarPresent;
        private boolean isBottomBarStretchable;
        private int[] BottomBar_Data = new int[6];
        //</editor-fold>

        public BorderStyleBuilder setTextureFile(ResourceLocation textureMapIn) {
            this.textureMap = textureMapIn;

            return this;
        }

        public BorderStyleBuilder setTopLeftCornerTexture(int textureBound_Left, int textureBound_Top,
                                                          int textureBound_Right, int textureBound_Bottom,
                                                          int renderOffsetX, int renderOffsetY) {
            isTLCPresent = true;
            TLC_Data[0] = textureBound_Left;
            TLC_Data[1] = textureBound_Top;
            TLC_Data[2] = textureBound_Right;
            TLC_Data[3] = textureBound_Bottom;
            TLC_Data[4] = renderOffsetX;
            TLC_Data[5] = renderOffsetY;

            return this;
        }

        public BorderStyleBuilder setTopRightCornerTexture(int textureBound_Left, int textureBound_Top,
                                                           int textureBound_Right, int textureBound_Bottom,
                                                           int renderOffsetX, int renderOffsetY) {
            isTRCPresent = true;
            TRC_Data[0] = textureBound_Left;
            TRC_Data[1] = textureBound_Top;
            TRC_Data[2] = textureBound_Right;
            TRC_Data[3] = textureBound_Bottom;
            TRC_Data[4] = renderOffsetX;
            TRC_Data[5] = renderOffsetY;

            return this;
        }

        public BorderStyleBuilder setBottomRightCornerTexture(int textureBound_Left, int textureBound_Top,
                                                              int textureBound_Right, int textureBound_Bottom,
                                                              int renderOffsetX, int renderOffsetY) {
            isBRCPresent = true;
            BRC_Data[0] = textureBound_Left;
            BRC_Data[1] = textureBound_Top;
            BRC_Data[2] = textureBound_Right;
            BRC_Data[3] = textureBound_Bottom;
            BRC_Data[4] = renderOffsetX;
            BRC_Data[5] = renderOffsetY;

            return this;
        }

        public BorderStyleBuilder setBottomLeftCornerTexture(int textureBound_Left, int textureBound_Top,
                                                             int textureBound_Right, int textureBound_Bottom,
                                                             int renderOffsetX, int renderOffsetY) {
            isBLCPresent = true;
            BLC_Data[0] = textureBound_Left;
            BLC_Data[1] = textureBound_Top;
            BLC_Data[2] = textureBound_Right;
            BLC_Data[3] = textureBound_Bottom;
            BLC_Data[4] = renderOffsetX;
            BLC_Data[5] = renderOffsetY;

            return this;
        }

        public BorderStyleBuilder setLeftBarCornerTexture(boolean isTextureStretchable,
                                                          int textureBound_Left, int textureBound_Top,
                                                          int textureBound_Right, int textureBound_Bottom,
                                                          int renderOffsetX, int renderOffsetY) {
            isLeftBarPresent = true;
            isLeftBarStretchable = isTextureStretchable;
            LeftBar_Data[0] = textureBound_Left;
            LeftBar_Data[1] = textureBound_Top;
            LeftBar_Data[2] = textureBound_Right;
            LeftBar_Data[3] = textureBound_Bottom;
            LeftBar_Data[4] = renderOffsetX;
            LeftBar_Data[5] = renderOffsetY;

            return this;
        }

        public BorderStyleBuilder setTopBarCornerTexture(boolean isTextureStretchable,
                                                         int textureBound_Left, int textureBound_Top,
                                                         int textureBound_Right, int textureBound_Bottom,
                                                         int renderOffsetX, int renderOffsetY) {
            isTopBarPresent = true;
            isTopBarStretchable = isTextureStretchable;
            TopBar_Data[0] = textureBound_Left;
            TopBar_Data[1] = textureBound_Top;
            TopBar_Data[2] = textureBound_Right;
            TopBar_Data[3] = textureBound_Bottom;
            TopBar_Data[4] = renderOffsetX;
            TopBar_Data[5] = renderOffsetY;

            return this;
        }

        public BorderStyleBuilder setRightBarCornerTexture(boolean isTextureStretchable,
                                                           int textureBound_Left, int textureBound_Top,
                                                           int textureBound_Right, int textureBound_Bottom,
                                                           int renderOffsetX, int renderOffsetY) {
            isRightBarPresent = true;
            isRightBarStretchable = isTextureStretchable;
            RightBar_Data[0] = textureBound_Left;
            RightBar_Data[1] = textureBound_Top;
            RightBar_Data[2] = textureBound_Right;
            RightBar_Data[3] = textureBound_Bottom;
            RightBar_Data[4] = renderOffsetX;
            RightBar_Data[5] = renderOffsetY;

            return this;
        }

        public BorderStyleBuilder setBottomBarCornerTexture(boolean isTextureStretchable,
                                                            int textureBound_Left, int textureBound_Top,
                                                            int textureBound_Right, int textureBound_Bottom,
                                                            int renderOffsetX, int renderOffsetY) {
            isBottomBarPresent = true;
            isBottomBarStretchable = isTextureStretchable;
            BottomBar_Data[0] = textureBound_Left;
            BottomBar_Data[1] = textureBound_Top;
            BottomBar_Data[2] = textureBound_Right;
            BottomBar_Data[3] = textureBound_Bottom;
            BottomBar_Data[4] = renderOffsetX;
            BottomBar_Data[5] = renderOffsetY;

            return this;
        }

        private boolean validateSettings() {
            return this.textureMap != null;
        }

        public BorderStyle build() {
            if (validateSettings()) {
                return new BorderStyle(this);
            } else {
                return new BorderStyle(new BorderStyleBuilder());
            }
        }
    }
}
