package com.company;
import java.util.Scanner;
public class Nim {



        public static int[] piles = new int[] {3,3,3};
    public static boolean finished = false;
    public static String userName1;
    public static String userName2;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Player 1, please enter your name: ");
        userName1 = scanner.nextLine();
        System.out.print("Player 2, please enter your name: ");
        userName2 = scanner.nextLine();
    }



}
