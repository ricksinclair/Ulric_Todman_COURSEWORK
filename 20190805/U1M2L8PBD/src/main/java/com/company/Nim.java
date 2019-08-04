package com.company;

import java.util.Scanner;

public class Nim {

    private static String last = "";
    private static int[] piles = new int[]{5, 5, 5};
    private static boolean finished = piles[0] <= 0 && piles[1] <= 0 && piles[2] <= 0;
    private static String userName1;
    private static String userName2;
    private static int aBlanks = 5 - piles[0];
    private static int bBlanks = 5 - piles[1];
    private static int cBlanks = 5 - piles[2];
    private static int turns = Integer.MIN_VALUE;
    private static int userNumber = Integer.MIN_VALUE;


    public static void setBlanks() {
        aBlanks = 5 - piles[0];
        bBlanks = 5 - piles[1];
        cBlanks = 5 - piles[2];

    }


    public static boolean getFinished() {
        finished = piles[0] <= 0 && piles[1] <= 0 && piles[2] <= 0;
        return finished;

    }

    public static String starsOrBlanks(int pile, int blankNumber) {


        int blankPrintInt = blankNumber;

        String rtn = "";
        if (blankPrintInt > 0) {

            rtn = (" ");
        }
        if (blankPrintInt <= 0) {

            rtn = ("*");
        }

        return rtn;

    }


    public static void printStatus() {

        for (int i = 0; i < 5; i++) {

            System.out.println(" " + starsOrBlanks(piles[0], aBlanks)
                    + " " + starsOrBlanks(piles[1], bBlanks)
                    + " " + starsOrBlanks(piles[2], cBlanks) + " ");

            aBlanks--;
            bBlanks--;
            cBlanks--;
        }


        System.out.println(" A B C ");


    }

    public static void setAnswer(String userName, int pile) {
        Scanner scanner = new Scanner(System.in);

        try {
            userNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Stop trying to cheat bro (or sis).");
            pickPile(userName);
        }
        if (pile - userNumber < 0 || userNumber < 0) {
            System.out.println("You are trying to cheat. Stop it bro (or sis).");
            pickPile(userName);
        }

        last = userName;
        setBlanks();
        getFinished();
        turns++;
    }

    public static void pickPile(String userName) {
        userNumber = Integer.MIN_VALUE;
        Scanner scanner = new Scanner(System.in);
        System.out.print(userName + ", choose a pile: ");
        String userChoice = scanner.nextLine().toUpperCase();


        switch (userChoice) {
            case "A":
                System.out.print("Choose how many to remove from pile A:");
                setAnswer(userName, piles[0]);
                piles[0] -= userNumber;

                break;
            case "B":
                System.out.print("Choose how many to remove from pile B:");
                setAnswer(userName, piles[1]);
                piles[1] -= userNumber;
                break;


            case "C":
                System.out.print("Choose how many to remove from pile C:");
                setAnswer(userName, piles[2]);
                piles[2] -= userNumber;
                break;
            default:
                System.out.println("That isn't a valid answer, bro. (or sis).");
        }

        setBlanks();

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Player 1, please enter your name: ");
        userName1 = scanner.nextLine();
        System.out.print("Player 2, please enter your name: ");
        userName2 = scanner.nextLine();

        while (!finished) {
            if (turns % 2 == 0) {
                printStatus();
                pickPile(userName1);

            } else {
                printStatus();
                pickPile(userName2);

            }

        }

        if (finished) {
            if (last == userName1) {
                System.out.println("You picked the last pile " + userName1 + ". You lose");
                System.out.println("You win " + userName2 + "!");
            } else if (last == userName2) {
                System.out.println("You picked the last pile " + userName2 + ". You lose");
                System.out.println("You win " + userName1 + "!");
            }
        }
    }


}
