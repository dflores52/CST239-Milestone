package app;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a weapon item that can be sold.
 */
public class Weapon extends SalableItem {
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
    public Weapon(@JsonProperty("name") String name,
            @JsonProperty("damage") int damage,
            @JsonProperty("price") double price,
            @JsonProperty("description") String description,
            @JsonProperty("quantity") int quantity) {
        super(name, price, description, quantity);
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
}
