package com.company;
//import Scanner
import java.util.Scanner;
public class MultiplyThree {

    public static void main(String[] args) {
        //Create new Scanner instance
        Scanner scanner = new Scanner(System.in);
        //prompt and assign first value
        System.out.println("Please enter the first number:");
        int number1 = Integer.parseInt(scanner.nextLine());
        //prompt and assign second value
        System.out.println("Please enter the second number:");
        int number2 = Integer.parseInt(scanner.nextLine());
        //prompt and assign third value
        System.out.println("Please enter the third number:");
        int number3 = Integer.parseInt(scanner.nextLine());
        //calculate total
        int total = number1*number2*number3;
        //print total
        System.out.printf("%d",total);
    }
}