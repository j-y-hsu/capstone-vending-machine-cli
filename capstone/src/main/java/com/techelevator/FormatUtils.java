package com.techelevator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {

    public static String formatMoney(BigDecimal money) {
        return String.format("$%.2f", money);
    }

    public static String getReportDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getLogDate(){

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        Date date = new Date();
        return formatter.format(date);
    }

    public static void displayItems(InventoryManager inventoryManager) {
        System.out.println("slot | Name | Cost | Amount");
        inventoryManager.getInventory().forEach((key, value) -> {
            System.out.println(value);
        });
    }


    public static void getWarningMessage(String message){
        String exclamationPoint = "!".repeat(message.length() + 2);

        System.out.println();
        System.out.println(exclamationPoint);
        System.out.println(" " + message + " ");
        System.out.println(exclamationPoint);
    }

    public static void getHeaderMessage(String message){

        String asterisk = "*".repeat(message.length() + 2);

        System.out.println();
        System.out.println(asterisk);
        System.out.println(" " + message + " ");
        System.out.println(asterisk);

    }

    public static void getQuestionMessage(String message) {
        String questionMark = "?".repeat(message.length() + 2);

        System.out.println();
        System.out.println(questionMark);
        System.out.println(" " + message + " ");
        System.out.println(questionMark);
    }

}
