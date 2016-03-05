package me.eetee.Core;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.eetee.Core.commands.Broadcast;
import me.eetee.Core.commands.ClearChat;
import me.eetee.Core.commands.Feed;
import me.eetee.Core.commands.Fly;
import me.eetee.Core.commands.Gm;
import me.eetee.Core.commands.HeadCommand;
import me.eetee.Core.commands.Help;
import me.eetee.Core.commands.Pet;
import me.eetee.Core.commands.Ping;
import me.eetee.Core.commands.Test;
import me.eetee.Core.commands.Tp;
import me.eetee.Core.commands.Trails;
import me.eetee.Core.commands.Vanish;
import me.eetee.Core.listeners.AntiSwear;
import me.eetee.Core.listeners.PlayerCombat;
import me.eetee.Core.listeners.PlayerJoin;
import me.eetee.Core.listeners.PlayerLeave;
import me.eetee.Core.utils.ChatPrefix;
import me.eetee.Core.utils.Messanger;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Core extends JavaPlugin implements Listener{
	
	public static EntityPlayer npc;
	public static ArrayList<String> A = new ArrayList<String>();
	Messanger messanger;
	private static Plugin plugin;
	public void onEnable() {
        plugin = this;

        messanger = new Messanger(this);
        getServer().getPluginManager().registerEvents(this, this);
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Trails(), this);
        registerEvents(this, new PlayerJoin(), new PlayerCombat(), new PlayerLeave(), new AntiSwear(), new ChatPrefix());
	    getCommand("help").setExecutor(new Help());		
	    getCommand("gm").setExecutor(new Gm	());		
	    getCommand("cc").setExecutor(new ClearChat	());	
	    getCommand("tp").setExecutor(new Tp	());	
	    getCommand("head").setExecutor(new HeadCommand	());
	    getCommand("pet").setExecutor(new Pet	());		
	    getCommand("trails").setExecutor(new Trails	());	
	    getCommand("broadcast").setExecutor(new Broadcast	());		
	    getCommand("fly").setExecutor(new Fly	());		
	    getCommand("feed").setExecutor(new Feed ());		
	    getCommand("ping").setExecutor(new Ping ());		
	    getCommand("vanish").setExecutor(new Vanish ());	
	    getCommand("test").setExecutor(new Test ());		
    	PlayerCombat.cooldownTime = new HashMap<Player, Integer>();
        PlayerCombat.cooldownTask = new HashMap<Player, BukkitRunnable>();
        messanger.runTaskTimer(this, 0, 1000 * 20);
        saveDefaultConfig();
	}

	
	
	
    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

	public void onDisable() {
	}
    public static void sendMsg(Player p, String msg) {
//SEND MESSGAGE
    	
    	p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    	    }
    
    
    public static void sendActionBar(Player p, String msg)
    {
    	//A QUICK API
      IChatBaseComponent cbc = 
       IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + ChatColor.translateAlternateColorCodes('&', msg) + "\"}");
      PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte)2);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(ppoc);
    }
    public static Plugin getPlugin() {
 			return (Plugin) Bukkit.getServer().getPluginManager().getPlugin("Core");



    }
  
    public static void playCircularEffect(Location location, Effect effect, boolean v){
    	for(int i = 0; i<=8;i+= ((!v && (i==3)) ? 2 :1))
    		location.getWorld().playEffect(location, effect, i);
    }
    
	public static String Format(String text) {
		return text.replaceAll("&", "§");
	}
	

	  public void add(Player player)
	  {
	    ScoreboardManager manager = Bukkit.getScoreboardManager();
	    Scoreboard board = manager.getNewScoreboard();
	    int online = Bukkit.getOnlinePlayers().size();
	    final Objective objective = board.registerNewObjective("Scoreboard", "dummy");
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    
	    Score spacer = objective.getScore("§d");
	    spacer.setScore(6);
	    
	    Score score = objective.getScore(ChatColor.WHITE + "§2NAME §9§");
	    score.setScore(5);
	    Score spacer2 = objective.getScore("§d");
	    spacer2.setScore(4);
	    Score name = objective.getScore("§b" + player.getName());
	    name.setScore(3);
	    Score spacer3 = objective.getScore("§d");
	    spacer3.setScore(2);
	    Score onlinep = objective.getScore("§cONLINE §9§ §b" + online);
	    onlinep.setScore(2);
	    A.clear();
	    A.add("1");
	    
	    BukkitScheduler Scheduler = Bukkit.getServer().getScheduler();
	    Scheduler.scheduleSyncRepeatingTask(this, new Runnable()
	    {
	      public void run()
	      {
	        Integer i = Integer.valueOf(Core.A.size());
	        if (i.intValue() == 1)
	        {
	          objective.setDisplayName(Core.Format("&b&lCore"));
	          Core.A.add("A");
	        }
	        if (i.intValue() == 2)
	        {
	          objective.setDisplayName(Core.Format("&c&lCore"));
	          Core.A.add("B");
	        }
	        if (i.intValue() == 3)
	        {
	          objective.setDisplayName(Core.Format("&3&lCore"));
	          Core.A.add("C");
	        }
	        if (i.intValue() == 3)
	        {
	          Core.A.clear();
	          Core.A.add("1");
	        }
	        if (Bukkit.getOnlinePlayers().size() >= 6)
	        {
	          objective.getDisplayName();
	          objective.setDisplayName("6 Players");
	        }
	      }
	    }, 0L, 5L);
	    player.setScoreboard(board);
	  }
	  
	
	  @EventHandler
	  public void PlayerJoinEvent(PlayerJoinEvent e)
	  {
	    Player p = e.getPlayer();
	    add(p);
	  }
	  @EventHandler
	  public void onPing(ServerListPingEvent e)
	  {
	
	    e.setMotd("§bTHIS SERVER USES CORE");
	  }
}
