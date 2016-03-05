package me.eetee.Core.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class HeadCommand
  implements CommandExecutor
{

	public static String prefix = "§eCore §8┃ §bHeads §8» ";
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("be a player");
      return true;
    }
    Player p = (Player)sender;
    if (!p.hasPermission("core.staff"))
    {
      p.sendMessage(prefix + "no perms");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("head")) {
      if (args.length == 0)
      {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta skullmeta = (SkullMeta)skull.getItemMeta();
        skullmeta.setOwner(p.getName());
        skull.setItemMeta(skullmeta);
        p.getInventory().addItem(new ItemStack[] { skull });
        p.sendMessage(prefix + "Heres your head");
      }
      else if (args.length == 1)
      {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta skullmeta = (SkullMeta)skull.getItemMeta();
        skullmeta.setOwner(args[0]);
        skull.setItemMeta(skullmeta);
        p.getInventory().addItem(new ItemStack[] { skull });
        p.sendMessage(prefix + "Heres the head of " + args[0]);
      }
      else
      {
        p.sendMessage(prefix + "/head [name]");
      }
    }
    return true;
  }
}
