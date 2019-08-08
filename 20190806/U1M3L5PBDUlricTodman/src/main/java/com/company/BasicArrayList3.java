package com.company;

import java.util.ArrayList;

public class BasicArrayList3 {

    public static int genRandom(){
        int max = 99;
        int min = 10;
        int range = max - min + 1;
        return (int)(Math.random() * range) + min;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(1000);

        while(list.size()<1000){
            list.add(genRandom());
        }

        System.out.println("ArrayList: " + list);

    }
}
