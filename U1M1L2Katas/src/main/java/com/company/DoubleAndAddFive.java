package com.company;
import java.util.Scanner;
public class DoubleAndAddFive {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your number: ");

        int myNumber = Integer.parseInt(scanner.nextLine());

        int total = (myNumber*2)+5;

        System.out.printf("%d", total);
    }
}
