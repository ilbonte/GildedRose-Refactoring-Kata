package com.gildedrose;

class GildedRose {
	
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String CONJURED = "Conjured";
	
    Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) { 
        	
			if (CONJURED.equals(currentItem.name)) {
				conjuredDecrease(currentItem);
        		continue;
        	}
			
            if (!AGED_BRIE.equals(currentItem.name)
                    && !BACKSTAGE_PASSES.equals(currentItem.name)) {
                if (currentItem.quality > 0) {
                    if (!SULFURAS.equals(currentItem.name)) {
                        currentItem.quality--;
                    }
                }
            } else {
                if (currentItem.quality < 50) {
                    currentItem.quality++;

                    if (BACKSTAGE_PASSES.equals(currentItem.name)) {
                        if (currentItem.sellIn < 11) {
                            if (currentItem.quality < 50) {
                                currentItem.quality++;
                            }
                        }

                        if (currentItem.sellIn < 6) {
                            if (currentItem.quality < 50) {
                                currentItem.quality++;
                            }
                        }
                    }
                }
            }

            if (!SULFURAS.equals(currentItem.name)) {
                currentItem.sellIn = currentItem.sellIn - 1;
            }

            if (currentItem.sellIn < 0) {
                if (!AGED_BRIE.equals(currentItem.name)) {
                    if (!BACKSTAGE_PASSES.equals(currentItem.name)) {
                        if (currentItem.quality > 0) {
                            if (!SULFURAS.equals(currentItem.name)) {
                                currentItem.quality--;
                            }
                        }
                    } else {
                        currentItem.quality = 0;
                    }
                } else {
                    if (currentItem.quality < 50) {
                        currentItem.quality++;
                    }
                }
            }
        }
    }

	private void conjuredDecrease(Item currentItem) {
		currentItem.sellIn--;
		currentItem.quality -= currentItem.sellIn>=0 ?  2 : 4;
	}
}
