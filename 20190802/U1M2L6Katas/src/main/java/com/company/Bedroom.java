package com.company;

public class Bedroom {

    private double length;
    private double width;
    private double height;
    private String bedType;
    private boolean walkInCloset;


    public Bedroom(double length, double width, double height, String bedType, boolean walkInCloset ){

        this.length = length;
        this.width = width;
        this.height = height;
        this.bedType = bedType;
        this.walkInCloset = walkInCloset;

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

    public String getBedType() {
        return bedType;
    }

    public boolean isWalkInCloset() {
        return walkInCloset;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }


}
