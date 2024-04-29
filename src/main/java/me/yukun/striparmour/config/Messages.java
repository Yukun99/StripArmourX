package me.yukun.striparmour.config;

import static me.yukun.striparmour.util.TextFormatter.applyColor;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Messages {

  private static FileConfiguration messages;
  // Plugin info ping messages.
  private static final String VERSION = "StripArmour v%version% loaded.";
  // Configuration related logging.
  private static final String FOLDER = "Config folder";
  private static final String EXISTS = " exists, skipping creation.";
  private static final String NOT_EXISTS = " not created, creating now.";
  private static final String COPY_ERROR = "&cERROR! %file% could not be created.";
  private static final String CONFIG_ERROR = "&cERROR! Config files could not load properly. Plugin will be disabled.";
  private static final String VALIDATION_SUCCESS = "&aValidation success! %file% has no errors.";
  private static final String RELOAD = "&a%file% reloaded!";
  // Command reply messages.
  private static final String HELP_HEADER = "&b&l=============StripArmour=============";
  private static final String HELP_COMMANDS = "&b&l----------Commands----------";
  private static final String HELP_ALIASES = "Command aliases: strip, striparmor";
  private static final String HELP_HELP = "/striparmour help: Shows commands, aliases and permissions.";
  private static final String HELP_RELOAD = "/striparmour reload: Reloads all configuration files.";
  private static final String HELP_STRIP_PLAYER = "/striparmour strip (player): Strips all gear off specified player based on Config.yml.";
  private static final String HELP_STRIP_PLAYER_SPECIFIC = "/captchas strip (player) (pieces): Strips specified gear off specified player.";
  private static final String HELP_STRIP_PLAYER_SPECIFIC_PIECES = "  - valid pieces: helmet, chestplate, leggings, boots, offhand";
  private static final String HELP_PERMISSIONS = "&b&l----------Permissions----------";
  private static final String HELP_WILDCARD = "striparmour.*: All permissions combined.";
  private static final String HELP_ADMIN = "striparmour.admin: Ability to use commands + admin.bypass.";
  private static final String HELP_BYPASS = "striparmour.bypass: Immunity to stripping. No horny!";
  private static final String HELP_FOOTER = "&b&l=====================================";
  private static final String RELOAD_SUCCESS = "&aReload successful!";
  private static final String STRIP_NO_PLAYER = "&cNo such player exists! No horny!";
  private static final String STRIP_INVALID_ARMOUR = "&cInvalid armour piece: %item%. No horny!";
  private static final String STRIP_IMMUNE = "&cThis player's clothes are superglued on. NO HORNY!";
  // Prefix appended before all messages.
  private static String prefix = "&bStrip&eArmour&f >> &7";
  // Messages sent to players.
  private static String strip;
  private static String stripped;
  private static String noSpace;

  protected static void setup(FileConfiguration fileConfiguration) {
    messages = fileConfiguration;
    prefix = fileConfiguration.getString("Prefix");
    strip = prefix + fileConfiguration.getString("Strip");
    stripped = prefix + fileConfiguration.getString("Stripped.Message");
    noSpace = prefix + fileConfiguration.getString("NoSpace");
  }

  /**
   * Sends plugin version info to specified player.
   *
   * @param player Player to send plugin version info to.
   * @param plugin Plugin to get version info for.
   */
  public static void sendPluginVersion(Player player, Plugin plugin) {
    String message = prefix + VERSION.replaceAll("%version%", plugin.getDescription().getVersion());
    player.sendMessage(applyColor(message));
  }

  /**
   * Sends config error message to specified player.
   *
   * @param player Player to send config error message to.
   */
  public static void sendConfigError(Player player) {
    player.sendMessage(applyColor(prefix + CONFIG_ERROR));
  }

  /**
   * Logging message during setup sent if config folder exists.
   */
  protected static void printFolderExists() {
    System.out.println(applyColor(prefix + FOLDER + EXISTS));
  }

  /**
   * Logging message during setup sent if config folder does not exist.
   */
  protected static void printFolderNotExists() {
    System.out.println(applyColor(prefix + FOLDER + NOT_EXISTS));
  }

  /**
   * Logging message during setup sent if specified file exists in config folder.
   *
   * @param filename Filename of specified file.
   */
  protected static void printFileExists(String filename) {
    System.out.println(applyColor(prefix + filename + EXISTS));
  }

  /**
   * Logging message during setup sent if specified file does not exist in config folder.
   *
   * @param filename Filename of specified file.
   */
  protected static void printFileNotExists(String filename) {
    System.out.println(applyColor(prefix + filename + NOT_EXISTS));
  }

  /**
   * Logging message during setup sent if specified file could not be copied to config folder.
   *
   * @param filename Filename of specified file.
   */
  protected static void printFileCopyError(String filename) {
    String message = prefix + COPY_ERROR.replaceAll("%file%", filename);
    System.out.println(applyColor(message));
  }

  /**
   * Logging message during setup sent if config files contain errors and could not load properly.
   */
  public static void printConfigError(Exception exception) {
    System.out.println(applyColor(prefix + CONFIG_ERROR));
    System.out.println(applyColor(prefix + exception.getMessage()));
  }

  /**
   * Logging message during setup sent if specified file is validated successfully.
   *
   * @param configType Configuration file type that was validated successfully.
   */
  public static void printValidationSuccess(ConfigTypeEnum configType) {
    String message = prefix + VALIDATION_SUCCESS.replaceAll("%file%", configType.toString());
    System.out.println(applyColor(message));
  }

  /**
   * Logging message during reloading sent if specified file is reloaded successfully.
   *
   * @param configType Configuration file type that was reloaded successfully.
   */
  public static void printReloaded(ConfigTypeEnum configType) {
    String message = prefix + RELOAD.replaceAll("%file%", configType.toString());
    System.out.println(applyColor(message));
  }

  /**
   * Send command sender error about player to be stripped not existing.
   *
   * @param sender Command sender to send error message to.
   */
  public static void sendStripNoPlayer(CommandSender sender) {
    sender.sendMessage(applyColor(prefix + STRIP_NO_PLAYER));
  }

  /**
   * Send command sender error about item to be stripped being incorrect.
   *
   * @param sender Command sender to send error message to.
   * @param item   Name of item that does not exist.
   */
  public static void sendStripInvalidArmour(CommandSender sender, String item) {
    String message = prefix + STRIP_INVALID_ARMOUR.replaceAll("%item%", item);
    sender.sendMessage(applyColor(message));
  }

  public static void sendStripImmune(CommandSender sender) {
    sender.sendMessage(applyColor(prefix + STRIP_IMMUNE));
  }

  /**
   * Send command sender confirmation of victim being stripped of armour.
   *
   * @param sender Command sender to send strip message to.
   * @param victim Player being stripped of armour.
   */
  public static void sendStrip(CommandSender sender, Player victim) {
    sender.sendMessage(applyColor(strip.replaceAll("%player%", victim.getDisplayName())));
  }

  /**
   * Send victim indication of being stripped of armour.
   *
   * @param victim Player being stripped of armour.
   */
  public static void sendStripped(Player victim) {
    if (!messages.getBoolean("Stripped.Enable")) {
      return;
    }
    victim.sendMessage(applyColor(prefix + stripped));
  }

  /**
   * Send command sender victim having no inventory space message.
   *
   * @param sender Command sender to send no inventory space message to.
   */
  public static void sendNoSpace(CommandSender sender) {
    if (Config.doIgnoreNoSpace()) {
      return;
    }
    sender.sendMessage(applyColor((prefix + noSpace)));
  }

  /**
   * Send commands help message to help command sender.
   *
   * @param commandSender Command sender to send commands help message to.
   */
  public static void sendHelp(CommandSender commandSender) {
    commandSender.sendMessage(applyColor(HELP_HEADER));
    commandSender.sendMessage(applyColor(HELP_COMMANDS));
    commandSender.sendMessage(applyColor(HELP_ALIASES));
    commandSender.sendMessage(applyColor(HELP_HELP));
    commandSender.sendMessage(applyColor(HELP_RELOAD));
    commandSender.sendMessage(applyColor(HELP_STRIP_PLAYER));
    commandSender.sendMessage(applyColor(HELP_STRIP_PLAYER_SPECIFIC));
    commandSender.sendMessage(applyColor(HELP_STRIP_PLAYER_SPECIFIC_PIECES));
    commandSender.sendMessage(applyColor(HELP_PERMISSIONS));
    commandSender.sendMessage(applyColor(HELP_WILDCARD));
    commandSender.sendMessage(applyColor(HELP_ADMIN));
    commandSender.sendMessage(applyColor(HELP_BYPASS));
    commandSender.sendMessage(applyColor(HELP_FOOTER));
  }

  /**
   * Send config reloaded message to player.
   *
   * @param commandSender CommandSender to send reloaded message to.
   */
  public static void sendReloadSuccess(CommandSender commandSender) {
    commandSender.sendMessage(applyColor(prefix + RELOAD_SUCCESS));
  }
}
