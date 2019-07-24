package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            System.out.println("Would you like to print some words on the screen?");

            String answer= in.nextLine();

            while( answer.equalsIgnoreCase("y") ||  answer.equalsIgnoreCase("yes")) {
                System.out.println("Type a word to print");
                String word = in.nextLine();
                System.out.println(word);
                System.out.println("Would you like to print some words on the screen?");
                answer= in.nextLine();
            }
    }
}
