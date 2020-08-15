package cn.hotpot.alchemy.level;

import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirSpecies;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 * 炼丹等级
 */
@Data
@RequiredArgsConstructor
public abstract class BaseAlchemyLevel implements Level {
    private final String title;

    private final BaseAlchemyLevel nextLevel;

    @Override
    public void tryUpgrade(AlchemyPlayer player) {
        if (canUpgrade(player)) {
            player.setAlchemyLevel(nextLevel);
            player.setAlchemyExp(0);
        }
    }

    /**
     * 获得炼丹成功几率加成
     *
     * @param elixirSpecies 丹药种类
     * @return 返回值范围[0, 1000] e.g. 返回50表示成功几率增加千分之五十
     */
    public abstract Integer getTheChanceOfSuccessBonus(ElixirSpecies elixirSpecies);
}
