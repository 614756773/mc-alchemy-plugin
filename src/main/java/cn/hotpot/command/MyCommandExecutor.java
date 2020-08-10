package cn.hotpot.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Objects;

import static cn.hotpot.global.Cache.USER_MAP;

public class MyCommandExecutor implements CommandExecutor {
	/**
	 * 传送
	 */
	private final String TP = "tp";

	/**
	 * 射击
	 */
	private final String SHOT = "st";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String name = sender.getName();
		Player player = USER_MAP.get(sender.getName());
//		player.sendMessage("name is " + name);
//		player.sendMessage("command is " + cmd);
//		player.sendMessage("label is " + label);
//		player.sendMessage("args is " + String.join(",", args));

		if (TP.equals(args[0]) && !Objects.isNull(args[1])) {
			if (!USER_MAP.containsKey(args[1])) {
				return false;
			}

			Player other = USER_MAP.get(args[1]);
			Location location = player.getLocation();
			Location ol = other.getLocation();
			location.setX(ol.getX());
			location.setY(ol.getY());
			location.setZ(ol.getZ());
			return true;
		}
		return false;
	}
}