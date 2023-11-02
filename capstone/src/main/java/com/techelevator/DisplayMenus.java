package com.techelevator;

import com.techelevator.view.Menu;

import java.util.Scanner;

public class DisplayMenus {

    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};
    private double totalMoney;

    Scanner userInput = new Scanner(System.in);

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

        System.out.println("                            ");
        System.out.println("****************************");
        System.out.println("Current Money Provided: " + totalMoney );
        System.out.println("****************************");
        System.out.println("                            ");

        while(true){
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if(choice.equals(PURCHASE_MENU_FEED_MONEY)){

                addMoney();

            } else if(choice.equals(PURCHASE_MENU_SELECT_PRODUCT)){
                displayItems();

                System.out.println("Enter the number of the item you would like: ");
                String itemWanted = userInput.nextLine();

                totalMoney = inventoryManager.purchaseItem(itemWanted, totalMoney);

            }


       }




    }


    public void addMoney(){


        System.out.println("How much would you like to add?");
        String addedMoneyStr = userInput.nextLine();
        double addedMoney = Double.parseDouble(addedMoneyStr);
        totalMoney += addedMoney;

        System.out.println("                            ");
        System.out.println("****************************");
        System.out.println("Current Money Provided: " + totalMoney );
        System.out.println("****************************");
        System.out.println("                            ");
    }



}
