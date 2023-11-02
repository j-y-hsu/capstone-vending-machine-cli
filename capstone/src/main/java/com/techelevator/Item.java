package com.techelevator;

public class Item {

    private final int MAX_ITEM_COUNT = 5;
    private String slotLocation;
    private String productName;
    private double price;
    private String type;
    private int count = MAX_ITEM_COUNT;

    public Item(String slotLocation, String productName, double price, String type) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
        this.type = type;
    }

    public Item(String[] values) {
        this.slotLocation = values[0];
        this.productName = values[1];
        this.price = Double.parseDouble(values[2]);
        this.type = values[3];
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        String message = "";
        if (type.equals("chips")) {
            message = "Crunch Crunch, Yum!";
        } else if (type.equals("candy")) {
            message = "Munch Munch, Yum!";
        } else if (type.equals("drink")) {
            message = "Glug Glug, Yum!";
        } else if (type.equals("gum")) {
            message ="Chew Chew, Yum!";
        }

        return message;
    }

    @Override
    public String toString() {
        String itemCount;
        if (count == 0) {
            itemCount = "SOLD OUT";
        } else {
            itemCount = String.valueOf(count);
        }
        return slotLocation + ": " + productName + ": " + price + ": " + itemCount;
    }
}
