package com.delicious.ui;

import com.delicious.models.*;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean run = true;

        while (run) {
            System.out.println("\nWelcome to DELI-cious!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Order order = takeOrder();
                    displayOrder(order);
                    ReceiptFileManager.writeReceipt(order);
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public Order takeOrder() {
        Order order = new Order();
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
                    ReceiptFileManager.writeReceipt(order);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        return order;
    }

    private Sandwich buildSandwich() {
        System.out.println("Pricing Per Size:");
        System.out.println("4-inch ----------------- $5.50");
        System.out.println("8-inch ----------------- $7.00");
        System.out.println("12-inch ---------------- $8.50");
        System.out.println("Choose a size:\n1) 4-inch\n2) 8-inch\n3) 12-inch");
        int sizeChoice = Integer.parseInt(scanner.nextLine());
        int size = 0;
        switch (sizeChoice) {
            case 1: size = 4; break;
            case 2: size = 8; break;
            case 3: size = 12; break;
            default:
                System.out.println("Invalid choice, defaulting to 4-inch.");
                size = 4;
        }

        System.out.println("\nChoose bread type:");
        System.out.println("1) White\n2) Wheat\n3) Rye\n4) Sourdough\n5) Wrap");
        System.out.print("Choice: ");
        String bread = "";
        switch (scanner.nextLine()) {
            case "1": bread = "White"; break;
            case "2": bread = "Wheat"; break;
            case "3": bread = "Rye"; break;
            case "4": bread = "Sourdough"; break;
            case "5": bread = "Wrap"; break;
            default:
                System.out.println("Invalid choice, defaulting to White.");
                bread = "White";
        }

        System.out.println("Toasted? (yes/no):");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // Meats
        System.out.println("Add meats (type 'done' to finish):");
        while (true) {
            System.out.println("1) Steak\n2) Ham\n3) Salami\n4) Roast Beef\n5) Chicken\n6) Bacon");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;

            String meat = null;
            switch (input) {
                case "1": meat = "Steak"; break;
                case "2": meat = "Ham"; break;
                case "3": meat = "Salami"; break;
                case "4": meat = "Roast Beef"; break;
                case "5": meat = "Chicken"; break;
                case "6": meat = "Bacon"; break;
                default: System.out.println("Invalid meat choice."); continue;
            }

            System.out.print("Extra? (yes/no): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("yes");
            sandwich.addMeat(new Meat(meat, extra));
        }

        // Cheeses
        System.out.println("Add cheeses (type 'done' to finish):");
        while (true) {
            System.out.println("1) American\n2) Provolone\n3) Cheddar\n4) Swiss");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;

            String cheese = null;
            switch (input) {
                case "1": cheese = "American"; break;
                case "2": cheese = "Provolone"; break;
                case "3": cheese = "Cheddar"; break;
                case "4": cheese = "Swiss"; break;
                default: System.out.println("Invalid cheese choice."); continue;
            }

            System.out.print("Extra? (yes/no): ");
            boolean extra = scanner.nextLine().equalsIgnoreCase("yes");
            sandwich.addCheese(new Cheese(cheese, extra));
        }

        // Regular Toppings
        System.out.println("Add regular toppings (type 'done' to finish):");
        while (true) {
            System.out.println("1) Lettuce\n2) Tomato\n3) Pickles\n4) Onions\n5) Peppers\n6) Jalapeños\n7) Cucumbers\n8) Guacamole\n9) Mushrooms");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;

            String topping = null;
            switch (input) {
                case "1": topping = "Lettuce"; break;
                case "2": topping = "Tomato"; break;
                case "3": topping = "Pickles"; break;
                case "4": topping = "Onions"; break;
                case "5": topping = "Peppers"; break;
                case "6": topping = "Jalapeños"; break;
                case "7": topping = "Cucumbers"; break;
                case "8": topping = "Guacamole"; break;
                case "9": topping = "Mushrooms"; break;
                default: System.out.println("Invalid topping."); continue;
            }

            sandwich.addRegularTopping(new RegularTopping(topping, false));
        }

        // Sauces
        System.out.println("Add sauces (type 'done' to finish):");
        while (true) {
            System.out.println("1) Mayo\n2) Mustard\n3) Ketchup\n4) Ranch\n5) Thousand Islands\n6) Vinaigrette");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;

            String sauce = null;
            switch (input) {
                case "1": sauce = "Mayo"; break;
                case "2": sauce = "Mustard"; break;
                case "3": sauce = "Ketchup"; break;
                case "4": sauce = "Ranch"; break;
                case "5": sauce = "Thousand Islands"; break;
                case "6": sauce = "Vinaigrette"; break;
                default: System.out.println("Invalid sauce."); continue;
            }

            sandwich.addSauce(sauce);
        }

        return sandwich;
    }

    private Drink buildDrink() {
        System.out.println("\nChoose drink size:\n1) Small\n2) Medium\n3) Large");
        String size = "";
        switch (scanner.nextLine()) {
            case "1": size = "Small"; break;
            case "2": size = "Medium"; break;
            case "3": size = "Large"; break;
            default:
                System.out.println("Invalid choice. Defaulting to Small.");
                size = "Small";
        }

        System.out.println("Choose drink flavor:\n1) Cola\n2) Lemonade\n3) Orange\n4) Water");
        String flavor = "";
        switch (scanner.nextLine()) {
            case "1": flavor = "Cola"; break;
            case "2": flavor = "Lemonade"; break;
            case "3": flavor = "Orange"; break;
            case "4": flavor = "Water"; break;
            default:
                System.out.println("Invalid choice. Defaulting to Cola.");
                flavor = "Cola";
        }

        return new Drink(size, flavor);
    }

    private Chips buildChips() {
        while (true) {
            System.out.println("\nChoose chip type:");
            System.out.println("1) Classic\n2) BBQ\n3) Sour Cream & Onion\n4) Salt & Vinegar");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": return new Chips("Classic");
                case "2": return new Chips("BBQ");
                case "3": return new Chips("Sour Cream & Onion");
                case "4": return new Chips("Salt & Vinegar");
                default:
                    System.out.println("Invalid chip choice. Try again.");
            }
        }
    }

    public void displayOrder(Order order) {
        System.out.println("\n===== DELI-cious Order Summary =====");

        for (Sandwich s : order.getSandwiches()) {
            System.out.println("\nSandwich:");
            System.out.println(s.getDescription());

            double meatCost = 0.0;
            for (Topping meat : s.getMeats()) meatCost += meat.getPrice();
            System.out.printf("  Meat cost: $%.2f\n", meatCost);

            double cheeseCost = 0.0;
            for (Topping cheese : s.getCheeses()) cheeseCost += cheese.getPrice();
            System.out.printf("  Cheese cost: $%.2f\n", cheeseCost);

            System.out.printf("  Total sandwich cost: $%.2f\n", s.getPrice());
        }

        for (Drink d : order.getDrinks()) {
            System.out.println("\nDrink: " + d.getSize() + " " + d.getFlavor());
            System.out.printf("  Drink cost: $%.2f\n", d.getPrice());
        }

        for (Chips c : order.getChips()) {
            System.out.println("\nChips: " + c.getType());
            System.out.printf("  Chips cost: $%.2f\n", c.getPrice());
        }

        System.out.printf("\nTotal Order Cost: $%.2f\n", order.getTotalCost());
    }
}
