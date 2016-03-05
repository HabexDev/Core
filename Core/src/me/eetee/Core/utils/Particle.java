package me.eetee.Core.utils;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Particle {

	
	public static void spawnParticle(Location loc, Player... player){
		PacketPlayOutWorldParticles packetParticle = new PacketPlayOutWorldParticles(EnumParticle.FLAME,
				true, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), 33, 55, 11, 20, 0, null);
		
		for (Player p : player)  {
			((CraftPlayer)p).getHandle().playerConnection.sendPacket(packetParticle);
		}
	}
	
}
