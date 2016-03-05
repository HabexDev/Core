package me.eetee.Core.listeners;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.eetee.Core.Core;

public class PlayerCombat implements Listener {

	public static String prefix = "§eCore §8┃ §bCombatTag §8» ";
    public static HashMap<Player, Integer> cooldownTime;
    public static HashMap<Player, BukkitRunnable> cooldownTask;
	
    int task1;
    int task2;
    
	@EventHandler
	public void combatTag(EntityDamageByEntityEvent e) {
		
		if(e.getEntity() instanceof Player) {
		if(e.getDamager() instanceof Player) {
			
			final Player p = (Player) e.getEntity();
			final Player t = (Player) e.getDamager();
			
			
			//TAG DAMAGER
			if (!cooldownTime.containsKey(t)) {
				
				Core.sendMsg(t, prefix + " &9You have tagged &3" + p.getName() + "&9.");	
				
			}
			
			 cooldownTime.remove(p);
			 cooldownTime.put(t, 10);
             cooldownTask.put(t, new BukkitRunnable() {
                     public void run() {
                    	 if(!cooldownTask.containsKey(t)) {
                        	 return;
                         }
                    	 
                             cooldownTime.put(t, cooldownTime.get(t) - 1);
                             
                             if(cooldownTime.get(t) == 10) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(t) == 9) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛⬛⬛⬛⬛⬛⬛⬛&a⬛");
                             }
                             
                             if(cooldownTime.get(t) == 8) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛⬛⬛⬛⬛⬛⬛&a⬛⬛");
                             }
                             
                             if(cooldownTime.get(t) == 7) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛⬛⬛⬛⬛⬛&a⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(t) == 6) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛⬛⬛⬛⬛&a⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(t) == 5) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛⬛⬛⬛&a⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(t) == 4) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛⬛⬛&a⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(t) == 3) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛⬛&a⬛⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(t) == 2) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛⬛&a⬛⬛⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(t) == 1) {
                            	 Core.sendActionBar(t, prefix + "&bCombatTag &7» &c⬛&a⬛⬛⬛⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if (cooldownTime.get(t) == 0) {
                            	 
                            	 Core.sendActionBar(t, prefix + " &a⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
                            	 Core.sendMsg(t, prefix + "&9You are now out of combat.");
                            	 
                                     cooldownTime.remove(t);
                                     cooldownTime.clear();
                                     cooldownTask.remove(t);
                                     cooldownTask.clear();
                             }
                     }
             });
            
             cooldownTask.get(t).runTaskTimer(Core.getPlugin(), 20, 20);
             
             
             //TAG HITTED
             if (cooldownTime.containsKey(p)) {
 				
 				
 				
 			}else{
 				
 				Core.sendMsg(p, prefix + "&9You have been tagged by &3" + t.getName() + "&9.");
 				
 			}

             cooldownTime.remove(p);
             cooldownTime.put(p, 10);
             cooldownTask.put(p, new BukkitRunnable() {
                        public void run() {
                        	if(!cooldownTask.containsKey(p)) {
                           	 return;
                            }
                        	
                             cooldownTime.put(p, cooldownTime.get(p) - 1);
                             
                             if(cooldownTime.get(p) == 10) {
                            	 Core.sendActionBar(p, " &c⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(p) == 9) {
                            	 Core.sendActionBar(p, " &c⬛⬛⬛⬛⬛⬛⬛⬛⬛&a⬛");
                             }
                             
                             if(cooldownTime.get(p) == 8) {
                            	 Core.sendActionBar(p, " &c⬛⬛⬛⬛⬛⬛⬛⬛&a⬛⬛");
                             }
                             
                             if(cooldownTime.get(p) == 7) {
                            	 Core.sendActionBar(p, " &c⬛⬛⬛⬛⬛⬛⬛&a⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(p) == 6) {
                            	 Core.sendActionBar(p, " &c⬛⬛⬛⬛⬛⬛&a⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(p) == 5) {
                            	 Core.sendActionBar(p, " &c⬛⬛⬛⬛⬛&a⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(p) == 4) {
                            	 Core.sendActionBar(p, " &c⬛⬛⬛⬛&a⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(p) == 3) {
                            	 Core.sendActionBar(p, " &c⬛⬛⬛&a⬛⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(p) == 2) {
                            	 Core.sendActionBar(p, " &c⬛⬛&a⬛⬛⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if(cooldownTime.get(p) == 1) {
                            	 Core.sendActionBar(p, " &c⬛&a⬛⬛⬛⬛⬛⬛⬛⬛⬛");
                             }
                             
                             if (cooldownTime.get(p) == 0) {
                            	 
                            	 Core.sendActionBar(p, "&bCombatTag &7» &a⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
                            	 Core.sendMsg(p, " &9You are now out of combat.");
                            	 
                                     cooldownTime.remove(p);
                                     cooldownTime.clear();
                                     cooldownTask.remove(p);
                                     cooldownTask.clear();
                             }
                     }
             });
             
             cooldownTask.get(p).runTaskTimer(Core.getPlugin(), 20, 20);
			
			
		}else{
			return;
		}
		}else{
			return;
		}
		
		
	}
	
	@EventHandler
	public void blockCommands(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if(e.getMessage().startsWith("/")) {
			
			 if (cooldownTime.containsKey(p)) {
	 				
				    e.setCancelled(true);
	 				Core.sendMsg(p, prefix + "&9You are combat tagged, wait &3" + cooldownTime.get(p) + "&9seconds before using commands!");
	 				
	 			}
			
		
		}
		}

}
