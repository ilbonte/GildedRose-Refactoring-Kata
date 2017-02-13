package com.gildedrose;

public class Normal extends ItemUpdater {

	public Normal(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();
		decreaseQuality();
		if (isSellInDatePassed()) {
			decreaseQuality();
		}
	}

	private void decreaseQuality() {
		if (item.quality > 0) {
			updateQualityBy(-1);
		}
	}

}
