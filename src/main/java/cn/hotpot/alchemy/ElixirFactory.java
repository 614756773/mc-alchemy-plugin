package cn.hotpot.alchemy;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: qinzhu
 * 丹药工厂，用于创建丹药
 */
public class ElixirFactory {
    private ElixirFactory() {}

    /**
     * 炼丹
     * @param elixirMetadata 需要练哪些丹
     * @param uid 用户id
     * @return 丹药
     */
    public static List<Elixir> produce(List<ElixirMetadata> elixirMetadata, @Nullable String uid) {
        List<Elixir> result = doProduce(elixirMetadata);
        doAfter(result);
        return new ArrayList<>();
    }

    /**
     * 执行炼丹
     */
    private static List<Elixir> doProduce(List<ElixirMetadata> elixirMetadata) {
        // TODO
        return new ArrayList<>();
    }

    /**
     * 炼丹结束后的操作
     */
    private static void doAfter(List<Elixir> result) {
    }
}
