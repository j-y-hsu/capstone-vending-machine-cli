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
}
