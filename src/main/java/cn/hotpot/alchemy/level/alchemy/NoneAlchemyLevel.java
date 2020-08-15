package cn.hotpot.alchemy.level.alchemy;

import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 初始炼丹等级
 */
public class NoneAlchemyLevel extends BaseAlchemyLevel {
    public NoneAlchemyLevel(BaseAlchemyLevel nextLevel) {
        super("平民", nextLevel);
    }

    @Override
    public Integer getTheChanceOfSuccessBonus(ElixirSpecies elixirSpecies) {
        return 0;
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getAlchemyExp() > 0
                && player.elixirHistoryContains(ElixirSpecies.FAN);
    }
}
