//I could have imported java.util.Arrays and used the Arrays.toString() method
//to print the final result  but i'm going to play it safe and assume you don't
// want us using that yet

//I didn't see the readme indicate that they wanted me to prompt the user
//or give them feedback when they enter the numbers so i will just
//take the input without prompting and return the array.
package com.company;
import java.util.Scanner;

public class ArrayFunUserArray {

    public static void main(String[] args) {

        //create new scanner instance.
        Scanner scanner = new Scanner(System.in);

        int[] userInputs = new int[5];


        for(int i = 0;i<userInputs.length; i++){ //I'll populate each element

            userInputs[i]=Integer.parseInt(scanner.nextLine()); //with user input
        }
        for(int elem : userInputs){
            System.out.println(elem); //and print each of the elements.
        }

    }
}
