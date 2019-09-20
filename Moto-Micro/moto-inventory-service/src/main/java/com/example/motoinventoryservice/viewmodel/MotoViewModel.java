package com.example.motoinventoryservice.viewmodel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class MotoViewModel {
    private int id;

    @NotEmpty(message = "You must supply a value for VIN.")
    @Size(min = 5, max = 20, message = "VIN must be 5 characters in length.")
    private String vin;

    @NotEmpty(message = "You must supply a value for make.")
    @Size(max = 20)
    private String make;

    @NotEmpty(message = "You must supply a value for model.")
    @Size(max = 20)
    private String model;

    @NotEmpty(message = "You must supply a value for year.")
    @Size(min = 4, max = 4, message = "Year must be 4 digits.")
    private String year;

    @NotEmpty(message = "You must supply a value for color.")
    @Size(max = 20)
    private String color;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotoViewModel that = (MotoViewModel) o;
        return getId() == that.getId() &&
                getVin().equals(that.getVin()) &&
                getMake().equals(that.getMake()) &&
                getModel().equals(that.getModel()) &&
                getYear().equals(that.getYear()) &&
                getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVin(), getMake(), getModel(), getYear(), getColor());
    }
}


