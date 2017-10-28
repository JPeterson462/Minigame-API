package com.digiturtle.minigames.adapters;

import org.bukkit.event.entity.PlayerDeathEvent;

import com.digiturtle.minigames.User;

@FunctionalInterface
public interface OnDeathAdapter {
	
	public void onDeath(PlayerDeathEvent event, User player);

}
