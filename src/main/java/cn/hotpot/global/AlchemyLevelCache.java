package cn.hotpot.global;

import cn.hotpot.alchemy.level.BaseAlchemyLevel;
import cn.hotpot.alchemy.level.alchemy.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: qinzhu
 * @since: 2020/08/15
 */
public class AlchemyLevelCache {
    public static final Map<Class<? extends BaseAlchemyLevel>, BaseAlchemyLevel> MAP = new HashMap<>(16);

    static {
        Dansheng dansheng = new Dansheng(null);
        Danzun danzun = new Danzun(dansheng);
        Master master = new Master(danzun);
        Danzhe danzhe = new Danzhe(master);
        Apprentice apprentice = new Apprentice(danzhe);
        NoneAlchemyLevel noneAlchemyLevel = new NoneAlchemyLevel(apprentice);

        put(dansheng);
        put(danzun);
        put(master);
        put(danzhe);
        put(apprentice);
        put(noneAlchemyLevel);
    }

    private static void put(BaseAlchemyLevel level) {
        MAP.put(level.getClass(), level);
    }
}
