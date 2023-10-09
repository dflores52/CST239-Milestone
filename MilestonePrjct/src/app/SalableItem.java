package app;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = SalableItem.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Weapon.class, name = "Weapon"),
    @JsonSubTypes.Type(value = Armor.class, name = "Armor"),
    @JsonSubTypes.Type(value = Health.class, name = "Health")
})

/**
 * Represents a salable item in a store.
 */
public class SalableItem implements Comparable<SalableItem>{
	private String name;
	private double price;
	private String description;
	private int quantity;
	
	/**
	 * Constructs a SalableItem object with the specified attributes.
	 *
	 * @param name        the name of the item
	 * @param price       the price of the item
	 * @param description the description of the item
	 * @param quantity    the quantity of the item
	 */
	
	public SalableItem(String name, double price, String description, int quantity) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}
    @Override
    public int compareTo(SalableItem o) {
        // Comparing based on the name first
        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison == 0) {
            // If names are equal, compare based on price
            return Double.compare(this.price, o.price);
        }
        return nameComparison;
    }
	
	/**
	 * Returns the name of the item.
	 *
	 * @return the name of the item
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the price of the item.
	 *
	 * @return the price of the item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns the description of the item.
	 *
	 * @return the description of the item
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the quantity of the item.
	 *
	 * @return the quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "SalableItem [name=" + name + ", price=" + price + ", description=" + description + ", quantity="
				+ quantity + "]";
	}
}
