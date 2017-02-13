package com.gildedrose;

public abstract class IncreasingQualityItemUpdater extends ItemUpdater{

	private final int MAX_ITEM_QUALITY=50;
	
	public IncreasingQualityItemUpdater(Item item) {
		super(item);
	}
	
	abstract void update();
	
	public boolean isItemBelowMaxQuality(){
		return item.quality < MAX_ITEM_QUALITY;
	}
	
	public void increaseQualityBy(int amount){
		if (isItemBelowMaxQuality()) {
			updateQualityBy(1);
		}
	}

}
