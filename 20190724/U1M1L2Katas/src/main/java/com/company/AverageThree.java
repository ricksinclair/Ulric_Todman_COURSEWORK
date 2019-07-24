package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
        //prompt and receive first number
        System.out.println("Please enter number 1: ");
        float num1 = Float.parseFloat(scanner.nextLine());
        //prompt and receive second number
        System.out.println("Please enter number 2: ");
        float num2 = Float.parseFloat(scanner.nextLine());
        //prompt and receive third number
        System.out.println("Please enter number 3: ");
        float num3 = Float.parseFloat(scanner.nextLine());

        ///calculate and display average

        float average  = (num1 + num2 + num3 ) / 3;

        System.out.printf("%.2f", average);
    }
}
