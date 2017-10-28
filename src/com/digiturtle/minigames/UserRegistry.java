package com.digiturtle.minigames;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Function;

import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class UserRegistry {
	
	private final Minigame minigame;
	
	private HashMap<UUID, User> users = new HashMap<>();
	
	public Function<Player, User> createUser;
	
	public UserRegistry(Minigame minigame, Function<Player, User> createUser) {
		this.minigame = minigame;
		this.createUser = createUser;
	}
	
	public User newUser(Player player) {
		User user = createUser.apply(player);
		users.put(player.getUniqueId(), user);
		return user;
	}
	
	public User getUser(UUID uuid) {
		return users.get(uuid);
	}
	
	public User getUser(Player player) {
		return users.get(player.getUniqueId());
	}

}
