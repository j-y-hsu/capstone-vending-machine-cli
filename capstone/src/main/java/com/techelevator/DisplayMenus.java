package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DisplayMenus {

    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};
    private BigDecimal totalMoney = BigDecimal.ZERO;

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

        while(true){
            System.out.println("                            ");
            System.out.println("****************************");
            System.out.println("Current Money Provided: " + inventoryManager.getFormattedMoney(totalMoney) );
            System.out.println("****************************");
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if(choice.equals(PURCHASE_MENU_FEED_MONEY)){

                addMoney();

            } else if(choice.equals(PURCHASE_MENU_SELECT_PRODUCT)){
                displayItems();

                System.out.println("Enter the number of the item you would like: ");
                String itemWanted = userInput.nextLine();

                totalMoney = inventoryManager.purchaseItem(itemWanted, totalMoney);

            } else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
                finishTransaction();
                break;
            }


       }




    }


    public void addMoney(){

        System.out.println("How much would you like to add?");
        String addedMoneyStr = userInput.nextLine();
        BigDecimal addedMoney = BigDecimal.valueOf(Double.parseDouble(addedMoneyStr));
        totalMoney = totalMoney.add(addedMoney);

    }

    public void finishTransaction() {
        BigDecimal[] coinValues = {BigDecimal.valueOf(.25), BigDecimal.valueOf(.10), BigDecimal.valueOf(.05), BigDecimal.valueOf(.01)};
        BigDecimal quarter = BigDecimal.valueOf(.25);
        BigDecimal nickel = BigDecimal.valueOf(.05);
        BigDecimal dime = BigDecimal.valueOf(.10);
        BigDecimal penny = BigDecimal.valueOf(.01);
        BigDecimal currentChange = totalMoney;
        Map<String, Integer> coins = new HashMap<>();

        if (!currentChange.equals(BigDecimal.ZERO)) {
            for (int i = 0; i < coinValues.length; i++) {
                BigDecimal coin = currentChange.divide(coinValues[i], 0,RoundingMode.FLOOR);
                String coinName = "";
                if (coinValues[i].equals(quarter)) {
                    coinName = "Quarter(s)";
                } else if (coinValues[i].equals(dime)) {
                    coinName = "Dime(s)";
                } else if (coinValues[i].equals(nickel)){
                    coinName = "Nickel(s)";
                } else if (coinValues[i].equals(penny)) {
                    coinName = "Penny(ies)";
                }
                currentChange = currentChange.subtract(coin.multiply(coinValues[i]));
                coins.put(coinName, coin.intValue());
            }

            System.out.println("Your change is " + inventoryManager.getFormattedMoney(totalMoney));
            coins.forEach((key, value) -> {
                if (value != 0) {
                    System.out.println(key + ": " + value);
                }
            });
            totalMoney = BigDecimal.ZERO;
        } else {
            System.out.println("No change");
        }
    }



}
