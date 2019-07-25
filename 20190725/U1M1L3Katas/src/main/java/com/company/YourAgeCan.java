package com.company;
import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your age.");
        int userAge = Integer.parseInt(scanner.nextLine());


        //store vars for ages so its all more readable.
        int votingAge = 18;
        int drinkingAge = 21;
        int presidentialAge = 35;
        int aarpEligible = 55;
        int retirementAge = 65;
        int lowerOcto = 80;
        int upperOcto = 89;
        int centenarian = 100;

        if (userAge >= votingAge)
            System.out.println("Vote");

        if (userAge >= drinkingAge)
            System.out.println("Drink Alcohol");

        if (userAge >= presidentialAge)
            System.out.println("Be president");


        if (userAge >= aarpEligible)
            System.out.println("Is eligible for AARP");

        if (userAge >= retirementAge)
            System.out.println("Can retire");
        if (userAge >= lowerOcto && userAge <= upperOcto)
            System.out.println("is an octogenarian");
        if (userAge >= centenarian)
            System.out.println("more than a century old");
    }
}