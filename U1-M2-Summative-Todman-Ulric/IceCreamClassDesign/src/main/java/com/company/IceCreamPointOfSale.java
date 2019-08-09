package com.company;

public class IceCreamPointOfSale {

    private final int conesPerGallon = 32;//I looked  it up there are 96 scoops in a 3 gallon tub.
    private final int pintsPerGallon = 8;
    private final int conesPer3GallonTub = 96;
    private final int pintsPer3GallonTub = 24;
    private String flavor;
    private double pricePerPint;
    private double pricePerCone;
    private double cost;
    private int gallonsInStock;

    public IceCreamPointOfSale(String flavor, double pricePerPint, double pricePerCone, double cost, int gallonsInStock) {
        this.flavor = flavor;
        this.pricePerPint = pricePerPint;
        this.pricePerCone = pricePerCone;
        this.cost = cost;
        this.gallonsInStock = gallonsInStock;
    }

    public void sellItem() {
        //subtract from gallonsInStock
    }

    public void replenishStock() {

    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPricePerPint() {
        return pricePerPint;
    }

    public void setPricePerPint(double pricePerPint) {
        this.pricePerPint = pricePerPint;
    }

    public double getPricePerCone() {
        return pricePerCone;
    }

    public void setPricePerCone(double pricePerCone) {
        this.pricePerCone = pricePerCone;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getGallonsInStock() {
        return gallonsInStock;
    }

    public void setGallonsInStock(int gallonsInStock) {
        this.gallonsInStock = gallonsInStock;
    }
}
