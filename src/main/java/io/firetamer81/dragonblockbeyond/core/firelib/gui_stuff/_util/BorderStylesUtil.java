package io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders.BorderStyle;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders.BoundingBox;
import net.minecraft.resources.ResourceLocation;

import static net.minecraft.client.gui.GuiComponent.blit;

public class BorderStylesUtil {

    public static void renderBorder(PoseStack poseStack, BorderStyle borderStyleIn, BoundingBox boundsIn, boolean shouldRenderBorderInsideBounds) {
        RenderSystem.setShaderTexture(0, borderStyleIn.getTextureFile());

        /**
        int[2] topLeftCornerPos = calculatePositionForBorderElement(boundsIn, shouldRenderBorderInsideBounds, );

        //Render Sprite
        blit(poseStack,
                positionAndSizeData[0],
                positionAndSizeData[1],
                0,
                0,
                (int) (positionAndSizeData[2] * scale),
                (int) (positionAndSizeData[3] * scale),
                (int) (positionAndSizeData[2] * scale),
                (int) (positionAndSizeData[3] * scale));
        **/
    }


    /*------------------------------------------------*/
    /*------------------------------------------------*/


    public static BorderStyle BORDER_STYLE_1 = new BorderStyle.BorderStyleBuilder()
            .setTextureFile(new ResourceLocation("firelib", "textures/gui/borderstyles/border_styles_map_1.png"))
            .setTopLeftCornerTexture(0, 0, 7, 7, 0, 0)
            .setTopRightCornerTexture(22, 0, 29, 7, 0, 0)
            .setBottomRightCornerTexture(22, 22, 29, 29, 0, 0)
            .setBottomLeftCornerTexture(0, 22, 7, 29, 0, 0)
            .setLeftBarCornerTexture(true, 0, 9, 7, 20, 0, 0)
            .setTopBarCornerTexture(true, 9, 0, 20, 7, 0, 0)
            .setRightBarCornerTexture(true, 22, 9, 29, 20, 0, 0)
            .setBottomBarCornerTexture(true, 9, 22, 20, 29, 0, 0)
            .build();
}
