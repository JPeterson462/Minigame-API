package com.digiturtle.minigames.adapters;

import org.bukkit.event.block.BlockPlaceEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnPlaceItemAdapter {

	public boolean onPlace(BlockPlaceEvent event, GItem item);
	
}
