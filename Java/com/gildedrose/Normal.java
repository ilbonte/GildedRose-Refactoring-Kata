package com.gildedrose;

public class Normal extends BaseItem {

	public Normal(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();
		decreaseQuality();
		if (item.sellIn < 0) {
			decreaseQuality();
		}
	}

	private void decreaseQuality() {
		if (item.quality > 0) {
			updateQualityBy(-1);
		}
	}

}
