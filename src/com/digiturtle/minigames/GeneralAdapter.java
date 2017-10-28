package com.digiturtle.minigames;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

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
		if (item == null) {
			return;
		}
		if (event.getAction() == Action.PHYSICAL) {
			item.getCollideWithAdapter().onCollideWith(event, item);
		}
		else if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
			item.getLeftClickItemAdapter().onLeftClick(event, item);
		}
		else if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			itemInHand.getLeftClickWithAdapter().onLeftClickWith(itemInHand);
		}
		else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			item.getRightClickItemAdapter().onRightClick(event, item);
		}
		else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			itemInHand.getRightClickWithAdapter().onRightClickWith(itemInHand);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getBlock());
		if (item == null) {
			return;
		}
		item.getDestroyItemAdapter().onDestroy(event, item);
	}
	
	@EventHandler
	public void onDropItem(PlayerDropItemEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getItemDrop().getItemStack());
		if (item == null) {
			return;
		}
		item.getDropItemAdapter().onDrop(event, item);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getCurrentItem());
		if (item == null) {
			return;
		}
		item.getInventoryClickItemAdapter().onInventoryClick(event, item);
	}
	
	@EventHandler
	public void onLaunchItem(ProjectileLaunchEvent event) {

	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		GItem item = minigame.getGameItemRegistry().getItem(event.getBlock());
		if (item == null) {
			return;
		}
		item.getPlaceItemAdapter().onPlace(event, item);
	}
	
	@EventHandler
	public void onPickup(EntityPickupItemEvent event) {
		if (!(event.getEntityType() == EntityType.PLAYER)) {
			return;
		}
		GItem item = minigame.getGameItemRegistry().getItem(event.getItem().getItemStack());
		if (item == null) {
			return;
		}
		item.getPickupItemAdapter().onPickup(event, item);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		minigame.join(event);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		minigame.quit(event);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		User user = minigame.getUserRegistry().getUser(event.getEntity());
		if (user == null) {
			return;
		}
		user.getDeathAdapter().onDeath(event, user);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (event.getEntityType() == EntityType.PLAYER) {
			Player player = (Player) event.getEntity();
			User user = minigame.getUserRegistry().getUser(player);
			if (user == null) {
				return;
			}
			user.getHealthLossAdapter().onHealthLoss(event, user);
		}
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		User user = minigame.getUserRegistry().getUser(event.getPlayer());
		if (user == null) {
			return;
		}
		user.getRespawnAdapter().onRespawn(event, user);
	}
	
}
