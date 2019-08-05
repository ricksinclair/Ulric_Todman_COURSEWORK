package com.company.lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class CollectionsExamples {

    public static void main(String[] args) {
        List<Integer> numbers;
        numbers = new ArrayList<>();

        numbers.add(75);
        numbers.add(42);
        numbers.add(50);

        Iterator<Integer> iteratorNumbers = numbers.iterator();
        while (iteratorNumbers.hasNext()) {
            System.out.println(iteratorNumbers.next());


            Integer number = 5;
            int myPrimative = number;//unboxing

            Integer num = new Integer(50);

            num = myPrimative;//autoboxing

        }

    }
}