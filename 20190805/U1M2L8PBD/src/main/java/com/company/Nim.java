package com.company;

import sun.awt.image.IntegerComponentRaster;

import javax.swing.*;
import java.util.Scanner;

public class Nim {

    private static String last = "";
    private static int[] piles = new int[]{5, 5, 5};
    private static boolean finished = piles[0] <= 0 && piles[1] <= 0 && piles[2] <= 0;
    private static String userName1;
    private static String userName2;
    private static int aBlanks = 5-piles[0];
    private static int bBlanks = 5-piles[1] ;
    private static int cBlanks = 5-piles[2];
    private static int turns = Integer.MIN_VALUE;
    private static String pileNameA="A";
    private static String pileNameB="B";
    private static String pileNameC="C";

    public static void setBlanks(){
        aBlanks = 5-piles[0];
        bBlanks = 5-piles[1] ;
        cBlanks = 5-piles[2];

    }
    public static void subtractBlanks(){
        aBlanks--;
        bBlanks--;
        cBlanks--;
    }

    public static boolean getFinished() {
        finished = piles[0] <= 0 && piles[1] <= 0 && piles[2] <= 0;
        return finished;


    }

    public static String starsOrBlanks(int pile, int blankNumber) {


        int blankPrintInt= blankNumber;

        String rtn = new String();
        if (blankPrintInt > 0) {

            rtn = ("x");
        }  if (blankPrintInt<= 0) {

            rtn = ("*");
        }

        return rtn;

    }


    public static void printStatus() {

        for (int i = 0; i < 5; i++) {

            System.out.println(" " + starsOrBlanks(piles[0], aBlanks)
                    + " " + starsOrBlanks(piles[1], bBlanks)
                    + " " + starsOrBlanks(piles[2], cBlanks) + " ");
            subtractBlanks();
        }


        System.out.println(" A B C ");


    }

    public static void pickPile(String userName) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(userName + ", choose a pile: ");
        String userChoice = scanner.nextLine().toUpperCase();
        int userNumber;

        switch (userChoice) {
            case "A":
                System.out.print("Choose how many to remove from pile A:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[0] -= userNumber;
                setBlanks();
                last = userName;
                getFinished();


                break;
            case "B":
                System.out.print("Choose how many to remove from pile B:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[1] -= userNumber;
                last = userName;
                getFinished();


                break;
            case "C":
                System.out.print("Choose how many to remove from pile C:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[2] -= userNumber;
                last = userName;
                getFinished();


                break;
            default:
                System.out.println("That isn't a valid answer, bro. (or sis.");
        }

        setBlanks();
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
                turns++;
            } else {
                printStatus();
                pickPile(userName2);
                turns++;
            }

        }

        if (finished) {
            if (last == userName1) {
                System.out.println("You picked the last pile "+userName1+". You lose");
                System.out.println("You win "+userName2+"!");
            }else if( last == userName2) {
                System.out.println("You picked the last pile "+userName2+". You lose");
                System.out.println("You win "+userName1+"!");
            }
        }
    }


}
