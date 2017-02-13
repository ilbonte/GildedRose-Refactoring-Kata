package com.gildedrose;

public class AgedBrie extends IncreasingQualityItemUpdater {


	public AgedBrie(Item item) {
		super(item);
	}

	@Override
	void update() {
		decrementSellIn();
		
		increaseQualityBy(1);
	}

}
