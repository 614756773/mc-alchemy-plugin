package cn.hotpot.alchemy.level.firecontrol;

import cn.hotpot.alchemy.level.BaseFireControlLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 初学
 */
public class Beginner extends BaseFireControlLevel {
    public Beginner(BaseFireControlLevel nextLevel) {
        super("初学", nextLevel);
    }

    @Override
    public Integer getRank() {
        return 1;
    }

    @Override
    public Integer getMaxOutputNum(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 28;
            case LING:
                return 24;
            case QI:
                return 15;
            default:
                return 0;
        }
    }

    @Override
    public Integer[] getQualityBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return new Integer[]{13, 10, 9};
            case LING:
                return new Integer[]{18, 8, 6};
            case QI:
                return new Integer[]{20, 8, 4};
            default:
                return new Integer[3];
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getFireControlExp() >= 50;
    }
}
