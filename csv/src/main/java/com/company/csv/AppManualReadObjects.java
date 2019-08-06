package com.company.csv;

import com.company.Motorcycle;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppManualReadObjects {

    public static void main(String[] args) {

        List<Motorcycle> bikeList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("motorcycles.csv")));
            String currentRow = "";
            String[] headings = new String[0];
            String[] currentCells = new String[0];

            // Read the first line (if it exists) - this is the header row.  We'll print out the headers
            if (scanner.hasNext()) {
                currentRow = scanner.nextLine();
                headings = currentRow.split(",");
                System.out.println("Number of columns: " + headings.length);

                for (String heading : headings) {
                    System.out.println(heading);
                }
            }

            // Now read each remaining row and convert into an object
            while (scanner.hasNext()) {
                currentRow = scanner.nextLine();
                currentCells = currentRow.split(",");

                Motorcycle currentBike = new Motorcycle();
                currentBike.setMake(currentCells[0]);
                currentBike.setModel(currentCells[1]);
                currentBike.setYear(currentCells[2]);
                currentBike.setColor(currentCells[3]);
                currentBike.setDisplacement(Integer.parseInt(currentCells[4]));
                currentBike.setHorsepower(Integer.parseInt(currentCells[5]));
                currentBike.setWeight((Integer.parseInt(currentCells[6])));

                bikeList.add(currentBike);
            }

            // Display all motorcycle info
            for (Motorcycle bike : bikeList) {
                System.out.println("=================================");
                System.out.println(bike.getMake());
                System.out.println(bike.getModel());
                System.out.println(bike.getYear());
                System.out.println(bike.getColor());
                System.out.println(bike.getDisplacement());
                System.out.println(bike.getHorsepower());
                System.out.println(bike.getWeight());
            }


        } catch (FileNotFoundException e) {
            System.out.println("Oops - I couldn't find your file: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: It seems your CSV file is malformed.  Perhaps some of your rows have too many columns??? ");
        } catch (NumberFormatException e) {
            System.out.println("ERROR: it seems you CSV data is corrupted.  Could not conver to number: " + e.getMessage());
        }
    }
}