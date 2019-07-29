package com.company;

public class FortuneCookie {

    public static int lottoNumGen(){

        int lotteryNumber = (int) Math.ceil(Math.random()*54);
        return lotteryNumber;


    }

    public static void fortuneNumbers(){
        System.out.println(lottoNumGen()+" - "+lottoNumGen()+" - "+lottoNumGen()+" - "+lottoNumGen()+" - "+lottoNumGen()
                +" - "+lottoNumGen());
    }

    public static void main(String[] args) {
        int randomFortune = (int) Math.ceil(Math.random()*6);

        switch(randomFortune){

            case(1):
                System.out.println("You will be a very rich person!");
                fortuneNumbers();
                break;

            case(2):
                System.out.println("They are cheating on you be careful!");
                fortuneNumbers();
                break;
            case(3):
                System.out.println("That promotion you wanted is coming soon!");
                fortuneNumbers();
                break;
            case(4):
                System.out.println("Love is just around the corner! Don't give up!");
                fortuneNumbers();
                break;
            case(5):
                System.out.println("A storm is coming. Prepare, and prepare fast!");
                fortuneNumbers();
                break;
            case(6):
                System.out.println("Spending time with family is what you should do now.");
                fortuneNumbers();
                break;
        }

    }
}
