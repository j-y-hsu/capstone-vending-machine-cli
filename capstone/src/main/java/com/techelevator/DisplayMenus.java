package com.techelevator;

import com.techelevator.view.Menu;

public class DisplayMenus {

    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};

    private InventoryManager inventoryManager;
    private Menu menu;

    public DisplayMenus(Menu menu, InventoryManager inventoryManager){
        this.menu = menu;
        this.inventoryManager = inventoryManager;
    }

    public void displayItems() {
        inventoryManager.getInventory().forEach((key, value) -> {
            System.out.println(value);
        });
    }



    public void purchaseItem(){

       while(true){



       }




    }




}
