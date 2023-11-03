package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private final int MAX_ITEM_COUNT = 5;
    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private String type;
    private int count = MAX_ITEM_COUNT;

    public Item(String[] values) {
        this.slotLocation = values[0];
        this.productName = values[1];
        this.price = new BigDecimal(values[2]);
        this.type = values[3];
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        String message = "";
        if (type.equals("Chip")) {
            message = "Crunch Crunch, Yum!";
        } else if (type.equals("Candy")) {
            message = "Munch Munch, Yum!";
        } else if (type.equals("Drink")) {
            message = "Glug Glug, Yum!";
        } else if (type.equals("Gum")) {
            message ="Chew Chew, Yum!";
        }

        return message;
    }

    public int getAmountSold() {
        return MAX_ITEM_COUNT - count;
    }

    public boolean isSoldOut(){

        return count == 0;

    }

    public void decreaseAmount() {
        count--;
    }

    @Override
    public String toString() {
        String itemCount = isSoldOut() ? "SOLD OUT" : String.valueOf(count);
        return String.format("%s: %s: $%.2f: %s", slotLocation, productName, price, itemCount);
    }
}
