package com.delicious.models;

public class IncludedTopping extends Topping {
    public IncludedTopping(String name, double price, boolean isExtra) {
        super(name, 0, false);
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
