package com.robertx22.mine_and_slash.vanilla_mc.items.misc;

import com.robertx22.mine_and_slash.database.base.CreativeTabs;
import com.robertx22.mine_and_slash.datapacks.models.IAutoModel;
import com.robertx22.mine_and_slash.datapacks.models.ItemModelManager;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocName;
import com.robertx22.mine_and_slash.uncommon.interfaces.IWeighted;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class MagicEssenceItem extends Item implements IAutoLocName, IWeighted, IAutoModel {

    public MagicEssenceItem() {
        super(new Settings().maxCount(64)
            .group(CreativeTabs.MyModTab));
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
        return "Magic Essence";
    }

    @Override
    public String GUID() {
        return "mat/magic_essence";
    }

    @Override
    public int Weight() {
        return 1000;
    }

    @Override
    public void generateModel(ItemModelManager manager) {
        manager.generated(this);
    }
}
