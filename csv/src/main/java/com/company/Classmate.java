package com.company;
import com.opencsv.bean.CsvBindByName;
public class Classmate {
    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "OS")
    private String os;
    @CsvBindByName(column = "Band")
    private String band;


    public Classmate(){

    }
    public Classmate(String name, String os, String band) {
        this.name = name;
        this.os = os;
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}