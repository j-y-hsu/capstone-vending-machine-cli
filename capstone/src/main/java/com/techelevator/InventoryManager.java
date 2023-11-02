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

    public Item purchaseItem(String selectedItem, BigDecimal wallet) {

        Item item = null;
        if (inventory.containsKey(selectedItem)) {

            item = inventory.get(selectedItem);

            if (item.isSoldOut()) {

                System.out.println("Sorry, that item is sold out");

            } else if (wallet.compareTo(item.getPrice()) >= 0) {

                System.out.println(item.getProductName());
                System.out.println(Utility.formatMoney(item.getPrice()));
                System.out.println(item.getMessage());
                item.decreaseAmount();


            } else {

                System.out.println("Insufficient Funds");
                item = null;
            }


        } else {

            System.out.println("That item does not exist. Please Try again");

        }

        return item;

    }

}
