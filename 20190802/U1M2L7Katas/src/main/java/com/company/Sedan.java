package com.company;

public class Sedan extends Car {
    private int numDoors;
    private boolean poweredWindows;

    public Sedan(){

    }

    public Sedan(String make, String model, int milesTraveled, int numDoors, boolean poweredWindows) {
        super(make, model, milesTraveled);
        this.numDoors = numDoors;
        this.poweredWindows = poweredWindows;
    }


    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public boolean isPoweredWindows() {
        return poweredWindows;
    }

    public void setPoweredWindows(boolean poweredWindows) {
        this.poweredWindows = poweredWindows;
    }
}
