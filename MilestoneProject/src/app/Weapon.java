package app;

/**
 * Represents a weapon item that can be sold.
 */
public class Weapon extends SalableItem implements Comparable<Weapon>{
	private int damage;
	
	/**
	 * Constructs a Weapon object with the specified attributes.
	 *
	 * @param name        the name of the weapon
	 * @param damage      the damage value of the weapon
	 * @param price       the price of the weapon
	 * @param description the description of the weapon
	 * @param quantity    the quantity of the weapon
	 */
	public Weapon(String name, int damage, int price, String description, int quantity) {
		super(name, description, price, quantity);
		this.damage = damage;
	}
	
	/**
	 * Returns the damage value of the weapon.
	 *
	 * @return the damage value
	 */
	public int getDamage() {
		return damage;
	}

	  /**
     * Compares this weapon to another weapon based on their names.
     * The comparison is case-insensitive.
     *
     * @param otherWeapon The weapon to be compared.
     * @return A negative integer, zero, or a positive integer as this weapon's name
     *         is less than, equal to, or greater than the specified weapon's name.
     */
    @Override
	public int compareTo(Weapon otherWeapon) {
		
		// Compare the names of the two weapons, ignoring case
		return this.getName().compareToIgnoreCase(otherWeapon.getName());
	}
}