package com.digiturtle.minigames;

import java.util.function.Function;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Minigame extends JavaPlugin {

	private GItemRegistry gameItemRegistry;
	
	private MenuRegistry menuRegistry;
	
	private MenuManager menuManager;
	
	private GeneralAdapter generalAdapter;
	
	private UserRegistry userRegistry;
	
	private Function<Player, User> createUser;
	
	public abstract void enable();
	
	public abstract void disable();
	
	public abstract void join(PlayerJoinEvent event);
	
	public abstract void quit(PlayerQuitEvent event);
	
	public void init(Function<Player, User> createUser) {
		this.createUser = createUser;
	}
	
	public void onEnable() {
		gameItemRegistry = new GItemRegistry(this);
		menuRegistry = new MenuRegistry(this);
		menuManager = new MenuManager(this);
		generalAdapter = new GeneralAdapter(this);
		userRegistry = new UserRegistry(this, createUser);
		getServer().getPluginManager().registerEvents(generalAdapter, this);
		enable();
	}
	
	public void onDisable() {
		disable();
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
	
	public UserRegistry getUserRegistry() {
		return userRegistry;
	}
	
}
