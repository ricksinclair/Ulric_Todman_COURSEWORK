package com.company;

public class Product {

    private String brand;
    private String type;
    private int qty;
    private double price;

    public Product(){

    }
    public Product(String brand, String type, int qty, double price) {
        this.brand = brand;
        this.type = type;
        this.qty = qty;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void processSale(int saleQty){

        qty -= saleQty;
    }

    public void addMore(int addingQty ){
        qty += addingQty;
    }


}
