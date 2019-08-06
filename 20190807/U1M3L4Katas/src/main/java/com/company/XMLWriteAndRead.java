package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {

    public static void main(String[] args) {

        PrintWriter writer = null;


        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        try {
            ObjectMapper mapper = new XmlMapper();
            String xmlCarList = mapper.writeValueAsString(carList);
            System.out.println(xmlCarList);

            writer = new PrintWriter(new FileWriter("cars.xml"));
            writer.println(xmlCarList);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }


        }


        try{
            ObjectMapper mapper = new XmlMapper();
            List<Car> carListFromFile = mapper.readValue(new File("cars.xml"), new TypeReference<List<Car>>(){});

            for(Car car : carListFromFile){
                System.out.println("==================");
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
                System.out.println(car.getColor());
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
