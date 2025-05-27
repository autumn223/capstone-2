package com.delicious.models;

import com.delicious.interfaces.Customizable;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product implements Customizable {
    private int sizeInches;
    private String breadType;
    private boolean toasted;
    private List<Topping> toppings;

    public static final int SIZE_4 = 4;
    public static final int SIZE_8 = 8;
    public static final int SIZE_12 = 12;

    public Sandwich(String name, double price, int sizeInches, String breadType, boolean toasted, List<Topping> toppings) {
        super(name, price);
        this.sizeInches = sizeInches;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<Topping>(toppings);
    }

    public static double getBasePriceBySize(int size) {
        switch (size) {
            case SIZE_4: return 5.50;
            case SIZE_8: return 7.00;
            case SIZE_12: return 8.50;
            default: return 0.0;
        }
    }

    @Override
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public double getPrice() {
        double basePrice = 0;
        double totalToppings = 0;
        for (Topping t : toppings) {
            totalToppings += t.getPrice();
        }
        return basePrice + totalToppings;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(sizeInches).append("\" ").append(breadType);
        sb.append(toasted ? " (Toasted)\n" : " (Not toasted)\n");
        sb.append("Toppings:\n");
        for (Topping t : toppings) {
            sb.append(" - ").append(t.toString()).append("\n");
        }
        sb.append(String.format("Price: $%.2f", getPrice()));
        return sb.toString();
    }
}


