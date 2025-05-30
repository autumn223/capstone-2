package com.delicious.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    public static final int SIZE_4 = 4;
    public static final int SIZE_8 = 8;
    public static final int SIZE_12 = 12;

    private int sizeInches;
    private String breadType;
    private boolean toasted;

    private List<Topping> meats = new ArrayList<>();
    private List<Topping> cheeses = new ArrayList<>();
    private List<Topping> regulars = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    public Sandwich(int sizeInches, String breadType, boolean toasted) {
        this.sizeInches = sizeInches;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    public List<Topping> getMeats() {
        return meats;
    }

    public List<Topping> getCheeses() {
        return cheeses;
    }

    public List<Topping> getRegulars() {
        return regulars;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public static double getBasePriceBySize(int size) {
        switch (size) {
            case SIZE_4:
                return 5.50;
            case SIZE_8:
                return 7.00;
            case SIZE_12:
                return 8.50;
            default:
                return 0.00;
        }
    }

    public void addMeat(Topping meat) {
        meats.add(meat);
    }

    public void addCheese(Topping cheese) {
        cheeses.add(cheese);
    }

    public void addRegularTopping(Topping regular) {
        regulars.add(regular);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public double getPrice() {
        double basePrice = getBasePriceBySize(sizeInches);
        double totalToppings = 0.0;

        for (Topping meat : meats) {
            totalToppings += meat.getPrice();
        }
        for (Topping cheese : cheeses) {
            totalToppings += cheese.getPrice();
        }

        return basePrice + totalToppings;
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(sizeInches).append("\" ").append(breadType);
        sb.append(toasted ? " (Toasted)\n" : " (Not Toasted)\n");

        sb.append("Meats:\n");
        for (Topping t : meats) sb.append(" - ").append(t.toString()).append("\n");

        sb.append("Cheeses:\n");
        for (Topping t : cheeses) sb.append(" - ").append(t.toString()).append("\n");

        sb.append("Toppings:\n");
        for (Topping t : regulars) sb.append(" - ").append(t.toString()).append("\n");

        sb.append("Sauces:\n");
        for (String sauce : sauces) sb.append(" - ").append(sauce).append("\n");

        sb.append(String.format("Total Price: $%.2f", getPrice()));
        return sb.toString();
    }
}
