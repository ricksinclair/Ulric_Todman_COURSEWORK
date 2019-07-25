package com.company;
//import Scanner class
import java.util.Scanner;
public class UltimateQuestion {

    public static void main(String[] args) {
        //create new scanner instance.
        Scanner scanner = new Scanner(System.in);

        //initialize user answer to fail while loop case
        int userAnswer = 0 ;

        ///while userAnswer isn't the best number in the world.
        while(userAnswer != 42){
            //Prompt for the user to input a number.
            System.out.println("Please enter a number between 1 and 100");
            userAnswer = Integer.parseInt(scanner.nextLine());
            if(userAnswer >= 1 && userAnswer <= 100){//if the number is in range, prompt again.
                System.out.println("Please enter a number between 1 and 100");
                userAnswer = Integer.parseInt(scanner.nextLine());


            }else{//just in case the number they choose is out of range.
                System.out.println("Don't do instructions well, huh?");
            }
        }


        if (userAnswer==42){//If the number's 42. Give them the great news.
            System.out.println("That's the number I was looking for! 42 is definitely the answer!");
        }

    }
}
