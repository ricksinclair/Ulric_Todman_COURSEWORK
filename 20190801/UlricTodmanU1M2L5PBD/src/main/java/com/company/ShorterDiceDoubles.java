package com.company;

public class ShorterDiceDoubles {
    public static void main(String[] args) {
        int die1;
        int die2;

        System.out.println("HERE COMES THE DICE!");
        do{
            die1 = (int) Math.ceil(Math.random()*6);
            die2 = (int) Math.ceil(Math.random()*6);

            System.out.printf("Roll #1: %d\n" +
                    "Roll #2: %d\n" +
                    "The total is %d!\n\n", die1, die2, die1+die2);
        }
        while(die1!=die2);

    }
}
