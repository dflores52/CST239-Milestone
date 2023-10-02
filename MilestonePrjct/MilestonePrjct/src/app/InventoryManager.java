package app;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * Manages the inventory of salable items, including weapons, armor, and health items.
 */
public class InventoryManager {
    /**
     * List of all salable items in the inventory.
     */
    private List<SalableItem> inventory;
    
    /**
     * List of all weapon items in the inventory.
     */
    private List<Weapon> weaponItems;
    
    /**
     * List of all armor items in the inventory.
     */
    private List<Armor> armorItems;
    
    /**
     * List of all health items in the inventory.
     */
    private List<Health> healthItems;

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
        inventory.removeIf(i -> i.equals(item));
    }

    /**
     * Displays the contents of the inventory.
     */
    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(i + ". " + inventory.get(i));
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
    public List<Weapon> getWeaponItems() {
        return weaponItems;
    }

    /**
     * Retrieves a list of armor items in the inventory.
     *
     * @return A list of armor items in the inventory.
     */
    public List<Armor> getArmorItems() {
        return armorItems;
    }

    /**
     * Retrieves a list of health items in the inventory.
     *
     * @return A list of health items in the inventory.
     */
    public List<Health> getHealthItems() {
        return healthItems;
    }

  

public void loadInventoryFromFile(String filePath) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
       // inventory.clear(); // Clear existing inventory before loading from file

        // Read JSON data and convert it to a List of SalableItem objects
        List<SalableItem> items = objectMapper.readValue(new File(filePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, SalableItem.class));

        // Add all the items to the inventory
        for (SalableItem item : items) {
            addItem(item);
        }

        System.out.println("Inventory loaded from file: " + filePath);
    } catch (JsonParseException | JsonMappingException e) {
        System.err.println("Error parsing JSON data from file: " + filePath);
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("Error reading JSON file: " + filePath);
        e.printStackTrace();
    }
}
/**
 * Sorts the inventory based on the name and price in descending order.
 */
public void sortInventoryDescending() {
	Collections.sort(inventory, new Comparator<SalableItem>() {
	    @Override
	    public int compare(SalableItem o1, SalableItem o2) {
	        return o2.getName().compareToIgnoreCase(o1.getName());
	    }
	});
}
public void sortByPriceAscending() {
    Collections.sort(inventory, new Comparator<SalableItem>() {
        @Override
        public int compare(SalableItem o1, SalableItem o2) {
            return Double.compare(o1.getPrice(), o2.getPrice());
        }
    });
}
/**
 * Sorts the inventory based on the name and price in ascending order.
 */
public void sortInventoryAscending() {
    Collections.sort(inventory);
}
/**
 * Sorts the inventory based on the price in ascending order.
 */

/**
 * Sorts the inventory based on the price in descending order.
 */
public void sortByPriceDescending() {
    Collections.sort(inventory, new Comparator<SalableItem>() {
        @Override
        public int compare(SalableItem o1, SalableItem o2) {
            return Double.compare(o2.getPrice(), o1.getPrice());
        }
    });
}
/**
 * Converts the inventory to a JSON string.
 * 
 * <p>This method takes the inventory list and converts it into a JSON-formatted string.
 * If the conversion fails, it returns an empty JSON object.</p>
 *
 * @return A JSON-formatted string representing the inventory.
 */
public String toJson() {
    try {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this.inventory); // Assuming 'inventory' is the list/collection of Salable Products
    } catch (Exception e) {
        e.printStackTrace();
        return "{}"; // Return an empty JSON object on error
    }
}
/**
 * Adds items to the inventory from a JSON string.
 * 
 * <p>This method takes a JSON-formatted string and converts it into a list of SalableItem objects.
 * These objects are then added to the inventory. If the conversion fails, an error message is printed.</p>
 *
 * @param json The JSON-formatted string containing the items to be added.
 */
public void addItemsFromJson(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
        List<SalableItem> items = objectMapper.readValue(json, new TypeReference<List<SalableItem>>() {});
        inventory.addAll(items);
        System.out.println(items.size() + " items added to the inventory from JSON.");
    } catch (Exception e) {
        System.err.println("Error parsing JSON data.");
        e.printStackTrace();
    }
}
}

