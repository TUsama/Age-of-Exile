package com.robertx22.mine_and_slash.mmorpg.registers.client;

import com.robertx22.mine_and_slash.mmorpg.ModRegistry;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.item_modify_station.ContainerGearModify;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.item_modify_station.GuiGearModify;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.repair_station.ContainerGearRepair;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.repair_station.GuiGearRepair;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.salvage_station.ContainerGearSalvage;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.salvage_station.GuiGearSalvage;
import net.fabricmc.fabric.api.client.screen.ScreenProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

public class ContainerGuiRegisters {

    public static void reg() {

        ScreenProviderRegistry.INSTANCE.<ContainerGearModify>registerFactory(ModRegistry.CONTAINERS.GEAR_MODIFY, x -> new GuiGearModify(x, MinecraftClient.getInstance().player.inventory, new LiteralText("")));
        ScreenProviderRegistry.INSTANCE.<ContainerGearRepair>registerFactory(ModRegistry.CONTAINERS.GEAR_REPAIR, x -> new GuiGearRepair(x, MinecraftClient.getInstance().player.inventory, new LiteralText("")));
        ScreenProviderRegistry.INSTANCE.<ContainerGearSalvage>registerFactory(ModRegistry.CONTAINERS.GEAR_SALVAGE, x -> new GuiGearSalvage(x, MinecraftClient.getInstance().player.inventory, new LiteralText("")));

    }

}
