package com.company;

public class Dice {

    public static void main(String[] args) {
        int dice1 = (int) Math.ceil(Math.random()*6);
        int dice2 = (int) Math.ceil(Math.random()*6);
        int total = dice1+dice2;


        System.out.println("Roll#1: "+dice1);
        System.out.println("Roll#2: "+dice2);
        System.out.println("The total is "+total+"!");

    }
}
