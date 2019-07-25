package com.company;
//Import the scanner class
import java.util.Scanner;


public class CountTo {

    public static void main(String[] args) {
        //Create a scanner instance.
        Scanner scanner = new Scanner(System.in);
        //Prompt for an store user provided integer.
        System.out.println("Welcome to the counter. Please enter an integer.");
        int userNumber = Integer.parseInt(scanner.nextLine());
        //print out a count up to the user's input.
        for (int x = 0; x<=userNumber; ++x){
            System.out.println(x);
        }
    }
}
