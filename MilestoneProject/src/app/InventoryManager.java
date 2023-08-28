package app;

import java.util.ArrayList;

/**
 * Manages the inventory of salable items.
 */
public class InventoryManager {
    private ArrayList<SalableItem> inventory;

    /**
     * Constructs an empty inventory manager.
     */
    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Generates a string representation of the inventory manager.
     *
     * @return A string representation of the inventory manager.
     */
    @Override
    public String toString() {
        return "InventoryManager [inventory=" + inventory + "]";
    }

    /**
     * Adds a salable item to the inventory.
     *
     * @param item The salable item to be added to the inventory.
     */
    public void addItem(SalableItem item) {
        inventory.add(item);
        System.out.println("Item " + item.getName() + " added");
    }

    /**
     * Removes a salable item from the inventory.
     *
     * @param item The salable item to be removed from the inventory.
     */
    public void removeItem(SalableItem item) {
        System.out.println("Item " + item.getName() + " removed");
        inventory.remove(item);
    }

    /**
     * Displays the contents of the inventory.
     */
    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ", " + inventory.get(i));
        }
    }

    /**
     * Retrieves a salable item from the inventory.
     *
     * @param toBuy The index of the item to retrieve.
     * @return The salable item retrieved from the inventory.
     */
    public SalableItem getItemFromInventory(int toBuy) {
        return inventory.get(toBuy);
    }

    /**
     * Returns the number of items in the inventory.
     *
     * @return The number of items in the inventory.
     */
    public int size() {
        return inventory.size();
    }
}
