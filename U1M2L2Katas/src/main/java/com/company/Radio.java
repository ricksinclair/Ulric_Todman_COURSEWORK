package com.company;

public class Radio {

    private String manufacturer;
    private String model;
    private int numSpeaker;
    private String station;
    private int volume;
    private boolean powered;


    public void togglePower(){
        if(this.powered==false){
            powered=true;
        }else{
            powered=false;
        }
    }
}
