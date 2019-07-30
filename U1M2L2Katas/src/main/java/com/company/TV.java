package com.company;

public class TV {

    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
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
