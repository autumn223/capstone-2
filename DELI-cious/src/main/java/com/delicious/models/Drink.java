package com.delicious.models;

public class Drink extends Product {

    private String size; // Small, Medium, Large
    private String flavor;

    public Drink(String name, double price, String size, String flavor) {
        super(name, price);
        this.size = size;
        this.flavor = flavor;
    }

    private static double getPriceBySize(String size) {
        switch (size.toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0;
        }
    }
}