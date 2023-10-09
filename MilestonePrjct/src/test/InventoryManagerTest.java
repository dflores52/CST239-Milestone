package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



import app.InventoryManager;
import app.SalableItem;

import java.util.Arrays;
import java.util.List;


/**
 * Test class for InventoryManager.
 */
public class InventoryManagerTest {

    private InventoryManager manager;
    private SalableItem item1;
    private SalableItem item2;
    private SalableItem item3;

    /**
     * Setup method to initialize objects before each test.
     */
    @Before
   public void setUp() {
        manager = new InventoryManager();
        item1 = new SalableItem("Sword", 50.0, "A sharp sword", 10);
        item2 = new SalableItem("Shield", 40.0, "A strong shield", 5);
        item3 = new SalableItem("Potion", 20.0, "A health potion", 15);
    }

    /**
     * Tests the addItem and size methods.
     * This test checks whether items are correctly added to the inventory.
     */
    @Test
  public  void testAddItemAndSize() {
        manager.addItem(item1);
        manager.addItem(item2);

        assertEquals(2, manager.size());
    }

    /**
     * Tests the removeItem method.
     * This test checks whether items are correctly removed from the inventory.
     */
    @Test
  public  void testRemoveItem() {
        manager.addItem(item1);
        manager.addItem(item2);
        manager.removeItem(item1);

        assertEquals(1, manager.size());
    }

    /**
     * Tests the sortInventoryAscending and sortInventoryDescending methods.
     * This test checks whether the inventory is sorted correctly.
     */
    @Test
  public  void testSortInventory() {
        manager.addItem(item1);
        manager.addItem(item2);
        manager.addItem(item3);

        manager.sortInventoryAscending();
        List<SalableItem> expectedAscending = Arrays.asList(item3, item2, item1);
        assertEquals(expectedAscending, manager.getInventory());

        manager.sortInventoryDescending();
        List<SalableItem> expectedDescending = Arrays.asList(item1, item2, item3);
        assertEquals(expectedDescending, manager.getInventory());
    }

   
}

