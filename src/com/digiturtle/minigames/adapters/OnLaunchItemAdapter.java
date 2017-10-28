package com.digiturtle.minigames.adapters;

import org.bukkit.event.entity.ProjectileLaunchEvent;

import com.digiturtle.minigames.GItem;

@FunctionalInterface
public interface OnLaunchItemAdapter {

	public boolean onLaunch(ProjectileLaunchEvent event, GItem item);
	
}
