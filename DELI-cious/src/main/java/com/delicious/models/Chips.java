package com.delicious.models;

public class Chips extends Product{

    private String type;

    public Chips(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }
}
