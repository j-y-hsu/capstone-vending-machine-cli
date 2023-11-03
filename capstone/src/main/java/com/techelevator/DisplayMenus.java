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
        inventoryManager.getInventory().forEach((key, value) -> System.out.println(value));
    }

    public void purchaseItem(){

        while(true){
            FormatUtils.getMessage("Current Money Provided: " + FormatUtils.formatMoney(totalMoney)2);
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if(choice.equals(PURCHASE_MENU_FEED_MONEY)){

                addMoney();

            } else if(choice.equals(PURCHASE_MENU_SELECT_PRODUCT)){
                displayItems();

                FormatUtils.getMessage("Enter the number of the item you would like: ");
                String itemWanted = userInput.nextLine().toUpperCase();

                Item item = inventoryManager.purchaseItem(itemWanted, totalMoney);

                if(item != null) {
                    totalMoney = totalMoney.subtract(item.getPrice());
                    FileManager.logWriter((item.getProductName() + " " + itemWanted), item.getPrice(), totalMoney);
                }
            } else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
                finishTransaction();
                break;
            }

       }

    }

    public void addMoney(){

        FormatUtils.getMessage("How much would you like to add?");
        String addedMoneyStr = userInput.nextLine();
        BigDecimal addedMoney;
        try {
            addedMoney = new BigDecimal(addedMoneyStr);
            if (addedMoney.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO)) {
                if (addedMoney.add(totalMoney).compareTo(BigDecimal.valueOf(100)) == 1) {
                    FormatUtils.getWarningMessage("Total can't go above $100");
                } else {
                    totalMoney = totalMoney.add(addedMoney);
                    FileManager.logWriter("FEED MONEY:", addedMoney, totalMoney );
                }
            } else {
                FormatUtils.getWarningMessage("Please enter a whole dollar amount.");
            }
        } catch (NumberFormatException e) {
            FormatUtils.getWarningMessage("Please enter a valid input.");
        }

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
                BigDecimal coin = totalMoney.divide(coinValues[i], 0,RoundingMode.FLOOR);
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
                totalMoney = totalMoney.subtract(coin.multiply(coinValues[i]));
                coins.put(coinName, coin.intValue());
            }

            FormatUtils.getMessage("Your change is " + FormatUtils.formatMoney(currentChange));
            coins.forEach((key, value) -> {
                if (value != 0) {
                    System.out.println(key + ": " + value);
                }
            });
            FileManager.logWriter("GIVE CHANGE:", currentChange, totalMoney);
        } else {
            FormatUtils.getMessage("No Change") ;
        }
    }

}
