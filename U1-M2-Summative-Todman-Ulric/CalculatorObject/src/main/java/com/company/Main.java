package com.company;


public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("1 + 1 = " + calc.addInt(1, 1));
        System.out.println("23 - 52 = " + calc.subtractInt(23, 52));
        System.out.println("34 * 2 = " + calc.multiplyInt(34, 2));
        System.out.println("12 / 3 = " + calc.divideInt(12, 3));
        System.out.println("12 / 7 = " + calc.divideInt(12, 7));
        System.out.println("3.4 + 2.3 = " + calc.addDouble(3.4, 2.3));
        System.out.println("6.7 * 4.4 = " + calc.multiplyDouble(6.7, 4.4));
        System.out.println("5.5 - 0.5 = " + calc.subtractDouble(5.5, 0.5));
        System.out.println("10.8 / 2.2 = " + calc.divideDouble(10.8, 2.2));
    }
}
