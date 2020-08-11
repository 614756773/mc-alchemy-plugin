package cn.hotpot.alchemy;

import cn.hotpot.enums.ElixirLevel;
import lombok.Data;

/**
 * @author: qinzhu
 * 一堆同类型的丹药
 */
@Data
public class ElixirStack {
    protected ElixirStack() {
    }

    public ElixirStack(String name, ElixirLevel level) {
        this.name = name;
        this.level = level;
    }

    /**
     * 丹药名称
     */
    private String name;

    /**
     * 丹药品阶
     */
    private ElixirLevel level;

    /**
     * 成功数量
     */
    private Integer successNumber;

    /**
     * 失败数量
     */
    private Integer failNumber;

    /**
     * 所有丹药数量
     */
    public int getAllNumber() {
        return successNumber + failNumber;
    }

    public void increaseSuccessNumber() {
        this.successNumber++;
    }

    public void increaseFailNumber() {
        this.failNumber++;
    }
}
