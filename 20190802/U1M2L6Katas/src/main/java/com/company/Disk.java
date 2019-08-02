package com.company;

public class Disk {


    private String make;
    private String model;
    private int capacityInTB;


    public Disk(){

    }

    public Disk(String make, String model, int capacityInTB) {
        this.make = make;
        this.model = model;
        this.capacityInTB = capacityInTB;
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

    public int getCapacityInTB() {
        return capacityInTB;
    }

    public void setCapacityInTB(int capacityInTB) {
        this.capacityInTB = capacityInTB;
    }


    protected void delete(){
//       delete stuff

    }

    protected void seek(){
        //seek data and ye shall find
    }

    protected void read(){
        //reading is fundamental
    }
}
