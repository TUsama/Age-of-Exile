package com.robertx22.mine_and_slash.mmorpg.registers.common;

import com.robertx22.mine_and_slash.database.data.spells.blocks.holy_flower.HolyFlowerTileEntity;
import com.robertx22.mine_and_slash.database.data.spells.blocks.magma_flower.MagmaFlowerTileEntity;
import com.robertx22.mine_and_slash.database.data.spells.blocks.thorn_bush.ThornBushTileEntity;
import com.robertx22.mine_and_slash.mmorpg.ModRegistry;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.item_modify_station.TileGearModify;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.repair_station.TileGearRepair;
import com.robertx22.mine_and_slash.vanilla_mc.blocks.salvage_station.TileGearSalvage;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class BlockEntities {

    public BlockEntityType<TileGearModify> GEAR_MODIFY = of(ModRegistry.BLOCKS.GEAR_MODIFY, TileGearModify::new);
    public BlockEntityType<TileGearModify> GEAR_REPAIR = of(ModRegistry.BLOCKS.GEAR_REPAIR, TileGearRepair::new);
    public BlockEntityType<TileGearModify> GEAR_SALVAGE = of(ModRegistry.BLOCKS.GEAR_SALVAGE, TileGearSalvage::new);
    public BlockEntityType<TileGearModify> MAGMA_FLOWER = of(ModRegistry.BLOCKS.MAGMA_FLOWER, MagmaFlowerTileEntity::new);
    public BlockEntityType<TileGearModify> HOLY_FLOWER = of(ModRegistry.BLOCKS.HOLY_FLOWER, HolyFlowerTileEntity::new);
    public BlockEntityType<TileGearModify> THORN_BUSH = of(ModRegistry.BLOCKS.THORN_BUSH, ThornBushTileEntity::new);

    private <T extends BlockEntity> BlockEntityType<T> of(Block block, Supplier<BlockEntity> en) {

        BlockEntityType<T> type = (BlockEntityType<T>) BlockEntityType.Builder.create(en, block)
            .build(null); // todo unsure if this cast works

        return Registry.register(Registry.BLOCK_ENTITY_TYPE, Registry.BLOCK.getId(block)
            .toString(), type);

    }
}
