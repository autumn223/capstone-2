package com.delicious.models;

public abstract class Topping {
    protected String name;
    protected double price;
    protected boolean isExtra;

    public Topping(String name, double price, boolean isExtra) {
        this.name = name;
        this.price = price;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name + (isExtra ? " (extra)" : "");
    }

    public double getPrice() {
        return isExtra ? price * 1.5 : price;
    }

    @Override
    public String toString() {
        return getName() + " ($" + String.format("%.2f", getPrice()) + ")";
    }
}
