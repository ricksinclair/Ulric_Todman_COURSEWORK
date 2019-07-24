package com.company;
//import Scanner
import java.util.Scanner;
public class AddThirteen {

    public static void main(String[] args) {
        //create new Scanner instance
        Scanner scanner = new Scanner(System.in);
        //prompt for input
        System.out.println("Please enter your number: ");
        //assign user input and calculate
        int myNumber = Integer.parseInt(scanner.nextLine());
        int total = myNumber+13;
        System.out.printf("%d", total);
    }
}
