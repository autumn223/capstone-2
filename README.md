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


![DA1](https://github.com/user-attachments/assets/a71c194d-80ff-4fef-bfb5-fb94382ac86d)
![DA2](https://github.com/user-attachments/assets/d4582ba2-d3c4-4581-a1c2-c00063586685)
![DA3](https://github.com/user-attachments/assets/2e3c56c1-3db6-4f52-a226-6ffe0903ca44)
![DA4](https://github.com/user-attachments/assets/a06e2dfa-37a5-48e4-aeb7-41a8b0121711)
![DA5](https://github.com/user-attachments/assets/64271b95-40be-4bf3-9b80-b5b2ca2e93a5)
![DA6](https://github.com/user-attachments/assets/6f2b94f0-47a1-4f54-a174-f1d87ddc7720)
![DA7](https://github.com/user-attachments/assets/44c3c32f-1836-49f6-a4eb-1b202e5d7eeb)
![DA8](https://github.com/user-attachments/assets/33941315-72b1-4da4-92eb-6c36ecd2012d)
![DA9](https://github.com/user-attachments/assets/0bae4079-a767-415a-9e62-d3a8325287b1)
![DA10](https://github.com/user-attachments/assets/5edc9510-0753-4750-a5ff-5330a5413bfe)
![DA11](https://github.com/user-attachments/assets/02ea8ae7-00a7-4ba0-9b12-d189e3f2c576)
![DA12](https://github.com/user-attachments/assets/453b8fd6-a94d-4081-8493-8dbe525059f9)
![DA13](https://github.com/user-attachments/assets/2c1be069-ab95-4e20-8a96-2c5625c60a89)
![DA14](https://github.com/user-attachments/assets/571e3075-ab6a-44a5-a09c-7c1e84c016a0)
![DA15](https://github.com/user-attachments/assets/075127fa-fb2b-4e58-af79-b62a57f434a0)
![DA16](https://github.com/user-attachments/assets/af21ff74-4385-4901-bd5c-c4f03e2abbc2)
![DA17](https://github.com/user-attachments/assets/4c478996-6cef-4c44-8ade-b395ab80a9b1)
![DA18](https://github.com/user-attachments/assets/1e0f59b6-26a2-4d2c-a8ed-6b105ca9858d)
![DA19](https://github.com/user-attachments/assets/73a17a93-2094-456c-bc17-3378909c0dd2)
![DA20](https://github.com/user-attachments/assets/ac9480e1-7a26-4dc9-9df5-b4d5c09ce8af)
![DA21](https://github.com/user-attachments/assets/820a3e17-d184-454e-972a-cd0dcfbcf9a8)
![DA22](https://github.com/user-attachments/assets/c4082ccd-94b5-4b36-b5b0-bedb6dd7a723)
![DA23](https://github.com/user-attachments/assets/e46818f8-3af2-49fa-ba3b-c0d83bd4a49f)
![DA24](https://github.com/user-attachments/assets/07154dda-0a4a-4b72-9a31-444eed938c63)
![DA25](https://github.com/user-attachments/assets/9f681bd0-7846-42f5-9e3d-4c2d7ec8ec92)
![DA26](https://github.com/user-attachments/assets/dab954aa-cd62-4c16-aef8-e0241b4b614c)
![DA27](https://github.com/user-attachments/assets/528eb0aa-7583-4731-b6b8-87ef36ef85c6)













