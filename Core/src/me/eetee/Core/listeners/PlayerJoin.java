package me.eetee.Core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import me.eetee.Core.Core;
import me.eetee.Core.utils.Particle;
import me.eetee.Core.utils.TabAPI;
import me.eetee.Core.utils.TitleAPI;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class PlayerJoin implements Listener {
	Player p;
	private Inventory serverinv = Bukkit.getServer().createInventory(null, 9, "Core Menu");
	//« »

	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
	    int online = Bukkit.getServer().getOnlinePlayers().size();
	    int max = Bukkit.getServer().getMaxPlayers();
		e.setJoinMessage("");
		Core.npc.teleportTo(p.getLocation(), false);
		
	
		if(!p.hasPlayedBefore()) {
			
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r   &7&m*&b&m-----&7&m]-&r &cCore Server &7&m-[&b&m-----&7&m*&r\n"
					                                                          + "&cWelcome to &4" + p.getName() + "&c, have a fun experience on our server!"));
		}
		

		Core.sendMsg(p, "&7&m-----]&r &bCore Server &7&m[-----" + "\n" 
		              + "&7 » &bWelcome &3" + p.getName() + "&b, to our network!" + "\n");
				   
		Core.sendActionBar(p, "§bCORE SERVER WELCOME");

		TitleAPI.sendTitle(p, 10, 10, 20, "§bCORE", "§bWELCOME");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 10F, 10F);
		TabAPI.sendTabTitle(p, "§b----Core---" + " " + online + "/" + max , "----§bServer----");
	
	}

}

	


