package com.company;
import java.util.Scanner;
public class AddThirteen {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your number: ");

        int myNumber = Integer.parseInt(scanner.nextLine());
        int total = myNumber+13;
        System.out.printf("%d", total);
    }
}
