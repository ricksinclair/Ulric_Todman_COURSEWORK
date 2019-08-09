package com.company;

public class Warrior extends Character {



    private int shieldStrength;




    public Warrior(String name, int shieldStrength) {
        this.setShieldStrength(shieldStrength);
        this.setName(name);
        this.setStrength(75);
        this.setStamina(100);
        this.setSpeed(50);
        this.setAttackPower(10);
    }

    public static void decreaseShieldStrength(){

    }
    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

}

