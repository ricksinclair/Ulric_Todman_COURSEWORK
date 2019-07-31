package com.company;

public class CoffeeMaker {


    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(String manufacturer, String model, int carafeSize, int cupsLeft, boolean powered){
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafeSize;
        this.cupsLeft = cupsLeft;
        this.powered = powered;
    }



    public void brew(){}

    public void pourCoffee(int numCups){

    }

    public String getManufacturer(){
        return this.manufacturer;
    }

    public String getModel(){
        return this.model;
    }

    public boolean isPowered() {
        return this.powered;
    }

    public int getCarafeSize() {
        return this.carafeSize;
    }

    public int getCupsLeft(){
        return this.cupsLeft;
    }


}
