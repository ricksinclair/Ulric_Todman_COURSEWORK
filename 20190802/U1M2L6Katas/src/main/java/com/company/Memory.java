package com.company;

public class Memory {

    private String type;
    private int sizeInGB;
    private int numModules;

    public Memory(){

    }

    public Memory(String type, int sizeInGB, int numModules) {
        this.type = type;
        this.sizeInGB = sizeInGB;
        this.numModules = numModules;
    }

    public void allocate(){
        //allocate some memory
        //t
    }

    public void deallocate(){
        //deallocate some memory
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSizeInGB() {
        return sizeInGB;
    }

    public void setSizeInGB(int sizeInGB) {
        this.sizeInGB = sizeInGB;
    }

    public int getNumModules() {
        return numModules;
    }

    public void setNumModules(int numModules) {
        this.numModules = numModules;
    }
}
