package com.company;

public class BabyBlackjack {

    private static int random(){
        return (int) Math.ceil(Math.random()*10);
    }
    public static void main(String[] args) {
            int playerNumber1 = random(); //assign player 1st number randomly (1-10)
        int playerNumber2 = random(); //assign player 2nd number randomly (1-10)
        int playerTotal = playerNumber1 + playerNumber2;
        int cpuNumber1 = random();//assign cpu 1st number randomly (1-10)
        int cpuNumber2 = random();//assign cpu 2nd number randomly (1-10)
        int cpuTotal = cpuNumber1 + cpuNumber2;

        System.out.println("Baby Blackjack!\n");
        System.out.println("You drew "+ playerNumber1 + " and " + playerNumber2 + ".");
        System.out.println("Your total is "+(playerTotal)+".\n");
        System.out.println("The dealer has " + cpuNumber1 + " and " + cpuNumber2+".");
        System.out.println("The dealer's total is " + (cpuTotal) + ".\n");

        if(playerTotal > cpuTotal){//if the user's total is larger than the cpu's
            System.out.println("YOU WIN!");//they drink the champagne of victory
        }else{//otherwise....
            System.out.println("YOU LOSE!");//they lower their head in defeat.
        }
    }
}
