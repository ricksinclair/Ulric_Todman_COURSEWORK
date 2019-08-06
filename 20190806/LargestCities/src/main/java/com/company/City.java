package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class City {
    private String name;
    private int population;
    private static Map<String, City> citiesMap;
    private static int userInput;


    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        City  newYork = new City("New York", 8654321);
        City  losAngeles = new City("Los Angeles", 4563218);
        City  chicago = new City("Chicago", 2716520);
        City  denver = new City("Denver", 704621);
        City  desMoines = new City("Des Moines", 4563218);
        City  atlanta = new City("Atlanta", 486213);

        citiesMap = new HashMap<String, City>();
        citiesMap.put("New York" , newYork );
        citiesMap.put("California", losAngeles);
        citiesMap.put("Illinois", chicago);
        citiesMap.put("Colorado", denver);
        citiesMap.put("Iowa", desMoines);
        citiesMap.put("Georgia", atlanta);

        System.out.println("Press 1 to print all. Press 2 to filter by population of your choosing.");
        try {
            userInput = Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Please enter a number");
        }

        switch (userInput){
            case 1:
                print();
                break;

            case 2:
                System.out.println("Please your population threshold.");
                userInput = Integer.parseInt(scanner.nextLine());
                print(userInput);
                break;
        }

    }



    public static void print(){
        System.out.println(" |       City      |    Population     |");
        System.out.println(" |-----------------|-------------------|");

        citiesMap.forEach((state, city)->{
            System.out.println(" | "+ city.getName()+"\t\t\t"+city.getPopulation()+"      ");
        });

                }



    public static void print(int userPop){
        System.out.println(" |       City      |    Population     |");
        System.out.println(" |-----------------|-------------------|");

        citiesMap.forEach((state, city)->{
            if(city.population>=userPop) {
                System.out.println(" | " + city.getName() + "\t\t\t" + city.getPopulation() + "      ");
            }});

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
