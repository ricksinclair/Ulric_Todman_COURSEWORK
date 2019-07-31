package com.company;

import com.company.interfaces.Shape;

public class Circle implements Shape {
    private double radius;


    public double getRadius() {
        return radius;
    }


    public double getDiameter() {
        return diameter;
    }

    private double diameter;

    public Circle(double radius){

        this.diameter = 2*radius;
        this.radius = radius;



    }
    public Circle(){

        this.diameter = 2*5;
        this.radius = 5;



    }

    public double area(){

        return Math.PI*Math.pow(radius, 2);
    }

    public double perimeter(){
        return  2 * Math.PI*radius;
    }


}
