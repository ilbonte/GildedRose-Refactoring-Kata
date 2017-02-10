package com.gildedrose;

public class AgedBrie extends BaseItem {

	private Item item;



	public AgedBrie(Item item) {
		this.item = item;
	}
	


	@Override
	void update() {
		item.sellIn -= 1;
		if (item.quality < 50) {
			item.quality += 1;
		}
		
	}

}
