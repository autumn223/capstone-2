package com.delicious.models;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReceiptFileManager {

    public static void writeReceipt(Order order) {
        // Get current timestamp to create a unique filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "receipt_" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("===== DELI-cious Receipt =====\n");
            writer.write("Date & Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()) + "\n\n");

            // Write sandwich details
            List<Sandwich> sandwiches = order.getSandwiches();
            for (Sandwich s : sandwiches) {
                writer.write("Sandwich:\n");
                writer.write(s.getDescription() + "\n");

                // Calculate meat cost using a loop
                double meatCost = 0.0;
                List<Topping> meats = s.getMeats();
                for (Topping meat : meats) {
                    meatCost += meat.getPrice();
                }

                // Calculate cheese cost using a loop
                double cheeseCost = 0.0;
                List<Topping> cheeses = s.getCheeses();
                for (Topping cheese : cheeses) {
                    cheeseCost += cheese.getPrice();
                }

                writer.write(String.format("  Meat cost: $%.2f\n", meatCost));
                writer.write(String.format("  Cheese cost: $%.2f\n", cheeseCost));
                writer.write(String.format("  Total sandwich cost: $%.2f\n\n", s.getPrice()));
            }

            // Write drink details
            List<Drink> drinks = order.getDrinks();
            for (Drink d : drinks) {
                writer.write(String.format("Drink (%s %s): $%.2f\n", d.getSize(), d.getFlavor(), d.getPrice()));
            }

            // Write chips details
            List<Chips> chips = order.getChips();
            for (Chips c : chips) {
                writer.write(String.format("Chips (%s): $%.2f\n", c.getType(), c.getPrice()));
            }

            // Write total
            writer.write(String.format("\nTOTAL: $%.2f\n", order.getTotalCost()));
            writer.write("===============================\n");

            System.out.println("Receipt saved to file: " + filename);

        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
