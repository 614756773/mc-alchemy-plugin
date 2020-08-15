package cn.hotpot.alchemy.level.firecontrol;

import cn.hotpot.alchemy.level.BaseFireControlLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 熟练
 */
public class Skilled extends BaseFireControlLevel {
    public Skilled(BaseFireControlLevel nextLevel) {
        super("熟练", nextLevel);
    }

    @Override
    public Integer getRank() {
        return 2;
    }

    @Override
    public Integer getMaxOutputNum(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 32;
            case LING:
                return 28;
            case QI:
                return 18;
            case DI:
                return 10;
            default:
                return 0;
        }
    }

    @Override
    public Integer[] getQualityBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return new Integer[]{20, 16, 12};
            case LING:
                return new Integer[]{28, 12, 8};
            case QI:
                return new Integer[]{32, 10, 6};
            case DI:
                return new Integer[]{38, 8, 2};
            default:
                return new Integer[3];
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getFireControlExp() >= 100;
    }
}
