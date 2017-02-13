package com.gildedrose;

public class BackstagePasses extends BaseItem {

	


	public BackstagePasses(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();
		if (item.quality < 50) {
			if (item.sellIn < 0) {
				item.quality = 0;
				return;
			}

			item.quality += 1;

			if (item.sellIn < 10 && item.quality < 50) {
				item.quality += 1;
			}

			if (item.sellIn < 5 && item.quality < 50) {
				item.quality += 1;
			}
		}
		
	}

}
