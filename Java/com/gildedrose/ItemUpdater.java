package com.gildedrose;

public abstract class ItemUpdater{

	Item item;
	
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
	
	public boolean isSellInDatePassed(){
		return item.sellIn < 0;
	}
}
