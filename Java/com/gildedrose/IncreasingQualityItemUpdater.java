package com.gildedrose;

public abstract class IncreasingQualityItemUpdater extends ItemUpdater{

	public IncreasingQualityItemUpdater(Item item) {
		super(item);
	}
	
	public void increaseQualityBy(int amount){
		if (isItemBelowMaxQuality()) {
			updateQualityBy(1);
		}
	}
	
	abstract void update();

}
