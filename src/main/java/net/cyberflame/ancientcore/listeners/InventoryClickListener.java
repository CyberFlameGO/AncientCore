package net.cyberflame.ancientcore.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener
{
	/**
	 * @param event If an inventory is clicked, check if it's an enderchest inventory
	 */
	@EventHandler
	public void onInventoryClick(final InventoryClickEvent event) {
		final Inventory inventory = event.getInventory();

		if (inventory.getType() == InventoryType.ENDER_CHEST)
			{
				if (event.getRawSlot() < inventory.getSize())
					{
						final ItemStack cursor = event.getCursor();

						if (cursor.getType() == Material.MOB_SPAWNER)
							{
								final int slot = event.getSlot();

								event.setCancelled(true);
								event.setCursor(cursor);  // I know it's deprecated, but I'm not sure if #setCurrentItem would do it
								final ItemStack item = inventory.getItem(slot);
								inventory.setItem(slot, item);
							}
					}
				else if (event.isShiftClick())
					{
						final ItemStack clicked = event.getCurrentItem();
						if (clicked.getType() == Material.MOB_SPAWNER)
							{
								final int slot = event.getSlot();

								event.setCancelled(true);
								final ItemStack item = inventory.getItem(slot);
								inventory.setItem(slot, item);
							}
					}
			}
	}
}
