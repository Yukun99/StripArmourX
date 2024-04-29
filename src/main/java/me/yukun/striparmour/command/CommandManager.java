package me.yukun.striparmour.command;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import me.yukun.striparmour.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandManager implements CommandExecutor {

  private static final Map<String, Function<CommandSender, StripArmourCommand>> commandProducerMap = new HashMap<>() {{
    put("help", HelpCommand::new);
    put("reload", ReloadCommand::new);
    put("strip", StripCommand::new);
  }};

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
      @NotNull String label, @NotNull String[] args) {
    if (!Config.canUseCommands(sender)) {
      return false;
    }
    if (args.length == 0 || !commandProducerMap.containsKey(args[0])) {
      commandProducerMap.get("help").apply(sender).execute();
      return false;
    }
    StripArmourCommand stripArmourCommand = commandProducerMap.get(args[0]).apply(sender);
    if (stripArmourCommand instanceof StripCommand) {
      ((StripCommand) stripArmourCommand).withArguments(args);
    }
    return stripArmourCommand.execute();
  }
}
