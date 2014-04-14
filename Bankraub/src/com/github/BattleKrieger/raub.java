package com.github.BattleKrieger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class raub extends JavaPlugin {
	public void onEnable() {
		System.out.println("[Bankraub]Plugin Läuft!");
	}

	public void onDisable() {
		System.out.println("[Bankraub]Plugin Läuft nicht mehr!");
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String cmdLabel, String[] args) {

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("Heilen")) {
			if (p.hasPermission("Bankraub.Heilen")) {
				if (args.length == 0) {
					p.sendMessage("§aDu wurdest geheilt");
					p.setHealth(20.0);
					p.setFoodLevel(20);
				}
				if (args.length == 1) {
					Player p2 = getServer().getPlayer(args[0]);
					p2.setHealth(20.0);
					p2.setFoodLevel(20);
					p.sendMessage("§dDer Spieler " + ChatColor.GREEN
							+ p2.getName() + "§d wurde geheilt!");
					p2.sendMessage("§cDu wurdest von ein Admin geheilt !");
				}
			}
			return true;
		} else {
			return false;

		}
	}
}
