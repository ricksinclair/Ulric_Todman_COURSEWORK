package com.company.csv;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppOpenCSVReadArray {

    public static void main(String[] args) {

        CSVReader reader = null;
        String[] currentCells = new String[0];
        String[] headings = new String[0];

        try {
            reader = new CSVReader(new FileReader("motorcycles.csv"));

            // Read the first line (if it exists) - this is the header row.  We'll print out the headers
            headings = reader.readNext();
            if (headings != null) {
                for (String heading : headings) {
                    System.out.println(heading);
                }
            }

            while ((currentCells = reader.readNext()) != null) {
                System.out.println("=====================================");
                for (int i = 0; i < currentCells.length; i++) {
                    System.out.println(headings[i] + " : " + currentCells[i]);
                }
            }



        } catch (FileNotFoundException e) {
            System.out.println("Oops - I couldn't find your file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not read row from file: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: It seems your CVS file is malformed.  Perhaps some of your rows have too many columns??? ");
        }




    }
}
