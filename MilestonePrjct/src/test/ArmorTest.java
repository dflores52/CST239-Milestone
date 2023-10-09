package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Armor;

public class ArmorTest {

   // @SuppressWarnings("deprecation")
	@Test
    public void testArmorConstructorAndGetters() {
        // Arrange
        String expectedName = "Iron Armor";
        int expectedShield = 50;
        double expectedPrice = 100.0;
        String expectedDescription = "Strong iron armor";
        int expectedQuantity = 5;

        // Act
        Armor armor = new Armor(expectedName, expectedShield, expectedPrice, expectedDescription, expectedQuantity);

        // Assert
        assertEquals(expectedName, armor.getName());
        assertEquals(expectedShield, armor.getShield());
        assertEquals(expectedDescription, armor.getDescription());
        assertEquals(expectedQuantity, armor.getQuantity());
    }
}
