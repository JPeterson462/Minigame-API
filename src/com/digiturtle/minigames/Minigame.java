package com.digiturtle.minigames;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class Minigame extends JavaPlugin {

	private GItemRegistry gameItemRegistry;
	
	private MenuRegistry menuRegistry;
	
	private MenuManager menuManager;
	
	private GeneralAdapter generalAdapter;
	
	public void onEnable() {
		gameItemRegistry = new GItemRegistry(this);
		menuRegistry = new MenuRegistry(this);
		menuManager = new MenuManager(this);
		generalAdapter = new GeneralAdapter(this);
		getServer().getPluginManager().registerEvents(generalAdapter, this);
	}
	
	public void onDisable() {
		
	}
	
	public GItemRegistry getGameItemRegistry() {
		return gameItemRegistry;
	}
	
	public MenuRegistry getMenuRegistry() {
		return menuRegistry;
	}
	
	public MenuManager getMenuManager() {
		return menuManager;
	}
	
}
