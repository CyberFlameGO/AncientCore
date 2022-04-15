package net.cyberflame.ancientcore;

import net.cyberflame.ancientcore.listeners.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AncientCorePlugin extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
	}
}
