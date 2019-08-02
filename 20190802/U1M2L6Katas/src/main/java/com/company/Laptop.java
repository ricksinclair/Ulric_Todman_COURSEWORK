package com.company;
public class Laptop {
    private String make;
    private String model;
    private Processor processor;
    private Disk storage;
    private Memory[] memory;
    private int screenSize;
    private boolean isPowered;

    public Laptop(){

    }
    public Laptop(String make, String model, Processor processor,
                  Disk storage, Memory[] memory, int screenSize, boolean isPowered) {
        setMake(make);
       setModel(model);
       setProcessor(processor);
      setStorage(storage);
        setMemory(memory);
      setScreenSize(screenSize);
      setPowered(isPowered);
    }



    private void powerOn(){
        setPowered(true);
    }

    private void powerOff(){

        setPowered(false);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Disk getStorage() {
        return storage;
    }

    public void setStorage(Disk storage) {
        this.storage = storage;
    }

    public Memory[] getMemory() {
        return memory;
    }

    public void setMemory(Memory[] memory) {
        this.memory = memory;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isPowered() {
        return isPowered;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }


}

