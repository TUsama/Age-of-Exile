package com.robertx22.mine_and_slash.vanilla_mc.packets;

import com.robertx22.mine_and_slash.config.forge.ModConfig;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class NoManaPacket extends MyPacket<NoManaPacket> {

    @Override
    public Identifier getIdentifier() {
        return new Identifier(Ref.MODID, "nomana");
    }

    @Override
    public void loadFromData(PacketByteBuf tag) {

    }

    @Override
    public void saveToData(PacketByteBuf tag) {

    }

    @Override
    public void onReceived(PacketContext ctx) {
        if (ModConfig.get().client.SHOW_LOW_ENERGY_MANA_WARNING) {

            PlayerEntity player = ctx.getPlayer();
            player.playSound(SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT, 0.5F, 0);

        }
    }

    @Override
    public MyPacket<NoManaPacket> newInstance() {
        return new NoManaPacket();
    }

    public enum MessageTypes {
        NoEnergy,
        NoMana
    }

    public NoManaPacket() {
    }

}