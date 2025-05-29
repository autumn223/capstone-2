package com.delicious.models;

/**
 * Represents a cheese topping on a sandwich.
 * Cheeses are free by default, but extra cheese costs $0.75.
 */
public class Cheese extends Topping {

    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice() {
        return isExtra ? 0.75 : 0.00;
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (Extra)" : "");
    }
}
