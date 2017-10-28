package com.digiturtle.minigames.adapters;

import org.bukkit.event.entity.EntityDamageEvent;

import com.digiturtle.minigames.User;

@FunctionalInterface
public interface OnHealthLossAdapter {

	public boolean onHealthLoss(EntityDamageEvent event, User user);
	
}
