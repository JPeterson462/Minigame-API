package com.digiturtle.minigames.adapters;

import org.bukkit.event.player.PlayerDropItemEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnDropItemAdapter {

	public boolean onDrop(PlayerDropItemEvent event, GItem item);
	
}
