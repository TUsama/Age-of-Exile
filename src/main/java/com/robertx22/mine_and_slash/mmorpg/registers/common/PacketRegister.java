package com.robertx22.mine_and_slash.mmorpg.registers.common;

import com.robertx22.mine_and_slash.mmorpg.Packets;
import com.robertx22.mine_and_slash.vanilla_mc.packets.RequestTilePacket;
import com.robertx22.mine_and_slash.vanilla_mc.packets.SpendStatPointsPacket;
import com.robertx22.mine_and_slash.vanilla_mc.packets.spells.CastSpellPacket;
import com.robertx22.mine_and_slash.vanilla_mc.packets.spells.HotbarSetupPacket;
import com.robertx22.mine_and_slash.vanilla_mc.packets.sync_cap.RequestSyncCapToClient;

public class PacketRegister {

    public static void register() {

        Packets.registerClientToServerPacket(new RequestTilePacket());
        Packets.registerClientToServerPacket(new RequestSyncCapToClient());
        Packets.registerClientToServerPacket(new SpendStatPointsPacket());
        Packets.registerClientToServerPacket(new HotbarSetupPacket());
        Packets.registerClientToServerPacket(new CastSpellPacket());

    }

}


