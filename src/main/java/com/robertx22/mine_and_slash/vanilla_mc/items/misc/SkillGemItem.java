package com.robertx22.mine_and_slash.vanilla_mc.items.misc;

import com.robertx22.mine_and_slash.database.base.CreativeTabs;
import com.robertx22.mine_and_slash.datapacks.models.IAutoModel;
import com.robertx22.mine_and_slash.datapacks.models.ItemModelManager;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocName;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class SkillGemItem extends Item implements IAutoModel, IAutoLocName {

    public SkillGemItem() {
        super(new Item.Settings().maxCount(1)
            .maxDamage(0)
            .group(CreativeTabs.MyModTab));
    }

    @Override
    public void generateModel(ItemModelManager manager) {
        manager.generated(this);
    }

    @Override
    public AutoLocGroup locNameGroup() {
        return AutoLocGroup.Misc;
    }

    @Override
    public String locNameLangFileGUID() {
        return Registry.ITEM.getId(this)
            .toString();
    }

    @Override
    public String locNameForLangFile() {
        return "Skill Gem";
    }

    @Override
    public String GUID() {
        return "";
    }
}
