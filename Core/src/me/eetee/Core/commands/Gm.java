package me.eetee.Core.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Gm implements CommandExecutor {

	List<String> toggle = new ArrayList<String>();

	public static String prefix = "§eCore §8┃ §bGameMode §8» ";
	public boolean onCommand(CommandSender cs, Command command, String cmd, String[] args) {
		Player p = (Player) cs;

		if(!cs.hasPermission("core.staff"))
			return false;
		if(cmd.equalsIgnoreCase("gm")) {
			
			if(toggle.contains(p.getName())) {
				p.sendMessage(prefix + "Survival");
				p.setGameMode(GameMode.SURVIVAL);
				toggle.remove(p.getName());
				
			}else{
				p.sendMessage(prefix + "Creative");
				p.setGameMode(GameMode.CREATIVE);
				toggle.add(p.getName());
				
			}
			
		}
		
		return false;
	}

}
