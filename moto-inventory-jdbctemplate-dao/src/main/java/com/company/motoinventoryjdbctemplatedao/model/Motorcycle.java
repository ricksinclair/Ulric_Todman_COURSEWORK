package com.company.motoinventoryjdbctemplatedao.model;

import java.util.Objects;

public class Motorcycle {
    private int id;
    private String vin;
    private String  make;
    private String model;
    private String color;
    private String year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return getId() == that.getId() &&
                getVin().equals(that.getVin()) &&
                getMake().equals(that.getMake()) &&
                getModel().equals(that.getModel()) &&
                getColor().equals(that.getColor()) &&
                getYear().equals(that.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVin(), getMake(), getModel(), getColor(), getYear());
    }
}
