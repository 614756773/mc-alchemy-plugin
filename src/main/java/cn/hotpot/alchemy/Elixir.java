package cn.hotpot.alchemy;

import cn.hotpot.enums.ElixirLevel;
import lombok.Data;

/**
 * @author: qinzhu
 * 丹药
 */
@Data
public class Elixir {
    protected Elixir() {}

    /**
     * 丹药名称
     */
    private String name;

    /**
     * 丹药品阶
     */
    private ElixirLevel level;

    /**
     * true表示炼丹成功
     */
    private Boolean created;
}
