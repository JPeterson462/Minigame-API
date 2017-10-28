package com.digiturtle.minigames.adapters;

import org.bukkit.event.player.PlayerRespawnEvent;

import com.digiturtle.minigames.User;

@FunctionalInterface
public interface OnRespawnAdapter {

	public boolean onRespawn(PlayerRespawnEvent event, User user);
	
}
