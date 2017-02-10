package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateItem(items[i]);
		}
	}

	private void updateItem(Item item) {

		switch (item.name) {
		case "Sulfuras, Hand of Ragnaros":

			break;

		case "Aged Brie":
			updateAgedBrie(item);
			break;

		case "Backstage passes to a TAFKAL80ETC concert":
			item.sellIn -= 1;
			updateBackstagePasses(item);
			break;

		default:
			item.sellIn -= 1;
			if (item.quality < 50) {
				if (item.quality > 0) {
					item.quality -= 1;

					if (item.sellIn < 0) {
						item.quality -= 1;
					}
				}
			}

			break;
		}
	}

	private void updateBackstagePasses(Item item) {
		if (item.quality < 50) {
			if (item.sellIn < 0) {
				item.quality = 0;
				return;
			}

			item.quality += 1;

			if (item.sellIn < 10 && item.quality < 50) {
				item.quality += 1;
			}

			if (item.sellIn < 5 && item.quality < 50) {
				item.quality += 1;
			}
		}
	}

	private void updateAgedBrie(Item item) {
		item.sellIn -= 1;
		if (item.quality < 50) {
			item.quality += 1;
		}
	}
}
