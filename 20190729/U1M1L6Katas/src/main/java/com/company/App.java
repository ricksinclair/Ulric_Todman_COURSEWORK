package com.company;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import org.omg.PortableInterceptor.INACTIVE;

///only used this to print out array to console, not for swap logic
import java.util.Arrays;
public class App {

    public static int total(int[] inputArray) {

        int total = 0;

        for (int elem : inputArray) {

            total += elem;

        }
        return total;
    }

    public static int totalOdd(int[] inputArray) {

        int total = 0;

        for (int i = 0; i < inputArray.length; i++) {

            if (i % 2 != 0)
                total += inputArray[i];

        }
        return total;

    }

    public static int totalEven(int[] inputArray) {

        int total = 0;

        for (int i = 0; i < inputArray.length; i++) {

            if (i % 2 == 0)
                total += inputArray[i];

        }
        return total;

    }

    public static int secondLargestNumber(int[] inputArray) {

        int largest = Integer.MIN_VALUE;///Had issues with negative numbers so I had to do some digging to find this way
                                        //To set a "zero" less than 0 but that won't bump heads.
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > largest) {
                secondLargest = largest;
                largest = inputArray[i];

            } else if (inputArray[i] > secondLargest && inputArray[i] != largest) {
                secondLargest = inputArray[i];
            }

        }
        return secondLargest;


    }

    public static String[] swapFirstAndLast(String[] inputArray){
        String firstElem;
        String lastElem;
        String[] newArray = inputArray;
         firstElem = inputArray[0];
        lastElem = inputArray[inputArray.length-1];
        newArray[0]=lastElem;
        newArray[inputArray.length-1]=firstElem;
        return newArray;

    }

    public static int[] reverse(int[] inputArray){
        int endOfArray = inputArray.length-1;
        int[] newArray = new  int[inputArray.length];
        for(int i=0; i<inputArray.length&& endOfArray>=0; i++){
            newArray[i]=inputArray[endOfArray];
            endOfArray--;
        }
        return newArray;
    }

    public static String concatenateString(String[] inputArray){
        String newString ="";
        for(String elem : inputArray){
            newString += elem;
        }
        return newString;
    }

    public static int[] everyThird(int[] inputArray) {
        int newArrLength = inputArray.length / 3;
        int[] outputArray = new int[newArrLength];
        int outputArrayIndex = 0;

        for (int i = 2; i<inputArray.length  ; i+=3){

            outputArray[outputArrayIndex]=inputArray[i];
            outputArrayIndex++;

            }
        if(outputArray.length==0){
            return null;
        }
        return outputArray;

        }


        public  static int[] lessThanFive(int[] inputArray){

        int newArrSize=0;
        for(int elem : inputArray){
            if(elem<5)
                newArrSize++;
        }
        int[] outputArray = new int[newArrSize];

        for (int i=0; i<inputArray.length; i++){
            int outputArrayIndex=0;
             for(int elem : inputArray){
                     if(elem <5 ){
                         outputArray[outputArrayIndex] = elem;
                         outputArrayIndex++;
                     }
             }

        }

       if (outputArray.length == 0){
           return  null;
       }    else
                return outputArray;


        }

    public static void main(String[] args) {

        int array1[] = {0, 1, 2, 3, 4, 5, 6, 7};
        int withNeg[] = {-3,-17};
        String array2[]={"foo", "bar", "baz", "qux"};

        System.out.println(secondLargestNumber(array1));

//        System.out.printf(Arrays.toString(array1));

    }
}