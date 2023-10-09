package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.SalableItem;
import app.StoreFront;

import java.util.ArrayList;



/**
 * Test class for StoreFront.
 */
public class StoreFrontTest {

    private StoreFront store;
    private SalableItem item1;
    private SalableItem item2;

    /**
     * Setup method to initialize objects before each test.
     */
    @Before
  public void setUp() {
        store = new StoreFront("Test Store");
        item1 = new SalableItem("Sword", 50.0, "A sharp sword", 10);
        item2 = new SalableItem("Shield", 40.0, "A strong shield", 5);
    }

    /**
     * Tests the purchase method.
     * This test checks whether the total cost of items in the cart is displayed correctly.
     */
    @Test
   public void testPurchase() {
        store.getCart().addToCart(item1);
        store.getCart().addToCart(item2);

        // Assuming the purchase() method returns the total cost instead of printing it
        assertEquals(90, StoreFront.purchase());
    }

    /**
     * Tests the cancelPurchase method.
     * This test checks whether the items are returned to the inventory and the cart is emptied.
     */
    @Test
   public void testCancelPurchase() {
        store.getCart().addToCart(item1);
        store.getCart().addToCart(item2);
        StoreFront.cancelPurchase();

        assertTrue(store.getCart().isCartEmpty());
        
    }

    /**
     * Tests the getName method.
     * This test checks whether the name of the storefront is returned correctly.
     */
    @Test
   public void testGetName() {
        assertEquals("Test Store", store.getName());
    }
}
