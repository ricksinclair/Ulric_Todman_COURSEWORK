package com.company;
import com.company.interfaces.Shape;

public class Triangle implements Shape {
    private double legALength;
    private double legBLength;
    private double legCLength;
    private double area;

    public Triangle(double a, double b, double c, double area){
        this.legALength = a;
        this.legBLength = b;
        this.legCLength = c;
        this.area = area;

    }
    public Triangle(){
        this.legALength = 3;
        this.legBLength = 4;
        this.legCLength = 5;
        this.area = 6;

    }


    public double perimeter(){
        return legALength+legBLength+legCLength;
    }

    public double area(){
        return area;

    }
}
