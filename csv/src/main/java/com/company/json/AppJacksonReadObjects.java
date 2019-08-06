package com.company.json;

import com.company.Motorcycle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppJacksonReadObjects {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Motorcycle> motoList;

            motoList = mapper.readValue(new File("motorcycles.json"), new TypeReference<List<Motorcycle>>(){});

            for (Motorcycle moto : motoList) {
                System.out.println("================");
                System.out.println(moto.getMake());
                System.out.println(moto.getModel());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }




}
