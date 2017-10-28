package com.digiturtle.minigames;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Menu {
	
	private final String name;
	
	private final Minigame minigame;
	
	private final int size;
	
	private HashMap<Integer, GItem> items = new HashMap<>();
	
	public Menu(String name, Minigame minigame, int size) {
		this.name = name;
		this.minigame = minigame;
		this.size = size;
	}
	
	public void setItem(int slot, GItem item) {
		if (item == null) {
			items.remove(slot);
		} else {
			items.put(slot, item);
		}
	}
	
	public Inventory createInventory(Player owner) {
		Inventory inventory = Bukkit.createInventory(owner, size, name);
		for (Map.Entry<Integer, GItem> item : items.entrySet()) {
			inventory.setItem(item.getKey(), item.getValue().getItem());
		}
		return inventory;
	}
	
	public String getName() {
		return name;
	}
	
	public Minigame getMinigame() {
		return minigame;
	}
	
	public int size() {
		return size;
	}

}
