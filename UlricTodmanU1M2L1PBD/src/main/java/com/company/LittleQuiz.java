package com.company;
import java.util.Scanner;
public class LittleQuiz {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you ready for the quiz? (Y/y to continue or press any other key to exit.)");

        String ready = scanner.nextLine();
        int numQuestions = 3;
        int numCorrect = 0;
System.out.println(ready);
       if(ready.equalsIgnoreCase("y")) {

           System.out.println("Q1) What late \"Keep ya head up\" rapper got his start in Digital Underground?");
           System.out.println("1) Heavy D");
           System.out.println("2) Tupac Shakur");
           System.out.println("3) Flavor Flav");
           System.out.println("4) Craig Mack");

           int answerQ1 = Integer.parseInt(scanner.nextLine());

           if (answerQ1 == 2) {
               System.out.println("You are correct!");
               numCorrect++;
           } else {
               System.out.println("Sorry that's not what we were looking for!");

           }

           System.out.println("Q2)How many continents are there?");
           System.out.println("1) 5");
           System.out.println("2) 8");
           System.out.println("3) 7");
           System.out.println("4) 6");

           int answerQ2 = Integer.parseInt(scanner.nextLine());

           if (answerQ2 == 3) {
               System.out.println("You are correct!");
               numCorrect++;
           } else {
               System.out.println("Sorry that's not what we were looking for!");

           }
           System.out.println("Q1) Who developed this quiz?");
           System.out.println("1) Dr Evil");
           System.out.println("2) Albert Einstein");
           System.out.println("3) Elon Musk");
           System.out.println("4) Ulric Todman");

           int answerQ3 = Integer.parseInt(scanner.nextLine());

           if (answerQ3 == 4) {
               System.out.println("You are correct!");
               numCorrect++;
           } else {
               System.out.println("Sorry that's not what we were looking for!");

           }

           System.out.println("Overall, you got " + numCorrect + " out of 3 correct!");
           System.out.println("Thank you for playing!");
       }
       else{
           return;
       }
    }
}
