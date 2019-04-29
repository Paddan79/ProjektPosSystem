package se.kth.iv1350.pocesSale.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.modell.Item;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;

import static org.junit.jupiter.api.Assertions.*;

class ItemDescriptionDTOTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testToString() {
        String name = "Fläskkotlett";
        int id = 25;
        float vat = 25.0f;
        String description = "Kött";
        double netPrice = 99.50;

        ItemDescriptionDTO instance = new ItemDescriptionDTO(name,id,vat,description,netPrice);
        String expResult = "Vara " + name + " Eankod " + id + " Moms " + vat + " Beskrivning " + description + " Pris " + netPrice;
        String result = instance.toString();
        assertEquals(expResult,result,"Wrong string returned");
    }

    @Test
    public void testToStringNullParam() {
        String name = null;
        int id = 0;
        float vat = 0.0f;
        String description = null;
        double netPrice = 0.0;

        ItemDescriptionDTO instance = new ItemDescriptionDTO(name,id,vat,description,netPrice);
        String expResult = "Vara " + name + " Eankod " + id + " Moms " + vat + " Beskrivning " + description + " Pris " + netPrice;
        String result = instance.toString();
        assertEquals(expResult,result,"Wrong string returned");
    }

    @Test
    public void testToStringEmptyParam() {
        String name = "";
        int id = 0;
        float vat = 0.0f;
        String description = "";
        double netPrice = 0.0;

        ItemDescriptionDTO instance = new ItemDescriptionDTO(name,id,vat,description,netPrice);
        String expResult = "Vara " + name + " Eankod " + id + " Moms " + vat + " Beskrivning " + description + " Pris " + netPrice;
        String result = instance.toString();
        assertEquals(expResult,result,"Wrong string returned");
    }
}