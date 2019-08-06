package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static int total (ArrayList<Integer> numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (ArrayList<Integer> numbers) {

        int sum = 0;
        for(int i =0; i<numbers.size(); i++) {
            if(i%2 == 0)
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(ArrayList<String> strings) {

        String temp = strings.get(0);
        strings.set(0, strings.get( strings.size() - 1 ));
        strings.set( strings.size() - 1, temp);

        return strings;
    }

    public static List<Integer> reverse(ArrayList<Integer> numbers) {

        List<Integer> reversed = new ArrayList<Integer>(numbers.size());
        int count = numbers.size()-1;
        for(int i = count; i>=0; i--){
            reversed.add(numbers.get(i));
        }
        return reversed;
    }

    public static List<Integer> lessThanFive(ArrayList<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

        List<Integer> lessThan = new ArrayList<>(numLessThanFive);

        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
                lessThan.add(num);

            }
        }

        return  lessThan;
    }

    //challenge
    public static int[][] splitAtFive(int[] numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

        int[] lessThan = new int[numLessThanFive];
        int[] moreThan = new int[numMoreThanFive];


        for(int num : numbers) {

            // subtracting numLessThanFive from length then decrementing numLessThanFive
            // allows us to go from 0 to length - 1 in order without additional variables
            // same with numMoreThanFive
            if ( num < 5 ) {
                lessThan[lessThan.length - numLessThanFive] = num;
                numLessThanFive--;
            } else {
                moreThan[moreThan.length - numMoreThanFive] = num;
                numMoreThanFive--;
            }
        }

        return new int[][] { lessThan, moreThan };
    }

    // Challenge
    public static String[][] evensAndOdds(String[] strings) {

        //leveraging integer division
        String[] odds = new String[ strings.length/2 ];

        // Set evens to null for reassignment below
        String[] evens = null;

        // again leveraging integer division
        // if it's already of even length, we're good
        // but if it's of odd length, there's one more even index than odd
        if (strings.length % 2 == 0) {
            evens = new String[ strings.length/2];
        } else {
            evens = new String[ strings.length/2 + 1];
        }

        for(int i = 0; i < strings.length; i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens[currIndex] = strings[i];
            } else {
                odds[currIndex] = strings[i];
            }
        }

        return new String[][] { evens, odds };
    }
}
