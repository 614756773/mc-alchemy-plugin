package cn.hotpot.alchemy.level;

import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 控火等级
 */
@Data
@RequiredArgsConstructor
public abstract class BaseFireControlLevel implements Level, Comparable<BaseFireControlLevel> {
    private final String title;

    private final BaseFireControlLevel nextLevel;

    @Override
    public void tryUpgrade(AlchemyPlayer player) {
        if (canUpgrade(player)) {
            player.setFireControlLevel(nextLevel);
            player.setFireControlExp(0);
        }
    }

    /**
     * 获得分数，用于比较控火等级
     * 值越大，表示控火等级越高
     */
    public abstract Integer getRank();

    /**
     * @param elixirSpecies 丹药种类
     * @return 最大丹药产出数量
     */
    public abstract Integer getMaxOutputNum(ElixirSpecies elixirSpecies);

    /**
     * 获取炼丹品质加成
     *
     * @param elixirSpecies 丹药种类
     * @return e.g. 返回值为{0,20}，则表示普通品质加成0的权重，饱满品质加成20的权重
     * e.g. 返回值为{0,20,40}，则表示普通品质加成0的权重，饱满品质加成20的权重，极品品质加成40的权重
     */
    public abstract Integer[] getQualityBonus(ElixirSpecies elixirSpecies);

    @Override
    public int compareTo(BaseFireControlLevel other) {
        return this.getRank().compareTo(other.getRank());
    }
}
