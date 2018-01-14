package me.Yukun.StripArmour;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.Yukun.StripArmour.MultiSupport.CESupport;

public class Api {
	public static Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("StripArmour");

	@SuppressWarnings("static-access")
	public Api(Plugin plugin) {
		this.plugin = plugin;
	}

	public static ItemStack getItemInOffHand(Player player) {
		if (getVersion() >= 191) {
			return player.getInventory().getItemInOffHand();
		} else {
			return null;
		}
	}

	public static void callEvent(Player player, ItemStack armour) {
		if (Bukkit.getPluginManager().getPlugin("CrazyEnchantments") != null) {
			if (Bukkit.getPluginManager().getPlugin("CrazyEnchantments").isEnabled()) {
				CESupport.callEvent(player, armour);
			}
		}
	}
	
	public static String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	public static String removeColor(String msg) {
		msg = ChatColor.stripColor(msg);
		return msg;
	}

	public static String getConfigString(String path) {
		String msg = Main.settings.getConfig().getString(path);
		return msg;
	}

	public static String getMessageString(String path) {
		String msg = Main.settings.getMessages().getString(path);
		return msg;
	}

	public static String replacePHolders(String msg, Player player, String stripped) {
		return msg.replace("%player%", player.getDisplayName()).replace("%stripped%", stripped);
	}

	public static Integer getVersion() {
		String ver = Bukkit.getServer().getClass().getPackage().getName();
		ver = ver.substring(ver.lastIndexOf('.') + 1);
		ver = ver.replaceAll("_", "").replaceAll("R", "").replaceAll("v", "");
		return Integer.parseInt(ver);
	}

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static Player getPlayer(String name) {
		return Bukkit.getServer().getPlayer(name);
	}
}