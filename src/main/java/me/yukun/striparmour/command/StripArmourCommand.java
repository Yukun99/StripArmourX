package me.yukun.striparmour.command;

import org.bukkit.command.CommandSender;

public class StripArmourCommand {

  protected CommandSender sender;

  public StripArmourCommand(CommandSender sender) {
    this.sender = sender;
  }

  /**
   * Executes the command.
   */
  public boolean execute() {
    return false;
  }
}
