package me.yukun.striparmour;

import java.util.Objects;
import me.yukun.striparmour.command.CommandManager;
import me.yukun.striparmour.config.FileManager;
import me.yukun.striparmour.config.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

  private boolean isConfigErrored = false;

  @Override
  public void onEnable() {
    isConfigErrored = !FileManager.onEnable(this);
    PluginManager pm = Bukkit.getServer().getPluginManager();
    pm.registerEvents(this, this);
    if (isConfigErrored) {
      Bukkit.getPluginManager().disablePlugin(this);
      return;
    }
    Objects.requireNonNull(getCommand("striparmour")).setExecutor(new CommandManager());
  }

  @EventHandler
  private void DevJoinEvent(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    if (!player.getName().equals("xu_yukun")) {
      return;
    }
    Messages.sendPluginVersion(player, this);
    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
    if (isConfigErrored) {
      Messages.sendConfigError(player);
      player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
    }
  }

  public static Integer getVersion() {
    String ver = Bukkit.getServer().getClass().getPackage().getName();
    ver = ver.substring(ver.lastIndexOf('.') + 1);
    ver = ver.replaceAll("_", "").replaceAll("R", "").replaceAll("v", "");
    return Integer.parseInt(ver);
  }
}