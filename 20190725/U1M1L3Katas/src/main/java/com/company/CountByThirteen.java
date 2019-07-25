package com.company;
//Import the scanner class.
import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        //Create a scanner instance.
        Scanner scanner = new Scanner(System.in);
        //Greet the user and prompt them to provide an integer.
        //Store that integer
        System.out.println("Welcome to the counter. Please enter an integer.");
        int userNumber = Integer.parseInt(scanner.nextLine());
        //Increment up to that integer, but only print numbers
        //which divide evenly by 13.
        for (int x = 0; x<=userNumber; x++){
            if( x % 13 == 0 ){
                System.out.println(x);
            }
        }
    }
}