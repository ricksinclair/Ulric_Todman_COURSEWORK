package com.company;


public class Business {

    private String name;
    private Product[] productsSold;
    private double money;

    public Business(){

    }
    public Business(String name, Product[] productsSold, double money) {
        this.name = name;
        this.productsSold = productsSold;
        this.money = money;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product[] getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Product[] productsSold) {
        this.productsSold = productsSold;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public static void main(String[] args) {
        Product storesChips = new Product("Lays", "BBQ Chips", 25, .99);
        Product storesSodaPop = new Product("Coca Cola", "soda pop",30, 2.00);
        Product storesChocolate = new Product ("Hershey", "Chocolate", 12, 1.25);

        Product vendingChips = new Product("Lays", "BBQ Chips", 25, 99);
        Product vendingSodaPop = new Product("Coca Cola", "soda pop",30, 2.00);
        Product vendingChocolate = new Product ("Hershey", "Chocolate", 12 ,1.00);
        Product vendingMints = new Product ("Mentos", "The fresh maker", 20, 1.00);
        Product vendingGum = new Product ("Bazooka", "Original Classic", 10, .25);
        Product vendingPopcorn = new  Product ("wise", "white cheddar", 20, 1.00);

        Product restaurantSoda = new Product ("Coca Cola", "Cherry Coke", 20, 4.00);
        Product restaurantSoda1 = new Product ("Coca Cola", "Classic", 20, 4.00);
        Product restaurantSoda2 = new Product ("Coca Cola", "Diet Coke", 20, 4.00);

        Product[] storeProducts = {storesChips, storesChips, storesChocolate};
        Product[] vendingProducts = {vendingChips, vendingSodaPop, vendingChocolate, vendingMints,
                                    vendingGum, vendingPopcorn};

        Product[] restaurantProducts = {restaurantSoda, restaurantSoda1, restaurantSoda2};


        Business vendingMachine = new Business("Vending Machine", vendingProducts, 2000);
        Business store = new Business("Store", storeProducts, 10000);
        Restaurant restaurant = new Restaurant("Restaurant", restaurantProducts, 200000);
    }
}
