package com.robertx22.mine_and_slash.mmorpg.registers.common.items;

import com.robertx22.mine_and_slash.database.data.currency.*;
import com.robertx22.mine_and_slash.database.data.currency.base.CurrencyItem;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class CurrencyItemRegistrator extends BaseItemRegistrator {

    public List<CurrencyItem> currencies = new ArrayList<>();

    public CurrencyItem ORB_OF_TRANSMUTATION = of(new OrbOfTransmutationItem());
    public CurrencyItem ORB_OF_DISORDER = of(new OrbOfDisorder());
    public CurrencyItem ORB_OF_TURBULENCE = of(new OrbOfTurbulence());
    public CurrencyItem STONE_OF_HOPE = of(new StoneOfHopeItem());
    public CurrencyItem LEAF_OF_CHANGE = of(new LeafOfChangeItem());
    public CurrencyItem ORB_OF_BLESSING = of(new OrbOfBlessingItem());
    public CurrencyItem ORB_OF_UNIQUE_BLESSING = of(new OrbOfUniqueBlessingItem());

    CurrencyItem of(CurrencyItem c) {
        Registry.register(Registry.ITEM, new Identifier(Ref.MODID, c.GUID()), c);

        currencies.add(c);

        return c;

    }

}
