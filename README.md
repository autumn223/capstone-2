DELI-cious Point-of-Sale Application


Overview

DELI-cious is a simple Java console-based point-of-sale (POS) system for a sandwich deli. It allows users to create custom sandwich orders, add drinks and chips, view order summaries, and save detailed receipts as text files.

Features

Custom Sandwich Builder
Choose sandwich size, bread type, meats, cheeses, regular toppings, and sauces. Option to add extra portions for meats and cheeses at an additional cost.

Drinks and Chips Selection

Add drinks of various sizes and flavors, and choose from multiple chip types.

Order Summary

Displays a detailed order summary with individual item costs and total order price.

Receipt Generation

Automatically generates a timestamped receipt file containing all order details and costs.



MenuItem (Interface)

getName(): String

getPrice(): double

Topping (Abstract Class)

name: String

isExtra: boolean

getName(): String

isExtra(): boolean

getPrice(): double (abstract or implemented based on isExtra)

Meat (Class)

Extends Topping

Meat(name: String, isExtra: boolean)

Cheese (Class)

Extends Topping

Cheese(name: String, isExtra: boolean)

Chips (Class)

type: String

getType(): String

getPrice(): double

Sandwich (Class)

size: int

bread: String

toasted: boolean

meats: List<Meat>

cheeses: List<Cheese>

toppings: List<Topping>

addMeat(meat: Meat)

addCheese(cheese: Cheese)

addTopping(topping: Topping)

getPrice(): double

getName(): String

UserInterface (Class)

scanner: Scanner

start(): void

buildSandwich(): Sandwich

(other UI-related methods)

Program (Class)

main(String[] args): void

