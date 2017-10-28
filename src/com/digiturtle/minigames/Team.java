package com.digiturtle.minigames;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Color;

public class Team {
	
	private final Color color;
	
	private HashMap<Integer, GItem> startingInventory;
	
	private final Uniform uniform;
	
	private ArrayList<User> users;
	
	public Team(Color color, Uniform uniform) {
		this.color = color;
		this.uniform = uniform;
		startingInventory = new HashMap<>();
		users = new ArrayList<>();
	}
	
	public HashMap<Integer, GItem> getStartingInventory() {
		return startingInventory;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Uniform getUniform() {
		return uniform;
	}

}
