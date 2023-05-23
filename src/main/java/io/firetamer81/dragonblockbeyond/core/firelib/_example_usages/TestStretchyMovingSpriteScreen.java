package io.firetamer81.dragonblockbeyond.core.firelib._example_usages;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders.SpriteTextureObject;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class TestStretchyMovingSpriteScreen extends Screen {

    public boolean isStretching = false;
    public boolean isMoving = false;
    private SpriteTextureObject SPRITE = new SpriteTextureObject(
            new ResourceLocation("textures/item/iron_sword.png"));

    public TestStretchyMovingSpriteScreen() {
        super(Component.literal(""));
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderBackground(pPoseStack);
        RenderSystem.setShaderTexture(0, SPRITE.getTextureResource());

        int[] positionAndSizeData = SPRITE.getPositionAndSizeData();

        blit(pPoseStack,
                positionAndSizeData[0], positionAndSizeData[1],
                0, 0,
                positionAndSizeData[2], positionAndSizeData[3],
                positionAndSizeData[2], positionAndSizeData[3]);
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {

        if (hasShiftDown() && !isMoving) {
            isMoving = true;
        } else if (!isStretching) {
            isStretching = true;
        }
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    public boolean mouseDragged(double pMouseX, double pMouseY, int pButton, double pDragX, double pDragY) {
        int positionAndSizeData[] = SPRITE.getPositionAndSizeData();
        double tempSpriteXPos = positionAndSizeData[0];
        double tempSpriteYPos = positionAndSizeData[1];
        double tempSpriteWidth = positionAndSizeData[2];
        double tempSpriteHeight = positionAndSizeData[3];

        if (isStretching) {
            tempSpriteWidth = positionAndSizeData[2] + pDragX;
            tempSpriteHeight = positionAndSizeData[3] + pDragY;
        }
        if (isMoving) {
            tempSpriteXPos = positionAndSizeData[0] + pDragX;
            tempSpriteYPos = positionAndSizeData[1] + pDragY;
        }

        SPRITE.setTextureWidthAndHeight((int) tempSpriteWidth, (int) tempSpriteHeight);
        SPRITE.setTopLeftCornerTexturePosition((int) tempSpriteXPos, (int) tempSpriteYPos);

        return super.mouseDragged(pMouseX, pMouseY, pButton, pDragX, pDragY);
    }

    @Override
    public boolean mouseReleased(double pMouseX, double pMouseY, int pButton) {
        if (isStretching) {
            isStretching = false;
        }
        if (isMoving) {
            isMoving = false;
        }
        return super.mouseReleased(pMouseX, pMouseY, pButton);
    }
}
