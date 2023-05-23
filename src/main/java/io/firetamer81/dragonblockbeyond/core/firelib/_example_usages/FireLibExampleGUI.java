package io.firetamer81.dragonblockbeyond.core.firelib._example_usages;

import io.firetamer81.dragonblockbeyond.core.firelib.FireLibColor;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.AdvancedScreenBase;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff._alphacomponents.BlankComponent;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.dataholders.SpriteTextureObject;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;

public class FireLibExampleGUI extends AdvancedScreenBase {
    //private FireLibTextLabel exampleLabel;
    //private FireLibTextInputField exampleTextInputField;
    //private FireLibImage exampleImage;
    //private FireLibButton exampleButton;

    private BlankComponent testComponent;

    //<editor-fold desc="General Behaviour Abstract Methods">
    @Override
    public boolean isTopLevelGui() { return true; }

    @Override
    public boolean doesGuiPauseGame() { return false; }

    @Override
    public boolean doesEscCloseGui() { return true; }
    //</editor-fold>

    public FireLibExampleGUI() { super(); }

    @Override
    public void buildGui() {
        /**
        //<editor-fold desc="Example Label">
        this.exampleLabel = new FireLibTextLabel.FireLibLabelBuilder()
                .setTopLeftCornerPosition(0, 0)
                //.setMaxWidth(100)
                .setText("Hello There General Kenobi, I've Been Expecting You")
                //.addLine("And I've been looking for you")
                .setTextColor(new FireLibColor(255, 0, 0, 255))
                .centerAlignText()
                .drawGradientBackground(new FireLibColor(255, 0, 0, 100), new FireLibColor(0, 0, 255, 255))
                .build();
        //</editor-fold>

        //<editor-fold desc="Example Text Input Field">
        this.exampleTextInputField = new FireLibTextInputField(this.width / 2, this.height / 2, 150)
                .setLabel("Example Text Input Field")
                .setInitialText("") // Watch out!! Do not make this longer than your set max string length. Doing so causes issues on Return Actions
                .setTooltips("A simple Textbox", "This one does support colors too!", "Simply use a \u00a7", "Press return/enter to run a callback")
                .setMaxStringLength(50)
                .setAcceptsColors(true)
                .setTextColor(new FireLibColor(Color.WHITE.getRGB()))
                .setDisabledTextColour(new FireLibColor(Color.DARK_GRAY.getRGB()))
                .setReturnAction(() ->
                        Minecraft.getInstance().player.sendSystemMessage(Component.literal("Hello There"))
                        //this.exampleLabel.addLine("Hello There, this is added by the example text field on pressing 'Enter'")
                )
                .enableSuggestions()
                .addSuggestions("Hello There Kenobi","Bye Have a Good Time","Meme Central");
        //</editor-fold>

        //<editor-fold desc="Example Image">
        this.exampleImage = new FireLibImage.FireLibImageBuilder()
                .setSprite(new SpriteTextureObject(new ResourceLocation("textures/item/iron_sword.png")))
                .setTitle("Example Image 2", FireLibImage.FireLibImageBuilder.TitlePosition.LEFT_ALIGNED_TOP, new FireLibColor(255, 255, 255))
                .setPos(this.width / 2, this.height / 2)
                .setDimensions(200, 80)
                .shouldKeepAspectRatio(true)
                .shouldDrawGradientBackground(new FireLibColor(255, 0, 0), new FireLibColor(0, 0, 255))
                .setOnClickAction(() -> {
                    Minecraft.getInstance().player.sendSystemMessage(Component.literal("Hello There"));
                    //this.exampleImage2.setWidth(this.exampleImage2.getWidth() - 10);
                })
                .shouldSizeComponentToScaledSprite(true)
                .setBackgroundPadding(0, 20, 5, 20)
                .build();
        //</editor-fold>

        //<editor-fold desc="Example Button">
        this.exampleButton = new FireLibButton(this.width/2, this.height/2, 100, 50)
                .setTooltips("Hi, I'm a button tooltip")
                //.setText("Hello there, I've been expecting you General Kenobi")
                .setIcon(new ResourceLocation("textures/item/iron_sword.png"))
                .setClickAction(() ->
                        Minecraft.getInstance().player.sendSystemMessage(Component.literal("Hello There"))
                );
        //</editor-fold>


        //this.addComponent(exampleLabel);
        //this.addComponent(exampleTextInputField);
        //this.addComponent(exampleImage);
        //this.addComponent(exampleButton);


        //this.exampleLabel.hide();
        //this.exampleTextInputField.hide();
        //this.exampleImage.hide();
        //this.exampleButton.hide();
        **/

        this.testComponent = new BlankComponent.BlankComponentBuilder()
                .setPos((this.width) / 2, (this.height) / 2)
                .setDimensions(100, 20)
                .build();

        this.addComponent(testComponent);

        //this.testComponent.hide();
    }

    @Override
    public void updateGui() {
        /**
        this.exampleLabel.setX(this.width / 2); //This is meant to update the position of the label whenever the game window size changes.

        this.exampleTextInputField.setX(this.width / 2);
        this.exampleTextInputField.setY(this.height / 2);

        this.exampleImage.setX(this.width / 2);
        this.exampleImage.setY(this.height / 2);

        this.exampleButton.setX(this.width / 2);
        this.exampleButton.setY(this.height / 2);
        **/

        //this.testComponent.setPosition(this.width / 2, this.height / 2);
    }
}
