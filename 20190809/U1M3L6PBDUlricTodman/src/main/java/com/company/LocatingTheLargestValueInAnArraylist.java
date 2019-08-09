package com.company;

import java.util.ArrayList;

public class LocatingTheLargestValueInAnArraylist {
    private static int largest = Integer.MIN_VALUE;


    public static int genRandom(){
        return (int) Math.ceil(Math.random()*100);

    }


    public static void main(String[] args) {

        ArrayList<Integer> randomList = new ArrayList<Integer>();

        while(randomList.size()<10){
            randomList.add(genRandom());
        }

        System.out.println(randomList);

        randomList.stream().forEach(num->{
            if(num>largest){
                largest=num;
            }
        });

        System.out.println("The largest value is: "+largest+" , which is in slot: "+randomList.indexOf(largest));
    }
}
