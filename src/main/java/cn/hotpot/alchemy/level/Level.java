package cn.hotpot.alchemy.level;

import cn.hotpot.alchemy.player.AlchemyPlayer;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 */
public interface Level {
    /**
     * 称号
     */
    String getTitle();

    /**
     * 下一等级
     */
    Level getNextLevel();

    /**
     * 尝试升级
     */
    void tryUpgrade(AlchemyPlayer player);

    /**
     * 能否升级到下一级
     * @param player 玩家
     */
    boolean canUpgrade(AlchemyPlayer player);
}
