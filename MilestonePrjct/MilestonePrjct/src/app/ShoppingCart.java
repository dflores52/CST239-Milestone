package app;

import java.util.ArrayList;

/**
 * Represents a shopping cart that holds a collection of items.
 */
public class ShoppingCart {
    private ArrayList<SalableItem> cart;
    // Total is moved here to be local to the getTotal() method
    // private int total;

    /**
     * Constructs an empty shopping cart.
     */
    public ShoppingCart() {
        this.cart = new ArrayList<>();
        // Total initialization removed from here
    }

    /**
     * Calculates and returns the total price of items in the cart.
     *
     * @return The total price of items in the cart.
     */
    public int getTotal() {
        int total = 0; // Total calculated locally within the method
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getPrice();
        }
        return total;
    }

    /**
     * Adds an item to the shopping cart.
     *
     * @param item The item to be added to the cart.
     */
    public void addToCart(SalableItem item) {
        cart.add(item);
    }

    /**
     * Empties the shopping cart, removing all items.
     */
    public void emptyCart() {
        cart.clear();
    }

    /**
     * Retrieves the list of items in the cart.
     *
     * @return The list of items in the cart.
     */
    public ArrayList<SalableItem> getCart() {
        return cart;
    }

    /**
     * Generates a string representation of the shopping cart.
     *
     * @return A string representation of the shopping cart.
     */
    @Override
    public String toString() {
        return "ShoppingCart [cart=" + cart + ", total=" + getTotal() + "]";
    }

    /**
     * Checks if the shopping cart is empty.
     *
     * @return true if the cart is empty, false otherwise.
     */
    public boolean isCartEmpty() {
        return cart.isEmpty();
    }
}