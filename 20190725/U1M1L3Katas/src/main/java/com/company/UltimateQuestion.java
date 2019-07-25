package com.company;
import java.util.Scanner;
public class UltimateQuestion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int userAnswer = 0 ;

        while(userAnswer != 42){

            System.out.println("Please enter a number between 1 and 100");
            userAnswer = Integer.parseInt(scanner.nextLine());
            if(userAnswer >= 1 && userAnswer <= 100){
                System.out.println("Please enter a number between 1 and 100");
                userAnswer = Integer.parseInt(scanner.nextLine());


            }
        }


        if (userAnswer==42){
            System.out.println("That's the number I was looking for! 42 is definitely the answer!");
        }

    }
}
