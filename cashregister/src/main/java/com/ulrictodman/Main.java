package com.ulrictodman;

public class Main {

    public static void main(String[] args) {
        CashRegister reg = new CashRegister();

        System.out.printf("The total is: $%f\n",reg.returnBalance());
        System.out.printf("The pennies are worth: $%f\n", reg.returnPenniesTotal());
        System.out.printf("The nickels are worth $%f\n", reg.returnNickelsTotal());
        System.out.printf("The dimes are worth $%f\n", reg.returnDimesTotal());
        System.out.printf("The quarters are worth $%f\n", reg.returnQuartersTotal());
        reg.checkout();
    }
}
