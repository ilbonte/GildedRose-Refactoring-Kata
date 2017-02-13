package com.gildedrose;

public class Normal extends BaseItem {

	private Item item;



	public Normal(Item item) {
		this.item = item;
	}
	


	@Override
	void update() {
		item.sellIn -= 1;
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
