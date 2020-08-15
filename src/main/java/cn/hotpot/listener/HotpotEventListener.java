package cn.hotpot.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

import static cn.hotpot.global.UserCache.ADMINS;
import static cn.hotpot.global.UserCache.USER_MAP;


/**
 * @author: qinzhu
 * @since: 2020/08/09
 */
public class HotpotEventListener implements Listener {

    @EventHandler
    public void login(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        USER_MAP.put(player.getName(), player);
        if (ADMINS.contains(player.getName())) {
            player.setOp(true);
        }
        Bukkit.broadcastMessage("玩家【" + player.getName() + "】上线");
    }

    @EventHandler
    public void logout(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        USER_MAP.remove(player.getName());
        Bukkit.broadcastMessage("玩家【" + player.getName() + "】下线");
    }

    @EventHandler
    public void wavingBones(PlayerAnimationEvent event) {
        Player player = event.getPlayer();
        if (!ADMINS.contains(player.getName())) {
            return;
        }

        ItemStack itemInHand = player.getItemInHand();
        if (!itemInHand.getType().equals(Material.BONE)) {
            return;
        }

        Location location = player.getLocation();
        World world = player.getWorld();
        location.add(location.getDirection().normalize().multiply(10));
        world.createExplosion(location, 7);
    }
}
