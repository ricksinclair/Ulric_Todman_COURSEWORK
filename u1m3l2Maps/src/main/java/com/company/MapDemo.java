package com.company;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {


    public static void main(String[] args) {
Map< String, Integer> heights = new HashMap<>();
heights.put("John",66);
heights.put("Aynul",70);
//        System.out.println(heights.get("John"));


heights.replace("Bob", 7);
//        System.out.println(heights.get("Bob"));

heights.put("Bob", 7);
        System.out.println(heights.entrySet());
//heights.entrySet();

//    Set<String> myKeys = heights.keySet();
//        System.out.println(heights.values());
//    heights.forEach( (key,val) ->{
//        System.out.println(key+" "+":"+" "+val);
//    });


    }


}
