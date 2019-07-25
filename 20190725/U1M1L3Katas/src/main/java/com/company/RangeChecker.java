package com.company;
//Import the scanner.
import java.util.Scanner;
public class RangeChecker {

    public static void main(String[] args) {

        //Create and name a new scanner instance from the class we imported.
        Scanner scanner = new Scanner(System.in);


        //Initialize it to 0 since that will allow us to have it evaluate as false to start.
        int userNumber = 0;

        //While the number is out of range, prompt.
        while( userNumber <= 15 || userNumber >= 32 ) {
            System.out.println("Please enter a number between 15 and 32");
            userNumber = Integer.parseInt(scanner.nextLine());


        }
        //once that while statement is fulfilled, print the user's number
        System.out.println("Your number was "+userNumber);
    }
}
