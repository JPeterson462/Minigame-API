package com.digiturtle.minigames;

import java.util.HashMap;
import java.util.Map;

public class MenuRegistry {

	private HashMap<String, Menu> menus = new HashMap<>();
	
	private final Minigame minigame;
	
	public MenuRegistry(Minigame minigame) {
		this.minigame = minigame;
	}
	
	public Menu newMenu(String name, int size, HashMap<Integer, GItem> items) {
		 Menu menu = new Menu(name, minigame, size);
		 for (Map.Entry<Integer, GItem> item : items.entrySet()) {
			 menu.setItem(item.getKey(), item.getValue());
		 }
		 menus.put(name, menu);
		 return menu;
	}
	
	public Menu getMenu(String name) {
		return menus.get(name);
	}

}
