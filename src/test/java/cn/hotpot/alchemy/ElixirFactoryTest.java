package cn.hotpot.alchemy;


import cn.hotpot.alchemy.level.alchemy.Dansheng;
import cn.hotpot.alchemy.level.firecontrol.Proficient;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirQuality;
import cn.hotpot.enums.ElixirSpecies;
import cn.hotpot.global.AlchemyLevelCache;
import cn.hotpot.global.FireLevelCache;
import cn.hotpot.global.UserCache;

import java.util.HashSet;

public class ElixirFactoryTest {
    public static void main(String[] args) {
        AlchemyPlayer player = new AlchemyPlayer(null,
                FireLevelCache.MAP.get(Proficient.class),
                0,
                AlchemyLevelCache.MAP.get(Dansheng.class),
                0,
                new HashSet<>());
        UserCache.ALCHEMY_PLAYER_MAP.put("hotpot", player);

        ElixirSpecies species = ElixirSpecies.TIAN;
        ElixirFactory factory = new ElixirFactory(species, "hotpot");
        ElixirStack stack = factory.produce();
        System.out.println(String.format("炼制%s丹共计%d颗", species.toString(), stack.getAllNumber()));
        System.out.println();
        for (ElixirQuality value : ElixirQuality.values()) {
            Integer v = stack.getOneSpeciesOfElixirNumber(value);
            if (v != null) {
                System.out.println(String.format("%s品质的有%d颗", value.toString(), v));
            }
        }
    }
}
