package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		ItemUpdater itemUpdater = null;
		for (int i = 0; i < items.length; i++) {
			switch (items[i].name) {
			case "Sulfuras, Hand of Ragnaros":
				itemUpdater = new Sulfuras(items[i]);
				break;

			case "Aged Brie":
				itemUpdater = new AgedBrie(items[i]);
				break;

			case "Backstage passes to a TAFKAL80ETC concert":
				itemUpdater = new BackstagePasses(items[i]);
				break;

			default:
				itemUpdater = new Normal(items[i]);
				break;
			}
			
			itemUpdater.update();
		}
	}

	


	
}
