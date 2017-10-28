package com.digiturtle.minigames;

import org.bukkit.entity.Player;

import com.digiturtle.minigames.adapters.OnDeathAdapter;
import com.digiturtle.minigames.adapters.OnHealthLossAdapter;
import com.digiturtle.minigames.adapters.OnRespawnAdapter;

public abstract class User {
	
	private final Minigame minigame;
	
	private final Player player;
	
	private Team team;
	
	private OnDeathAdapter deathAdapter;
	
	private OnHealthLossAdapter healthLossAdapter;
	
	private OnRespawnAdapter respawnAdapter;
	
	public User(Minigame minigame, Player player) {
		this.minigame = minigame;
		this.player = player;
	}
	
	public void joinTeam(Team team) {
		this.team = team;
		team.getUsers().add(this);
	}
	
	public void leaveTeam() {
		team.getUsers().remove(this);
	}
	
	public Minigame getMinigame() {
		return minigame;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Team getTeam() {
		return team;
	}

	public OnDeathAdapter getDeathAdapter() {
		return deathAdapter;
	}

	public void setDeathAdapter(OnDeathAdapter deathAdapter) {
		this.deathAdapter = deathAdapter;
	}

	public OnHealthLossAdapter getHealthLossAdapter() {
		return healthLossAdapter;
	}

	public void setHealthLossAdapter(OnHealthLossAdapter healthLossAdapter) {
		this.healthLossAdapter = healthLossAdapter;
	}

	public OnRespawnAdapter getRespawnAdapter() {
		return respawnAdapter;
	}

	public void setRespawnAdapter(OnRespawnAdapter respawnAdapter) {
		this.respawnAdapter = respawnAdapter;
	}
	
}
