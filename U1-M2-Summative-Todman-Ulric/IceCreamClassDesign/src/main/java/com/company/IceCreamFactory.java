package com.company;

public class IceCreamFactory {

    private double costPerVat;
    private int tubsPerVat;//I would have made these two final but idk the math on these
    private int gallonsPerVat;//<--------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    private int gallonsInStorage;
    private int numPendingOrders;


    public IceCreamFactory(double costPerVat, int tubsPerVat, int gallonsPerVat, int gallonsInStorage, int numPendingOrders) {
        this.costPerVat = costPerVat;
        this.tubsPerVat = tubsPerVat;
        this.gallonsPerVat = gallonsPerVat;
        this.gallonsInStorage = gallonsInStorage;
        this.numPendingOrders = numPendingOrders;
    }

    public void sellVat() {

    }

    public void addOrder() {

    }

    public double getCostPerVat() {
        return costPerVat;
    }

    public void setCostPerVat(double costPerVat) {
        this.costPerVat = costPerVat;
    }

    public int getTubsPerVat() {
        return tubsPerVat;
    }

    public void setTubsPerVat(int tubsPerVat) {
        this.tubsPerVat = tubsPerVat;
    }

    public int getGallonsPerVat() {
        return gallonsPerVat;
    }

    public void setGallonsPerVat(int gallonsPerVat) {
        this.gallonsPerVat = gallonsPerVat;
    }

    public int getGallonsInStorage() {
        return gallonsInStorage;
    }

    public void setGallonsInStorage(int gallonsInStorage) {
        this.gallonsInStorage = gallonsInStorage;
    }

    public int getNumPendingOrders() {
        return numPendingOrders;
    }

    public void setNumPendingOrders(int numPendingOrders) {
        this.numPendingOrders = numPendingOrders;
    }
}
