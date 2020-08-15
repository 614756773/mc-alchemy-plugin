package cn.hotpot.alchemy.level.alchemy;

import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.level.firecontrol.Grasp;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;
import cn.hotpot.global.FireLevelCache;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 尊
 */
public class Danzun extends BaseAlchemyLevel {
    public Danzun(BaseAlchemyLevel nextLevel) {
        super("尊", nextLevel);
    }

    @Override
    public Integer getTheChanceOfSuccessBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 250;
            case LING:
                return 210;
            case QI:
                return 180;
            case DI:
                return 130;
            default:
                return 0;
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getAlchemyExp() >= 50000
                && player.getFireControlLevel().compareTo(FireLevelCache.MAP.get(Grasp.class)) >= 0
                && player.elixirHistoryContains(ElixirSpecies.TIAN);
    }
}
