package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> map){


        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void printValues(Map<String, String> map){

        System.out.println(map.values());

    }

    public void printKeysAndValues(Map<String, String> map){


        for(String key: map.keySet()){
            System.out.printf("%s: %s\n", key, map.get(key));
        }

//        map.forEach((key, value)->{
//            System.out.println(key+": "+value);
//
//        });
    }

    public Map<String,Integer> mapFun(Map<String, Integer> map){


        map.put("Ford Explorer", 2012);
        map.put("Smart Fortwo", 2013);
        map.remove("Jeep Wrangler");


        return map;
    }

    public Map listCars(List<Car> carsList){

        List toyotaList = new ArrayList();
        List fordList = new ArrayList();
        List hondaList = new ArrayList();

        for (Car car : carsList) {
            if(car.getMake().contains("Toyota")){

                toyotaList.add(car);

            }else if(car.getMake().contains("Ford")){
                fordList.add(car);
            }else if(car.getMake().contains("Honda")){
                hondaList.add(car);
            }
        }

        Map<String, List<Car>> returnMap = new HashMap<>();

        returnMap.put("Toyota", toyotaList);
        returnMap.put("Ford", fordList);
        returnMap.put("Honda", hondaList);

        return returnMap;
    }



}


