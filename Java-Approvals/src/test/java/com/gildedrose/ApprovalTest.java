package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class ApprovalTest {

    @Test
    public void updateQuality() {
        CombinationApprovals.verifyAllCombinations(
            this::callUpdateQuality,
            new String[]{"a common item", "Sulfuras, Hand of Ragnaros", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert"},
            new Integer[]{0, -1, 1, 12},
            new Integer[]{0, 2, 49, 50}
        );
    }

    private String callUpdateQuality(String name,int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        return gildedRose.items[0].toString();
    }
}
