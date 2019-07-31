package com.company;
import java.util.Scanner;
public class ThreeCardMonte {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.");
        System.out.printf("Which one is the ace?\n" +
                "\n" +
                "\t##  ##  ##\n" +
                "\t##  ##  ##\n" +
                "\t1   2   3 \n\n");

        int cpuChoice = (int) Math.ceil(Math.random()*3);
        int userChoice = Integer.parseInt(scanner.nextLine());

        if(userChoice != cpuChoice){
            System.out.printf("Ha! Fast Eddie wins again! The ace was card number %d.\n", cpuChoice);
        }else{
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        }


        switch(cpuChoice){
            case(1):
                System.out.printf(  "\n" +
                        "\tAA  ##  ##\n" +
                        "\tAA  ##  ##\n" +
                        "\t1   2   3 \n");
                break;

            case(2):
                System.out.printf(  "\n" +
                        "\t##  AA  ##\n" +
                        "\t##  AA  ##\n" +
                        "\t1   2   3 \n");
                break;
            case(3):
                System.out.printf(  "\n" +
                        "\t##  ##  AA\n" +
                        "\t##  ##  AA\n" +
                        "\t1   2   3 \n");
                break;

        }
    }










}
