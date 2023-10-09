package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Weapon;

import org.junit.Before;
import org.junit.Test;
/**
 * This class contains unit tests for the Weapon class.
 */
public class WeaponTest {

    private Weapon weapon;

    /**
     * Sets up the test fixture before each test method.
     * A new Weapon object is created with known characteristics.
     */
    @Before
    public void setUp() {
        weapon = new Weapon("Sword", 10, 50.0, "A sharp sword", 5);
    }

    /**
     * Test method for {@link Weapon#getName()}.
     * Checks if the getName method returns the correct name.
     */
    @Test
    public void testGetName() {
        assertEquals("Sword", weapon.getName());
    }

    /**
     * Test method for {@link Weapon#getDamage()}.
     * Checks if the getDamage method returns the correct damage value.
     */
    @Test
    public void testGetDamage() {
        assertEquals(10, weapon.getDamage());
    }

    /**
     * Test method for {@link Weapon#getDescription()}.
     * Checks if the getDescription method returns the correct description.
     */
    @Test
    public void testGetDescription() {
        assertEquals("A sharp sword", weapon.getDescription());
    }

    /**
     * Test method for {@link Weapon#getQuantity()}.
     * Checks if the getQuantity method returns the correct quantity.
     */
    @Test
    public void testGetQuantity() {
        assertEquals(5, weapon.getQuantity());
    }
}
