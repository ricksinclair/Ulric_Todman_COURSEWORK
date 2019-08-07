package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class PhoneReader {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new XmlMapper();
            List<Phone> phoneListFromFile = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>() {
            });
            for(Phone phone : phoneListFromFile){
                System.out.println(phone.getBrand());
                System.out.println(phone.getModel());
                System.out.println(phone.getPrice());
                System.out.println(phone.getProcessor());
                System.out.println(phone.getStorage()+"\n");
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
