package com.company;
import java.util.Scanner;
public class HiLowLimited {

    public static void main(String[] args) {
        int cpuNumber = (int) Math.ceil(Math.random()*100);
        int numGuesses = 1;
        System.out.println("Cpu number for testing "+cpuNumber);

        System.out.println("I'm thinking of a number between 1 and 100. You have 7 guesses.");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("First guess: ");
        int userNumber = Integer.parseInt(scanner.nextLine());



        while(userNumber != cpuNumber && numGuesses<7){
            if(userNumber>cpuNumber){
                System.out.println("Sorry, that guess is too high.");
                numGuesses++;
                System.out.printf("Guess #%d: ", numGuesses);
                userNumber =  Integer.parseInt(scanner.nextLine());
            }else{
                System.out.println("Sorry, you are too low.");
                numGuesses++;
                System.out.printf("Guess #%d: ", numGuesses);
                userNumber =  Integer.parseInt(scanner.nextLine());

            }


        }

        if(userNumber == cpuNumber){
            System.out.println("You guessed it! What are the odds?!?");
        }else {
            System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");

        }
    }
}
