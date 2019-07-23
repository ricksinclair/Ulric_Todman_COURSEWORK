package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {


        //add scanner instance
            Scanner scanner = new Scanner(System.in);
        //Declare num 1 as user input
            System.out.println("Please enter number 1: ");
            int num1 = Integer.parseInt(scanner.nextLine());
        //Declare num 2 as user input
            System.out.println("Please enter number 2: ");
            int num2 = Integer.parseInt(scanner.nextLine());
        //Declare num 3 as user input
            System.out.println("Please enter number 3: ");
            int num3 = Integer.parseInt(scanner.nextLine());
        //Declare num 4 as user input
            System.out.println("Please enter number 4: ");
            int num4 = Integer.parseInt(scanner.nextLine());
        //Declare num 5 as user input
            System.out.println("Please enter number 5: ");
            int num5 = Integer.parseInt(scanner.nextLine());
        //Declare total as sum of 5 numbers
            float total  = (num1 + num2 + num3 +num4 + num5);
        //Display results to user
            System.out.printf("%.2f",total);
        }

    }

