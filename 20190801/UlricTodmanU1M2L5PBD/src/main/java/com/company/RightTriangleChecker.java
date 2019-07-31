package com.company;
import java.util.Scanner;
public class RightTriangleChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter three integers:");
        System.out.printf("Side 1: ");
        int side1 = Integer.parseInt(scanner.nextLine());

        System.out.printf("Side 2: ");
        int side2 = Integer.parseInt(scanner.nextLine());

        while(side2<side1){
            System.out.printf("%d is smaller than %d. Try again.\n", side2, side1);
            side2 = Integer.parseInt(scanner.nextLine());
            }
        System.out.printf("Side 3: ");
        int side3 = Integer.parseInt(scanner.nextLine());
        while(side2>side3){
            System.out.printf("%d is smaller than %d. Try again.\n", side3, side2);
            side3 = Integer.parseInt(scanner.nextLine());
        }

        System.out.printf("Your three sides are %d %d %d\n", side1, side2, side3);

        if(Math.pow(side1, 2)+Math.pow(side2, 2)== Math.pow(side3,2)){
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        }else{
            System.out.println("NO!  These sides do not make a right triangle!");
        }
    }
}
