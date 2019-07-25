package com.company;

public class Main {
    public static void main(String[] args) {

        float width, length;
        length=29;
        width=30;
        calcRectArea(width, length);
        calcRectArea(23.5f, 11.75f);
    }

    public static void calcRectArea( float width, float length){
        System.out.println("The area is "+ (width*length));
        return;
    }
}
