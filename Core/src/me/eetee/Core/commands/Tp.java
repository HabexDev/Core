package me.eetee.Core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp
  implements CommandExecutor
  {

	public static String prefix = "§eCore §8┃ §bTeleport §8» ";
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("be a player pls");
      return true;
    }
    Player p = (Player)sender;
    if (!p.hasPermission("core.staff"))
    {
      p.sendMessage(prefix + "No Perms");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("tp")) {
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null)
        {
          p.sendMessage(prefix + "He isnt online");
          return true;
        }
        p.teleport(target);
        
        p.sendMessage(prefix + "Telepoted to " + target.getName());
      }
      else
      {
        p.sendMessage(prefix + "/tp [name]");
      }
    }
    return true;
  }
}
