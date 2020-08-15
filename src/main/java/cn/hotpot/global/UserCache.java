package cn.hotpot.global;

import cn.hotpot.alchemy.player.AlchemyPlayer;
import com.google.common.collect.Sets;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: qinzhu
 * @since: 2020/08/09
 */
public class UserCache {
    public static Map<String, Player> USER_MAP = new HashMap<>(32);

    public static Map<String, AlchemyPlayer> ALCHEMY_PLAYER_MAP = new HashMap<>(32);

    public static Set<String> ADMINS = Sets.newHashSet("hotpot");
}
