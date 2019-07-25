package com.company;
//Import the scanner class.
import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
        //Create a new scanner instance.
        Scanner scanner = new Scanner(System.in);

        //Greet the user, prompt them for the integer and store it.
        System.out.println("Welcome to the counter. Please enter an integer.");
        int userNumber = Integer.parseInt(scanner.nextLine());

        //Print only integers which divide evenly by zero(even numbers)
        //up to the user's input number.
        for (int x = 0; x<=userNumber; x++){
            if( x % 2 == 0 ){
                System.out.println(x);
            }
        }
    }
}
