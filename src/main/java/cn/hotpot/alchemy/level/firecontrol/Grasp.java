package cn.hotpot.alchemy.level.firecontrol;

import cn.hotpot.alchemy.level.BaseFireControlLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 掌握
 */
public class Grasp extends BaseFireControlLevel {
    public Grasp(BaseFireControlLevel nextLevel) {
        super("掌握", nextLevel);
    }

    @Override
    public Integer getRank() {
        return 3;
    }

    @Override
    public Integer getMaxOutputNum(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 36;
            case LING:
                return 32;
            case QI:
                return 20;
            case DI:
                return 12;
            case TIAN:
                return 5;
            default:
                return 0;
        }
    }

    @Override
    public Integer[] getQualityBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return new Integer[]{32, 20, 14};
            case LING:
                return new Integer[]{37, 17, 10};
            case QI:
                return new Integer[]{40, 16, 8};
            case DI:
                return new Integer[]{46, 14, 4};
            case TIAN:
                return new Integer[]{54, 9, 1};
            default:
                return new Integer[3];
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getFireControlExp() >= 150;
    }
}
