package com.company;
//import scanner class.
import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        //Create a new scanner instance.
        Scanner scanner = new Scanner(System.in);
        //prompt user for their number and store it in a variable.
        System.out.println("Please enter a number and I will tell you if its even or odd.");
        int userNumber = Integer.parseInt(scanner.nextLine());
        //If the user's number is evenly divisible by 2, its even. Print it's even. If it isn't,  print it's odd.
        if(userNumber%2==0){
            System.out.printf("%d is even\n", userNumber);
        }else
            System.out.printf("%d is odd\n", userNumber);
    }
}
