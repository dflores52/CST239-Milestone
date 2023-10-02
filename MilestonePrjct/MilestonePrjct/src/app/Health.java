package app;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an health item that can be sold.
 */
public class Health extends SalableItem{
	private int heal;

	/**
	 * @param name
	 * @param price
	 * @param description
	 * @param quantity
	 */
	public Health(@JsonProperty("name") String name,
			@JsonProperty("heal") int heal,
            @JsonProperty("price") double price,
            @JsonProperty("description") String description,
            @JsonProperty("quantity") int quantity) {
		super(name, price, description, quantity);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Returns the life value of the health.
	 *
	 * @return the health value
	 */
	public int getLife() {
		return heal;
	}

	
	

}
