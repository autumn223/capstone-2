package com.delicious.models;

public abstract class Topping {
    protected String name;
    protected boolean isExtra;

    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public double getPrice() {
        // Base price is $1.00, extra adds $0.50
        return isExtra ? 1.50 : 1.00;
    }

    public String toString() {
        return name + (isExtra ? " (Extra)" : "");
    }
}
