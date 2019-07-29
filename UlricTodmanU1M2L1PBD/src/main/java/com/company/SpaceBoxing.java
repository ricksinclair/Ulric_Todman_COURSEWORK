package com.company;
import java.util.Scanner;


public class SpaceBoxing {


    public static void checkRelativeWeight(int weight, double gravityFactor){

        System.out.println("Your weight would be "+weight*gravityFactor+" pounds on that planet.");

    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your weight:");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("I have information for the following planets:\n" +
                "   1. Venus   2. Mars    3. Jupiter\n" +
                "   4. Saturn  5. Uranus  6. Neptune");

        System.out.println("Which planet are you visiting?");

        int planet = Integer.parseInt(scanner.nextLine());
        switch(planet){
            case(1):
                checkRelativeWeight(weight,.78);
                break;

            case(2):
                checkRelativeWeight(weight, .39);
                break;

            case(3):
                checkRelativeWeight(weight, 2.65);
                break;

            case(4):
                checkRelativeWeight(weight,1.17);
                break;

            case(5):
                checkRelativeWeight(weight,1.05);
                break;

            case(6):
                checkRelativeWeight(weight, 1.23);
                break;

        }
    }

}
