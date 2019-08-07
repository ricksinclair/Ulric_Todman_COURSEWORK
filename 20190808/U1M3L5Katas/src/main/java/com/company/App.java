package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import org.w3c.dom.ls.LSOutput;

import java.awt.event.TextEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<Television> tvList;

        try {
            ObjectMapper mapper = new ObjectMapper();
            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });

            tvList.stream().filter(tv -> tv.getScreenSize() > 60).forEach(tv -> {
                System.out.println(tv.getBrand());
                System.out.println(tv.getModel());
                System.out.println(tv.getPrice());
                System.out.println(tv.getScreenSize() + "\n");
            });

            Map<String, List<Television>> groupedTVsByBrand = tvList.stream().collect(Collectors.groupingBy(tv -> tv.getBrand()));
            groupedTVsByBrand.keySet().forEach(key -> {
                System.out.println(key);


            });
            System.out.println("");
            int averageDisplaySize = (int)tvList.stream().mapToInt(tv->tv.getScreenSize()).average().getAsDouble();
            System.out.println("Average screen size = "+averageDisplaySize);

            int largestScreen = tvList.stream().mapToInt(tv->tv.getScreenSize()).max().getAsInt();
            System.out.println("Largest screen size = "+largestScreen);

             tvList.sort(Comparator.comparingInt(Television::getScreenSize));


            System.out.println("\nTVs sorted by screen size.\n==============================\n");
             tvList.forEach(tv-> {
                 System.out.println(tv.getBrand());
                 System.out.println(tv.getModel());
                 System.out.println(tv.getPrice());
                 System.out.println(tv.getScreenSize()+"\n");
             });

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
