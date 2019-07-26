package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static int promptDimension(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.format("Please enter the %s of your driveway in feet: \n", message);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void outputDimension(String dim, int value){
        System.out.format("The %s of the driveway is %d feet %n", dim, value);
    }

    public static void outputCosts(String name, float value){
        System.out.format("The cost of the %s is %f. %n", name, value);

    }

    public static int calcPerimeter(int length, int width){
        int perimeter = (2*width)+(2*length);
        return perimeter;
    }

    public static int calculateArea(int length, int width){
        int area = length * width;
        return area;
    }


    public static float setPrice(String type, String unit){
        Scanner scanner = new Scanner(System.in);
        System.out.format ("Please enter the %s price per %s:  %n", type, unit);
        float price = Float.parseFloat(scanner.nextLine());
        return price;
    }

    public static float calculateTotalCosts(int area, int perimeter, float cementCost, float framingCost){
        float totalCost = (area * cementCost) + (perimeter*framingCost);
        return totalCost;
    }
    public static void displayPermAndArea(int perimeter, int area){
        System.out.format("The perimeter is %d. %n  The area is %d  %n", perimeter, area);

    }

    public static void outputSubTotal(String type, float cost, int quantity, String unit){
        System.out.format("The total cost of %d %s of %s  is $%f%n", quantity, unit, type, cost*quantity );
    }


    public static void outputTotalCosts(float totalCosts ){
        System.out.format("Your total cost is: %f", totalCosts);
    }
    public static void main(String[] args) {

        int width = promptDimension("width");
        int length = promptDimension("length");
        int perimeter = calcPerimeter(length, width);
        int area = calculateArea(length, width);
        float framingCostPerFt = setPrice("framing", "foot");
        float cementCostPerSqFt = setPrice("cement", "sqft");
        float totalCosts = calculateTotalCosts(area, perimeter,cementCostPerSqFt,framingCostPerFt);

        outputDimension("width", width);
        outputDimension("length", length);
        displayPermAndArea(perimeter, area);
        outputCosts("framing", framingCostPerFt);
        outputCosts("cement", cementCostPerSqFt);
        outputSubTotal("cement", cementCostPerSqFt, area, "sqft"  );
        outputSubTotal("framing", framingCostPerFt, perimeter, "ft"  );
        outputTotalCosts(totalCosts);


    }
}
