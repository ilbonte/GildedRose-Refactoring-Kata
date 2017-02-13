package com.gildedrose;

public abstract class ItemUpdater{

	Item item;
	private final int MAX_ITEM_QUALITY=50;
	
	public ItemUpdater(Item item){
		this.item = item;
	}
	
	abstract void update();
	
	void decrementSellIn(){
		item.sellIn -= 1;
	}
	
	void updateQualityBy(int amount){
		item.quality += (amount);
	}
	
	public boolean isItemBelowMaxQuality(){
		return item.quality < MAX_ITEM_QUALITY;
	}
	
	public boolean isSellInDatePassed(){
		return item.sellIn < 0;
	}
}
