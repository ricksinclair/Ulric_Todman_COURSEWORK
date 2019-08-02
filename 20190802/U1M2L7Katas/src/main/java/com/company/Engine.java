package com.company;

public class Engine {
    private String model;
    private int horsepower;

    public Engine(){

    }

    public Engine(String model, int horsepower) {
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
}
