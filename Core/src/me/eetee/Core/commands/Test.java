package me.eetee.Core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.eetee.Core.utils.TitleAPI;

public class Test implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("test")){
			TitleAPI.sendTitle(p, 10, 4, 2, "TEST", "ANOTHER TEST");
		}
		return false;
	}

}
