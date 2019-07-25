package com.company;
//import scanner class
import java.util.Scanner;
public class AgeAgain {

    public static void main(String[] args) {
        //create new Scanner instance
        Scanner scanner = new Scanner(System.in);

        //prompt for and store user age using Scanner instance
        System.out.println("Please enter your age: ");
        int userAge = Integer.parseInt(scanner.nextLine());
        //Inquire about child's grade if they are less than 14.
        if (userAge < 14){
            System.out.println("What grade are you in?");
            String userGrade = scanner.nextLine();
            System.out.println("Wow! " + userGrade + " grade - that sounds exciting!");
        }else if(userAge>=14 && userAge <=18){//Inquire about college plans if in high school age range
            System.out.println("Are you planning to go to college? (yes or no)");
            String ifCollege = scanner.nextLine();

            switch (ifCollege) {//if they are going ask which school and laud them for their choice.
                case "yes":
                    System.out.println("Cool, which school are you interested in most?");
                    String college = scanner.nextLine();
                    System.out.println(college + " is a great school!");
                    break;

                case "no"://If not attending college, ask about plans and be supportive.
                    System.out.println("Cool, what's your plan?");
                    String plan = scanner.nextLine();
                    System.out.println("Wow, "+ plan +" sounds like a plan!");
                    break;

                 default: //If its not a yes or no, put the pressure on.
                     System.out.println("What do you mean you don't know? I don't understand. Are you joking?");

            }
        }else if (userAge>18){//Ask about job if over 18.
            System.out.println("What do you do for a living?");
            String occupation = scanner.nextLine();
            System.out.println(occupation+ " sounds like a great job!");
        }

    }
}
