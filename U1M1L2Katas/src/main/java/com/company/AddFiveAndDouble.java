package com.company;
import java.util.Scanner;
public class AddFiveAndDouble {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number  you wish to add five to then double: ");
        int myNumber = Integer.parseInt(scanner.nextLine());

        float total = (myNumber+5)*2;

        System.out.printf("%.2f", total);

    }
}
