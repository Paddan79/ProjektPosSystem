package se.kth.iv1350.pocesSale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.integration.ItemRegistry;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;

import static org.junit.jupiter.api.Assertions.*;

class ItemRegistryTest {

    private ItemRegistry itemRegistry;

    @BeforeEach
    void setUp() {
        itemRegistry = new ItemRegistry();

    }

    @AfterEach
    void tearDown() {
        itemRegistry = null;
    }

    @Test
    void testGetItem() {


        ItemDescriptionDTO result = itemRegistry.getItem(1);
        ItemDescriptionDTO expResult = new ItemDescriptionDTO("Äpple",1,25.0f, "grönt",23.00);
        assertEquals(expResult.toString() ,result.toString(), "Wrong item recived");
    }

    @Test
    void testGetItemMissing() {


        ItemDescriptionDTO result = itemRegistry.getItem(9);
        ItemDescriptionDTO expResult = null;
        assertNull(result, "Item found");
    }

    @Test
    void testGetItemWithWrongInput() {


        ItemDescriptionDTO result = itemRegistry.getItem(' ');
        ItemDescriptionDTO expResult = null;
        assertNull(result, "Item found");
    }


}