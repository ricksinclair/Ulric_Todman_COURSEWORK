package com.company;
import java.util.Scanner;
public class AddingValuesInALoop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int total=0;

        System.out.println("I will add up the numbers you give me.");
        System.out.printf("Number: ");
        int userNumber = Integer.parseInt(scanner.nextLine());
        total +=userNumber;
        while(userNumber!=0){
            System.out.println("The total so far is: "+total);
            System.out.printf("Number: ");

            userNumber = Integer.parseInt(scanner.nextLine());
            total +=userNumber;

        }
        System.out.println("The total is "+total);
    }

}
