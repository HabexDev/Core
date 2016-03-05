package me.eetee.Core.commands;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly
  implements CommandExecutor
{
  ArrayList<Player> flying = new ArrayList();

	public static String prefix = "§eCore §8┃ §bFly §8» ";
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (p.hasPermission("core.staff"))
    {
      if (cmd.getName().equalsIgnoreCase("fly"))
      {
        if (args.length == 0)
        {
          if (this.flying.contains(p))
          {
            p.setAllowFlight(false);
            p.setFlying(false);
            p.sendMessage(prefix + "You are no longer flying!");
            this.flying.remove(p);
            return true;
          }
          if (!this.flying.contains(p))
          {
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage(prefix + "You are now flying!");
            this.flying.add(p);
            return true;
          }
          return true;
        }
        if (args.length >= 2)
        {
          p.sendMessage(prefix + "To many args :/");
          return true;
        }
        if (args.length == 1)
        {
          Player target = Bukkit.getServer().getPlayer(args[0]);
          if (!target.isOnline())
          {
            p.sendMessage(prefix + "That player isn't online!");
            return true;
          }
          if (this.flying.contains(p))
          {
            target.setAllowFlight(false);
            target.setFlying(false);
            p.sendMessage(prefix + target.getName() + ", is no longer flying!");
            target.sendMessage(prefix + "You are no longer flying!");
            this.flying.remove(target);
            return true;
          }
          if (!this.flying.contains(p))
          {
            target.setAllowFlight(true);
            target.setFlying(true);
            p.sendMessage(prefix + target.getName() + ", is now flying!");
            target.sendMessage(prefix + "You are now flying!");
            this.flying.add(target);
            return true;
          }
          return true;
        }
      }
    }
    else {
      sender.sendMessage(ChatColor.RED + "You don't have permission!");
    }
    return true;
  }
}
