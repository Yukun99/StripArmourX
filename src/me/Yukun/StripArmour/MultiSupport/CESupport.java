package me.Yukun.StripArmour.MultiSupport;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.badbones69.crazyenchantments.api.CrazyEnchantments;
import me.badbones69.crazyenchantments.multisupport.armorequip.ArmorEquipEvent.EquipMethod;
import me.badbones69.crazyenchantments.multisupport.armorequip.ArmorEquipEvent;

public class CESupport {
	public static void callEvent(Player player, ItemStack armour) {
		if (CrazyEnchantments.getInstance() != null) {
			EquipMethod method = EquipMethod.DRAG;
			ItemStack newarmour = new ItemStack(Material.AIR);
			ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(player, method, null, armour, newarmour);
			Bukkit.getServer().getPluginManager().callEvent(armorEquipEvent);
		}
	}
}