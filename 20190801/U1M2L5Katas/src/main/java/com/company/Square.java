package com.company;

import com.company.interfaces.Shape;

public class Square implements Shape {

    private int width;
    private int height;

    public Square(int dimension){
        this.width = dimension;
        this.height = dimension;

    }

    public Square(){
        this.width = 5;
        this.height = 5;

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double perimeter(){
        return height*4;
    }

    public double area(){
        return width*height;
    }
}
