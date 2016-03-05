package me.eetee.Core.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPrefix implements Listener{
	
	
	@EventHandler
	public void onChatPrefix(AsyncPlayerChatEvent e){
		Player p = (Player) e.getPlayer();
		if (p.isOp()){
			e.setFormat("§b[§cOP§b] " + p.getDisplayName() + " " + e.getMessage());
		}
	
			
	
	}
	

}
