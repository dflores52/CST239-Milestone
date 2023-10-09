package test;

import static org.junit.Assert.*;
import app.Health;

import org.junit.Test;

public class HealthTest {

    @Test
    public void testHealthConstructorAndGetters() {
        // Arrange
        String expectedName = "Health Potion";
        int expectedHeal = 20;
        double expectedPrice = 50.0;
        String expectedDescription = "Restores 20 health points";
        int expectedQuantity = 10;

        // Act
        Health healthItem = new Health(expectedName, expectedHeal, expectedPrice, expectedDescription, expectedQuantity);

        // Assert
        assertEquals(expectedName, healthItem.getName());
        assertEquals(expectedHeal, healthItem.getLife());
        assertEquals(expectedDescription, healthItem.getDescription());
        assertEquals(expectedQuantity, healthItem.getQuantity());
    }
}
