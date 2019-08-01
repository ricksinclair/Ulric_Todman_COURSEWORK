package com.company;

public class Home {

    private Bedroom[] bedRooms;
    private Bathroom[] bathRooms;
    private int numBedRooms;
    private int numBathRooms;
    private double acreage;




    public void Home(Bedroom[] bedRooms, Bathroom[] bathRooms, double acreage){
        
        setBedrooms(bedRooms);
        setBathrooms(bathRooms);
        setAcreage(acreage);

    }


    public Bedroom[] getBedrooms() {
        return bedRooms;
    }

    public void setBedrooms(Bedroom[] bedRooms) {
        this.bedRooms = bedRooms;
    }

    public Bathroom[] getBathrooms() {
        return bathRooms;
    }

    public void setBathrooms(Bathroom[] bathRooms) {
        this.bathRooms = bathRooms;
    }

    public int getNumBedRooms() {
        return numBedRooms;
    }

    public void setNumBedRooms() {
        this.numBedRooms = this.bedRooms.length;
    }

    public int getNumBathrooms() {
        return numBathRooms;
    }

    public void setNumBathrooms() {
        this.numBathRooms = this.bathRooms.length;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }


}
