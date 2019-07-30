package com.company;

public class Person {
    private String name;

    public  Person(String name){
        this.name = name;
    }

    public void setName(String newName){
        this.name = newName;
    }


    public String getName(){
       return this.name;
    }


    public void sayHello(){
        System.out.println("Hello, I am "+ this.name);
    }
}
