package com.delicious.models;

import com.delicious.interfaces.MenuItem;

public abstract class Product implements MenuItem {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return name + " ($" + String.format("%.2f", getPrice()) + ")";
    }
}
