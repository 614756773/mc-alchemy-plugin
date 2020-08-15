package cn.hotpot.alchemy.level.alchemy;

import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 学徒士
 */
public class Apprentice extends BaseAlchemyLevel {
    public Apprentice(BaseAlchemyLevel nextLevel) {
        super("学徒士", nextLevel);
    }

    @Override
    public Integer getTheChanceOfSuccessBonus(ElixirSpecies elixirSpecies) {
        return elixirSpecies == ElixirSpecies.FAN ? 100 : 0;
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getAlchemyExp() >= 3000
                && player.elixirHistoryContains(ElixirSpecies.LING);
    }
}
