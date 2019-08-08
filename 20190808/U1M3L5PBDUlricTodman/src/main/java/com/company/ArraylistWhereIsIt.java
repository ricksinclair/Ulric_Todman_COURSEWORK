package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.FindingAValueInAnArraylist.genRandom;

public class ArraylistWhereIsIt {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);

        while (list.size() < 10) {
            list.add(genRandom());

        }

        System.out.println("ArrayList: " + list);
        System.out.printf("Value to find: ");

        int userAnswer = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == userAnswer) {
                System.out.println(userAnswer + " is in slot " + i);
            }
        }
        if (list.indexOf(userAnswer) == -1) {
            System.out.println(userAnswer + " is not in the ArrayList.");
        }
    }
}
