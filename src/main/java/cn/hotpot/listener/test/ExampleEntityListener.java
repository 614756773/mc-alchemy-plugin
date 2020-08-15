package cn.hotpot.listener.test;

import cn.hotpot.HotpotPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static cn.hotpot.global.UserCache.ADMINS;

public class ExampleEntityListener implements Listener {
    
    public HotpotPlugin plugin;
    
    public ExampleEntityListener(HotpotPlugin instance) {
        plugin = instance;
    }
 
        @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        
        if(event.getEntity() instanceof Player){
        //If the entity being damaged is a player then...
            Player player = (Player) event.getEntity();
            if (ADMINS.contains(player.getName())) {
                event.setCancelled(true);
            }
        //Cancel the damage event, this will give the player unlimited health
        }
    }
 
}