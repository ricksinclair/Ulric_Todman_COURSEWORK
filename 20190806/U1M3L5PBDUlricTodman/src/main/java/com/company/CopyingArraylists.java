package com.company;

import java.util.ArrayList;

public class CopyingArraylists {

    public static int genRandom(){
        return (int) Math.ceil(Math.random()*100);
    }

    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>(10);
        while(list.size()<10){
            list.add(genRandom());
        }

        ArrayList<Integer> secondList = new ArrayList<>(list.size());

        secondList.addAll(list);
        list.set(list.size()-1, -7);

        System.out.println("ArrayList1: "+list);
        System.out.println("ArrayList2:" + secondList );


    }
}
