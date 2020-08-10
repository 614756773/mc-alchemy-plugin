package cn.hotpot.global;

import com.google.common.collect.Sets;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: qinzhu
 * @since: 2020/08/09
 */
public class Cache {
    public static Map<String, Player> USER_MAP = new HashMap<>(32);

    public static Set<String> ADMINS = Sets.newHashSet("hotpot");
}
