package com.delicious.models;

/**
 * Represents a meat topping on a sandwich.
 * Meats are free by default, but extra meat costs $1.00.
 */
public class Meat extends Topping {

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice() {
        return isExtra ? 1.00 : 0.00;
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (Extra)" : "");
    }
}
