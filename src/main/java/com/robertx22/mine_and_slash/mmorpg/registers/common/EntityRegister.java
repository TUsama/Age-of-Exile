package com.robertx22.mine_and_slash.mmorpg.registers.common;

import com.robertx22.mine_and_slash.database.data.spells.entities.cloud.ArrowStormEntity;
import com.robertx22.mine_and_slash.database.data.spells.entities.cloud.BlizzardEntity;
import com.robertx22.mine_and_slash.database.data.spells.entities.cloud.ThunderstormEntity;
import com.robertx22.mine_and_slash.database.data.spells.entities.cloud.VolcanoEntity;
import com.robertx22.mine_and_slash.database.data.spells.entities.proj.*;
import com.robertx22.mine_and_slash.database.data.spells.entities.single_target_bolt.FireballEntity;
import com.robertx22.mine_and_slash.database.data.spells.entities.single_target_bolt.FrostballEntity;
import com.robertx22.mine_and_slash.database.data.spells.entities.single_target_bolt.PoisonBallEntity;
import com.robertx22.mine_and_slash.database.data.spells.entities.trident.SpearOfJudgementEntity;
import com.robertx22.mine_and_slash.database.data.spells.entities.trident.ThunderspearEntity;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedList;
import java.util.List;

public class EntityRegister {

    public List<EntityType<? extends Entity>> ENTITY_TYPES = new LinkedList();
    public List<EntityType<? extends Entity>> ENTITY_THAT_USE_ITEM_RENDERS = new LinkedList();

    public EntityType<ThunderstormEntity> THUNDERSTORM = projectile(ThunderstormEntity::new, "thunderstorm");
    public EntityType<TridentEntity> THUNDER_SPEAR = projectile(ThunderspearEntity::new, "thunder_spear", false);
    public EntityType<SpearOfJudgementEntity> HOLY_SPEAR = projectile(SpearOfJudgementEntity::new, "holy_spear", false);
    public EntityType<LightningTotemEntity> LIGHTNING_TOTEM = projectile(LightningTotemEntity::new, "lightning_totem");

    public EntityType<FireballEntity> FIREBOLT = projectile(FireballEntity::new, "fireball");
    public EntityType<FireBombEntity> FIRE_BOMB = projectile(FireBombEntity::new, "fire_bomb");
    public EntityType<ThrowFlameEntity> THROW_FLAMES = projectile(ThrowFlameEntity::new, "seeker_flame");
    public EntityType<VolcanoEntity> VOLCANO = projectile(VolcanoEntity::new, "volcano");
    public EntityType<PoisonBallEntity> POISON_BALL = projectile(PoisonBallEntity::new, "poison_ball");

    public EntityType<FrostballEntity> FROSTBOLT = projectile(FrostballEntity::new, "frostball");
    public EntityType<WhirlpoolEntity> WHIRPOOL = projectile(WhirlpoolEntity::new, "whirlpool");
    public EntityType<BlizzardEntity> BLIZZARD = projectile(BlizzardEntity::new, "blizzard");
    public EntityType<TidalWaveEntity> TIDAL_WAVE = projectile(TidalWaveEntity::new, "tidal_wave");

    public EntityType<RangerArrowEntity> RANGER_ARROW = projectile(RangerArrowEntity::new, "ranger_arrow");
    public EntityType<ArrowStormEntity> ARROW_STORM = projectile(ArrowStormEntity::new, "arrow_storm");

    public EntityType<SeedEntity> SEED = projectile(SeedEntity::new, "seed_entity");

    private <T extends Entity> EntityType<T> projectile(EntityType.EntityFactory<T> factory,
                                                        String id) {
        return projectile(factory, id, true);

    }

    private <T extends Entity> EntityType<T> projectile(EntityType.EntityFactory<T> factory,
                                                        String id, boolean itemRender) {

        EntityType<T> type = FabricEntityTypeBuilder.<T>create(SpawnGroup.MISC, factory).dimensions(new EntityDimensions(0.5F, 0.5F, true))
            .build();

        Registry.register(Registry.ENTITY_TYPE, new Identifier(Ref.MODID, id), type);

        ENTITY_TYPES.add(type);

        if (itemRender) {
            ENTITY_THAT_USE_ITEM_RENDERS.add(type);
        }

        return type;
    }

}


