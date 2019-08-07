package com.company;

public class Calculator {
    //could have method overloaded but spec asked for separate methods.
    public int addInt(int a, int b) {
        return a + b;
    }

    public double addDouble(double a, double b) {
        return a + b;
    }

    public int subtractInt(int a, int b) {
        return a - b;
    }

    public double subtractDouble(double a, double b) {
        return a - b;
    }

    public int multiplyInt(int a, int b) {
        return a * b;
    }

    public double multiplyDouble(double a, double b) {
        return a * b;
    }

    public int divideInt(int a, int b) {
        return a / b;
    }

    public double divideDouble(double a, double b) {
        return a / b;
    }


}
