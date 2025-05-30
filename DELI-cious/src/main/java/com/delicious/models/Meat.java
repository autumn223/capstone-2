package com.delicious.models;

/**
 * Represents a meat topping on a sandwich.
 * Meats are free by default, but extra meat costs $1.00.
 */
public class Meat extends Topping {
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }
}
