package com.company;
//Import scanner
import java.util.Scanner;
public class LoanCalculator {
    public static void main(String[] args) {
        //Create scanner instance
        Scanner scanner = new Scanner(System.in);
        //Prompt for and set principle, interest and term
        System.out.println("Please enter the principle amount: ");
        double principle = Double.parseDouble( scanner.nextLine());
        System.out.println("Please enter the APR: ");
        double rate = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter the term in years: ");
        int mortgageTerm = Integer.parseInt(scanner.nextLine());


        int months = mortgageTerm*12;
        double monthlyRate= rate/12/100;


        double payment = principle * (monthlyRate*(Math.pow((1+monthlyRate), months))/(Math.pow((1+monthlyRate), months)-1));

        System.out.println("Your principle is: "+ principle);
        System.out.println("Your term in months is: "+ months);
        System.out.println("Your interest rate is "+ rate +"%");
        System.out.println("Your monthly payment is: " + payment);
    }
}

