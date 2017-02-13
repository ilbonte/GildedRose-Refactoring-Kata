package com.gildedrose;

public abstract class IncreasingQualityItemUpdater extends ItemUpdater{

	public IncreasingQualityItemUpdater(Item item) {
		super(item);
	}
	
	abstract void update();
	
	public void increaseQualityBy(int amount){
		if (isItemBelowMaxQuality()) {
			updateQualityBy(1);
		}
	}

}
