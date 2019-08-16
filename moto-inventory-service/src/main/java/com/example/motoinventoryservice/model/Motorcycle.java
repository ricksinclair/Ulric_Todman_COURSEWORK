package com.example.motoinventoryservice.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Motorcycle {

    private int id;

    @NotEmpty(message = "Must send VIN.")
    @Size(min = 17, max = 17)
    private String vin;
    @NotEmpty(message = "Must send make.")
    private String make;
    @NotEmpty(message = "Must send model.")
    private String model;
    @NotEmpty(message = "Must send year")
    private String year;
    @NotEmpty(message = "Must send color")
    private String color;

    public int getId() {
        return id;
    }

    public String toString(){
        return "CAR\n====\nmake: " +this.getMake()+"\nmodel: "+this.getModel()+"\nYear: " + this.getYear()+ "\ncolor: "+this.getColor()
                    + "\nvin: "+this.getVin() +"\nid: "+ getId();
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
}
