package com.gildedrose;

public abstract class DecreasingQualityItemUpdater extends ItemUpdater{

	public DecreasingQualityItemUpdater(Item item) {
		super(item);
	}

	abstract void update();
	
	public void decreaseQualityBy(int amount){
		if (item.quality > 0) {
			updateQualityBy(-1);
		}
	}
	
}
