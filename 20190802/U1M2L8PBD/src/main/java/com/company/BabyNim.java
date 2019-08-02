package com.company;

import java.util.Scanner;
public class BabyNim {
    public static int[] piles = new int[] {3,3,3};
    public static boolean finished = false;



    public static void checkFinished(){
        if(piles[0] > 0 ||  piles[1]>0 || piles[2] >0  ){
            finished = false;
        }else{
            finished = true;
        }
    }
    public static void pickPile(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a pile: ");
        String userChoice = scanner.nextLine();
        int userNumber;

        switch (userChoice){
            case "A" :
                System.out.print("Choose how many to remove from pile A:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[0] -= userNumber;
                break;
                case "B" :
                System.out.print("Choose how many to remove from pile B:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[1] -= userNumber;
                break;
                case "C" :
                System.out.print("Choose how many to remove from pile C:");
                userNumber = Integer.parseInt(scanner.nextLine());
                piles[2] -= userNumber;
                break;
        }
        checkFinished();
    }


    public static void  printStatus(){

        System.out.println("A: "+ piles[0] + " B: " + piles[1] + " C: " + piles[2]);


    }


    public static void main(String[] args) {
        printStatus();
        while(!finished ){

            pickPile();
            printStatus();
        }

        System.out.println("All piles are empty. Good Job!");

    }

}
