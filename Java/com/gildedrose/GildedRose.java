package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		ItemUpdater itemUpdater = null;
		for (Item item : items){
			switch (item.name) {
			case "Sulfuras, Hand of Ragnaros":
				itemUpdater = new Sulfuras(item);
				break;

			case "Aged Brie":
				itemUpdater = new AgedBrie(item);
				break;

			case "Backstage passes to a TAFKAL80ETC concert":
				itemUpdater = new BackstagePasses(item);
				break;

			default:
				itemUpdater = new Normal(item);
				break;
			}
			
			itemUpdater.update();
		}
	}

	


	
}
