package com.company;


import java.util.ArrayList;

public class BasicArrayLists2 {

    public static int genRandom(){
        return (int) Math.ceil(Math.random()*100);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        while(list.size()<10){
            list.add(genRandom());
        }

        System.out.println("ArrayList: "+list);
    }
}
