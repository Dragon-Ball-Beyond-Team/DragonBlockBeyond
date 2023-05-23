package io.firetamer81.dragonblockbeyond.core.firelib._example_usages;

import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.AdvancedScreenBase;
import io.firetamer81.dragonblockbeyond.core.firelib.gui_stuff.testcomponents.*;

import java.util.Random;

public class TestGUI extends AdvancedScreenBase {
    private TestButton exampleButton;
    private TestTextField exampleTextField;
    private TestLabel exampleLabel1;
    private TestButton exitButton;
    private TestCheckBox exampleCheckbox;
    private TestSlider exampleSlider1;
    //private ASEnumSlider exampleSlider2;
    private TestToggleButton exampleToggleButton;
    //private ASEnumSlider drawTypeSlider;
    private TestTextField urlField;
    private TestButton nextPageButton;
    private TestButton prevPageButton;
    private TestLabel pageIndicator;
    private TestScrollPanel scrollPanel;
    private TestButton scrollButton1;
    private TestButton scrollButton2;
    private TestTextField scrollTextField;
    private TestSlider xSlider;
    private TestSlider ySlider;
    private TestSlider contentSlider;
    private TestSlider scrollSlider;
    private TestProgressBar pBar;
    private TestSlider pBarSlider;
    //private ASEnumSlider pBarColorSlider;
    private TestButton pBarLoader;
    private Thread loader;

    private TestToggleButton spinnerPlayPause;

    public TestGUI() { super(); }

