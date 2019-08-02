package com.company;

public class Transmission {
    private String type;
    private int numGears;

    public Transmission(){

    }

    public Transmission(String type, int numGears) {
        this.type = type;
        this.numGears = numGears;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumGears() {
        return numGears;
    }

    public void setNumGears(int numGears) {
        this.numGears = numGears;
    }
}
