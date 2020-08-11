package cn.hotpot.alchemy;

import com.sun.istack.internal.Nullable;

import java.util.*;

/**
 * @author: qinzhu
 * 丹药工厂，用于创建丹药
 */
public class ElixirFactory {
    private static final Random RANDOM = new Random();

    private ElixirFactory() {}

    /**
     * 炼丹
     * @param elixirMetadata 需要练哪些丹
     * @param uid 用户id
     * @return 丹药
     */
    public static List<ElixirStack> produce(List<ElixirMetadata> elixirMetadata, @Nullable String uid) {
        List<ElixirStack> result = doProduce(elixirMetadata);
        doAfter(result);
        return new ArrayList<>();
    }

    /**
     * 执行炼丹
     */
    private static List<ElixirStack> doProduce(List<ElixirMetadata> metadataList) {
        Map<String, ElixirStack> map = new HashMap<>((int)(metadataList.size() / 0.75) + 1);

        for (ElixirMetadata metadata : metadataList) {
            Integer num = metadata.getNumber();
            Integer probability = metadata.getProbabilityOfSuccess();
            // TODO 优化，如果num大于100，则让前n个100个丹药立马生成
            for (int i = 0; i < num; i++) {
                ElixirStack elixirStack = map.computeIfAbsent(metadata.getName(), key -> new ElixirStack(metadata.getName(), metadata.getLevel()));
                produceOneElixir(probability, elixirStack);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 炼丹结束后的操作
     */
    private static void doAfter(List<ElixirStack> result) {

    }

    /**
     * 生成一颗丹药，可能失败或者成功
     * @param probability 成功概率
     * @param elixirStack 丹药堆
     */
    private static void produceOneElixir(Integer probability, ElixirStack elixirStack) {
        final int limit = 100;
        int v = RANDOM.nextInt(limit) + 1;
        if (v > limit - probability) {
            elixirStack.increaseSuccessNumber();
        } else {
            elixirStack.increaseFailNumber();
        }
    }
}
