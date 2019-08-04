package com.company;

import java.util.Scanner;

public class BabyNim {
    public static int[] piles = new int[]{5, 5, 5};
    private static boolean finished = piles[0] <= 0 && piles[1] <= 0 && piles[2] <= 0;



    public static boolean getFinished() {
        finished = piles[0] <= 0 && piles[1] <= 0 && piles[2] <= 0;
        return finished;
    }

    public static void pickPile() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a pile: ");
        String userChoice = scanner.nextLine().toUpperCase();
        int userNumber;

        switch (userChoice) {
            case "A":
                System.out.print("Choose how many to remove from pile A:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[0] -= userNumber;
                break;
            case "B":
                System.out.print("Choose how many to remove from pile B:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[1] -= userNumber;
                break;
            case "C":
                System.out.print("Choose how many to remove from pile C:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[2] -= userNumber;
                break;
        }
        getFinished();
    }


    public static void printStatus() {

        System.out.println("A: " + piles[0] + " B: " + piles[1] + " C: " + piles[2]);


    }


    public static void main(String[] args) {
        printStatus();
        while (!finished) {

            pickPile();
            printStatus();
        }

        System.out.println("All piles are empty. Good Job!");

    }

}
