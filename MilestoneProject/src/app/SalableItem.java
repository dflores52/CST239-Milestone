package app;

/**
 * Represents an item that can be sold.
 */
public class SalableItem {
    private String name;
    private String description;
    private int quantity;
    private int price;

    /**
     * Constructs a salable item with the provided details.
     *
     * @param name        The name of the item.
     * @param description The description of the item.
     * @param quantity    The quantity available.
     * @param price       The price of the item.
     */
    public SalableItem(String name, String description, int quantity, int price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the quantity available.
     *
     * @return The quantity available.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Retrieves the price of the item.
     *
     * @return The price of the item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Generates a string representation of the salable item.
     *
     * @return A string representation of the salable item.
     */
    @Override
    public String toString() {
        return "SalableItem [name=" + name + ", description=" + description +
               ", quantity=" + quantity + ", price=" + price + "]";
    }
}
