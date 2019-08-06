package com.company;

 import java.util.HashSet;
 import java.util.Iterator;


public class SetIterator {

    public void printSet(int a, int b, int c, int d, int e){

      HashSet<Integer> hashset = new HashSet<Integer>();

        hashset.add(a);
        hashset.add(b);
        hashset.add(c);
        hashset.add(d);
        hashset.add(e);
        Iterator<Integer> iterator = hashset.iterator();

        while(iterator.hasNext()){

            System.out.println(iterator.next());
        }

    }
}
