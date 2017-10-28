package com.digiturtle.minigames.adapters;

import org.bukkit.event.inventory.InventoryClickEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnInventoryClickItemAdapter {

	public void onInventoryClick(InventoryClickEvent event, GItem item);
	
}
