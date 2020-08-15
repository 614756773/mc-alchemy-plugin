package cn.hotpot.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinzhu
 * 丹药品质
 */
public enum ElixirQuality {
    /**
     * 普通
     */
    ORDINARY,

    /**
     * 饱满
     */
    FULL,

    /**
     * 完美
     */
    PERFECT,

    /**
     * 极品
     */
    BEST,

    /**
     * 绝世
     */
    PEERLESS;

    public final static ElixirQuality[] qualitySequence = new ElixirQuality[]{ORDINARY, FULL, PERFECT, BEST, PEERLESS};

    /**
     * 各种丹药生成不同品质的比例
     */
    private static final Map<ElixirSpecies, Integer[]> map;

    static {
        map = new HashMap<>(16);
        map.put(ElixirSpecies.FAN, new Integer[]{200, 150, 30, 20, 0});
        map.put(ElixirSpecies.LING, new Integer[]{180, 130, 25, 15, 0});
        map.put(ElixirSpecies.QI, new Integer[]{160, 110, 20, 10, 0});
        map.put(ElixirSpecies.DI, new Integer[]{140, 90, 12, 5, 3});
        map.put(ElixirSpecies.TIAN, new Integer[]{120, 70, 5, 4, 1});
    }

    /**
     * @param elixirSpecies 丹药种类
     * @return e.g.
     * 返回的数组是{200, 150, 30, 20, 0}，
     * 则表示普通品质占200权重，饱满占150权重，完美占30权重，极品占20权重，绝世占0权重
     */
    public static Integer[] getQualityRate(ElixirSpecies elixirSpecies) {
        return map.get(elixirSpecies);
    }
}
