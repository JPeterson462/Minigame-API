package com.digiturtle.minigames;

import org.bukkit.inventory.ItemStack;

import com.digiturtle.minigames.adapters.*;

public class GItem {
	
	private final ItemStack item;
	
	private final Minigame minigame;
	
	private OnCollideWithAdapter collideWithAdapter;
	
	private OnDestroyItemAdapter destroyItemAdapter;
	
	private OnDropItemAdapter dropItemAdapter;
	
	private OnInventoryClickItemAdapter inventoryClickItemAdapter;
	
	private OnLaunchItemAdapter launchItemAdapter;
	
	private OnLeftClickItemAdapter leftClickItemAdapter;
	
	private OnLeftClickWithAdapter leftClickWithAdapter;
	
	private OnPickupItemAdapter pickupItemAdapter;
	
	private OnPlaceItemAdapter placeItemAdapter;
	
	private OnRightClickItemAdapter rightClickItemAdapter;
	
	private OnRightClickWithAdapter rightClickWithAdapter;
	
	public GItem(ItemStack item, Minigame minigame) {
		this.item = item;
		this.minigame =  minigame;
	}

	public OnCollideWithAdapter getCollideWithAdapter() {
		return collideWithAdapter;
	}

	public void setCollideWithAdapter(OnCollideWithAdapter collideWithAdapter) {
		this.collideWithAdapter = collideWithAdapter;
	}

	public OnDestroyItemAdapter getDestroyItemAdapter() {
		return destroyItemAdapter;
	}

	public void setDestroyItemAdapter(OnDestroyItemAdapter destroyItemAdapter) {
		this.destroyItemAdapter = destroyItemAdapter;
	}

	public OnDropItemAdapter getDropItemAdapter() {
		return dropItemAdapter;
	}

	public void setDropItemAdapter(OnDropItemAdapter dropItemAdapter) {
		this.dropItemAdapter = dropItemAdapter;
	}

	public OnInventoryClickItemAdapter getInventoryClickItemAdapter() {
		return inventoryClickItemAdapter;
	}

	public void setInventoryClickItemAdapter(OnInventoryClickItemAdapter inventoryClickItemAdapter) {
		this.inventoryClickItemAdapter = inventoryClickItemAdapter;
	}

	public OnLaunchItemAdapter getLaunchItemAdapter() {
		return launchItemAdapter;
	}

	public void setLaunchItemAdapter(OnLaunchItemAdapter launchItemAdapter) {
		this.launchItemAdapter = launchItemAdapter;
	}

	public OnLeftClickItemAdapter getLeftClickItemAdapter() {
		return leftClickItemAdapter;
	}

	public void setLeftClickItemAdapter(OnLeftClickItemAdapter leftClickItemAdapter) {
		this.leftClickItemAdapter = leftClickItemAdapter;
	}

	public OnLeftClickWithAdapter getLeftClickWithAdapter() {
		return leftClickWithAdapter;
	}

	public void setLeftClickWithAdapter(OnLeftClickWithAdapter leftClickWithAdapter) {
		this.leftClickWithAdapter = leftClickWithAdapter;
	}

	public OnPickupItemAdapter getPickupItemAdapter() {
		return pickupItemAdapter;
	}

	public void setPickupItemAdapter(OnPickupItemAdapter pickupItemAdapter) {
		this.pickupItemAdapter = pickupItemAdapter;
	}

	public OnPlaceItemAdapter getPlaceItemAdapter() {
		return placeItemAdapter;
	}

	public void setPlaceItemAdapter(OnPlaceItemAdapter placeItemAdapter) {
		this.placeItemAdapter = placeItemAdapter;
	}

	public OnRightClickItemAdapter getRightClickItemAdapter() {
		return rightClickItemAdapter;
	}

	public void setRightClickItemAdapter(OnRightClickItemAdapter rightClickItemAdapter) {
		this.rightClickItemAdapter = rightClickItemAdapter;
	}

	public OnRightClickWithAdapter getRightClickWithAdapter() {
		return rightClickWithAdapter;
	}

	public void setRightClickWithAdapter(OnRightClickWithAdapter rightClickWithAdapter) {
		this.rightClickWithAdapter = rightClickWithAdapter;
	}

	public ItemStack getItem() {
		return item;
	}

	public Minigame getMinigame() {
		return minigame;
	}

}
