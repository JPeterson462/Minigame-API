package com.digiturtle.minigames;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class StringMetadataValue implements MetadataValue {
	
	private final Minigame minigame;
	
	private String text;
	
	public StringMetadataValue(String text, Minigame minigame) {
		this.text = text;
		this.minigame = minigame;
	}

	@Override
	public boolean asBoolean() {
		return false;
	}

	@Override
	public byte asByte() {
		return 0;
	}

	@Override
	public double asDouble() {
		return 0;
	}

	@Override
	public float asFloat() {
		return 0;
	}

	@Override
	public int asInt() {
		return 0;
	}

	@Override
	public long asLong() {
		return 0;
	}

	@Override
	public short asShort() {
		return 0;
	}

	@Override
	public String asString() {
		return text;
	}

	@Override
	public Plugin getOwningPlugin() {
		return minigame;
	}

	@Override
	public void invalidate() {
		
	}

	@Override
	public Object value() {
		return text;
	}

}
