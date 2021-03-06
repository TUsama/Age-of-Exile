package com.robertx22.mine_and_slash.database.data.rarities;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import com.robertx22.mine_and_slash.database.data.MinMax;
import com.robertx22.mine_and_slash.database.data.rarities.serialization.SerializedBaseRarity;
import com.robertx22.mine_and_slash.database.data.rarities.serialization.SerializedGearRarity;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.IGearPart.Part;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;

import static com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.IGearPart.Part;

public interface GearRarity extends Rarity, SalvagableItem, IStatPercents {

    @Override
    default JsonObject toJson() {

        JsonObject json = this.getRarityJsonObject();

        json.addProperty("affix_chance", AffixChance());
        json.addProperty("unidentified_chance", unidentifiedChance());
        json.addProperty("stat_req_multi", statReqMulti());
        json.addProperty("salvage_lottery_chance", salvageLotteryWinChance());
        json.addProperty("max_affixes", maxAffixes());
        json.addProperty("min_affixes", minAffixes());

        json.addProperty("max_sockets", maxSockets());
        json.addProperty("socket_chance", socketChance());

        json.add("spawn_durability_hit", SpawnDurabilityHit().toJson());
        json.add("unique_stat_percents", uniqueStatPercents().toJson());
        json.add("affix_stat_percents", affixStatPercents().toJson());
        json.add("stat_percents", StatPercents().toJson());

        return json;
    }

    @Override
    default GearRarity fromJson(JsonObject json) {

        SerializedBaseRarity baseRarity = this.baseSerializedRarityFromJson(json);

        SerializedGearRarity rar = new SerializedGearRarity(baseRarity);

        rar.max_sockets = json.get("max_sockets")
            .getAsInt();
        rar.socket_chance = json.get("socket_chance")
            .getAsFloat();

        rar.maxAffixes = json.get("max_affixes")
            .getAsInt();
        rar.minAffixes = json.get("min_affixes")
            .getAsInt();
        rar.affixChance = json.get("affix_chance")
            .getAsInt();
        rar.salvageLotteryChance = json.get("salvage_lottery_chance")
            .getAsInt();
        rar.unidentifiedChance = json.get("unidentified_chance")
            .getAsInt();
        rar.stat_req_multi = json.get("stat_req_multi")
            .getAsFloat();
        rar.spawnDurabilityHit = MinMax.getSerializer()
            .fromJson(json.getAsJsonObject("spawn_durability_hit"));

        rar.statPercents = MinMax.getSerializer()
            .fromJson(json.getAsJsonObject("stat_percents"));

        rar.affixStatPercents = MinMax.getSerializer()
            .fromJson(json.getAsJsonObject("affix_stat_percents"));

        rar.uniqueStatPercents = MinMax.getSerializer()
            .fromJson(json.getAsJsonObject("unique_stat_percents"));

        Preconditions.checkArgument(!StatPercents().isEmpty());

        return rar;
    }

    default MinMax getStatPercentsFor(Part part) {

        if (part == Part.AFFIX) {
            return affixStatPercents();
        } else if (part == Part.UNIQUE_STATS) {
            return uniqueStatPercents();
        } else {
            return StatPercents();
        }
    }

    MinMax SpawnDurabilityHit();

    float statReqMulti();

    MinMax affixStatPercents();

    MinMax uniqueStatPercents();

    int AffixChance();

    int maxAffixes();

    int maxSockets();

    float socketChance();

    int minAffixes();

    default int maximumOfOneAffixType() {
        return maxAffixes() / 2;
    }

    float itemTierPower();

    float unidentifiedChance();
}
