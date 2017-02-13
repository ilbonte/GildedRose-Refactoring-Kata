package com.gildedrose;

public class AgedBrie extends ItemUpdater {


	public AgedBrie(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();
		if (isItemBelowMaxQuality()) {
			updateQualityBy(1);
		}
		
	}

}
