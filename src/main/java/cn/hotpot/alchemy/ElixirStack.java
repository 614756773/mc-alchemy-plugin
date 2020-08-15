package cn.hotpot.alchemy;
import cn.hotpot.enums.ElixirQuality;
import cn.hotpot.enums.ElixirSpecies;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: qinzhu
 * 一堆同品种的丹药
 */
public class ElixirStack {
    @Getter
    private ElixirSpecies species;
    /**
     * key -> 丹药品质
     * value -> 丹药数量
     */
    private Map<ElixirQuality, Integer> map = new HashMap<>();

    public ElixirStack(ElixirSpecies species) {
        this.species = species;
    }

    public Integer getOneSpeciesOfElixirNumber(ElixirQuality elixirQuality) {
        return map.get(elixirQuality);
    }

    public Integer getAllNumber() {
        return map.values().stream().mapToInt(o -> o).sum();
    }

    public void add(ElixirQuality elixirQuality) {
        map.merge(elixirQuality, 1, Integer::sum);
    }
}
