package com.example.weatherapiservice.model;


public class Temperature {

    private Double fahrenheit = (double) 32;

    private Double celcius = (double) 0 ;


    public Temperature(){

    }

    public Temperature(Double fahrenheit, Double celcius) {
        this.fahrenheit = fahrenheit;
        this.celcius = celcius;
    }

    public Double getFahrenheiht() {
        return fahrenheit;
    }

    public void setFahrenheiht(Double farenheight) {
        this.fahrenheit = farenheight;
    }

    public Double getCelcius() {
        return celcius;
    }

    public void setCelcius(Double celcius) {
        this.celcius = celcius;
    }
}
