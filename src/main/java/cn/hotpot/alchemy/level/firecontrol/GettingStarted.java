package cn.hotpot.alchemy.level.firecontrol;

import cn.hotpot.alchemy.level.BaseFireControlLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 入门
 */
public class GettingStarted extends BaseFireControlLevel {
    public GettingStarted(BaseFireControlLevel nextLevel) {
        super("入门", nextLevel);
    }

    @Override
    public Integer getRank() {
        return 0;
    }

    @Override
    public Integer getMaxOutputNum(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return 25;
            case LING:
                return 20;
            default:
                return 0;
        }
    }

    @Override
    public Integer[] getQualityBonus(ElixirSpecies elixirSpecies) {
        switch (elixirSpecies) {
            case FAN:
                return new Integer[]{10, 6};
            case LING:
                return new Integer[]{12, 4};
            default:
                return new Integer[2];
        }
    }

    @Override
    public boolean canUpgrade(AlchemyPlayer player) {
        return player.getFireControlExp() >= 10;
    }
}
