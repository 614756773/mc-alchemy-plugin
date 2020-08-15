package cn.hotpot.alchemy;


import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.level.BaseFireControlLevel;
import cn.hotpot.alchemy.player.AlchemyPlayer;
import cn.hotpot.enums.ElixirQuality;
import cn.hotpot.enums.ElixirSpecies;
import cn.hotpot.global.UserCache;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author: qinzhu
 * 丹药工厂，用于创建丹药
 */
public class ElixirFactory {
    private static final Random RANDOM = new Random();

    private ElixirSpecies elixirSpecies;

    private AlchemyPlayer player;

    public ElixirFactory(ElixirSpecies elixirSpecies, String uid) {
        this.elixirSpecies = elixirSpecies;
        this.player = UserCache.ALCHEMY_PLAYER_MAP.get(uid);
    }

    /**
     * 炼丹
     */
    public ElixirStack produce() {
        ElixirStack result = doProduce(elixirSpecies, player);
        doAfter(result);
        return result;
    }

    private ElixirStack doProduce(ElixirSpecies elixirSpecies, AlchemyPlayer alchemyPlayer) {
        ElixirStack result = new ElixirStack(elixirSpecies);

        BaseFireControlLevel fireControlLevel = alchemyPlayer.getFireControlLevel();
        BaseAlchemyLevel alchemyLevel = alchemyPlayer.getAlchemyLevel();
        Integer maxOutputNum = fireControlLevel.getMaxOutputNum(elixirSpecies);

        for (int i = 0; i < maxOutputNum; i++) {
            // 炼丹失败
            if (alchemyFailed(elixirSpecies, alchemyLevel)) {
                continue;
            }

            // 炼丹成功，下一步确认炼丹的品质
            result.add(determineTheQuality(elixirSpecies, alchemyPlayer.getFireControlLevel()));
        }
        return result;
    }

    /**
     * 炼丹失败
     */
    private boolean alchemyFailed(ElixirSpecies elixirSpecies, BaseAlchemyLevel alchemyLevel) {
        final int threshold = 1000;
        Integer bonus = alchemyLevel.getTheChanceOfSuccessBonus(elixirSpecies);
        Integer chanceOfSuccess = elixirSpecies.getChanceOfSuccess();
        chanceOfSuccess += bonus;
        int r = RANDOM.nextInt(threshold);
        return r >= chanceOfSuccess;
    }

    /**
     * 确定品质
     */
    private ElixirQuality determineTheQuality(ElixirSpecies elixirSpecies, BaseFireControlLevel fireControlLevel) {
        Integer[] rate = ElixirQuality.getQualityRate(elixirSpecies);
        Integer[] bonus = fireControlLevel.getQualityBonus(elixirSpecies);
        for (int i = 0; i < bonus.length; i++) {
            rate[i] += bonus[i];
        }

        int sum = Arrays.stream(rate).mapToInt(e -> e).sum();
        int r = RANDOM.nextInt(sum);
        for (int i = 0; i < rate.length; i++) {
            if (r < rate[i]) {
                return ElixirQuality.qualitySequence[i];
            }
            r -= rate[i];
        }
        throw new RuntimeException("unknown error unable to calculate suitable ElixirQuality");
    }

    /**
     * 炼丹结束后的操作
     */
    private void doAfter(ElixirStack result) {
        addElixirHistory(player, elixirSpecies);
        addFireControlExp(result);
        addAlchemyExp(result);
        tryUpgrade(player);
    }

    /**
     * 添加成功炼制过的丹药种类
     */
    private void addElixirHistory(AlchemyPlayer player, ElixirSpecies elixirSpecies) {
        Set<ElixirSpecies> set = player.getElixirHistory();
        if (set == null) {
            set = new HashSet<>();
            player.setElixirHistory(set);
        }
        set.add(elixirSpecies);
    }

    /**
     * 增加炼丹经验
     */
    private void addAlchemyExp(ElixirStack result) {
        Integer exp = result.getSpecies().getAlchemyExperience(result.getAllNumber() > 0);
        player.setAlchemyExp(player.getAlchemyExp() + exp);
    }

    /**
     * 增加控火经验
     */
    private void addFireControlExp(ElixirStack result) {
        Integer exp = result.getSpecies().getFireControlExperience(result.getAllNumber() > 0);
        player.setFireControlExp(player.getFireControlExp() + exp);
    }

    /**
     * 尝试升级
     * @param player 玩家
     */
    private void tryUpgrade(AlchemyPlayer player) {
        player.getFireControlLevel().tryUpgrade(player);
        player.getAlchemyLevel().tryUpgrade(player);
    }

    private static void asd() {
        // TODO RM
        int[] a = new int[]{100, 20, 30};
        int r = new Random().nextInt(150);
        System.out.println("r是" + r);
        for (int i = 0; i < a.length; i++) {
            if (r < a[i]) {
                System.out.println(i);
                return;
            }
            r -= a[i];
        }
    }
}
