package com.company;
import java.util.Scanner;
public class SafeSquareRoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SQUARE ROOT!");
        System.out.printf("Enter a number: ");
        int userNumber = Integer.parseInt(scanner.nextLine());

        while(userNumber<0){
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.printf("Try again: ");
            userNumber = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("The square root of %d is %f", userNumber, Math.sqrt(userNumber));
    }
}
