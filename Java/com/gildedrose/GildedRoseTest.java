package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class GildedRoseTest {
	final String NORMAL_ITEM = "Car";
	final String AGED_BRIE = "Aged Brie";
	final String SULFURAS ="Sulfuras, Hand of Ragnaros";
	final String BACKSTAGE_PASSES  = "Backstage passes to a TAFKAL80ETC concert";
	final String CONJURED ="Conjured Mana Cake";

	@Test
	public void qualityOfANormalItemDegradesByOneWhenADayPass() {
		Item[] items = { new ItemBuilder().withName(NORMAL_ITEM).withSellIn(10).withQuality(10).build() };
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(9, app.items[0].quality);
	}
	
	@Test
	public void qualityOfANormalItemDegradesTwiceAsFastWhenIsExpired() throws Exception {
		Item[] items = { new ItemBuilder().withName(NORMAL_ITEM).withSellIn(0).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(8, app.items[0].quality);
	}
	
	@Test
	public void qualityOfANormalItemDegradesTwiceAsFastWhenIsExpiredButMinimuIsZero() throws Exception {
		Item[] items = { new ItemBuilder().withName(NORMAL_ITEM).withSellIn(0).withQuality(1).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(0, app.items[0].quality);
	}
	
	@Test
	public void qualityOfANoramItemIsNeverNegative() throws Exception {
		Item[] items = { new ItemBuilder().withName(NORMAL_ITEM).withSellIn(10).withQuality(0).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(0, app.items[0].quality);
	}
	
	@Test	
	public void qualityOfAgedBrieIncreasesTheOlderItGets() throws Exception {
		Item[] items = { new ItemBuilder().withName(AGED_BRIE).withSellIn(10).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(11, app.items[0].quality);
	}
	
	@Test	
	public void qualityOfAnItemIsNeverMoreThan50() throws Exception {
		Item[] items = { new ItemBuilder().withName(AGED_BRIE).withSellIn(10).withQuality(50).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(50, app.items[0].quality);
	}
	
	@Test	
	public void qualityOfSulfurasNeverChanges() throws Exception {
		Item[] items = { new ItemBuilder().withName(SULFURAS).withSellIn(10).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(10, app.items[0].quality);
	}
	
	@Test	
	public void sellInOfSulfurasNeverChanges() throws Exception {
		Item[] items = { new ItemBuilder().withName(SULFURAS).withSellIn(10).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(10, app.items[0].sellIn);
	}
	
	@Test	
	public void backstagePassesIncreasesQualityBy1WhenTheAreMoreThan10DaysLeft() throws Exception {
		Item[] items = { new ItemBuilder().withName(BACKSTAGE_PASSES).withSellIn(15).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(11, app.items[0].quality);
	}
	
	@Test	
	public void backstagePassesIncreasesQualityBy2WhenTheAre10DaysLeft() throws Exception {
		Item[] items = { new ItemBuilder().withName(BACKSTAGE_PASSES).withSellIn(10).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(12, app.items[0].quality);
	}
	
	@Test	
	public void backstagePassesIncreasesQualityBy2WhenTheAreLessThan10DaysLeft() throws Exception {
		Item[] items = { new ItemBuilder().withName(BACKSTAGE_PASSES).withSellIn(9).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(12, app.items[0].quality);
	}
	
	@Test	
	public void backstagePassesIncreasesQualityBy3WhenTheAre5DaysLeft() throws Exception {
		Item[] items = { new ItemBuilder().withName(BACKSTAGE_PASSES).withSellIn(5).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(13, app.items[0].quality);
	}
	
	@Test	
	public void backstagePassesIncreasesQualityBy3WhenTheAreLessThan5DaysLeft() throws Exception {
		Item[] items = { new ItemBuilder().withName(BACKSTAGE_PASSES).withSellIn(4).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(13, app.items[0].quality);
	}
	
	@Test	
	public void backstagePassesQualityDropTo0AfterTheConcert() throws Exception {
		Item[] items = { new ItemBuilder().withName(BACKSTAGE_PASSES).withSellIn(0).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(0, app.items[0].quality);
	}
	
	@Test	
	public void qualityOfBackstagePassesIsNeverMoreThan50() throws Exception {
		Item[] items = { new ItemBuilder().withName(BACKSTAGE_PASSES).withSellIn(3).withQuality(49).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(50, app.items[0].quality);
	}
	
	@Test
	@Ignore("Not yet implemented")
	public void conjuredItemDegradeInQualityTwiceAsFastAsNormalItems() throws Exception {
		Item[] items = { new ItemBuilder().withName(CONJURED).withSellIn(10).withQuality(10).build() }; 
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		
		assertEquals(8, app.items[0].quality);
	}
	

	@Test
	public void TestFixture() throws Exception {
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Aged Brie", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6)
				};

		Item[] expected = new Item[] { new Item("+5 Dexterity Vest", 9, 19), //
				new Item("Aged Brie", 1, 1), //
				new Item("Elixir of the Mongoose", 4, 6), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
				new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
				new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 2, 5) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		for (int i = 0; i < items.length; i++) {
//			System.out.println(expected[i].name + " - "+ app.items[i].name );
//			System.out.println(expected[i].sellIn + " - "+ app.items[i].sellIn );
//			System.out.println(expected[i].quality + " - "+ app.items[i].quality );
			assertEquals(expected[i].sellIn, app.items[i].sellIn);
			assertEquals(expected[i].quality, app.items[i].quality);
		}

	}



	class ItemBuilder {
		private String name;
		private int days;
		private int quality;

		public ItemBuilder() {

		}

		public ItemBuilder withName(String name) {
			this.name = name;
			return this;
		}
		
		public ItemBuilder withSellIn(int days) {
			this.days = days;
			return this;
		}
		
		public ItemBuilder withQuality(int quality) {
			this.quality = quality;
			return this;
		}

		public Item build() {
			return new Item(this.name, this.days, this.quality);
		}

	}

}
