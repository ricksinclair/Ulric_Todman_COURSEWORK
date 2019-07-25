package com.company;
import java.util.Scanner;
public class PrimeFinder {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter your number");

    int userNumber = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i<=userNumber; i++){
        boolean prime = true;

        for(int j = 2; j < i; j++){

            if (i % j == 0 && (i!=0 ||i!=1)){
                prime = false;
                break;
            }
        }
        if(prime && (i != 0 && i != 1)){
            System.out.println(i);
        }
    }

    }
}
