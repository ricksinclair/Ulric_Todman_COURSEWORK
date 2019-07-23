package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the width of your driveway in feet: ");

        int width = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the length of your driveway in feet: ");

        int length = Integer.parseInt(scanner.nextLine());

        int perimeter = (2*width)+(2*length);

        System.out.println("The perimeter in  feet is: "+ perimeter );

        int area = length* width;

        System.out.printf("The area in square feet is: " + area +"\n");

        System.out.println("Please enter the cost of your framing: ");

        double framingCostPerFt = Double.parseDouble(scanner.nextLine());

        System.out.println("Please enter the cost of your cement: ");

        double cementCostPerSqFt = Double.parseDouble(scanner.nextLine());


        double framingCost = framingCostPerFt * perimeter;
        double cementCost = cementCostPerSqFt * area;
        double totalCost = framingCost+cementCost;


        System.out.printf("The cost of framing is %f, the cost of cement is %f, the total cost is: %f", framingCost, cementCost, totalCost);


    }
}
