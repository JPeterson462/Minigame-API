package com.digiturtle.minigames.adapters;

import org.bukkit.event.player.PlayerInteractEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnRightClickItemAdapter {

	public boolean onRightClick(PlayerInteractEvent event, GItem item);
	
}
