package se.kth.iv1350.pocesSale.modell;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.integration.ItemRegistry;
import se.kth.iv1350.pocesSale.modell.Item;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private ItemDescriptionDTO itemDTO;

    @BeforeEach
    void setUp() {
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Pelle", 23, 12f, "Leksaksdocka",12);

    }

    @AfterEach
    void tearDown() {
        itemDTO = null;
    }

    @Test
    void testAddQuantity() {
        Item testItem = new Item(itemDTO, 30);
        int exResult = 30;
        int result = testItem.getQuantity();
        assertEquals(exResult, result, "Item quantity not matching");
    }
}