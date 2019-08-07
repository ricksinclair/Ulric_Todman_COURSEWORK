package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public class TelevisionReader {
    public static void main(String[] args)  {

            try{
                ObjectMapper mapper = new ObjectMapper();
                List<Television> tvListFromFile = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});
                for (Television tv : tvListFromFile){
                    System.out.println(tv.getBrand());
                    System.out.println(tv.getModel());
                    System.out.println(tv.getPrice());
                    System.out.println(tv.getScreenSize()+"\n");
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

