package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriteAndRead {

    public static void main(String[] args) {


        try {
            List<Car> carList = new ArrayList<>();

            carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
            carList.add(new Car(2001, "Honda", "Civic", "Silver"));
            carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
            carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
            carList.add(new Car(1964, "Ford", "Mustang", "Red"));

            Writer writer = new FileWriter("cars.csv");
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(carList);
            writer.close();

            List<Car> carsFromFile =
                    new CsvToBeanBuilder<Car>(new FileReader("cars.csv")).withType(Car.class).build().parse();


            for(Car car : carsFromFile){
                System.out.println("============================");
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
                System.out.println(car.getColor());
            }
        }catch(FileNotFoundException e){
            System.out.println("Could not find csv file: "+e.getMessage());
        }catch(IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e){
            System.out.println("There was an error writing your file.");
        }


    }
}
