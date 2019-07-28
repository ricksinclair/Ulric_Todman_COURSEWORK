//I didn't see the readme indicate that they wanted me to prompt the user
//or give them feedback when they enter the words so I will just
//take the input without prompting and print the array elements.
package com.company;

import java.util.Scanner; //import Scanner

public class ArrayFun5Words {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //Create new Scanner instance and pass in System.in as argument to
                                                  //the constructor function

        String[] userWords = new String[5];   //new String[] with a size of 5


        for( int i = 0 ; i < userWords.length; i++ ){ //for the length of the array(stop after the last index.),
            userWords[i] = scanner.nextLine(); // populate with user input and create a new line after each time.
        }

        for(String elem : userWords){ ///then print each element in the array we just populated.
            System.out.println(elem);
        }

    }
}
