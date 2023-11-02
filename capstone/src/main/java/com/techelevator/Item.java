package com.techelevator;

import java.math.BigDecimal;

public class Item {

    private final int MAX_ITEM_COUNT = 5;
    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private String type;
    private int count = MAX_ITEM_COUNT;

//    public Item(String slotLocation, String productName, double price, String type) {
//        this.slotLocation = slotLocation;
//        this.productName = productName;
//        this.price = price;
//        this.type = type;
//    }

    public Item(String slotLocation, String productName, double price, String type, int count) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = BigDecimal.valueOf(price);
        this.type = type;
        this.count = count;
    }

    public Item(String[] values) {
        this.slotLocation = values[0];
        this.productName = values[1];
        this.price = BigDecimal.valueOf(Double.parseDouble(values[2]));
        this.type = values[3];
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        String message = "";
        if (type.equals("Chips")) {
            message = "Crunch Crunch, Yum!";
        } else if (type.equals("Candy")) {
            message = "Munch Munch, Yum!";
        } else if (type.equals("drink")) {
            message = "Glug Glug, Yum!";
        } else if (type.equals("Gum")) {
            message ="Chew Chew, Yum!";
        }

        return message;
    }

    @Override
    public String toString() {
        String itemCount = isSoldOut() ? "SOLD OUT" : String.valueOf(count);
        String string = String.format("%s: %s: $%.2f: %s", slotLocation, productName, price, itemCount);
        return string;
    }

    public boolean isSoldOut(){

        return count == 0;

    }

    public void decreaseAmount() {
        count--;
    }
}
