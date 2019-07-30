package com.company;

import java.security.PublicKey;

public class Lion {

    public static int lionPopulation;
    private String name;
    private int age;
    private int weight;


    public Lion(String newName, int newAge, int newWeight){
        this.name = newName;
        this.age = newAge;
        this.weight = newWeight;
        lionPopulation++;
    }

    public Lion(){
        this.name = "Leo";
        this.age= 1;
        this.weight=300;
        lionPopulation++;
    }


    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public  int getWeight(){
        return this.weight;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public void setWeight(int newWeight){
        this.weight = newWeight;

    }
}