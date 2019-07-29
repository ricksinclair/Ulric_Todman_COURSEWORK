package com.company;

import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {

        int guessCount = 1;
        Scanner scanner = new Scanner(System.in);
        int cpuNumber = (int) Math.ceil(Math.random()*10);
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        int userNumber = Integer.parseInt(scanner.nextLine());

        while(userNumber!=cpuNumber){
            System.out.println("That is incorrect. Guess again.");
            userNumber = Integer.parseInt((scanner.nextLine()));
            guessCount++;

        }

        System.out.println("That's right! You're a good guesser.");
        System.out.println("It only took you "+guessCount+" tries.");
    }
}
