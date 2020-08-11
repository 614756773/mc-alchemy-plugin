package cn.hotpot.alchemy;

import cn.hotpot.alchemy.buff.Buff;
import cn.hotpot.enums.ElixirLevel;
import lombok.Data;

/**
 * @author qinzhu
 * 丹药模板
 */
@Data
public class ElixirMetadata {
    protected ElixirMetadata() {}

    /**
     * 名称
     */
    private String name;

    /**
     * 品阶
     */
    private ElixirLevel level;

    /**
     * 效果
     */
    private Buff buff;

    /**
     * 使用何种mc中的实体表示该丹药
     */
    private String entityId;

    /**
     * 成功概率，取值范围[1,100]
     */
    private Integer probabilityOfSuccess;

    /**
     * 炼制的数量
     */
    private Integer number;
}
