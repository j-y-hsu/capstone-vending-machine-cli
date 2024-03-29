package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileManager {



    public static Map<String, Item> getItems(){
        Map<String, Item> inventory = new TreeMap<>();
        String inventoryFilePath = "vendingmachine.csv";
        File file = new File(inventoryFilePath);

        try(Scanner reader = new Scanner(file)){

            while(reader.hasNextLine()){

                String itemStr = reader.nextLine();
                String[] itemArr = itemStr.split("\\|");
                Item item = new Item(itemArr);
                inventory.put(itemArr[0],item);
            }



        } catch(FileNotFoundException ex){
            System.out.println("Inventory file could not be found");
        }

        return inventory;
    }

    public static void logWriter(String message, BigDecimal amount, BigDecimal total){

        File logFile = new File("log.txt");
        String date = FormatUtils.getLogDate();

        try(PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))){

            writer.println(date + " " + message + " " + amount + " " + total );
            writer.flush();
        } catch (FileNotFoundException ex){
            System.out.println("File not found");
        }

    }

    public static void salesReport(InventoryManager inventoryManager) {
        String salesReportPath = FormatUtils.getReportDateTime() + ".txt";
        File report = new File(salesReportPath);

        try (PrintWriter writer = new PrintWriter(report)) {
            BigDecimal totalSales = BigDecimal.ZERO;
            for (Map.Entry<String, Item> entry : inventoryManager.getInventory().entrySet()) {
                int count = entry.getValue().getAmountSold();
                Item item = entry.getValue();
                String line = item.getProductName() + "|" + count;
                writer.println(line);
                totalSales = totalSales.add(item.getPrice().multiply(BigDecimal.valueOf(count)));
            }

            writer.println("\n**TOTAL SALES** " + FormatUtils.formatMoney(totalSales));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }


}
