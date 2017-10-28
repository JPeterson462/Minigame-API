package com.digiturtle.minigames;

import java.util.HashMap;
import java.util.Stack;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MenuManager {
	
	private final Minigame minigame;
	
	private HashMap<Player, Stack<Menu>> menus = new HashMap<>();
	
	public MenuManager(Minigame minigame) {
		this.minigame = minigame;
	}
	
	public void openMenu(Player player, String menu, boolean returnToPrevious) {
		Menu menuInstance = minigame.getMenuRegistry().getMenu(menu);
		if (menus.containsKey(player)) {
			Inventory newMenu = menuInstance.createInventory(player);
			Stack<Menu> menuStack = menus.get(player);
			if (returnToPrevious) {
				menuStack.clear();
			}
			menuStack.push(menuInstance);
			player.openInventory(newMenu);
		} else {
			Inventory newMenu = menuInstance.createInventory(player);
			Stack<Menu> menuStack = new Stack<>();
			menuStack.push(menuInstance);
			menus.put(player, menuStack);
			player.openInventory(newMenu);
		}
	}
	
	public void closeMenu(Player player, boolean forceClose) {
		Stack<Menu> menuStack = menus.get(player);
		if (forceClose) {
			player.closeInventory();
		}
		if (menuStack.size() > 0) {
			menuStack.pop();
			Inventory newMenu = menuStack.peek().createInventory(player);
			player.openInventory(newMenu);
		}
	}

}
