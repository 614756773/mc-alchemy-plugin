package cn.hotpot.global;

import cn.hotpot.alchemy.level.BaseFireControlLevel;
import cn.hotpot.alchemy.level.firecontrol.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 */
public class FireLevelCache {
    public static final Map<Class<? extends BaseFireControlLevel>, BaseFireControlLevel> MAP = new HashMap<>(16);

    static {
        Proficient proficient = new Proficient(null);
        Grasp grasp = new Grasp(proficient);
        Skilled skilled = new Skilled(grasp);
        Beginner beginner = new Beginner(skilled);
        GettingStarted gettingStarted = new GettingStarted(beginner);
        put(proficient);
        put(grasp);
        put(skilled);
        put(beginner);
        put(gettingStarted);
    }

    private static void put(BaseFireControlLevel fireControlLevel) {
        MAP.put(fireControlLevel.getClass(), fireControlLevel);
    }
}
