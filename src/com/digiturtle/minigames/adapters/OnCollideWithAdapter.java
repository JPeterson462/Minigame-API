package com.digiturtle.minigames.adapters;

import org.bukkit.event.player.PlayerInteractEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnCollideWithAdapter {

	public boolean onCollideWith(PlayerInteractEvent event, GItem item);
	
}
