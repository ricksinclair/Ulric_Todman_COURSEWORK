package com.company;

import com.company.Classmate;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        try {
            List<Classmate> classmates =    new CsvToBeanBuilder<Classmate>(new FileReader("classmates.csv")).withType(Classmate.class).build().parse();
            for (Classmate classmate : classmates) {
                System.out.println("==============================");
                System.out.println(classmate.getName());
                System.out.println(classmate.getOs());
                System.out.println(classmate.getBand());

                Writer writer = new FileWriter("newclassmatelist.csv");
                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
                beanToCsv.write(classmates);
                writer.close();
            }


        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file: " + e.getMessage());
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("Error: Something went wrong with your file: " + e.getMessage());
        }
    }
}
