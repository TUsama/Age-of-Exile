package com.robertx22.mine_and_slash.database.data.unique_items.weapons.wand;

import com.robertx22.mine_and_slash.database.data.StatModifier;
import com.robertx22.mine_and_slash.database.data.gearitemslots.bases.BaseGearType;
import com.robertx22.mine_and_slash.database.data.gearitemslots.weapons.melee.SageWand;
import com.robertx22.mine_and_slash.database.data.stats.types.generated.ChanceToApplyEffect;
import com.robertx22.mine_and_slash.database.data.stats.types.generated.WeaponDamage;
import com.robertx22.mine_and_slash.database.data.unique_items.IUnique;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.ModType;

import java.util.Arrays;
import java.util.List;

public class EyeOfZegrathWand implements IUnique {

    @Override
    public List<StatModifier> uniqueStats() {
        return Arrays.asList(
            new StatModifier(10, 30, new WeaponDamage(Elements.Physical), ModType.LOCAL_INCREASE),
            new StatModifier(5, 10, ChanceToApplyEffect.BURN, ModType.FLAT),
            new StatModifier(5, 10, ChanceToApplyEffect.CHILL, ModType.FLAT),
            new StatModifier(5, 10, ChanceToApplyEffect.POISON, ModType.FLAT)
        );
    }

    @Override
    public String locDescForLangFile() {
        return "A cultist once so powerful, even his remnant eye inflicts ills on others.";
    }

    @Override
    public String locNameForLangFile() {
        return "Eye of Zegrath";
    }

    @Override
    public String GUID() {
        return "eye_of_zegrath";
    }

    @Override
    public BaseGearType getBaseGearType() {
        return SageWand.INSTANCE;
    }
}
