package me.eetee.Core.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor{
	
	public static String prefix = "§eCore §8┃ §bHelp §8» ";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("help"))
		p.sendMessage(prefix + "www.mywebsite.com");
		p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 10F, 10F);
		
		return true;
	}
}
