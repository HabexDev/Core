package me.eetee.Core.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.eetee.Core.Core;

public class Messanger extends BukkitRunnable{

	public static String prefix = "§eCore §8┃ §bBroadcast §8» ";
	Core plugin;
	Player p;

	public Messanger(Core plugin)
	{
		this.plugin = plugin;
	}
	
	@Override
	public void run() 
	{
		Bukkit.getServer().broadcastMessage(prefix + "Players: " + Bukkit.getOnlinePlayers().size());
	}

}
