package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;

public class InventoryManager {

    Map<String, Item> inventory;

    public InventoryManager(Map<String, Item> inventory) {
        this.inventory = inventory;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public BigDecimal purchaseItem(String selectedItem, BigDecimal wallet) {

        if(inventory.containsKey(selectedItem)){

            Item item = inventory.get(selectedItem);

            if(item.isSoldOut()){

                System.out.println("Sorry, that item is sold out");

            } else if(wallet.compareTo(item.getPrice()) >= 0) {

                System.out.println(item.getProductName());
                System.out.println(getFormattedMoney(item.getPrice()));
                System.out.println(item.getMessage());
                item.decreaseAmount();
                wallet = wallet.subtract(item.getPrice());

            } else {

                System.out.println("Insufficient Funds");

            }


        } else {

            System.out.println("That item does not exist. Please Try again");

        }

        return wallet;

    }

    public String getFormattedMoney(BigDecimal money) {
        return String.format("$%.2f", money);
    }

}
