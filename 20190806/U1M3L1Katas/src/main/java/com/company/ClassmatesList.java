package com.company;

import java.util.List;
import java.util.LinkedList;

public class ClassmatesList {

    List list = new LinkedList();


    public void add(Classmate classmate) {
      this.list.add(classmate);
    }


    public Classmate get(int index) {
        return (Classmate) this.list.get(index);
    }



    public void add(int index, Classmate classmate) {


        this.list.add(index, classmate);
    }

    public List getAll(){
        return list;
    }
}
