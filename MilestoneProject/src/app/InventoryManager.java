package app;

import java.util.ArrayList;

/**
 * Manages the inventory of salable items, including weapons, armor, and health items.
 */
public class InventoryManager {
    private ArrayList<SalableItem> inventory;
    private ArrayList<Weapon> weaponItems;
    private ArrayList<Armor> armorItems;
    private ArrayList<Health> healthItems;

    /**
     * Constructs an empty inventory manager with separate lists for different item types.
     */
    public InventoryManager() {
        this.inventory = new ArrayList<>();
        this.weaponItems = new ArrayList<>();
        this.armorItems = new ArrayList<>();
        this.healthItems = new ArrayList<>();
    }

    /**
     * Adds a salable item to the inventory.
     *
     * @param item The salable item to be added to the inventory.
     */
    public void addItem(SalableItem item) {
        inventory.add(item);
        if (item instanceof Weapon) {
            weaponItems.add((Weapon) item);
        } else if (item instanceof Armor) {
            armorItems.add((Armor) item);
        } else if (item instanceof Health) {
            healthItems.add((Health) item);
        }
    }

    /**
     * Removes a salable item from the inventory.
     *
     * @param item The salable item to be removed from the inventory.
     */
    public void removeItem(SalableItem item) {
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

    /**
     * Retrieves a list of weapon items in the inventory.
     *
     * @return A list of weapon items in the inventory.
     */
    public ArrayList<Weapon> getWeaponItems() {
        return weaponItems;
    }

    /**
     * Retrieves a list of armor items in the inventory.
     *
     * @return A list of armor items in the inventory.
     */
    public ArrayList<Armor> getArmorItems() {
        return armorItems;
    }

    /**
     * Retrieves a list of health items in the inventory.
     *
     * @return A list of health items in the inventory.
     */
    public ArrayList<Health> getHealthItems() {
        return healthItems;
    }
}
