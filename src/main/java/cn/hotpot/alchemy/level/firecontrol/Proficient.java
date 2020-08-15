package cn.hotpot.alchemy.level.firecontrol;

import cn.hotpot.alchemy.level.BaseFireControlLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 精通
 */
public class Proficient extends BaseFireControlLevel {
    public Proficient(BaseFireControlLevel nextLevel) {
        super("精通", nextLevel);
    }

    @Override
    public Integer getRank() {
        return 4;
    }

    @Override
    public Integer getMaxOutputNum(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 40;
            case LING:
                return 36;
            case QI:
                return 24;
            case DI:
                return 16;
            case TIAN:
                return 11;
            default:
                return 0;
        }
    }

    @Override
    public Integer[] getQualityBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return new Integer[]{40, 24, 16};
            case LING:
                return new Integer[]{48, 20, 12};
            case QI:
                return new Integer[]{50, 20, 10};
            case DI:
                return new Integer[]{52, 22, 6};
            case TIAN:
                return new Integer[]{65, 13, 2};
            default:
                return new Integer[3];
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return false;
    }
}
