package com.robertx22.mine_and_slash.mixin_methods;

import com.robertx22.mine_and_slash.capability.entity.EntityCap;
import com.robertx22.mine_and_slash.database.data.currency.base.ICurrencyItemEffect;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.saveclasses.unit.Unit;
import com.robertx22.mine_and_slash.uncommon.datasaving.Gear;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.ICommonDataItem;
import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.TooltipUtils;
import com.robertx22.mine_and_slash.uncommon.wrappers.SText;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TooltipMethod {
    public static void getTooltip(ItemStack stack, PlayerEntity entity, TooltipContext tooltipContext, CallbackInfoReturnable<List<Text>> list) {

        List<Text> tooltip = list.getReturnValue();

        boolean addCurrencyTooltip = stack
            .getItem() instanceof ICurrencyItemEffect;

        PlayerEntity player = MinecraftClient.getInstance().player;

        try {
            if (Screen.hasControlDown()) {
                GearItemData gear = Gear.Load(stack);
                if (gear != null) {
                    return;
                }
            }

            if (player == null || player.world == null) {
                return;
            }

            EntityCap.UnitData unitdata = Load.Unit(player);

            if (unitdata == null) {
                return;
            }

            Unit unit = unitdata.getUnit();

            if (unit == null) {
                return;
            }

            com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipContext ctx = new com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipContext(stack, tooltip, unitdata);

            if (stack.hasTag()) {

                ICommonDataItem data = ICommonDataItem.load(stack);

                if (data != null) {
                    data.BuildTooltip(ctx);
                }

                MutableText broken = TooltipUtils.itemBrokenText(stack, data);
                if (broken != null) {
                    tooltip.add(broken);
                }

                if (data instanceof GearItemData) {
                    List<String> strings = tooltip
                        .stream()
                        .map(x -> CLOC.translate(x))
                        .collect(Collectors.toList());

                    TextRenderer font = MinecraftClient.getInstance().textRenderer;

                    int max = font.getWidth(strings.stream()
                        .max(Comparator.comparingInt(x -> font.getWidth(x)))
                        .get());

                    tooltip.clear();

                    strings.forEach(x -> {

                        String str = x;

                        while (font.getWidth(str) <= max) {
                            str = " " + str + " ";
                        }

                        tooltip
                            .add(new SText(str));

                    });

                }
            }

            if (addCurrencyTooltip) {
                ICurrencyItemEffect currency = (ICurrencyItemEffect) stack
                    .getItem();
                currency.addToTooltip(tooltip);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
