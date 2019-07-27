package com.ulrictodman;

import java.util.Scanner;

public class CashRegister {
    private int pennies;
    private double penniesValue = .01;
    private int nickels;
    private double nickelsValue = .05;
    private int dimes;
    private double dimesValue=.10;
    private int quarters;
    private double quartersValue = .25;
    private double newBalance;
    public double transaction(double subtotal, double amountTendered){

    return dimesValue;
    }



    public void checkout(){
//        boolean finished = false;
//
//
//        String mainMenuInput;
//        System.out.printf("");
//        while (finished = false) {
//
////            switch (mainMenuInput) {
////                case :
////
////
////
////
////            }
//            return;
//            }
            System.out.printf("enter value:\n");
            Scanner scanner = new Scanner(System.in);
            Sanitizer sanitizer = new Sanitizer();
            String userInput = scanner.nextLine();
            System.out.printf( sanitizer.sanitizeNumber(userInput) );

        }


    public double returnPenniesTotal(){
        return (pennies*penniesValue);
    }

    public double returnNickelsTotal(){
        return (nickels*nickelsValue);
    }

    public double returnDimesTotal(){
        return (dimes*dimesValue);
    }

    public double returnQuartersTotal(){
        return (quarters*quartersValue);
    }

    public double returnBalance(){

        return returnPenniesTotal()+returnNickelsTotal()+returnDimesTotal()+ returnQuartersTotal();
    }
    private void setBalance(float newBalance){
        newBalance = newBalance;
    }



    public  CashRegister(){

        System.out.printf("Please enter number of pennies: \n");
        Scanner scanner = new Scanner(System.in);
        pennies = Integer.parseInt(scanner.nextLine());
        System.out.printf("Please enter number of nickels: \n");
        nickels = Integer.parseInt(scanner.nextLine());
        System.out.printf("Please enter number of dimes: \n");
        dimes = Integer.parseInt(scanner.nextLine());
        System.out.printf("Please enter number of quarters: \n");
        quarters = Integer.parseInt(scanner.nextLine());




    }



}
