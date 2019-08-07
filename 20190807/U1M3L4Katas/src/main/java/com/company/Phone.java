package com.company;

public class Phone {
    private String brand;
    private String model;
    private int storage;
    private int price;


    private String processor;

    public Phone() {
    }

    public Phone(String brand, String model, int storage, int price, String processor) {
        setBrand(brand);
        setModel(model);
        setStorage(storage);
        setPrice(price);
        setProcessor(processor);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }


}
