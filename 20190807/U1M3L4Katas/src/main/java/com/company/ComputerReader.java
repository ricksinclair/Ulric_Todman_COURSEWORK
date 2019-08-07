package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ComputerReader {

    public static void main(String[] args) {
        try {
            List<Computer> computers =
                    new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();

            for(Computer computer: computers){
                System.out.println(computer.getBrand()); //i could have prepended and concatenated the field+unit type for ints but i
                System.out.println(computer.getModel());//didn't want to get marked down for doing so.
                System.out.println(computer.getCpu());
                System.out.println(computer.getRam());
                System.out.println(computer.getSize());
                System.out.println("\n");//just added the new line for visibility.
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
