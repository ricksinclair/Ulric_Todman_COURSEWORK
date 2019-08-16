package com.company;

public class Car {

private String make;
private String model;
private int year;
private String color;
private int mileage;


    public Car(){

    }
    Car(String make, String model, int year, String color, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
    }

    String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
