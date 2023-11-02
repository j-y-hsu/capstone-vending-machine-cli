package com.techelevator;

import java.util.Map;

public class InventoryManager {

    Map<String, Item> inventory;

    public InventoryManager(Map<String, Item> inventory) {
        this.inventory = inventory;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public double purchaseItem(String selectedItem, double wallet){

        if(inventory.containsKey(selectedItem)){

            Item item = inventory.get(selectedItem);

            if(item.isSoldOut()){

                System.out.println("Sorry, that item is sold out");

            } else if(wallet >= item.getPrice()) {

                System.out.println(item.getProductName());
                System.out.println(item.getPrice());
                System.out.println(item.getMessage());

                wallet -= item.getPrice();

            } else {

                System.out.println("Insufficient Funds");

            }


        } else {

            System.out.println("That item does not exist. Please Try again");

        }

        return wallet;

    }
}
