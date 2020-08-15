package cn.hotpot.alchemy.level.alchemy;

import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.level.firecontrol.Beginner;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;
import cn.hotpot.global.FireLevelCache;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 丹者
 */
public class Danzhe extends BaseAlchemyLevel {
    public Danzhe(BaseAlchemyLevel nextLevel) {
        super("丹者", nextLevel);
    }

    @Override
    public Integer getTheChanceOfSuccessBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 150;
            case LING:
                return 70;
            default:
                return 0;
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getAlchemyExp() >= 5000
                && player.getFireControlLevel().compareTo(FireLevelCache.MAP.get(Beginner.class)) >= 0
                && player.elixirHistoryContains(ElixirSpecies.QI);
    }
}
