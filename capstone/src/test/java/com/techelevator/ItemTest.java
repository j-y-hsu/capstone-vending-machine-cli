package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ItemTest {

    Item item;

    @Test
    void itemConstructorShouldCreateItem() {
        String[] values = { "B2", "Lays", "2.50", "Chip"};
        item = new Item(values);
        String slot = "B2";
        String name = "Lays";
        BigDecimal price = new BigDecimal("2.50");
        String type = "Chip";
        int count = 5;

        Assert.assertEquals(slot, item.getSlotLocation());
        Assert.assertEquals(name, item.getProductName());
        Assert.assertEquals(price, item.getPrice());
        Assert.assertEquals(type, item.getType());
        Assert.assertEquals(count, item.getCount());
    }

    @Test
    void getMessageShouldReturnCrunchCrunchYumForChip() {
        String[] values = {"B2", "Lays", "2.50", "Chip"};
        item = new Item(values);
        String result = item.getMessage();
        String expected = "Crunch Crunch, Yum!";

        Assert.assertEquals(expected, result);
    }

    @Test
    void getMessageShouldReturnMunchMunchYumForCandy() {
        String[] values = {"B2", "Lays", "2.50", "Candy"};
        item = new Item(values);
        String result = item.getMessage();
        String expected = "Munch Munch, Yum!";

        Assert.assertEquals(expected, result);
    }

    @Test
    void getMessageShouldReturnGlugGlugYumForDrink() {
        String[] values = {"B2", "Lays", "2.50", "Drink"};
        item = new Item(values);
        String result = item.getMessage();
        String expected = "Glug Glug, Yum!";

        Assert.assertEquals(expected, result);
    }

    @Test
    void getMessageShouldReturnChewChewYumForGum() {
        String[] values = {"B2", "Lays", "2.50", "Gum"};
        item = new Item(values);
        String result = item.getMessage();
        String expected = "Chew Chew, Yum!";

        Assert.assertEquals(expected, result);
    }

    @Test
    void getAmountSoldShouldReturnOne() {
        String[] values = {"B2", "Lays", "2.50", "Chip"};
        item = new Item(values);
        int expected = 1;

        item.decreaseAmount();
        int result = item.getAmountSold();

        Assert.assertEquals(expected, result);
    }

    @Test
    void isSoldOutShouldReturnTrueWithCountAtZero() {
        String[] values = {"B2", "Lays", "2.50", "Chip"};
        item = new Item(values);
        for (int i = 0; i < 5; i++) {
            item.decreaseAmount();
        }

        boolean result = item.isSoldOut();
        Assert.assertTrue(result);
    }

    @Test
    void isSoldOutShouldReturnFalseWithCountNotAtZero() {
        String[] values = {"B2", "Lays", "2.50", "Chip"};
        item = new Item(values);

        boolean result = item.isSoldOut();
        Assert.assertFalse(result);
    }

    @Test
    void decreaseAmountShouldReturnFourWithOneCall() {
        String[] values = {"B2", "Lays", "2.50", "Chip"};
        item = new Item(values);
        int expected = 4;

        item.decreaseAmount();
        int result = item.getCount();

        Assert.assertEquals(expected, result);
    }

    @Test
    void testToStringShouldReturnCorrectStringWithFiveCount() {
        String[] values = {"B2", "Lays", "2.50", "Chip"};
        item = new Item(values);
        String expected = "B2 | Lays | $2.50 | 5";
        String result = item.toString();
        Assert.assertEquals(expected, result);
    }

    @Test
    void testToStringShouldReturnCorrectStringWithSoldOut() {
        String[] values = {"B2", "Lays", "2.50", "Chip"};
        item = new Item(values);
        String expected = "B2 | Lays | $2.50 | SOLD OUT";

        for (int i = 0; i < 5; i++) {
            item.decreaseAmount();
        }
        String result = item.toString();

        Assert.assertEquals(expected, result);
    }
}