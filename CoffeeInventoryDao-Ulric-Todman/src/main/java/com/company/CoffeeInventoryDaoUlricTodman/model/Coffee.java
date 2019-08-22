package com.company.CoffeeInventoryDaoUlricTodman.model;

import java.util.Objects;

public class Coffee {
    private int coffeeId;
    private int roasterId;
    private String name;
    private int count;
    private Double unitPrice;
    private String description;
    private String type;


    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(int roasterId) {
        this.roasterId = roasterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return getCoffeeId() == coffee.getCoffeeId() &&
                getRoasterId() == coffee.getRoasterId() &&
                getCount() == coffee.getCount() &&
                Double.compare(coffee.getUnitPrice(), getUnitPrice()) == 0 &&
                getName().equals(coffee.getName()) &&
                getDescription().equals(coffee.getDescription()) &&
                getType().equals(coffee.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoffeeId(), getRoasterId(), getName(), getCount(), getUnitPrice(), getDescription(), getType());
    }
}
