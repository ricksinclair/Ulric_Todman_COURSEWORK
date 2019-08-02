package com.company;

public class NoticingEvenNumbers {

    public static void main(String[] args) {

        for(int i=1; i<21;i++){//Starting at 1, run the below code, then add 1 and run again over and over till 21 then STOP

            if(i%2 != 0){ // if the number divide by 2 does not have a remainder equal to zero...
                System.out.println(i);//just print the number

            }else{///otherwise
                if(i%2==0){//if the number divided by 2 DOES have a remained equal to zero
                    System.out.println(i +" <");// print the number with a less than sign next to it.
                }
            }
        }



    }

}


