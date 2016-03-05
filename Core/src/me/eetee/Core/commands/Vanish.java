package me.eetee.Core.commands;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Vanish
  implements CommandExecutor, Listener
{
  ArrayList<Player> vanished = new ArrayList();

	public static String prefix = "§eCore §8┃ §bVanish §8» ";
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (p.hasPermission("core.staff"))
    {
      if ((cmd.getName().equalsIgnoreCase("vanish")))
      {
        if (args.length == 0)
        {
          if (this.vanished.contains(p))
          {
            this.vanished.remove(p);
            p.setPlayerListName(p.getName());
            p.removePotionEffect(PotionEffectType.INVISIBILITY);
            return true;
          }
          if (!this.vanished.contains(p))
          {
            this.vanished.add(p);
            p.setPlayerListName("");
            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 3, false));
            return true;
          }
        }
        if (args.length >= 2) {
          p.sendMessage(prefix + "Too many args. :/");
        }
        if (args.length == 1)
        {
          Player target = Bukkit.getPlayer(args[0]);
          if (this.vanished.contains(target))
          {
            this.vanished.remove(target);
            target.setPlayerListName(target.getName());
            p.removePotionEffect(PotionEffectType.INVISIBILITY);
            return true;
          }
          if (!this.vanished.contains(target))
          {
            this.vanished.add(target);
            target.setPlayerListName("");
            target.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000, 3, false));
            return true;
          }
        }
      }
    }
    else {
      sender.sendMessage(prefix + "You don't have permission!");
    }
    return true;
  }
}
