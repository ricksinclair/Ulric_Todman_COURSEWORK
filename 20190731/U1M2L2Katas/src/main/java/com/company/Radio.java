package com.company;

public class Radio {

    private String manufacturer;
    private String model;
    private int numSpeakers;
    private String station;
    private int volume;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getNumSpeakers() {
        return numSpeakers;
    }

    public String getStation() {
        return station;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowered() {
        return powered;
    }

    private boolean powered;



    public Radio(String manufacturer, String model, int numSpeakers, String station, int volume, boolean powered){
    this.manufacturer = manufacturer;
    this.model = model;
    this.numSpeakers = numSpeakers;
    this.station = station;
    this.volume = volume;
    this.powered = powered;
    }

    public void togglePower(){

    }


}
