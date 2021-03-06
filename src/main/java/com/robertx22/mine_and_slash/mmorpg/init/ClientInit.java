package com.robertx22.mine_and_slash.mmorpg.init;

import com.robertx22.mine_and_slash.mmorpg.event_registers.Client;
import com.robertx22.mine_and_slash.mmorpg.registers.client.ClientSetup;
import com.robertx22.mine_and_slash.mmorpg.registers.client.KeybindsRegister;
import com.robertx22.mine_and_slash.mmorpg.registers.client.ParticleFactoryRegister;
import net.fabricmc.api.ClientModInitializer;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ClientSetup.setup();

        KeybindsRegister.register();
        Client.register();

        ParticleFactoryRegister.register();

    }
}
