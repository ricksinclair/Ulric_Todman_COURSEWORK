package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first number: ");
        int number1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the second number: ");

        int number2 = Integer.parseInt(scanner.nextLine());

        int total = number1 - number2;

        System.out.printf("%d", total);

    }
}
