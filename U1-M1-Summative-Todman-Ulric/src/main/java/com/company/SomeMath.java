package com.company;


public class SomeMath {

    public static int total5(int num1, int num2, int num3, int num4, int num5){
        return num1+num2+num3+num4+num5;
    }


    public static int average5(int num1, int num2, int num3, int num4, int num5){
        return (num1+num2+num3+num4+num5) / 5;
    }

    public static double largest5(double num1, double num2, double num3, double num4, double num5){

        double[] numbers = {num1,num2,num3,num4,num5};

        double largest = Integer.MIN_VALUE; //set abs zero just in case of negative numbers

        for(double elem : numbers){

            if(elem>largest)
                largest=elem;

        }

        return largest;

    }

    public static void main(String[] args) {

        System.out.println(total5(1,2,3,4,5));

        System.out.println(average5(1,3,5,7,9));

        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));

    }
}
