package com.example.weatherapiservice.model;

public class Conditions {
    private Double fahrenheiht = (double) 32;
    private Double celcius = (double) 0;
    private Double windSpeed = (double) 0;
    private String windDirection = "S/SW";
    private String skies = "Sunny";
    private String precipitation = "none";

    public Conditions(){

    }

    public Conditions(Double fahrenheiht, Double celcius, Double windSpeed, String windDirection, String skies, String precipitation) {
        this.fahrenheiht = fahrenheiht;
        this.celcius = celcius;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.skies = skies;
        this.precipitation = precipitation;
    }

    public Double getFahrenheiht() {
        return fahrenheiht;
    }

    public void setFahrenheiht(Double fahrenheiht) {
        this.fahrenheiht = fahrenheiht;
    }

    public Double getCelcius() {
        return celcius;
    }

    public void setCelcius(Double celcius) {
        this.celcius = celcius;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
