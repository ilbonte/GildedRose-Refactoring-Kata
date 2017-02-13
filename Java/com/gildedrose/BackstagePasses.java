package com.gildedrose;

public class BackstagePasses extends BaseItem {

	


	public BackstagePasses(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();
		
		if (isItemBelowMaxQuality()) {
			if (item.sellIn < 0) {
				item.quality = 0;
				return;
			}

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
