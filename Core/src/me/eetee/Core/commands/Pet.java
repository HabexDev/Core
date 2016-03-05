package me.eetee.Core.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.eetee.Core.utils.ItemBuilder;
import me.eetee.Core.utils.MobAPI;

public class Pet implements CommandExecutor{

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(!sender.hasPermission("core.test"))
			return false;
		if(cmd.getName().equalsIgnoreCase("pet"))
			
			MobAPI.spawnMob(EntityType.CHICKEN, p.getWorld(), p.getLocation(), "MOB", 3, true);
		ArmorStand stand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
		stand.setGravity(false);
		stand.setVisible(false);
		stand.setCustomNameVisible(true);
		stand.setCustomName("PET");
		return false;
	}
}
