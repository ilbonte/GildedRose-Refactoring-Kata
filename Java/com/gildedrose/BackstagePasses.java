package com.gildedrose;

public class BackstagePasses extends BaseItem {

	private Item item;



	public BackstagePasses(Item item) {
		this.item = item;
	}
	


	@Override
	void update() {
		item.sellIn -= 1;
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
