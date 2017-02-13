package com.gildedrose;

public class Normal extends DecreasingQualityItemUpdater {

	public Normal(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();
		
		decreaseQualityBy(1);
		if (isSellInDatePassed()) {
			decreaseQualityBy(1);
		}
	}

	

}
