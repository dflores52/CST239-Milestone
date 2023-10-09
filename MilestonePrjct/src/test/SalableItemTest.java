/**
 * 
 */
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import app.SalableItem;

/**
 * @author flores
 *
 */
public class SalableItemTest {

	 /**
     * Tests the constructor and getter methods of the SalableItem class.
     * This test checks whether the constructed object has the expected attributes.
     */
	@Test
    public void testConstructorAndGetters()
    {
        SalableItem item = new SalableItem("Sword", 50.0, "A sharp sword", 10);

        assertEquals("Sword", item.getName());
        assertEquals("A sharp sword", item.getDescription());
        assertEquals(10, item.getQuantity());
    }

    /**
     * Tests the compareTo method of the SalableItem class.
     * This test checks the comparison based on the name and price of the items.
     */
    @Test
    public void testCompareTo() 
    {
        SalableItem item1 = new SalableItem("Sword", 50.0, "A sharp sword", 10);
        SalableItem item2 = new SalableItem("Shield", 40.0, "A strong shield", 5);
        SalableItem item3 = new SalableItem("Sword", 60.0, "A sharper sword", 8);
        
        assertTrue(item1.compareTo(item2) > 0);  // Sword comes after Shield
        assertTrue(item2.compareTo(item1) < 0);  // Shield comes before Sword
        assertTrue(item1.compareTo(item3) < 0);  // Same name, but item1 is cheaper than item3
    }
    /**
     * Tests the toString method of the SalableItem class.
     * This test checks whether the string representation of the object is as expected.
     */
    @Test
    public void testToString() 
    {
        SalableItem item = new SalableItem("Sword", 50.0, "A sharp sword", 10);
        String expected = "SalableItem [name=Sword, price=50.0, description=A sharp sword, quantity=10]";
        assertEquals(expected, item.toString());
    }



}
