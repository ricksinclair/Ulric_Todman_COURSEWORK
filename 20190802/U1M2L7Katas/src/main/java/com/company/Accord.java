package com.company;

public class Accord extends Sedan {

    private String year;
    private Engine engine = new Engine("Super Turbo", 230);
    private Transmission transmission = new Transmission("Automatic", 6);


    public Accord() {

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
