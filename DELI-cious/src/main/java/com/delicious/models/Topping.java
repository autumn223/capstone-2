package com.delicious.models;

public abstract class Topping {
    protected String name;
    protected boolean isExtra;

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public double getPrice() {
        return 0;
    }

}
