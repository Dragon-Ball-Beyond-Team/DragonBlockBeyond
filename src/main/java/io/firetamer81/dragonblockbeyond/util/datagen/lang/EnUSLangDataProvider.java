package io.firetamer81.dragonblockbeyond.util.datagen.lang;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import io.firetamer81.dragonblockbeyond.init.handlers.KeyBindHandler;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EnUSLangDataProvider extends LanguageProvider {

    public EnUSLangDataProvider(PackOutput output) {
        super(output, DragonBlockBeyond.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //addItemTranslations();
        //addBlockTranslations();
        addItemGroupTranslations();
        //addGuiTranslations();
        addKeyBindTranslations();
    }

    protected void addItemTranslations() {
        //add(CommonObjects.TEST_ITEM.get(), "Test Item");
        //add(CommonObjects.TEST_BLOCK.get(), "Test Block");
    }

    protected void addBlockTranslations() {
        //add(StrongBlockModule.WARENAI_FULL_BLOCK.get(), "Warenai Full Block");
    }

    protected void addItemGroupTranslations() {
        addItemGroupTranslation("dbb_build_tab", "DBB Building Blocks");
        addItemGroupTranslation("dbb_environmental_tab", "DBB Flora");
        addItemGroupTranslation("dbb_machines_tab", "DBB Machines");
        addItemGroupTranslation("dbb_recipe_items_tab", "DBB Recipe Components");
        addItemGroupTranslation("dbb_armour_tab", "DBB Armour");
        addItemGroupTranslation("dbb_tools_tab", "DBB Tools");
        addItemGroupTranslation("dbb_wip_tab", "DBB WIP");
    }

    protected void addGuiTranslations() {
        //addGui("useRGB", "Use RGB");
        //addGui("useHSB", "Use HSB");
        //addGui("red", "Red");
        //addGui("green", "Green");
        //addGui("blue", "Blue");
        //addGui("hue", "Hue");
        //addGui("saturation", "Saturation");
        //addGui("brightness", "Brightness");
    }


    protected void addKeyBindTranslations () {
        //Keybind Category
        add("key.category.dragonblockbeyond.keybinds", "Keybinds");

        //Keybinds
        add(KeyBindHandler.TEST_KEYBIND_KEYSTRING, "Test Key");
    }


    /****************************************************************/
    //--------------------------------------------------------------//
    /****************************************************************/


    private void addItemGroupTranslation(String key, String name) {
        add("itemGroup." + key, name);
    }

    private void addGuiTranslation(String suffix, String text) {
        add("gui." + DragonBlockBeyond.MODID + "." + suffix, text);
    }
}
