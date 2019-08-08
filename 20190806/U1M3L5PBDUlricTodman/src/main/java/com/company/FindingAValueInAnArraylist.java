package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FindingAValueInAnArraylist {

    public static int genRandom(){
        return (int) Math.ceil(Math.random()*50);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);
        while(list.size()<10){
            list.add(genRandom());

        }

        System.out.println("ArrayList: "+list);
        System.out.print("Value to find:");
        int userAnswer = Integer.parseInt(scanner.nextLine());

        list.stream().filter(item-> item==userAnswer).forEach(item->{
            System.out.println(userAnswer + " is in the ArrayList.");
        });




        System.out.println("");
    }
}
