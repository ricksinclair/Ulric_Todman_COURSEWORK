package com.company;
import java.util.Scanner;
public class NumberGuess {

    public static void main(String[] args) {
        int randomNumber =(int)Math.ceil( Math.random()*10);
        Scanner scanner= new Scanner(System.in);

        int userNumber = Integer.parseInt(scanner.nextLine());
        if(userNumber== randomNumber){
            System.out.println("That's right! My secret number was "+randomNumber);
        }else{
            System.out.println("Sorry, but I was thinking of "+randomNumber);
        }

    }
}
