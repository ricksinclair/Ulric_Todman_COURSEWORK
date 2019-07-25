package com.company;
//import Scanner class
import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        //create new Scanner instance
        Scanner scanner = new Scanner(System.in);
        //Ask user for favorite language
        System.out.println("What is your favorite programming language?");
        String userAnswer = scanner.nextLine();
        //Keep asking until the magic word Java floats off their fingers.
        while(!userAnswer.equals("Java")){
            System.out.println("What is your favorite programming language?");
            userAnswer = scanner.nextLine();
        }
        //Positive reinforcement of the subject
        System.out.println("That's what I was looking for! Java is definitely the answer!");
    }
}
