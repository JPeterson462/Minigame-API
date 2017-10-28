package com.digiturtle.minigames.adapters;

import org.bukkit.event.block.BlockBreakEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnDestroyItemAdapter {

	public boolean onDestroy(BlockBreakEvent event, GItem item);
	
}
