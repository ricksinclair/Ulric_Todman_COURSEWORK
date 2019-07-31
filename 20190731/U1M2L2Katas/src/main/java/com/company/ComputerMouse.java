package com.company;

public class ComputerMouse {

    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;



    public ComputerMouse(String manufacturer, String model, int xPosition, int yPosition, int[] lastClickedLocation){
        this.manufacturer = manufacturer;
        this.model = model;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.lastClickedLocation = lastClickedLocation;
    }



    public void move(int deltaX, int deltaY){

    }

    public void click(){///the png file had an arg of 'i' inside of the function but i didn't know if it was an err

    }

    public String getManufacturer(){
        return this.manufacturer;
    }
    public String getModel(){
        return this.model;
    }

    public int getxPosition(){
        return this.xPosition;
    }
    public int getyPosition(){
        return this.yPosition;
    }

    public int[] getLastClickedLocation(){
        return this.lastClickedLocation;
    }
}
