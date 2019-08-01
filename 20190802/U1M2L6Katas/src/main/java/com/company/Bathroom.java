package com.company;

public class Bathroom {
    private boolean shower;
    private boolean tub;
    private boolean bidet;
    private double length;
    private double width;
    private double height;

    public Bathroom(double length, double width, double height, boolean shower, boolean tub, boolean bidet){
        this.shower = shower;
        this.tub = tub;
        this.bidet = bidet;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public boolean isShower() {
        return shower;
    }

    public boolean isTub() {
        return tub;
    }

    public boolean isBidet() {
        return bidet;
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

}
