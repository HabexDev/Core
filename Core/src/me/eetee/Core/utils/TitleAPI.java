package me.eetee.Core.utils;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class TitleAPI {

	
	 
	  public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle)
	  {
	    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
	    
	    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
	    connection.sendPacket(packetPlayOutTimes);//THE TIME IT PLAYS
	    if (subtitle != null)
	    {
	      IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
	      PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
	      connection.sendPacket(packetPlayOutSubTitle);//SUBTITLE
	    }
	    if (title != null)
	    {
	      IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
	      PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
	      connection.sendPacket(packetPlayOutTitle);// MAIN TITLE
	    }// THIS IS THE TITLE API
	  }
	}

	

