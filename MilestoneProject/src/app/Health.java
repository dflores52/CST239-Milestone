package app;
/**
 * Represents an health item that can be sold.
 */
public class Health extends SalableItem{
	private int life;

	/**
	 * @param name
	 * @param price
	 * @param description
	 * @param quantity
	 */
	public Health(String name,int life, int price, String description, int quantity) {
		super(name, description, price, quantity);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Returns the life value of the health.
	 *
	 * @return the health value
	 */
	public int getLife() {
		return life;
	}

	
	

}