package me.yukun.striparmour.config;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Config {

  private static FileConfiguration config;

  protected static void setup(FileConfiguration fileConfiguration) {
    config = fileConfiguration;
  }

  /**
   * Checks if specified command sender has permissions to use commands.
   *
   * @param sender Command sender to check permissions for.
   * @return If specified command sender has permissions to use commands.
   */
  public static boolean canUseCommands(CommandSender sender) {
    if (sender instanceof ConsoleCommandSender) {
      return true;
    }
    if (sender.hasPermission("striparmour.*")) {
      return true;
    }
    return sender.hasPermission("striparmour.admin");
  }

  /**
   * Checks if specified player can be stripped.
   *
   * @param player Player to check strippability for. Yes, I made that word up.
   * @return If specified player can be stripped.
   */
  public static boolean canStrip(Player player) {
    if (player.hasPermission("striparmour.*")) {
      return true;
    }
    if (player.hasPermission("striparmour.admin")) {
      return true;
    }
    return !player.hasPermission("striparmour.bypass");
  }

  /**
   * Checks if items in off hand are to be stripped.
   *
   * @return If items in off hand are to be stripped.
   */
  public static boolean doStripOffHand() {
    return config.getBoolean("StripOffHand");
  }

  /**
   * Checks if stripping should ignore inventory space constraints.
   *
   * @return If stripping should ignore inventory space constraints.
   */
  public static boolean doIgnoreNoSpace() {
    return config.getBoolean("IgnoreNoSpace");
  }
}
