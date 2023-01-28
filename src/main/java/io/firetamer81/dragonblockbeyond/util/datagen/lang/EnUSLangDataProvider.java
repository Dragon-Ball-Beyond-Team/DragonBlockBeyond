package io.firetamer81.dragonblockbeyond.util.datagen.lang;

import io.firetamer81.dragonblockbeyond.DragonBlockBeyond;
import net.minecraft.data.DataGenerator;
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
    }

    protected void addItemTranslations() {
        //add(CommonObjects.TEST_ITEM.get(), "Test Item");
        //add(CommonObjects.TEST_BLOCK.get(), "Test Block");
    }

    protected void addBlockTranslations() {
        //add(StrongBlockModule.WARENAI_FULL_BLOCK.get(), "Warenai Full Block");
    }

    protected void addItemGroupTranslations() {
        addItemGroup("dbb_build_tab", "DBB Building Blocks");
        addItemGroup("dbb_environmental_tab", "DBB Flora");
        addItemGroup("dbb_machines_tab", "DBB Machines");
        addItemGroup("dbb_recipe_items_tab", "DBB Recipe Components");
        addItemGroup("dbb_armour_tab", "DBB Armour");
        addItemGroup("dbb_tools_tab", "DBB Tools");
        addItemGroup("dbb_wip_tab", "DBB WIP");
    }

    protected void addGuiTranslations() {
        addGui("useRGB", "Use RGB");
        addGui("useHSB", "Use HSB");
        addGui("red", "Red");
        addGui("green", "Green");
        addGui("blue", "Blue");
        addGui("hue", "Hue");
        addGui("saturation", "Saturation");
        addGui("brightness", "Brightness");
    }


    /****************************************************************/
    //--------------------------------------------------------------//
    /****************************************************************/


    private void addItemGroup(String key, String name) { add("itemGroup." + key, name); }
    private void addGui(String suffix, String text) {
        add("gui." + DragonBlockBeyond.MODID + "." + suffix, text);
    }
}
