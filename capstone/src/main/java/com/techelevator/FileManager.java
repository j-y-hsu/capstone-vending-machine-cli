package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
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




}
