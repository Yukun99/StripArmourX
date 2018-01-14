package me.Yukun.StripArmour;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static SettingsManager settings = SettingsManager.getInstance();

	@Override
	public void onEnable() {
		settings.setup(this);
		PluginManager pm = Bukkit.getServer().getPluginManager();
		// ==========================================================================\\
		pm.registerEvents(this, this);
		getCommand("striparmour").setExecutor(new StripArmour());
	}

	@EventHandler
	public void authorJoinEvent(PlayerJoinEvent e) {
		if (e.getPlayer() != null) {
			Player player = e.getPlayer();
			if (player.getName().equalsIgnoreCase("xu_yukun")) {
				player.sendMessage(
						Api.color("&bStrip&eArmour7 >> &fThis server is using your strip armour plugin. It is using v"
								+ Bukkit.getServer().getPluginManager().getPlugin("StripArmour").getDescription()
										.getVersion()
								+ "."));
			}
		}
	}
}