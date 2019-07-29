package com.company;

import com.sun.corba.se.impl.javax.rmi.CORBA.StubDelegateImpl;

public class Main {


    public static void main(String[] args) {
        Student testPupil = new Student();
        testPupil.setName("Steve");
        testPupil.setGpa(3.8);
        testPupil.greet();
        Student testPupil2 = new Student();
        testPupil2.setName("Bob");
        testPupil2.setGpa(2.3);
        testPupil2.greet();
    }
}

