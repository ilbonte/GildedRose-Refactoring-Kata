package com.gildedrose;

public class AgedBrie extends BaseItem {


	public AgedBrie(Item item) {
		super(item);
	}

	@Override
	void update() {
		item.sellIn -= 1;
		if (item.quality < 50) {
			item.quality += 1;
		}
		
	}

}
