package com.company;
//import Scanner
import java.util.Scanner;
public class DoubleAndAddFive {

    public static void main(String[] args) {

        //create Scanner instance
        Scanner scanner = new Scanner(System.in);
        //prompt input
        System.out.println("Please enter your number: ");
        //assign input to var
        int myNumber = Integer.parseInt(scanner.nextLine());
        // calculate total
        int total = (myNumber*2)+5;
        //print
        System.out.printf("%d", total);
    }
}
