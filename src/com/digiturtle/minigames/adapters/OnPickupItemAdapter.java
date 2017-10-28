package com.digiturtle.minigames.adapters;

import org.bukkit.event.entity.EntityPickupItemEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnPickupItemAdapter {

	public boolean onPickup(EntityPickupItemEvent event, GItem item);
	
}
