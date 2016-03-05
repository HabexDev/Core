package me.eetee.Core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.eetee.Core.utils.TitleAPI;

public class Feed
  implements CommandExecutor
{
	public static String prefix = "§eCore §8┃ §bFeed §8» ";
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (p.hasPermission("core.staff"))
    {
      if (cmd.getName().equalsIgnoreCase("feed"))
      {
        if (args.length == 0)
        {
			TitleAPI.sendTitle(p, 10, 10, 10, ChatColor.BLUE + "You were", ChatColor.GOLD + "FEED" );
			p.playSound(p.getLocation(), Sound.EAT, 10F, 10F);
          p.setFoodLevel(20);
          return true;
        }
        if (args.length >= 2)
        {
          p.sendMessage(prefix+ "Too many args :/");
          return true;
        }
        if (args.length == 1)
        {
          Player target = Bukkit.getPlayer(args[0]);
          if (!target.isOnline())
          {
            p.sendMessage(prefix + "That player isn't online!");
            return true;
          }
          target.setFoodLevel(20);
          target.sendMessage(prefix + "You have been fed.");
			TitleAPI.sendTitle(p, 10, 10, 10, ChatColor.BLUE + target.getName(), ChatColor.GOLD + "FEED" );
          return true;
        }
      }
    }
    else {
      sender.sendMessage(prefix + "You don't have permission!");
    }
    return true;
  }
}
