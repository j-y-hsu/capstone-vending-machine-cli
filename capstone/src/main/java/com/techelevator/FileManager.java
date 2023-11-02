package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {



    public static void getItems(){

        String inventoryFilePath = "C:\\Users\\acloc_000\\workspace\\oct-blue-capstone-1-team-0\\capstone\\vendingmachine.csv";
        File file = new File(inventoryFilePath);

        try(Scanner reader = new Scanner(file)){

            while(reader.hasNextLine()){

                String itemStr = reader.nextLine();
                String[] itemArr = itemStr.split("\\|");

            }



        } catch(FileNotFoundException ex){
            System.out.println("Inventory file could not be found");
        }

    }




}
