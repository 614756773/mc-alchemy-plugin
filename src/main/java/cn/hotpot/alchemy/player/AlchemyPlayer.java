package cn.hotpot.alchemy.player;

import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.level.BaseFireControlLevel;
import cn.hotpot.enums.ElixirSpecies;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.entity.Player;

import java.util.Set;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 */
@Data
@AllArgsConstructor
public class AlchemyPlayer {
    private Player originalPlayer;

    /**
     * 驭火等级
     */
    private BaseFireControlLevel fireControlLevel;

    /**
     * 驭火经验
     */
    private Integer fireControlExp;

    /**
     * 炼丹等级
     */
    private BaseAlchemyLevel alchemyLevel;

    /**
     * 炼丹经验
     */
    private Integer alchemyExp;

    /**
     * 炼制过的丹药种类
     */
    private Set<ElixirSpecies> elixirHistory;

    public boolean elixirHistoryContains(ElixirSpecies species) {
        return elixirHistory != null && elixirHistory.contains(species);
    }
}
