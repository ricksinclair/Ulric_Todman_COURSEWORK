package com.company;

import java.util.Arrays;

public class Architect extends TeamLead {

    public Architect(String name){
        super(name);
        System.out.println("Architect constructor");
    }
    public void createTechRoadmap(){
        //do something
    }
    public void evaluateVendor(){
        //do something else
    }

    @Override
    public void estimateStoryPoints() {
        System.out.println("I am estimating story points. (Architect)");
    }
}
