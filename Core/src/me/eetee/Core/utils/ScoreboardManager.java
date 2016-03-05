package me.eetee.Core.utils;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class ScoreboardManager {
	
	public void scoreboard(){

	    org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();
	    org.bukkit.scoreboard.Scoreboard s = manager.getNewScoreboard();
	    Objective o = s.registerNewObjective("stats", "dummy");
	    o.setDisplaySlot(DisplaySlot.SIDEBAR);
	    o.setDisplayName("CORE");
	    
	    
}
}
