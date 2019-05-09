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
    void testGetItem() throws ItemMissingException {

        try {
            ItemDescriptionDTO result = itemRegistry.getItem(1);
            ItemDescriptionDTO expResult = new ItemDescriptionDTO("Äpple", 1, 25.0f, "grönt", 23.00);
            assertEquals(expResult.toString(), result.toString(), "Wrong item recived");
        }
        catch (ItemRegistryExceptions excTestFail){
            fail("Should not throw this exception " + excTestFail);
        }
        catch (ItemMissingException excTestFail) {
            fail("Should not throw this exception " + excTestFail);
        }

    }

    @Test
    void testGetItemMissing() throws ItemMissingException {

        try {


            ItemDescriptionDTO result = itemRegistry.getItem(9);
        }
        catch (ItemRegistryExceptions excTestFail){
            fail("Should not throw this exception " + excTestFail);
        }
        catch (ItemMissingException exTest) {

            String result = exTest.getMessage();
            String expResult = "Felaktigt varuid: "+ 9 + " - Försök igen";

            assertTrue(result.contains(expResult), "Wrong error message or id");
        }
    }

    @Test
    void testGetItemWithWrongInput() throws ItemMissingException {

        try {


            ItemDescriptionDTO result = itemRegistry.getItem(99);
        }
        catch (ItemMissingException excTestFail){
            fail("Should not throw this exception " + excTestFail);
        }
        catch (ItemRegistryExceptions exTest){
            String expResult = "When registerd item id 99 database crashed";
            String result = exTest.getMessage();
            assertTrue(result.contains(expResult), "Item found");

        }
    }


}