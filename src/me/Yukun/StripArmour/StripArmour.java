package me.Yukun.StripArmour;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StripArmour implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player) {
			if (sender.isOp() || sender.hasPermission("StripArmour.Use")) {
				if (args.length == 0) {
					String header = "&b&l==========StripArmour v1.0 by Yukun==========";
					String footer = "&b&l=============================================";
					String usage = "/striparmour <player>";
					sender.sendMessage(Api.color(header));
					sender.sendMessage(Api.color("&c/striparmour: " + usage));
					sender.sendMessage(Api.color(footer));
				}
				if (args.length == 1) {
					if (args[0] != null) {
						if (Api.getPlayer(args[0]) != null) {
							Player player = Api.getPlayer(args[0]);
							String stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
							String prefix = Api.getMessageString("Messages.Prefix");
							String strippedmsg = Api.getMessageString("Messages.Stripped");
							String invenfull = Api.getMessageString("Messages.InvenFull");
							if (Api.getVersion() >= 191) {
								for (int i = 1; i <= 5; ++i) {
									if (i == 1) {
										ItemStack armour = player.getInventory().getHelmet();
										if (armour != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(armour);
												Api.callEvent(player, armour);
												player.getInventory().setHelmet(new ItemStack(Material.AIR));
												stripped = "&bHelmet";
												continue;
											} else {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + invenfull, player, stripped)));
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
												break;
											}
										} else {
											continue;
										}
									} else if (i == 2) {
										ItemStack armour = player.getInventory().getChestplate();
										if (armour != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(armour);
												Api.callEvent(player, armour);
												player.getInventory().setChestplate(new ItemStack(Material.AIR));
												if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
													stripped = stripped + "&b, Chestplate";
												} else {
													stripped = "&bChestplate";
												}
												continue;
											} else {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + invenfull, player, stripped)));
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
												break;
											}
										} else {
											continue;
										}
									} else if (i == 3) {
										ItemStack armour = player.getInventory().getLeggings();
										if (armour != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(armour);
												Api.callEvent(player, armour);
												player.getInventory().setLeggings(new ItemStack(Material.AIR));
												if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
													stripped = stripped + "&b, Leggings";
												} else {
													stripped = "&bLeggings";
												}
												continue;
											} else {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + invenfull, player, stripped)));
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
												break;
											}
										} else {
											continue;
										}
									} else if (i == 4) {
										ItemStack armour = player.getInventory().getBoots();
										if (armour != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(armour);
												Api.callEvent(player, armour);
												player.getInventory().setBoots(new ItemStack(Material.AIR));
												if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
													stripped = stripped + "&b, Boots";
												} else {
													stripped = "&bBoots";
												}
												continue;
											} else {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + invenfull, player, stripped)));
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
												break;
											}
										} else {
											continue;
										}
									} else if (i == 5) {
										ItemStack hand = Api.getItemInOffHand(player);
										if (hand != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(hand);
												player.getInventory().setLeggings(new ItemStack(Material.AIR));
												if (Api.getConfigString("Options.StrippedMessage")
														.equalsIgnoreCase("true")) {
													sender.sendMessage(Api
															.color(Api.replacePHolders(strippedmsg, player, stripped)));
												}
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											}
										} else {
											if (Api.getConfigString("Options.StrippedMessage")
													.equalsIgnoreCase("true")) {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + strippedmsg, player, stripped)));
											}
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
										}
									}
								}
							} else {
								for (int i = 1; i <= 4; ++i) {
									if (i == 1) {
										ItemStack armour = player.getInventory().getHelmet();
										if (armour != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(armour);
												Api.callEvent(player, armour);
												player.getInventory().setHelmet(new ItemStack(Material.AIR));
												stripped = "&bHelmet";
												continue;
											} else {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + invenfull, player, stripped)));
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
												break;
											}
										} else {
											continue;
										}
									} else if (i == 2) {
										ItemStack armour = player.getInventory().getChestplate();
										if (armour != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(armour);
												Api.callEvent(player, armour);
												player.getInventory().setChestplate(new ItemStack(Material.AIR));
												if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
													stripped = stripped + "&b, Chestplate";
												} else {
													stripped = "&bChestplate";
												}
												continue;
											} else {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + invenfull, player, stripped)));
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
												break;
											}
										} else {
											continue;
										}
									} else if (i == 3) {
										ItemStack armour = player.getInventory().getLeggings();
										if (armour != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(armour);
												Api.callEvent(player, armour);
												player.getInventory().setLeggings(new ItemStack(Material.AIR));
												if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
													stripped = stripped + "&b, Leggings";
												} else {
													stripped = "&bLeggings";
												}
												continue;
											} else {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + invenfull, player, stripped)));
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
												break;
											}
										} else {
											continue;
										}
									} else if (i == 4) {
										ItemStack armour = player.getInventory().getBoots();
										if (armour != null) {
											if (player.getInventory().firstEmpty() != -1) {
												player.getInventory().addItem(armour);
												Api.callEvent(player, armour);
												player.getInventory().setBoots(new ItemStack(Material.AIR));
												if (Api.getConfigString("Options.StrippedMessage")
														.equalsIgnoreCase("true")) {
													sender.sendMessage(Api.color(Api
															.replacePHolders(prefix + strippedmsg, player, stripped)));
												}
												stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											}
										} else {
											if (Api.getConfigString("Options.StrippedMessage")
													.equalsIgnoreCase("true")) {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + strippedmsg, player, stripped)));
											}
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
										}
									}
								}
							}
						}
					}
				}
				return false;
			}
		} else {
			if (args.length == 1) {
				if (args[0] != null) {
					if (Api.getPlayer(args[0]) != null) {
						Player player = Api.getPlayer(args[0]);
						String stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
						String prefix = Api.getMessageString("Messages.Prefix");
						String strippedmsg = Api.getMessageString("Messages.Stripped");
						String invenfull = Api.getMessageString("Messages.InvenFull");
						if (Api.getVersion() >= 191) {
							for (int i = 1; i <= 5; ++i) {
								if (i == 1) {
									ItemStack armour = player.getInventory().getHelmet();
									if (armour != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(armour);
											Api.callEvent(player, armour);
											player.getInventory().setHelmet(new ItemStack(Material.AIR));
											stripped = "&bHelmet";
											continue;
										} else {
											sender.sendMessage(Api
													.color(Api.replacePHolders(prefix + invenfull, player, stripped)));
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											break;
										}
									} else {
										continue;
									}
								} else if (i == 2) {
									ItemStack armour = player.getInventory().getChestplate();
									if (armour != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(armour);
											Api.callEvent(player, armour);
											player.getInventory().setChestplate(new ItemStack(Material.AIR));
											if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
												stripped = stripped + "&b, Chestplate";
											} else {
												stripped = "&bChestplate";
											}
											continue;
										} else {
											sender.sendMessage(Api
													.color(Api.replacePHolders(prefix + invenfull, player, stripped)));
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											break;
										}
									} else {
										continue;
									}
								} else if (i == 3) {
									ItemStack armour = player.getInventory().getLeggings();
									if (armour != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(armour);
											Api.callEvent(player, armour);
											player.getInventory().setLeggings(new ItemStack(Material.AIR));
											if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
												stripped = stripped + "&b, Leggings";
											} else {
												stripped = "&bLeggings";
											}
											continue;
										} else {
											sender.sendMessage(Api
													.color(Api.replacePHolders(prefix + invenfull, player, stripped)));
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											break;
										}
									} else {
										continue;
									}
								} else if (i == 4) {
									ItemStack armour = player.getInventory().getBoots();
									if (armour != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(armour);
											Api.callEvent(player, armour);
											player.getInventory().setBoots(new ItemStack(Material.AIR));
											if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
												stripped = stripped + "&b, Boots";
											} else {
												stripped = "&bBoots";
											}
											continue;
										} else {
											sender.sendMessage(Api
													.color(Api.replacePHolders(prefix + invenfull, player, stripped)));
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											break;
										}
									} else {
										continue;
									}
								} else if (i == 5) {
									ItemStack hand = Api.getItemInOffHand(player);
									if (hand != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(hand);
											player.getInventory().setLeggings(new ItemStack(Material.AIR));
											if (Api.getConfigString("Options.StrippedMessage")
													.equalsIgnoreCase("true")) {
												sender.sendMessage(
														Api.color(Api.replacePHolders(strippedmsg, player, stripped)));
											}
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
										}
									} else {
										if (Api.getConfigString("Options.StrippedMessage").equalsIgnoreCase("true")) {
											sender.sendMessage(Api.color(
													Api.replacePHolders(prefix + strippedmsg, player, stripped)));
										}
										stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
									}
								}
							}
						} else {
							for (int i = 1; i <= 4; ++i) {
								if (i == 1) {
									ItemStack armour = player.getInventory().getHelmet();
									if (armour != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(armour);
											Api.callEvent(player, armour);
											player.getInventory().setHelmet(new ItemStack(Material.AIR));
											stripped = "&bHelmet";
											continue;
										} else {
											sender.sendMessage(Api
													.color(Api.replacePHolders(prefix + invenfull, player, stripped)));
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											break;
										}
									} else {
										continue;
									}
								} else if (i == 2) {
									ItemStack armour = player.getInventory().getChestplate();
									if (armour != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(armour);
											Api.callEvent(player, armour);
											player.getInventory().setChestplate(new ItemStack(Material.AIR));
											if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
												stripped = stripped + "&b, Chestplate";
											} else {
												stripped = "&bChestplate";
											}
											continue;
										} else {
											sender.sendMessage(Api
													.color(Api.replacePHolders(prefix + invenfull, player, stripped)));
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											break;
										}
									} else {
										continue;
									}
								} else if (i == 3) {
									ItemStack armour = player.getInventory().getLeggings();
									if (armour != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(armour);
											Api.callEvent(player, armour);
											player.getInventory().setLeggings(new ItemStack(Material.AIR));
											if (!stripped.equalsIgnoreCase("&cNOTHING! ABSOLUTELY NOTHING!")) {
												stripped = stripped + "&b, Leggings";
											} else {
												stripped = "&bLeggings";
											}
											continue;
										} else {
											sender.sendMessage(Api
													.color(Api.replacePHolders(prefix + invenfull, player, stripped)));
											stripped = "&cNOTHING! ABSOLUTELY NOTHING!";
											break;
										}
									} else {
										continue;
									}
								} else if (i == 4) {
									ItemStack armour = player.getInventory().getBoots();
									if (armour != null) {
										if (player.getInventory().firstEmpty() != -1) {
											player.getInventory().addItem(armour);
											Api.callEvent(player, armour);
											player.getInventory().setBoots(new ItemStack(Material.AIR));
											if (Api.getConfigString("Options.StrippedMessage")
													.equalsIgnoreCase("true")) {
												sender.sendMessage(Api.color(
														Api.replacePHolders(prefix + strippedmsg, player, stripped)));
											}
											stripped = "";
										}
									} else {
										if (Api.getConfigString("Options.StrippedMessage").equalsIgnoreCase("true")) {
											sender.sendMessage(Api.color(
													Api.replacePHolders(prefix + strippedmsg, player, stripped)));
										}
										stripped = "";
									}
								}
							}
						}
					}
				}
			}
			return false;
		}
		return false;
	}
}
