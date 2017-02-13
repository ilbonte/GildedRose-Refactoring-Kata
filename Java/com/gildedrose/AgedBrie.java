package com.gildedrose;

public class AgedBrie extends BaseItem {


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
