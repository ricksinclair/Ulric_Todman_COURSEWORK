package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONWriteAndRead {
    public static void main(String[] args) {
        PrintWriter writer = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Car> carList = new ArrayList<>();

            carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
            carList.add(new Car(2001, "Honda", "Civic", "Silver"));
            carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
            carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
            carList.add(new Car(1964, "Ford", "Mustang", "Red"));


            String carsList = mapper.writeValueAsString(carList);
            System.out.println(carsList);
             writer = new PrintWriter(new FileWriter("cars.json"));
            writer.println(carsList);


        } catch (JsonParseException e) {
            System.out.println("Error parsing your JSON");
        } catch (IOException e) {
            System.out.println("ERROR cannot successfully process your file: " + e.getMessage());
        } finally{
            if (writer != null) {
                writer.flush();
                writer.close();
            }

        }




            try {
                ObjectMapper mapper = new ObjectMapper();
                List<Car> carsListFromFile;
                carsListFromFile = mapper.readValue(new File("cars.json"), new TypeReference<List<Car>>() {
                });
                for (Car car : carsListFromFile) {
                    System.out.println("===============");
                    System.out.println(car.getMake());
                    System.out.println(car.getModel());
                    System.out.println(car.getYear());
                    System.out.println(car.getColor());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
