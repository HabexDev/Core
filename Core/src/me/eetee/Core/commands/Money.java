package me.eetee.Core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Money implements CommandExecutor{
	Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("money")){
			Player p = (Player) sender;
			p.sendMessage("MONEY:");
			
		}
		return false;
	}

}
