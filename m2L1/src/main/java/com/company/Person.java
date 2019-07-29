package com.company;

public class Person {
    String name;

    Person(String name){
        this.name = name;
    }

    public void setName(String newName){
        this.name = newName;
    }



    public void sayHello(){
        System.out.println("Hello, I am "+ this.name);
    }
}
