package cn.hotpot;

import cn.hotpot.command.MyCommandExecutor;
import cn.hotpot.listener.HotpotEventListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * @author qinzhu
 */
public class HotpotPlugin extends JavaPlugin {
    public static Logger log;

    @Override
    public void onDisable() {}
 
    @Override
    public void onEnable() {
        log = getLogger();
        PluginManager pm = this.getServer().getPluginManager();
//        pm.registerEvents(new ExamplePlayerListener(this), this);
//        pm.registerEvents(new ExampleEntityListener(this), this);
        pm.registerEvents(new HotpotEventListener(), this);
        this.getCommand("hp").setExecutor(new MyCommandExecutor());
    }
}