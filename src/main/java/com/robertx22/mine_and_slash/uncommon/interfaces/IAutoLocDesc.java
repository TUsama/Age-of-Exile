package com.robertx22.mine_and_slash.uncommon.interfaces;

import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import net.minecraft.text.MutableText;

public interface IAutoLocDesc extends IBaseAutoLoc {

    public default String getDescGroupName() {
        return locDescGroup().name()
            .toUpperCase()
            .replaceAll("_", " ") + " - DESCRIPTIONS";
    }

    public AutoLocGroup locDescGroup();

    String locDescLangFileGUID();

    String locDescForLangFile();

    default boolean shouldRegisterLangDesc() {
        return true;
    }

    public default MutableText locDesc() {
        return CLOC.blank(formattedLocDescLangFileGUID());
    }

    public default String formattedLocDescLangFileGUID() {
        return getPrefix() + getFormatedForLangFile(locDescLangFileGUID());
    }

}

