package cn.hotpot.listener.test;

import cn.hotpot.HotpotPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ExamplePlayerListener implements Listener {
    
    private HotpotPlugin plugin;
    
    public ExamplePlayerListener(HotpotPlugin instance) {
        plugin = instance;
    }
 
        @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location playerLoc = player.getLocation();
        player.sendMessage("Your X Coordinates : " + playerLoc.getX());
        player.sendMessage("Your Y Coordinates : " + playerLoc.getY());
        player.sendMessage("Your Z Coordinates : " + playerLoc.getZ());
    }
 
}