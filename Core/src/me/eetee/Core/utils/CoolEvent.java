package me.eetee.Core.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CoolEvent extends Event{
	
	Player p;
	Location l;
	
	public CoolEvent(Player p , Location l){
	this.p = p;
	this.l = l;
}
	public Player getPlayer(){
		return p;
	}
	public Location getWarpLocation(){
		return l;
	}
	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
	    return handlers;
	}

	public static HandlerList getHandlerList() {
	    return handlers;
	}
}
