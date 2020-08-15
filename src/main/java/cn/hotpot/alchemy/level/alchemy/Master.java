package cn.hotpot.alchemy.level.alchemy;

import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.level.firecontrol.Skilled;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;
import cn.hotpot.global.FireLevelCache;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 丹师
 */
public class Master extends BaseAlchemyLevel {
    public Master(BaseAlchemyLevel nextLevel) {
        super("丹师", nextLevel);
    }

    @Override
    public Integer getTheChanceOfSuccessBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 200;
            case LING:
                return 140;
            case QI:
                return 90;
            default:
                return 0;
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getAlchemyExp() >= 10000
                && player.getFireControlLevel().compareTo(FireLevelCache.MAP.get(Skilled.class)) >= 0
                && player.elixirHistoryContains(ElixirSpecies.DI);
    }
}
