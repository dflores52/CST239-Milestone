# CST239-Milestone
**Interactive Storefront Program**

Welcome to the Interactive Storefront program! This Java application simulates a basic text-based store where users can browse, select, and purchase items from an inventory.

**Table of Contents**
- [Overview](#overview)
- [Classes](#classes)
  - [SalableItem](#salableitem-class)
  - [InventoryManager](#inventorymanager-class)
  - [ShoppingCart](#shoppingcart-class)
  - [StoreFront](#storefront-class)
- [Usage](#usage)

**Overview**

This program allows users to interact with a virtual storefront. Users can view the available items in the inventory, add items to their shopping cart, and then decide whether to proceed with their purchase or cancel it. The program keeps track of the user's cart and adjusts the inventory accordingly.

**Classes**

**SalableItem Class**

Represents a salable item with a name, description, quantity, and price. This class is used to create items that can be added to both the inventory and the shopping cart.

**InventoryManager Class**

Manages the store's inventory of salable items. It provides methods to add and remove items from the inventory, as well as display the current inventory.

**ShoppingCart Class**

Represents a shopping cart that holds a collection of salable items. Users can add items to the cart, calculate the total price of items in the cart, and empty the cart.

**StoreFront Class**

Implements the main program logic. It simulates the interaction between the user and the store. Users can browse the inventory, add items to their cart, and decide whether to purchase or cancel their order.

**Usage**

1.  Compile the program using a Java compiler.
2.  Run the compiled program.
3.  The program will greet the user and display the available items in the inventory.
4. Users can enter the number of the item they want to buy or choose to quit.
5.  Users can keep adding items to their cart or quit.
6.  Once users are done shopping, the program will display the total cost of items in the cart.
7.  Users can confirm the purchase by pressing '1' or cancel by pressing '2'.
8.  If the purchase is confirmed, the program will finalize the purchase and thank the user.

Remember that this program is designed to provide a simple and interactive shopping experience in a text-based environment. Feel free to explore the code and customize it to add more features or functionality.
