package com.company;

public class Car {

    private String make;
    private String model;
    private String type;
    private String color;
    private String engine;
    private String transmission;
    private int numDoors;
    private double mpg;
    private int milesDriven;

    public Car(String make, String model, String type, String color, String engine, String transmission,int numDoors, double mpg, int milesDriven){
        this.make = make;
        this.color = color;
        this.model = model;
        this.type = type;
        this.engine = engine;
        this.transmission = transmission;
        this.numDoors = numDoors;
        this.mpg = mpg;
        this.milesDriven = milesDriven;
    }
    public void drive(int miles) {

    }

    public void honk() {

    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public String getEngine() {
        return this.engine;
    }

    public String getTransmission() {
        return this.transmission;
    }
    public int getNumDoors(){
        return this.numDoors;
    }
    public double getMpg(){
        return this.mpg;
    }
    public int getMilesDriven(){
        return this.milesDriven;
    }
}
