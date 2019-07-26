package com.company;
import java.util.Scanner;
public class Main {

    public static String name = "Mike";
    public static float widthX = 23.f;
    public static float lengthX= 55.9f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float width, length;
        length=29;
        width=30;
        calcRectArea(width, length);
        System.out.println("Area using advance method "+ calcRectAreaAdvanced(width, length));
        System.out.println("Area using class vars method "+ calcRectClassVars());

        calcRectArea(23.5f, 11.75f);

        System.out.println(" Please provide length: ");
        lengthX = Float.parseFloat(scanner.nextLine());
        System.out.println(" Please provide width:");

        widthX = Float.parseFloat(scanner.nextLine());

        calcRectArea(lengthX, widthX);

        System.out.println("Area using class vars method "+ calcRectClassVars());

    }

    public static void calcRectArea( float width, float length){
        System.out.println("The area is "+ (width*length));
        return;
    }

    public static float calcRectAreaAdvanced(float width, float length){
        float area = width * length;
        return area;
    }

    public static float calcRectClassVars(){
        float area = widthX * lengthX;
        return area;
    }
}
