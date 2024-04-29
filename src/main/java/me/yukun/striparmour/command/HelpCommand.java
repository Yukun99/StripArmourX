package me.yukun.striparmour.command;

import me.yukun.striparmour.config.Messages;
import org.bukkit.command.CommandSender;

public class HelpCommand extends StripArmourCommand {

  public HelpCommand(CommandSender sender) {
    super(sender);
  }

  @Override
  public boolean execute() {
    Messages.sendHelp(sender);
    return true;
  }
}
