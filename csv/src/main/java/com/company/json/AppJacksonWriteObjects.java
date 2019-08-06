package com.company.json;

import com.company.Motorcycle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AppJacksonWriteObjects {

    public static void main(String[] args) {

        PrintWriter writer = null;

        Motorcycle bike = new Motorcycle();
        bike.setMake("Ducati");
        bike.setModel("Panigale V4R");
        bike.setYear("2019");
        bike.setColor("Red");
        bike.setDisplacement(1103);
        bike.setHorsepower(214);
        bike.setWeight(379);

        Motorcycle bike2 = new Motorcycle();
        bike2.setMake("Triumph");
        bike2.setModel("Tiger XCa");
        bike2.setYear("2019");
        bike2.setColor("Blue");
        bike2.setDisplacement(1215);
        bike2.setHorsepower(139);
        bike2.setWeight(547);

        List<Motorcycle> bikeList = new ArrayList<>();

        bikeList.add(bike);
        bikeList.add(bike2);


        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonBikeList = mapper.writeValueAsString(bikeList);

            System.out.println(jsonBikeList);


            writer = new PrintWriter(new FileWriter("motorcycles.json"));

            writer.println(jsonBikeList);


        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

    }
}
