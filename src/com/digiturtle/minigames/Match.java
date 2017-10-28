package com.digiturtle.minigames;

import org.bukkit.Location;

public abstract class Match {
	
	private final Minigame minigame;
	
	private final Team[] teams;
	
	private Location[] spawnpoints;
	
	private long gameStartTime, gameDuration;
	
	private boolean active;
	
	public Match(Minigame minigame, long gameDuration, Team... teams) {
		this.minigame = minigame;
		this.gameDuration = gameDuration;
		this.teams = teams;
		spawnpoints = new Location[teams.length];
	}
	
	public Minigame getMinigame() {
		return minigame;
	}
	
	public Team[] getTeams() {
		return teams;
	}
	
	public Location[] getSpawnPoints() {
		return spawnpoints;
	}
	
	public void setSpawnPoint(int team, Location spawnpoint) {
		spawnpoints[team] = spawnpoint;
	}
	
	public void start() {
		gameStartTime = System.currentTimeMillis();
		active = true;
		setupPlayers();
		runUpdate();
	}
	
	private void runUpdate() {
		minigame.getServer().getScheduler().runTaskLater(minigame, () -> {
			update();
			if (active) {
				runUpdate();
			}
		}, 10);
	}
	
	public void update() {
		if (System.currentTimeMillis() - gameStartTime > gameDuration) {
			active = false;
			resetPlayers();
		}
		updatePlayers();
	}
	
	public boolean isActive() {
		return active;
	}
	
	public abstract void setupPlayers();
	
	public abstract void resetPlayers();
	
	public abstract void updatePlayers();
	
}
