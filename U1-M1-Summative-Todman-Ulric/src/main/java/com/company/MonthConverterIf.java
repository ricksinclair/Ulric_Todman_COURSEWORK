package com.company;

//import scanner
import java.util.Scanner;



public class MonthConverterIf {

    public static void main(String[] args) {

        //create new Scanner instance
        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter a number between 1 and 12:");
        int userInput = Integer.parseInt(scanner.nextLine());

        //I'm not using curly braces for the following if
        //statements because there are only single line statements that follow each.
        //Looks a lot cleaner.


        if (userInput == 1)
            System.out.println("January");

        else if (userInput == 2)
            System.out.println("February");

        else if (userInput == 3)
            System.out.println("March");

        else if (userInput == 4)
            System.out.println("April");

        else if (userInput == 5)
            System.out.println("May");

        else if (userInput == 6)
            System.out.println("June");

        else if (userInput == 7)
            System.out.println("July");

        else if (userInput == 8)
            System.out.println("August");

        else if (userInput == 9)
            System.out.println("September");

        else if (userInput == 10)
            System.out.println("October");

        else if (userInput == 11)
            System.out.println("November");

        else if (userInput == 12)
            System.out.println("December");

        else //error msg if none of the above conditions have been met.
            System.out.printf("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
    }
}

