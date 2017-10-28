package com.digiturtle.minigames;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class GeneralAdapter implements Listener {
	
	private final Minigame minigame;
	
	public GeneralAdapter(Minigame minigame) {
		this.minigame = minigame;
	}
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		minigame.getMenuManager().closeMenu((Player) event.getPlayer(), false);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getClickedBlock());
		GItem itemInHand = minigame.getGameItemRegistry().getItem(event.getItem());
		if (event.getAction() == Action.PHYSICAL) {
			item.getCollideWithAdapter().onCollideWith(event, item);
		}
		else if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
			item.getLeftClickItemAdapter().onLeftClick(event, item);
		}
		else if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			item.getLeftClickWithAdapter().onLeftClickWith(itemInHand);
		}
		else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			item.getRightClickItemAdapter().onRightClick(event, item);
		}
		else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			item.getRightClickWithAdapter().onRightClickWith(itemInHand);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getBlock());
		item.getDestroyItemAdapter().onDestroy(event, item);
	}
	
	@EventHandler
	public void onDropItem(PlayerDropItemEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getItemDrop().getItemStack());
		item.getDropItemAdapter().onDrop(event, item);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getCurrentItem());
		item.getInventoryClickItemAdapter().onInventoryClick(event, item);
	}
	
	@EventHandler
	public void onLaunchItem(ProjectileLaunchEvent event) {
		// TODO
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getBlock());
		item.getPlaceItemAdapter().onPlace(event, item);
	}
	
	@EventHandler
	public void onPickup(EntityPickupItemEvent event) {
		if (!(event.getEntityType() == EntityType.PLAYER)) {
			return;
		}
		GItem item = minigame.getGameItemRegistry().getItem(event.getItem().getItemStack());
		item.getPickupItemAdapter().onPickup(event, item);
	}

}
