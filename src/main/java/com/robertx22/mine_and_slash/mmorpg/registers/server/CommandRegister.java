package com.robertx22.mine_and_slash.mmorpg.registers.server;

import com.mojang.brigadier.CommandDispatcher;
import com.robertx22.mine_and_slash.vanilla_mc.commands.entity.GiveExp;
import com.robertx22.mine_and_slash.vanilla_mc.commands.entity.SetEntityRarity;
import com.robertx22.mine_and_slash.vanilla_mc.commands.entity.SetLevel;
import com.robertx22.mine_and_slash.vanilla_mc.commands.giveitems.GiveExactUnique;
import com.robertx22.mine_and_slash.vanilla_mc.commands.giveitems.GiveGear;
import com.robertx22.mine_and_slash.vanilla_mc.commands.giveitems.GiveSkillGem;
import com.robertx22.mine_and_slash.vanilla_mc.commands.misc.ReloadConfigs;
import com.robertx22.mine_and_slash.vanilla_mc.commands.open_gui.OpenHub;
import com.robertx22.mine_and_slash.vanilla_mc.commands.reset.ResetSpellCooldowns;
import com.robertx22.mine_and_slash.vanilla_mc.commands.stats.ClearStats;
import com.robertx22.mine_and_slash.vanilla_mc.commands.stats.GiveAllStats;
import com.robertx22.mine_and_slash.vanilla_mc.commands.stats.GiveStat;
import com.robertx22.mine_and_slash.vanilla_mc.commands.stats.RemoveStat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;

public class CommandRegister {

    public static void Register(MinecraftServer server) {
        System.out.println("Registering Mine and Slash Commands.");

        CommandDispatcher<ServerCommandSource> dispatcher = server.getCommandManager()
            .getDispatcher();

        GiveSkillGem.register(dispatcher);
        GiveExactUnique.register(dispatcher);
        GiveGear.register(dispatcher);
        SetEntityRarity.register(dispatcher);
        SetLevel.register(dispatcher);
        GiveExp.register(dispatcher);

        ResetSpellCooldowns.register(dispatcher);

        GiveStat.register(dispatcher);
        RemoveStat.register(dispatcher);
        ClearStats.register(dispatcher);
        GiveAllStats.register(dispatcher);

        ReloadConfigs.register(dispatcher);
        OpenHub.register(dispatcher);

    }
}