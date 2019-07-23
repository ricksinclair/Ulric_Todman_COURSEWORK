package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter number 1: ");
        float num1 = Float.parseFloat(scanner.nextLine());
        System.out.println("Please enter number 2: ");
        float num2 = Float.parseFloat(scanner.nextLine());
        System.out.println("Please enter number 3: ");
        float num3 = Float.parseFloat(scanner.nextLine());


        float average  = (num1 + num2 + num3 ) / 3;

        System.out.printf("%.2f", average);
    }
}
