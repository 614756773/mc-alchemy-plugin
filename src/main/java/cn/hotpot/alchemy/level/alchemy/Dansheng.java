package cn.hotpot.alchemy.level.alchemy;

import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 圣
 */
public class Dansheng extends BaseAlchemyLevel {
    public Dansheng(BaseAlchemyLevel nextLevel) {
        super("圣", nextLevel);
    }

    @Override
    public Integer getTheChanceOfSuccessBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 300;
            case LING:
                return 280;
            case QI:
                return 270;
            case DI:
                return 260;
            case TIAN:
                return 240;
            default:
                return 0;
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return false;
    }
}
