package app;
/**
 * Represents an health item that can be sold.
 */
public class Health extends SalableItem implements Comparable<Health>{
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
	  /**
     * Compares this health to another health based on their names.
     * The comparison is case-insensitive.
     *
     * @param otherHealth The health to be compared.
     * @return A negative integer, zero, or a positive integer as this health's name
     *         is less than, equal to, or greater than the specified health's name.
     */
	@Override
	public int compareTo(Health otherHealth) {
		// TODO Auto-generated method stub
		return this.getName().compareToIgnoreCase(otherHealth.getName());
	}

	
	

}