    @Override
    public void buildGui() {
        this.exampleButton = new TestButton(50, 50, "Button", TestButton.DefaultButtonIcons.SAVE);
        this.exampleTextField = new TestTextField(50, 100, 150);
        this.exampleLabel1 = new TestLabel("Example GUI", this.width / 2, 10);
        this.exitButton = new TestButton(0, 0, TestButton.DefaultButtonIcons.DELETE);
        this.exampleCheckbox = new TestCheckBox(50, 70, "Checkbox", false);
        this.exampleSlider1 = new TestSlider(50, 130, "Slider: ", 0.0, 100.0, 50.0, () -> System.out.println(this.exampleSlider1.getValue()));
        /*this.exampleSlider2 = new ASEnumSlider(200, 130, "Enum Slider: ", ExampleEnum.class, ExampleEnum.EXAMPLE, () -> {
            System.out.println("Enum changed to \"" + ((ExampleEnum)this.exampleSlider2.getEnum()).getName() + "\"");
            System.out.println("Index: " + this.exampleSlider2.getValueInt());
            System.out.println("Other Value: " + ((ExampleEnum)this.exampleSlider2.getEnum()).getOtherValue());
        });*/
        this.exampleToggleButton = new TestToggleButton(50, 170, "Toggle Button: ");
        /*this.drawTypeSlider = new ASEnumSlider(156, 170, "Draw type: ",
                ASToggleButton.DrawType.class,
                (Enum)ASToggleButton.DrawType.COLORED_LINE,
                () -> this.exampleToggleButton.setDrawType(
                        (ASToggleButton.DrawType)this.drawTypeSlider.getEnum()
                )
        );*/
        //this.beeGif = new ASImage(250, 40, 64, 64);
        //this.apple = new ASImage(0, 0);
        //this.dynamicImage = new ASImage(0, 0, 300, 180);
        this.urlField = new TestTextField(0, 0, 240);
        this.nextPageButton = new TestButton(0, 0, 40, ">");
        this.prevPageButton = new TestButton(0, 0, 40, "<");
        this.pageIndicator = new TestLabel(0, 0);
        this.scrollPanel = new TestScrollPanel(0, 0, 300, 200);
        this.scrollButton1 = new TestButton(30, 10, "Button 1");
        this.scrollButton2 = new TestButton(30, 330, "Button 2");
        this.scrollTextField = new TestTextField(2, 300, 100);
        this.scrollSlider = new TestSlider(10, 212, "Another Slider: ", -20.0, 20.0, 0.0, () -> System.out.println("Changed to " + this.scrollSlider.getValueInt()));
        this.xSlider = new TestSlider(10, 20, "ScrollPanel X Pos", 0.0, 350.0, 0.0, () -> this.scrollPanel.setX(this.xSlider.getValueInt()));
        this.ySlider = new TestSlider(10, 50, "ScrollPanel Y Pos", 0.0, 255.0, 0.0, () -> this.scrollPanel.setY(this.ySlider.getValueInt()));
        this.contentSlider = new TestSlider(10, 80, "ScrollPanel Content length", 0.0, 1200.0, 500.0, () -> this.scrollPanel.setContentHeight(this.contentSlider.getValueInt()));
        //this.pikachu = new ASImage(150, 40, 120, 70);
        //this.spinner = new ASSpinner(0, 0);
        this.pBar = new TestProgressBar(0, 0, 200);
        this.pBarSlider = new TestSlider(0, 0, "ProgressBar value: ", 0.0, 100.0, 0.0, () -> this.pBar.setValue(this.pBarSlider.getValueInt()));
        //this.pBarColorSlider = new ASEnumSlider(0, 0, "Progress Bar Color: ", BossEvent.BossBarColor.class, (Enum)BossEvent.BossBarColor.BLUE, () -> this.pBar.setColor((BossEvent.BossBarColor)this.pBarColorSlider.getEnum()));
        this.pBarLoader = new TestButton(0, 0, "Load Something", TestButton.DefaultButtonIcons.PLAY);
        this.spinnerPlayPause = new TestToggleButton(0, 0, TestButton.DefaultButtonIcons.PAUSE, TestButton.DefaultButtonIcons.PLAY);
        //this.beeGif.loadImage("https://gamepedia.cursecdn.com/minecraft_gamepedia/thumb/5/58/Bee.gif/120px-Bee.gif");
        //this.apple.loadImage(new ResourceLocation("minecraft", "textures/item/apple.png"));
        //this.dynamicImage.loadImage("https://static.wikia.nocookie.net/minecraft_de_gamepedia/images/0/0a/Creeper.png/revision/latest?cb=20120514161909");
        //this.pikachu.loadImage("https://i.pinimg.com/originals/9f/b1/25/9fb125f1fedc8cc62ab5b20699ebd87d.gif");
        this.exampleButton.setClickListener(() -> System.out.println("I have been clicked!"));
        this.exampleCheckbox.setChangeListener(() -> System.out.println(this.exampleCheckbox.isChecked() ? "I just got Checked" : "I just have been unchecked :/"));
        this.exitButton.setClickListener(() -> this.close());
        this.exampleTextField.setReturnAction(() -> this.exampleButton.setText(this.exampleTextField.getText()));
        this.exampleToggleButton.setClickListener(() -> {
            System.out.println("New Value: " + this.exampleToggleButton.getValue());
            this.exampleButton.setEnabled(this.exampleToggleButton.getValue());
        });
        /*this.apple.setCallback(() -> {
            this.minecraft.getSoundManager().play((SoundInstance)SimpleSoundInstance.forUI((SoundEvent)SoundEvents.PLAYER_BURP, (float)1.0f));
            this.apple.setVisible(false);
            this.apple.disable();
        });*/
        //this.urlField.setText(this.dynamicImage.getImageURL());
        //this.urlField.setReturnAction(() -> this.dynamicImage.loadImage(this.urlField.getText()));
        this.nextPageButton.setClickListener(() -> this.nextPage());
        this.prevPageButton.setClickListener(() -> this.prevPage());
        this.pBarLoader.setClickListener(() -> {
            if (this.loader == null || !this.loader.isAlive()) {
                this.loader = new Thread(() -> {
                    this.pBarSlider.disable();
                    this.pBar.setValue(0);
                    this.pBar.setMaxValue(140);
                    this.pBarSlider.setValue(0.0);
                    this.pBarSlider.setMaxValue(140.0);
                    for (int i = 0; i < 140; ++i) {
                        this.pBar.increment(1);
                        this.pBarSlider.setValue(this.pBar.getValue());
                        try {
                            Thread.sleep(new Random().nextInt(5) * 100);
                            continue;
                        }
                        catch (InterruptedException interruptedException) {
                            // empty catch block
                        }
                    }
                    try {
                        Thread.sleep(3000L);
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                    this.pBar.setValue(0);
                    this.pBar.setMaxValue(100);
                    this.pBarSlider.setValue(0.0);
                    this.pBarSlider.setMaxValue(100.0);
                    this.pBarSlider.enable();
                });
                this.loader.start();
            }
        });
        this.exampleButton.setTooltips(new String[]{"Example Tooltip", "This is a Button"});
        this.exampleCheckbox.setTooltips(new String[]{"Another Tooltip", "This is a Checkbox", ""});
        this.exampleTextField.setTooltips(new String[]{"A simple Textbox", "This one does support colors too!", "Simply use a \u00a7", "Press return to run a callback"});
        this.exitButton.setTooltips(new String[]{"Closes this GUI"});
        this.exampleSlider1.setTooltips(new String[]{"A simple double/integer slider"});
        //this.exampleSlider2.setTooltips(new String[]{"This slider works using Enums", "It will change through all enum values"});
        this.exampleToggleButton.setTooltips(new String[]{"This button can be toggled"});
        //this.drawTypeSlider.setTooltips(new String[]{"Change how the toggle button will be rendered"});
        //this.beeGif.setTooltips(new String[]{"This is an example image", "It was loaded from an URL"});
        //this.apple.setTooltips(new String[]{"Oh, look at this apple!", "", "Click to eat"});
        this.scrollButton1.setTooltips(new String[]{"An button in an scroll panel"});
        //this.pikachu.setTooltips(new String[]{"Click me to open an URL"});
        this.scrollButton1.setClickListener(() -> System.out.println("TEST1"));
        this.scrollButton2.setClickListener(() -> System.out.println("TEST2"));
        this.scrollTextField.setReturnAction(() -> System.out.println(this.scrollTextField.getText()));
        //this.pikachu.setCallback(() -> this.openURL("http://pikachu.com"));
        /*this.beeGif.setCallback(() -> this.openYesNo("Pet the bee?", "Are you sure you want to pet the bee?", pet -> {
            if (pet) {
                this.beeGif.loadImage("https://static.wikia.nocookie.net/minecraft_gamepedia/images/4/47/Bee_%28angry%29.gif/revision/latest?cb=20200414132748");
                this.beeGif.setCallback(null);
            }
        }));*/
        this.spinnerPlayPause.setClickListener(() -> {
            if (this.spinnerPlayPause.getValue()) {
                //this.spinner.resume();
            } else {
                //this.spinner.stop();
            }
        });
        this.exampleTextField.setAcceptsColors(true);
        this.exampleTextField.setText("Text Field");
        this.exampleTextField.setLabel("Text Field Label");
        this.scrollTextField.setLabel("Example Text field in scroll panel");
        this.scrollTextField.setText("TEXT");
        this.exampleLabel1.setCentered();
        this.pageIndicator.setCentered();
        this.exampleToggleButton.setValue(true);
        this.urlField.setLabel("Image URL");
        this.urlField.setMaxStringLength(1024);
        this.pBar.setText("Progress Bar:");
        this.pBarSlider.setShowDecimal(false);
        this.spinnerPlayPause.setValue(true);
        this.spinnerPlayPause.setDrawType(TestToggleButton.DrawType.STRING_OR_ICON);
        //this.addAllComponents(new TestAdvancedScreenComponent[]{this.exampleLabel1, this.exitButton, this.prevPageButton, this.nextPageButton, this.pageIndicator});
        //this.addComponent(this.exampleButton, 0);
        //this.addComponent(this.exampleCheckbox, 0);
        //this.addComponent(this.exampleTextField, 0);
        //this.addComponent(this.exampleSlider1, 0);
        //this.addComponent((AdvancedScreenComponent)this.exampleSlider2, 0);
        //this.addComponent(this.exampleToggleButton, 0);
        //this.addComponent((AdvancedScreenComponent)this.drawTypeSlider, 0);
        //this.addComponent((AdvancedScreenComponent)this.beeGif, 0);
        //this.addComponent((AdvancedScreenComponent)this.apple, 0);
        //this.addComponent((AdvancedScreenComponent)this.dynamicImage, 1);
        //this.addComponent(this.urlField, 1);
        //this.addComponent(this.scrollPanel, 2);
        //this.addComponent(this.xSlider, 3);
        //this.addComponent(this.ySlider, 3);
        //this.addComponent(this.contentSlider, 3);
        //this.addComponent((AdvancedScreenComponent)this.spinner, 4);
        //this.addComponent(this.spinnerPlayPause, 4);
        //this.addComponent(this.pBar, 4);
        //this.addComponent(this.pBarSlider, 4);
        //this.addComponent((AdvancedScreenComponent)this.pBarColorSlider, 4);
        //this.addComponent(this.pBarLoader, 4);
        this.scrollPanel.addAllComponents(new TestAdvancedScreenComponent[]{this.scrollButton1, this.scrollButton2, this.scrollTextField/*, this.pikachu*/, this.scrollSlider});
        this.scrollPanel.fitContent();
    }

    @Override
    public void updateGui() {
        this.exampleLabel1.setX(this.width / 2);
        this.nextPageButton.setPosition(this.width - this.nextPageButton.getWidth() - 6, this.height - this.nextPageButton.getComponentHeight() - 15);
        this.prevPageButton.setPosition(6, this.nextPageButton.getY());
        this.pageIndicator.setPosition(this.width / 2, this.height - 13);
        this.pageIndicator.setText("Page " + this.getCurrentPage());
        this.exitButton.setX(this.width - this.exitButton.getWidth() - 6);
        this.exitButton.setY(6);
        //this.apple.setPosition(this.exitButton.getX() - 40, this.exitButton.getY() + 30);
        //this.dynamicImage.setPosition(this.width / 2 - 150, 50);
        //this.urlField.setPosition(this.dynamicImage.getX(), this.dynamicImage.getY() - 30);
        //this.urlField.setWidth(this.dynamicImage.getWidth());
        //this.spinner.setPosition(this.width / 2 - 16, this.pBar.getY() - 50);
        //this.spinnerPlayPause.setPosition(this.spinner.getX() + 32 + 20, this.spinner.getY() + 8);
        //this.pBar.setPosition(this.spinner.getX() - this.pBar.getWidth() / 2, this.height / 2);
        this.pBarSlider.setPosition(this.pBar.getX() + 25, this.pBar.getY() + 40);
        //this.pBarColorSlider.setPosition(this.pBarSlider.getX(), this.pBarSlider.getY() + this.pBarSlider.getComponentHeight() + 4);
        this.pBarLoader.setPosition(this.pBarSlider.getX() - this.pBarLoader.getWidth() - 12, this.pBarSlider.getY() + this.pBarSlider.getComponentHeight() + 4);
    }

    @Override
    public boolean isTopLevelGui() {
        return true;
    }

    @Override
    public boolean doesGuiPauseGame() { return false; }

    @Override
    public boolean doesEscCloseGui() { return true; }

    public static enum ExampleEnum {
        THIS("This", 1.0F),
        IS("is", 100.45F),
        AN("an", -90.0F),
        EXAMPLE("example", 1337.0F),
        SLIDER("slider", -2387.0F),
        WITH("with", 1.0E-9F),
        ENUM("enum", 3.1415927F),
        VALUES("values.", 98234.5F),
        YAAAY("Yaay!", -0.0F);

        private final String name;
        private final float otherValue;

        private ExampleEnum(String name, float someOtherValue) {
            this.name = name;
            this.otherValue = someOtherValue;
        }

        public String getName() {
            return this.name;
        }

        public float getOtherValue() {
            return this.otherValue;
        }
    }
}
