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

    public void addSandwich(Sandwich s) {
        sandwiches.add(0, s);
    }

    public void addDrink(Drink d) {
        drinks.add(0, d);
    }

    public void addChips(Chips c) {
        chips.add(0, c);
    }

    public double getTotalPrice() {
        double totalSandwich = sandwiches.stream().mapToDouble(Sandwich::getPrice).sum();
        double totalDrink = drinks.stream().mapToDouble(Drink::getPrice).sum();
        double totalChips = chips.stream().mapToDouble(Chips::getPrice).sum();
        return totalSandwich + totalDrink + totalChips;
    }

    public String getOrderDetails() {
        StringBuilder sb = new StringBuilder("Order Details:\n\nSandwiches:\n");
        for (Sandwich s : sandwiches) {
            sb.append(s.getDescription()).append("\n\n");
        }
        sb.append("Drinks:\n");
        for (Drink d : drinks) {
            sb.append(" - ").append(d.getDescription()).append("\n");
        }
        sb.append("Chips:\n");
        for (Chips c : chips) {
            sb.append(" - ").append(c.getDescription()).append("\n");
        }
        sb.append(String.format("\nTotal Price: $%.2f", getTotalPrice()));
        return sb.toString();
    }
}

