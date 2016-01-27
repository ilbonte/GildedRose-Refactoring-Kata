package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	private Item item;

	@Test
	public void at_the_end_of_each_day_our_system_lowers_both_values_for_every_item() {
		item = new ItemBuilder().name("generic item").sellIn(2).quality(3)
				.build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(1, app.items[0].sellIn);
		assertEquals(2, app.items[0].quality);
	}

	@Test
	public void once_the_sell_by_date_has_passed_quality_degrades_twice_as_ast()
			throws Exception {
		item = new ItemBuilder().name("generic item").sellIn(0).quality(3)
				.build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(1, app.items[0].quality);
		assertEquals(-1, app.items[0].sellIn);
	}

	@Test
	public void the_quality_of_an_item_is_never_negative() {
		item = new ItemBuilder().name("generic item").sellIn(0).quality(0)
				.build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(0, app.items[0].quality);
	}

	@Test
	public void the_quality_of_an_conjured_item_is_never_negative() {
		item = new ItemBuilder().name("Conjured").sellIn(0).quality(0)
				.build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(0, app.items[0].quality);
	}
	
	@Test
	public void conjured_degrades_twice_as_fast() throws Exception {
		item = new ItemBuilder().name("Conjured").sellIn(4).quality(5).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(3, app.items[0].quality);
		assertEquals(3, app.items[0].sellIn);
	}

	@Test
	public void conjured_degrades_4x_as_fast() throws Exception {
		item = new ItemBuilder().name("Conjured").sellIn(0).quality(5).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(1, app.items[0].quality);
		assertEquals(-1, app.items[0].sellIn);
	}
	
	@Test
	public void aged_brie_increases_in_quality() throws Exception {
		item = new ItemBuilder().name("Aged Brie").sellIn(4).quality(5).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(6, app.items[0].quality);
		assertEquals(3, app.items[0].sellIn);
	}

	@Test
	public void backstage_passes_increases_in_quality() throws Exception {
		item = new ItemBuilder()
				.name("Backstage passes to a TAFKAL80ETC concert").sellIn(12)
				.quality(5).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(6, app.items[0].quality);
		assertEquals(11, app.items[0].sellIn);
	}

	@Test
	public void backstage_passes_increases_in_quality_twice_when_sellIn_is_less_than_10()
			throws Exception {
		item = new ItemBuilder()
				.name("Backstage passes to a TAFKAL80ETC concert").sellIn(8)
				.quality(5).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(7, app.items[0].quality);
		assertEquals(7, app.items[0].sellIn);
	}

	@Test
	public void backstage_passes_increases_in_quality_thrice_when_sellIn_is_less_than_5()
			throws Exception {
		item = new ItemBuilder()
				.name("Backstage passes to a TAFKAL80ETC concert").sellIn(4)
				.quality(5).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(8, app.items[0].quality);
		assertEquals(3, app.items[0].sellIn);
	}

	@Test
	public void backstage_passes_drops_to_zero_when_sellIn_is_less_than_0()
			throws Exception {
		item = new ItemBuilder()
				.name("Backstage passes to a TAFKAL80ETC concert").sellIn(0)
				.quality(20).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(0, app.items[0].quality);
		assertEquals(-1, app.items[0].sellIn);
	}

	@Test
	public void solfuras_never_decreses_quality()
			throws Exception {
		item = new ItemBuilder()
				.name("Sulfuras, Hand of Ragnaros").sellIn(5)
				.quality(100).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(100, app.items[0].quality);
	}
	
	@Test
	public void solfuras_sellIn_should_remainSame()
			throws Exception {
		item = new ItemBuilder()
				.name("Sulfuras, Hand of Ragnaros").sellIn(5)
				.quality(100).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(5, app.items[0].sellIn);
	}
	
	@Test
	public void quality_of_an_item_is_never_more_than_50()
			throws Exception {
		item = new ItemBuilder()
				.name("Aged Brie").sellIn(5)
				.quality(50).build();
		GildedRose app = new GildedRose(item);

		app.updateQuality();

		assertEquals(50, app.items[0].quality);
	}

}
