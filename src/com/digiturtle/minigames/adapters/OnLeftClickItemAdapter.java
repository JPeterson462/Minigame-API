package com.digiturtle.minigames.adapters;

import org.bukkit.event.player.PlayerInteractEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnLeftClickItemAdapter {

	public boolean onLeftClick(PlayerInteractEvent event, GItem item);
	
}
