package com.gildedrose;

public abstract class BaseItem{

	Item item;
	
	public BaseItem(Item item){
		this.item = item;
	}
	
	abstract void update();
	
	void decrementSellIn(){
		item.sellIn -= 1;
	}
}
