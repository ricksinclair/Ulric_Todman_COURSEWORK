package com.company.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AppManualReadArray {

    public static void main(String[] args) {

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

            // Now read each remaining row and print out with matching heading
            while (scanner.hasNext()) {
                currentRow = scanner.nextLine();
                currentCells = currentRow.split(",");

                System.out.println("=================================");
                // Ask what could possibly go wrong here????
                for (int i = 0; i < currentCells.length; i++) {
                    System.out.println(headings[i] + " : " + currentCells[i]);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Oops - I couldn't find your file: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: It seems your CVS file is malformed.  Perhaps some of your rows have too many columns??? ");
        }

    }
}
