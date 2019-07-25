package com.company;
import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your favorite programming language?");
        String userAnswer = scanner.nextLine();

        while(!userAnswer.equals("Java")){
            System.out.println("What is your favorite programming language?");
            userAnswer = scanner.nextLine();
        }

        System.out.println("That's what I was looking for! Java is definitely the answer!");
    }
}
