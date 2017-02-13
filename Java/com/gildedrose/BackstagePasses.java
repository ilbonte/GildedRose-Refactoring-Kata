package com.gildedrose;

public class BackstagePasses extends IncreasingQualityItemUpdater {

	public BackstagePasses(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();

		if (isSellInDatePassed()) {
			item.quality = 0;
			return;
		}

		increaseQualityBy(1);

		if (item.sellIn < 10) {
			increaseQualityBy(1);
		}

		if (item.sellIn < 5) {
			increaseQualityBy(1);
		}

	}

}
