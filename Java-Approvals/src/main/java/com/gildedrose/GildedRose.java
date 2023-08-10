package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            doUpdateItemQuality(items[i]);
        }
    }

    private void doUpdateItemQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            doUpdateAgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            doUpdateBackstage(item);
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            doUpdateSulfuras();
        } else {
            doUpdateOther(item);
        }
    }

    private static void doUpdateOther(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private static void doUpdateSulfuras() {
    }

    private static void doUpdateBackstage(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;
        }
    }

    private static void doUpdateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}
