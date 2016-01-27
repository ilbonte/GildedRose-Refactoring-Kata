package com.gildedrose;

public class ItemBuilder {

	private String name;
	private int sellIn;
	private int quality;

	public ItemBuilder name(String string) {
		this.name = string;
		return this;
	}

	public ItemBuilder sellIn(int sellIn) {
		this.sellIn = sellIn;
		return this;
	}

	public ItemBuilder quality(int quality) {
		this.quality = quality;
		return this;
	}

	public Item build() {
		return new Item(name, sellIn, quality);
	}

}
