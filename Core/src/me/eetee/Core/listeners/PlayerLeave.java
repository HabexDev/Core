package me.eetee.Core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

	@EventHandler
	public void playerLeave(PlayerQuitEvent e) {
		
		e.setQuitMessage("");
		
	}
	
}
