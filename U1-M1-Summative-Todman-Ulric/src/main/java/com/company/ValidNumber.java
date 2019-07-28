package com.company;

//import Scanner Class
import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  //create scanner instance.

        System.out.println("Please enter a number between 1 and 10"); //prompt the user nicely the first time.
        int userInput = Integer.parseInt(scanner.nextLine());

        while( userInput < 1 || userInput > 10 ){ //while the user input is out of bounds, keep prompting them.
            System.out.println("You must enter a number between 1 and 10, please try again.");
            userInput = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(userInput); //once the desired condition has been met. while loop exits and we print
                                       //the user input.
    }
}
