package com.delicious.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(0, sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(0, drink);
    }

    public void addChips(Chips chip) {
        chips.add(0, chip);
    }

    public double getTotalCost() {
        double subtotal = 0.0;

        for (Sandwich sandwich : sandwiches) {
            subtotal += sandwich.getPrice();
        }

        for (Drink drink : drinks) {
            subtotal += drink.getPrice();
        }

        for (Chips chip : chips) {
            subtotal += chip.getPrice();
        }

        return subtotal;
    }

}

