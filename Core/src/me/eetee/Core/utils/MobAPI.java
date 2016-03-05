package me.eetee.Core.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class MobAPI {
	 public static void spawnMob(EntityType mob, World w, Location loc, String mobName, int cant, boolean visibleName)
	  {
	    int c = 0;
	    while (c <= cant)
	    {
	      Entity monster = w.spawnEntity(loc, mob);
	      monster.setCustomName(mobName);
	      monster.setCustomNameVisible(visibleName);
	      c += 1;
	    }
	  }
	}


