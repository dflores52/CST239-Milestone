package app;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Represents an armor item that can be sold.
 */
public class Armor extends SalableItem{
	private int shield;


	/**
	 * Constructs an Armor object with the specified attributes.
	 *
	 * @param name        the name of the armor
	 * @param shield      the shield value of the armor
	 * @param price       the price of the armor
	 * @param description the description of the armor
	 * @param quantity    the quantity of the armor
	 */
	public Armor(@JsonProperty("name") String name,
            @JsonProperty("shield") int shield,
            @JsonProperty("price") double price,
            @JsonProperty("description") String description,
            @JsonProperty("quantity") int quantity) {
		super(name, price, description, quantity);
		this.shield = shield; 
		// TODO Auto-generated constructor stub
	}


	/**
	 * Returns the shield value of the armor.
	 *
	 * @return the shield value
	 */
	public int getShield() {
		return shield;
	}

}
