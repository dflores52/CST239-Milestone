package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import app.SalableItem;
import app.ShoppingCart;

public class ShoppingCartTest {

		private ShoppingCart cart;
	    private SalableItem item1;
	    private SalableItem item2;

	    /**
	     * Setup method to initialize objects before each test.
	     */
	    @Before
	   public void setUp() {
	        cart = new ShoppingCart();
	        item1 = new SalableItem("Sword", 50.0, "A sharp sword", 10);
	        item2 = new SalableItem("Shield", 40.0, "A strong shield", 5);
	    }

	    /**
	     * Tests the addToCart and getCart methods.
	     * This test checks whether items are correctly added to the cart.
	     */
	    @Test
	    public void testAddToCartAndGetCart() {
	        cart.addToCart(item1);
	        cart.addToCart(item2);

	        ArrayList<SalableItem> expected = new ArrayList<>();
	        expected.add(item1);
	        expected.add(item2);

	        assertEquals(expected, cart.getCart());
	    }

	    /**
	     * Tests the getTotal method.
	     * This test checks whether the total price is calculated correctly.
	     */
	    @Test
	    public void testGetTotal() {
	        cart.addToCart(item1);
	        cart.addToCart(item2);

	        // 50.0 (price of Sword) + 40.0 (price of Shield) = 90.0
	        // The getTotal method returns an int, so the expected value is 90
	        assertEquals(90, cart.getTotal());
	    }

	    /**
	     * Tests the emptyCart and isCartEmpty methods.
	     * This test checks whether the cart is emptied correctly and whether it's empty.
	     */
	    @Test
	   public void testEmptyCartAndIsCartEmpty() {
	        cart.addToCart(item1);
	        cart.addToCart(item2);

	        assertFalse(cart.isCartEmpty());

	        cart.emptyCart();

	        assertTrue(cart.isCartEmpty());
	    }

	    /**
	     * Tests the toString method.
	     * This test checks whether the string representation of the object is as expected.
	     */
	    @Test
	   public void testToString() {
	        cart.addToCart(item1);
	        String expected = "ShoppingCart [cart=[" + item1.toString() + "], total=50]";
	        assertEquals(expected, cart.toString());
	    }

}
