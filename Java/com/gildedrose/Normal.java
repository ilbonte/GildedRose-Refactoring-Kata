package com.gildedrose;

public class Normal extends BaseItem {

	
	


	public Normal(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();
		if (item.quality < 50) {
			decreaseQuality();
			if (item.sellIn < 0) { 
				decreaseQuality();
			}
		}
	}
	
	private void decreaseQuality(){
		if (item.quality > 0) {
			item.quality -= 1;
		}
	}

}
