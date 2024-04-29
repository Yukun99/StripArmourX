package me.yukun.striparmour.command;

import me.yukun.striparmour.config.FileManager;
import me.yukun.striparmour.config.Messages;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends StripArmourCommand {

  public ReloadCommand(CommandSender sender) {
    super(sender);
  }

  @Override
  public boolean execute() {
    FileManager.reload();
    Messages.sendReloadSuccess(sender);
    return true;
  }
}
