package com.company;
import java.util.Arrays;
import java.util.Scanner;


public class ArrayDemo {

    public static int[] populateArray(int arraySize){
        Scanner scanner = new Scanner(System.in);
//        System.out.printf("Please enter your desired array size.\n");
//        int arraySize = Integer.parseInt(scanner.nextLine());

        int outputArray[]= new int[arraySize];

        for (int i = 0; i<outputArray.length; i++){
            System.out.printf("Please enter element number %d of %d\n", i+1, outputArray.length );
            outputArray[i]= Integer.parseInt(scanner.nextLine());
        }
        return outputArray;
    }

    public static int findMax(int[] inputArray){
        int max=0;

        for(int element : inputArray){// syntax denotes for each element in input array
            if (element>max){
                max = element;
            }

        }
        return max;
    }
    public static void main(String[] args) {

//        int[] array1;
//        //how to set size of the array.
//        array1 = new int[4];
//        //set array index 0 to value of 10
//        array1[0]= 10;
//        array1[1]= 20;
//        array1[2]= 20;
//        array1[3]= 40;
//
//        for (int i = 0; i<array1.length; i++){
//            System.out.println(array1[i]);
//        }
//
//        int[] array2 = {10,20,30, 40, 50};
//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));
//        int array1Max = findMax(array1);
//        int array2Max= findMax(array2);
//        System.out.printf("Max of array1 is %d\n", array1Max);
//        System.out.printf("Max of array2 is %d\n", array2Max);
        int[] array3 = populateArray(5);
       System.out.println( "max of array is "+ findMax(array3));
       System.out.println("items in array are "+ Arrays.toString(array3));
    }
}
