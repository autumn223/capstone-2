package com.delicious.models;

public class Chips {

    private String type;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getPrice(){
       return 1.50;
   }
}
