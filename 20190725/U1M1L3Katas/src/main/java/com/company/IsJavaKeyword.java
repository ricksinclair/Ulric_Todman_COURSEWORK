package com.company;
//import scanner class
import java.util.Scanner;
public class IsJavaKeyword {
    public static void main(String[] args) {
        //create new scanner instance
        Scanner scanner = new Scanner(System.in);
        //prompt for user to enter keyword and store keyword
        System.out.println("Please enter your key word to see if it is reserved: ");
        String keyword = scanner.nextLine();
        //keyword list from W3 Schools.
        String keywordsList = "abstract assert boolean break " +
                "byte case catch char class const continue default" +
                "do double else enum" +
                "extends final finally float" +
                "for goto if implements" +
                "import instanceof int interface" +
                "long native new package" +
                "private protected public return" +
                "short static strictfp super" +
                "switch synchronized this throw" +
                "throws transient try void" +
                "volatile while  true  false" +
                "null";



            /* found this .contains method at https://www.geeksforgeeks.org/java-string-contains-method-example/
            check if word is in our keywords reference string
            print its a keyword if it is. print its a keyword if it isn't. */
            if(keywordsList.contains(keyword))
                System.out.println(keyword+ " is a java keyword.");
            else
                System.out.println(keyword+ " is not a java keyword.");


    }
}
