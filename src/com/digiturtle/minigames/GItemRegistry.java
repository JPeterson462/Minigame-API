package com.digiturtle.minigames;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GItemRegistry {
	
	public static final String BLOCK_TITLE = "block.title";
	
	private HashMap<String, GItem> gameItems = new HashMap<>();
	
	private final Minigame minigame;
	
	public GItemRegistry(Minigame minigame) {
		this.minigame = minigame;
	}
	
	public GItem newItem(Material material, int quantity, String title, ArrayList<String> info) {
		ItemStack item = new ItemStack(material, quantity);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(title);
		meta.setLore(info);
		GItem gItem = new GItem(item, minigame);
		gameItems.put(title, gItem);
		return gItem;
	}
	
	public void applyToBlock(GItem item, Block block) {
		block.setMetadata(BLOCK_TITLE, new StringMetadataValue(item.getItem().getItemMeta().getDisplayName(), minigame));
	}
	
	public GItem getItem(ItemStack item) {
		return gameItems.get(item.getItemMeta().getDisplayName());
	}
	
	public GItem getItem(Block block) {
		return gameItems.get(block.getMetadata(BLOCK_TITLE));
	}
	
}
