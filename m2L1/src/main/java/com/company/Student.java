package com.company;

public class Student {
    String name;
    double gpa;


    public void setName(String name){
        this.name = name;

    }

    public void setGpa(double gpa){
        this.gpa= gpa;
    }

    public void greet(){
        System.out.println("Hello, I am "+this.name+" and I have a GPA of "+this.gpa+".");
    }

}
