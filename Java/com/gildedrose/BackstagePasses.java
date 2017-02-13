package com.gildedrose;

public class BackstagePasses extends ItemUpdater {

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
		
		if (isItemBelowMaxQuality()) {
			updateQualityBy(1);

			if (item.sellIn < 10 && isItemBelowMaxQuality()) {
				updateQualityBy(1);
			}

			if (item.sellIn < 5 && isItemBelowMaxQuality()) {
				updateQualityBy(1);
			}
		}

	}

}
