package me.eetee.Core.commands;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Trails implements CommandExecutor, Listener{
	private Inventory trails = Bukkit.getServer().createInventory(null, 9, "Trails");
	private ItemStack fire = new ItemStack(Material.BLAZE_POWDER);
	private ItemStack closemenu = new ItemStack(Material.BARRIER);
	private ItemStack wateritem = new ItemStack(Material.WATER_BUCKET);
	private ItemMeta firemeta = fire.getItemMeta();
	private ItemMeta closemenum = closemenu.getItemMeta();
	private ItemMeta watermeta = wateritem.getItemMeta();
	ArrayList<UUID> flame = new ArrayList<UUID>();
	ArrayList<UUID> water = new ArrayList<UUID>();
	private String prefix = "§eCore §8┃ §bTrails §8» ";
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		
		if(!sender.hasPermission("core.trails")){
			sender.sendMessage("BAD");
			return false;
		}

		if(cmd.getName().equalsIgnoreCase("trails")) {
			firemeta.setDisplayName(ChatColor.RED + "FIRE");
			closemenum.setDisplayName("§c§lCLOSE");
			firemeta.setDisplayName(ChatColor.RED + "FIRE");
			watermeta.setDisplayName(ChatColor.BLUE + "WATER");
			closemenu.setItemMeta(closemenum);
			fire.setItemMeta(firemeta);
			wateritem.setItemMeta(watermeta);
			trails.setItem(0, fire);
			trails.setItem(1, wateritem);
			trails.setItem(8, closemenu);
			p.openInventory(trails);
			
		}
		
		
		
		return true;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getInventory().getName().equalsIgnoreCase("Trails")){
			if(e.getSlot() == 0){
				e.setCancelled(true);
				flame.add(e.getWhoClicked().getUniqueId());
				e.getWhoClicked().sendMessage(prefix + "FIRE!");
				water.remove(e.getWhoClicked().getUniqueId());
			}
			if(e.getSlot() == 1){
				e.setCancelled(true);
				water.add(e.getWhoClicked().getUniqueId());
				flame.remove(e.getWhoClicked().getUniqueId());
				e.getWhoClicked().sendMessage(prefix + "WATER");
			}
			if(e.getSlot() == 8){
				e.setCancelled(true);
				e.getWhoClicked().closeInventory();
				flame.remove(e.getWhoClicked().getUniqueId());
				water.remove(e.getWhoClicked().getUniqueId());
			}
		}
	}
	
		@SuppressWarnings("deprecation")
		@EventHandler
		public void onPlayerMove(PlayerMoveEvent e) {
			
			if(flame.contains(e.getPlayer().getUniqueId())){
				e.getPlayer().playEffect(e.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 20);
			}	
			if(water.contains(e.getPlayer().getUniqueId())){
				e.getPlayer().playEffect(e.getPlayer().getLocation(), Effect.WATERDRIP, 700);
			}
		}
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		Player player = (Player) e;
		flame.remove(player.getUniqueId());
	}
	
}
