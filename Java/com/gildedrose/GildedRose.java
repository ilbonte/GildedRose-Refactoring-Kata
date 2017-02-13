package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		ItemUpdater baseItem = null;
		for (int i = 0; i < items.length; i++) {
			switch (items[i].name) {
			case "Sulfuras, Hand of Ragnaros":
				baseItem = new Sulfuras(items[i]);
				break;

			case "Aged Brie":
				baseItem = new AgedBrie(items[i]);
				break;

			case "Backstage passes to a TAFKAL80ETC concert":
				baseItem = new BackstagePasses(items[i]);
				break;

			default:
				baseItem = new Normal(items[i]);
				break;
			}
			
			baseItem.update();
		}
	}

	


	
}
