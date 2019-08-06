package com.company;

import com.opencsv.bean.CsvBindByName;

public class Motorcycle {

    @CsvBindByName(column = "Make")
    private String make;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "Year")
    private String year;
    @CsvBindByName(column = "Color")
    private String color;
    @CsvBindByName(column = "Displacement")
    private int displacement;
    @CsvBindByName(column = "Horsepower")
    private int horsepower;
    @CsvBindByName(column = "Weight")
    private int weight;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
