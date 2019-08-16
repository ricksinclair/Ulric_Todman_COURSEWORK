package com.example.cupcakeservice.model;

public class Cupcake {

    private int id;
    private String flavor;
    private String frostingType;

    public String toString(){
        return "CUPCAKE\n===============\nid: "+this.getId()+"\nflavor: "+this.getFlavor()+"\nfrosting type: "+this.getFrostingType();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getFrostingType() {
        return frostingType;
    }

    public void setFrostingType(String frostingType) {
        this.frostingType = frostingType;
    }
}
