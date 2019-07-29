package com.company;



///only used this to print out array to console, not for swap logic
import java.util.Arrays;
public class App {

    public static int total(int[] inputArray) { //method returns an int and takes an int[] as input

        int total = 0;
        //Add all elements in the input array and store it as a total.
        //then return the total.
        for (int elem : inputArray) {
        //enhanced for loop reads as "for each element in input array"
            total += elem;
            //take the total variable then add that current element's value to the total.
        }
        ///return the total
        return total;
    }

    public static int totalOdd(int[] inputArray) { //method returns an int  and takes an int[] as input

        int total = 0;
        // each index in input array.
        for (int i = 0; i < inputArray.length; i++) {
            //if the index doesn't divide evenly
            if (i % 2 != 0)
                total += inputArray[i];
            //take the total variable then add the element in that index's value to the total.



        }
        return total;

    }

    public static int totalEven(int[] inputArray) { //method returns an int and takes an int[] as input

        int total = 0;

        // each index in input array.
        for (int i = 0; i < inputArray.length; i++) {
            //if the index does divide evenly

            if (i % 2 == 0)
                total += inputArray[i];
            //take the total variable then add the element in that index's value to the total.

        }
        return total;

    }

    public static int secondLargestNumber(int[] inputArray) {//method returns an int and takes an int[] as input

        int largest = Integer.MIN_VALUE;//Had issues with negative numbers so I had to do some digging to find this way
        int secondLargest = Integer.MIN_VALUE; //to set an "absolute zero" less than 0 so that it that won't bump heads.
                                                //with a negative number and break the logic.
                                                //It is highly unlikely an element we're testing against
                                                //have a value that low.

        for (int i = 0; i < inputArray.length; i++) {//for all elements in array
            if (inputArray[i] > largest) {//if the current number is larger than the current value assigned to largest
                secondLargest = largest;//set the current largest to the second largest.
                largest = inputArray[i];//set the largest to the current index.

            } else if (inputArray[i] > secondLargest && inputArray[i] != largest) {
                //if the current number is larger than the second largest and it isn't the same value as the largest.
                secondLargest = inputArray[i];
                //make the second largest the current index
            }

        }
        return secondLargest;
                // after the loop is finished return the value of the second largest number.

    }

    public static String[] swapFirstAndLast(String[] inputArray){ //takes a String[] as input + returns String[]
        String firstElem;//declaring String to store the first element's value.
        String lastElem; // declaring String to store the last element's value.
        String[] newArray = inputArray; //we don't want to mutate the original, just return an array that's swapped.
         firstElem = inputArray[0];//initializing value as first element
        lastElem = inputArray[inputArray.length-1]; // initializing value as last element.
        newArray[0]=lastElem;//perform the desired
        newArray[inputArray.length-1]=firstElem;//swap on both elements in cloned String[] newArray.
        return newArray;
        //return the new String[].

    }

    public static int[] reverse(int[] inputArray){ // method takes and returns int[]
        int endOfArray = inputArray.length-1; //stores last index of the inputArray.
        int[] newArray = new  int[inputArray.length]; //create an array the same size as the inputArray.
        for(int i=0; i<inputArray.length&& endOfArray>=0; i++){ //we are going to decrement the end of the array var
            //so i wanted to make sure that it stops when there are no more elements.
            newArray[i]=inputArray[endOfArray]; //now we are going to assign the last to the first
            endOfArray--; //then the second last to the second and so on....
        }
        return newArray;//Then we are going to return the array.
    }

    public static String concatenateString(String[] inputArray){ //takes in String[] and returns String
        String newString =""; //Create new String.
        for(String elem : inputArray){ //for each element in the input array.
            newString += elem; //concatenate by added each value to the end as you traverse the array.
        }
        return newString; //return the string we created.
    }

    public static int[] everyThird(int[] inputArray) { //takes and returns int[]
        int newArrLength = inputArray.length / 3;
        //int will round. since only each 3rd will be taken array size will be 1/3
        int[] outputArray = new int[newArrLength];
        //create the output array with our calculated size.
        int outputArrayIndex = 0;//start at the first index of the output array.

        for (int i = 2; i<inputArray.length  ; i+=3){
        //start at the third index([2]) and increment by 3
            //keep going as long as the index is less than or equal to
            //than the length
            //the length value is always 1 more than the last index
            ///so that's why I didn't use the <= operator.
            outputArray[outputArrayIndex]=inputArray[i];
            //add the value to each third one to each index of the new array respectively.
            outputArrayIndex++;
            //increment through the array (end condition in for loop definition).
            }
        if(outputArray.length==0){
            return null; //if there is no third element , return a null value.
        }else
        return outputArray;
        //otherwise return the output array.

        }


        public  static int[] lessThanFive(int[] inputArray){//takes and returns int[]
        int newArrSize=0;//we need to store and calculate the size of the output array.
        for(int elem : inputArray){//for each element in inputArray.
            if(elem<5) //the element is less than five.
                newArrSize++;//add one to the size of outputArray
        }
        int[] outputArray = new int[newArrSize]; //declare output Array with the new array's size.

            int outputArrayIndex=0;//we need to add values to each element in output array.
            for(int elem : inputArray){ //we are going to repeat the same processes we did before
                                        //but now we have an array of the right size to assign values to.
                     if(elem <5 ){
                         outputArray[outputArrayIndex] = elem;
                         outputArrayIndex++;
                     }
             }


       if (outputArray.length == 0){ //if the size of the output array is 0;
           return  null; //return an null value.
       }    else
                return outputArray;//otherwise return the output array.


        }

    public static void main(String[] args) {

        int array1[] = {0, 1, 2, 3, 4, 5, 6, 7};
        int withNeg[] = {-3,-17};
        String array2[]={"foo", "bar", "baz", "qux"};

        System.out.println(secondLargestNumber(array1));

        System.out.printf(Arrays.toString(array2)+"\n");
        System.out.printf(Arrays.toString(withNeg)+"\n");

    }
}