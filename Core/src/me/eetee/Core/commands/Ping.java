package me.eetee.Core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.eetee.Core.utils.TitleAPI;

public class Ping implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player ) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("ping")){
				
				if(args.length == 0) {
					int  ping = ((CraftPlayer) p).getHandle().ping;
					TitleAPI.sendTitle(p, 10, 10, 10, ChatColor.BLUE + "PING:", " " + ping);
				} else{
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null){
						int  ping = ((CraftPlayer) p).getHandle().ping;
						TitleAPI.sendTitle(p, 10, 10, 10, ChatColor.BLUE + "PING:", " " + ping);
					}
				}
				
			}
		}
		
		return false;
	

}
}