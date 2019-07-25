package com.company;

//import Scanner class
import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        //Create scanner instance.
        Scanner scanner = new Scanner(System.in);

        //Prompt for and store user's age.
        System.out.println("Please enter your age.");
        int userAge = Integer.parseInt(scanner.nextLine());


        //store vars for ages so its all more hunman-readable.
        int votingAge = 18;
        int drinkingAge = 21;
        int presidentialAge = 35;
        int aarpEligible = 55;
        int retirementAge = 65;
        int lowerOcto = 80;
        int upperOcto = 89;
        int centenarian = 100;

        //If they are old enough to vote
        if (userAge >= votingAge)
            System.out.println("Vote");
        //If they are of drinking age or older
        if (userAge >= drinkingAge)
            System.out.println("Drink Alcohol");
        //If they are of age to be president.
        if (userAge >= presidentialAge)
            System.out.println("Be president");
        //if they can join AARP
        if (userAge >= aarpEligible)
            System.out.println("Is eligible for AARP");
        //If they can retire .
        if (userAge >= retirementAge)
            System.out.println("Can retire");
        //If they are an octogenarian.
        if (userAge >= lowerOcto && userAge <= upperOcto)
            System.out.println("is an octogenarian");
        //If they are a centenarian
        if (userAge >= centenarian)
            System.out.println("more than a century old");
    }
}