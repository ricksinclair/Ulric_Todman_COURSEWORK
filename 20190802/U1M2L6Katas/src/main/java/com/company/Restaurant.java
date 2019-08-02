package com.company;

public class Restaurant extends Business {

    public Restaurant(){

    }
    public Restaurant(String name, Product[] productsSold, double money) {
        super(name, productsSold, money);
    }

    public void takeReservation(String time){
        //take reservation
    }
}
