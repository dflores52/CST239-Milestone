/**
 * 
 */
package app;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author David Flores
 *
 */
/**
 * Represents a storefront application where users can interactively purchase items.
 */
public class StoreFront {
    private String name;
    private static InventoryManager inventory;
    private static ShoppingCart cart;
    Scanner scnr = new Scanner(System.in);

    /**
     * Constructs a StoreFront with the provided name, initializes inventory and cart, and adds initial items.
     *
     * @param name The name of the storefront.
     */
    public StoreFront(String name) {
        this.name = name;
        this.inventory = new InventoryManager();
        this.cart = new ShoppingCart();

        // Adding initial items to the inventory
        SalableItem item1 = new SalableItem("Sword", "melee weapon", 1, 10);
        SalableItem item2 = new SalableItem("Blaster", "range weapon", 1, 15);

        inventory.addItem(item1);
        inventory.addItem(item2);
    }

    /**
     * Displays the total cost of items in the cart.
     */
    public static void purchase() {
        System.out.println("Your total is: " + cart.getTotal());
    }

    /**
     * Cancels the purchase, returns items to inventory, and empties the cart.
     */
    public static void cancelPurchase() {
        ArrayList<SalableItem> returnInventory = cart.getCart();
        for (int i = 0; i < returnInventory.size(); i++) {
            inventory.addItem(returnInventory.get(i));
        }
        cart.emptyCart();
        System.out.println("Please come back soon!");
    }

    /**
     * Retrieves the name of the storefront.
     *
     * @return The name of the storefront.
     */
    public String getName() {
        return name;
    }

    /**
     * Welcomes the user and guides them through the purchasing process.
     */
    public void WelcomeUser() {
        System.out.println("Hello traveler, welcome to " + name + ", it's dangerous to go alone. Would you like to purchase something? (yes = 1, no = 2)");
        int wantToBuy = scnr.nextInt();

        while (wantToBuy == 1) {
            inventory.displayInventory();
            System.out.println("What would you like to buy? Please enter the number. (-1 to quit)");
            int toBuy = scnr.nextInt();
            if (toBuy < 0) {
                break;
            }
            if (toBuy < inventory.size()) {
                SalableItem toCart = inventory.getItemFromInventory(toBuy);
                cart.addToCart(toCart);
                inventory.removeItem(toCart);
                cart.getCart();
                System.out.println("Do you want to buy more? (yes = 1, no = 2)");
            } else {
                System.out.println("Your request is out of bounds...NO SOUP FOR YOU!!! NEXT!");
                break;
            }
            wantToBuy = scnr.nextInt();
        }

        if (!cart.isCartEmpty()) {
            StoreFront.purchase();
            System.out.println("Please press 1 to confirm your purchase, or 2 to cancel.");

            int confirm = scnr.nextInt();
            if (confirm == 2) {
                StoreFront.cancelPurchase();
            }
        }

        System.out.println("Have a nice day.");
    }

    /**
     * Main method to start the store simulation.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        StoreFront store = new StoreFront("The Shop");
        store.WelcomeUser();
    }
}
