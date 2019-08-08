package com.company;

import java.util.ArrayList;

public class BasicArrayList1 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
while(list.size()<10){
    list.add(-113);
}
        for(int i=0; i<list.size(); i++){
            System.out.println("Slot "+i+" contains a "+list.get(i));

        }



    }
}
