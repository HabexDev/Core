package me.eetee.Core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast
  implements CommandExecutor
{
	public static String prefix = "§eCore §8┃ §bBroadcast §8» ";
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (p.hasPermission("core.staff"))
    {
      if (cmd.getName().equalsIgnoreCase("broadcast"))
      {
        if (args.length == 0)
        {
          p.sendMessage(prefix + "Please specify what you would like to broadcast.");
          return true;
        }
        StringBuilder message = new StringBuilder("");
        for (int i = 0; i < args.length; i++)
        {
          message.append(" ");
          message.append(args[i]);
        }
        String broadcast = ChatColor.translateAlternateColorCodes('&', prefix + message.toString());
        Bukkit.broadcastMessage(broadcast);
        
      }
    }
    else {
      sender.sendMessage(prefix + "You don't have permission!");
    }
    return true;
  }
}
