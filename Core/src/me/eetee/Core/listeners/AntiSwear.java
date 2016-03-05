package me.eetee.Core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.eetee.Core.Core;


public class AntiSwear implements Listener {

	public static String prefix = "§eCore §8┃ §bAntiSwear §8» ";
	@EventHandler
	public void noSwear(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		
		String[] swearfilter = {
				                "fuck", 
				                "whore",
				                "hooker",
				                "bitch",
				                "sex",
				                "satan",
				                "devil",
				                "damn",
				                "retard",
				                "cunt",
				                "ass",
				                "dick",
				                "slut"
				                
		};
		
		for(String s : swearfilter){
			if(e.getMessage().contains(s)) {
				
				Core.sendMsg(p, "&c&l&m!==========================================!");
				Core.sendMsg(p, "&f&lPlease do not swear! Message sent to staff!");
				Core.sendMsg(p, "&c&l&m!==========================================!");
				Core.sendMsg(p, prefix + e.getMessage());
				
				e.setCancelled(true);
				
				for (Player ops : Bukkit.getServer().getOnlinePlayers()) {
					
					if(ops.isOp()) {
						
						Core.sendMsg(ops, prefix + p.getName() + " just sweared!");
						
					}
					
				}
				return;
				
			}
		  }
			
		}
		
	
}
