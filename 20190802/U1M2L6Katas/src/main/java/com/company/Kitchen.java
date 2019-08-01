package com.company;

public class Kitchen {

    private double length;


    private double width;
    private double height;
    private String fridgeMake;
    private String fridgeModel;
    private String stoveMake;
    private String stoveModel;
    private Boolean hasIsland;


    public Kitchen(double length, double width, double height, String fridgeMake, String fridgeModel, String stoveMake, String stoveModel, Boolean hasIsland) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.fridgeMake = fridgeMake;
        this.fridgeModel = fridgeModel;
        this.stoveMake = stoveMake;
        this.stoveModel = stoveModel;
        this.hasIsland = hasIsland;
    }



    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getFridgeMake() {
        return fridgeMake;
    }

    public String getFridgeModel() {
        return fridgeModel;
    }

    public String getStoveMake() {
        return stoveMake;
    }

    public String getStoveModel() {
        return stoveModel;
    }

    public Boolean getHasIsland() {
        return hasIsland;
    }

    public void setFridgeMake(String fridgeMake) {
        this.fridgeMake = fridgeMake;
    }

    public void setFridgeModel(String fridgeModel) {
        this.fridgeModel = fridgeModel;
    }

    public void setStoveMake(String stoveMake) {
        this.stoveMake = stoveMake;
    }

    public void setStoveModel(String stoveModel) {
        this.stoveModel = stoveModel;
    }

    public void setHasIsland(Boolean hasIsland) {
        this.hasIsland = hasIsland;
    }
}
