package me.eetee.Core.utils;

import java.lang.reflect.Field;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class TabAPI {
	  public static void sendTabTitle(Player player, String header, String footer)
	  {
	    if (header == null) {
	      header = "";
	    }
	    header = ChatColor.translateAlternateColorCodes('&', header);
	    if (footer == null) {
	      footer = "";
	    }
	    footer = ChatColor.translateAlternateColorCodes('&', footer);
	    
	    header = header.replaceAll("%player%", player.getDisplayName());
	    footer = footer.replaceAll("%player%", player.getDisplayName());
	    
	    CraftPlayer craftplayer = (CraftPlayer)player;
	    PlayerConnection connection = craftplayer.getHandle().playerConnection;
	    IChatBaseComponent header1 = ChatSerializer.a("{\"text\": \"" + header + "\"}");
	    IChatBaseComponent footer1 = ChatSerializer.a("{\"text\": \"" + footer + "\"}");
	    PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
	    try
	    {
	      Field headerField = packet.getClass().getDeclaredField("a");
	      headerField.setAccessible(true);
	      headerField.set(packet, header1);
	      headerField.setAccessible(!headerField.isAccessible());
	      
	      Field footerField = packet.getClass().getDeclaredField("b");
	      footerField.setAccessible(true);
	      footerField.set(packet, footer1);
	      footerField.setAccessible(!footerField.isAccessible());
	    }
	    catch (Exception e1)
	    {
	      e1.printStackTrace();
	    }
	    connection.sendPacket(packet);
	  }
}
