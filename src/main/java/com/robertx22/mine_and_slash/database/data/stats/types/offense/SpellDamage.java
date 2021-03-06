package com.robertx22.mine_and_slash.database.data.stats.types.offense;

import com.robertx22.mine_and_slash.database.data.stats.Stat;
import com.robertx22.mine_and_slash.database.data.stats.StatScaling;
import com.robertx22.mine_and_slash.database.data.stats.effects.offense.AllSpellDamageEffect;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffect;
import com.robertx22.mine_and_slash.uncommon.interfaces.IStatEffects;
import net.minecraft.util.Formatting;

public class SpellDamage extends Stat implements IStatEffects {

    private SpellDamage() {

    }

    @Override
    public StatScaling getScaling() {
        return StatScaling.SLOW_SCALING;
    }

    public static String GUID = "spell_damage";

    public static SpellDamage getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public String getIconPath() {
        return "spell_dmg";
    }

    @Override
    public Formatting getIconFormat() {
        return Formatting.GOLD;
    }

    @Override
    public String getIcon() {
        return "\u262F";
    }

    @Override
    public String locDescForLangFile() {
        return "Increases DMG of all spells no matter the element";
    }

    @Override
    public StatGroup statGroup() {
        return StatGroup.SpellDamage;
    }

    @Override
    public String GUID() {
        return GUID;
    }

    @Override
    public Elements getElement() {
        return null;
    }

    @Override
    public boolean IsPercent() {
        return true;
    }

    @Override
    public IStatEffect getEffect() {
        return AllSpellDamageEffect.INSTANCE;
    }

    @Override
    public String locNameForLangFile() {
        return "Spell Damage";
    }

    private static class SingletonHolder {
        private static final SpellDamage INSTANCE = new SpellDamage();
    }
}
