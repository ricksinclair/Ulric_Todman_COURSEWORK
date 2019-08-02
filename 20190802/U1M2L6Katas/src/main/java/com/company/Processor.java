package com.company;

public class Processor {
    private double clockSpeedGhz;
    private boolean hyperThreading;
    private String make;
    private String model;
    private int cores;

    public Processor(){

    }
    public Processor(double clockSpeedGhz, boolean hyperThreading, String make, String model, int cores) {
       setClockSpeedGhz(clockSpeedGhz);
       setHyperThreading(hyperThreading);
       setMake(make);
       setModel(model);
       setCores(cores);
    }


    public void overClock(){
//        bleh
    }

    public void calculate(){
        //bleh

    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public double getClockSpeedGhz() {
        return clockSpeedGhz;
    }

    public void setClockSpeedGhz(double clockSpeedGhz) {
        this.clockSpeedGhz = clockSpeedGhz;
    }

    public boolean isHyperThreading() {
        return hyperThreading;
    }

    public void setHyperThreading(boolean hyperThreading) {
        this.hyperThreading = hyperThreading;
    }

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


    
    
    
    
    
    
    
    
}
