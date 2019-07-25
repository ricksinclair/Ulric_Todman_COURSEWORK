package com.company;

import java.util.Scanner;
public class AgeAgain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your age: ");
        int userAge = Integer.parseInt(scanner.nextLine());

        if (userAge < 14){
            System.out.println("What grade are you in?");
            String userGrade = scanner.nextLine();
            System.out.println("Wow! " + userGrade + " grade - that sounds exciting!");
        }else if(userAge>=14 && userAge <=18){
            System.out.println("Are you planning to go to college? (yes or no)");
            String ifCollege = scanner.nextLine();

            switch (ifCollege) {
                case "yes":
                    System.out.println("Cool, which school are you interested in most?");
                    String college = scanner.nextLine();
                    System.out.println(college + " is a great school!");
                    break;

                case "no":
                    System.out.println("Cool, what's your plan?");
                    String plan = scanner.nextLine();
                    System.out.println("Wow, "+ plan +" sounds like a plan!");
                    break;

                 default:
                     System.out.println("What do you mean you don't know? I don't understand.");

            }
        }else if (userAge>18){
            System.out.println("What do you do for a living?");
            String occupation = scanner.nextLine();
            System.out.println(occupation+ " sounds like a great job!");
        }

    }
}
