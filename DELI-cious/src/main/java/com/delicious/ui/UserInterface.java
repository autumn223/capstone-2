package com.delicious.ui;

import com.delicious.models.*;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public Order takeOrder() {
        Order order = new Order();
        System.out.println("Welcome to DELI-cious!");

        boolean ordering = true;
        while (ordering) {
            System.out.println("\nChoose an item to add:");
            System.out.println("1) Sandwich\n2) Drink\n3) Chips\n4) Finish Order");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    order.addSandwich(buildSandwich());
                    break;
                case "2":
                    order.addDrink(buildDrink());
                    break;
                case "3":
                    order.addChips(buildChips());
                    break;
                case "4":
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        return order;
    }

    private Sandwich buildSandwich() {
        System.out.println("Choose a size (4, 8, 12):");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.println("Choose bread type:");
        String bread = scanner.nextLine();

        System.out.println("Toasted? (yes/no):");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // Add meats
        System.out.println("Add meats (type 'done' to finish):");
        while (true) {
            System.out.print("Meat: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            System.out.print("Extra? (yes/no): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("yes");
            sandwich.addMeat(new Meat(input, extra));
        }

        // Add cheeses
        System.out.println("Add cheeses (type 'done' to finish):");
        while (true) {
            System.out.print("Cheese: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            System.out.print("Extra? (yes/no): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("yes");
            sandwich.addCheese(new Cheese(input, extra));
        }

        // Add regular toppings
        System.out.println("Add regular toppings (type 'done' to finish):");
        while (true) {
            System.out.print("Topping: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            sandwich.addRegularTopping(new Regular(input, false));
        }

        // Add sauces
        System.out.println("Add sauces (type 'done' to finish):");
        while (true) {
            System.out.print("Sauce: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            sandwich.addSauce(input);
        }

        return sandwich;
    }

    private Drink buildDrink() {
        System.out.println("Choose drink size (small, medium, large):");
        String size = scanner.nextLine();

        System.out.println("Enter drink flavor:");
        String flavor = scanner.nextLine();

        return new Drink(size, flavor);
    }

    private Chips buildChips() {
        System.out.println("Enter chip type:");
        String type = scanner.nextLine();

        return new Chips(type);
    }

    public void displayOrder(Order order) {
        System.out.println("\nOrder Summary:");
        for (Sandwich s : order.getSandwiches()) {
            System.out.println("\n" + s.getDescription());
        }
        System.out.printf("\nTotal: $%.2f\n", order.getTotalCost());
    }
}

