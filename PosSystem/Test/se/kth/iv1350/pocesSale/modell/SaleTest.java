package se.kth.iv1350.pocesSale.modell;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    ByteArrayOutputStream outContent;
    PrintStream orginalSysOut;

    @BeforeEach
    void setUp() {
        orginalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        outContent = null;
        System.setOut(orginalSysOut);

    }

    @Test
    void testAddItem() {
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka",12);
        Item instance = new Item(itemDTO,4);
        ItemDescriptionDTO result = instance.getItem();
        assertTrue(result instanceof ItemDescriptionDTO,"Wrong ItemInformation instanced");
    }


    @Test
    void testToString() {
        int recivedAmount = 500;
        StoreRegistry testStoreRegistry = new StoreRegistry();
        Sale instance = new Sale(testStoreRegistry);
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka",12);
        instance.addItem(itemDTO,5);
        instance.paid(recivedAmount,instance);
        String expResult =  "\nMottaget belopp "+ Math.round(recivedAmount) + "\n" + "Pengar tillbaka ";
        String result = instance.toString();
        assertTrue(result.contains(expResult));


    }



    @Test
    void testPaid() {
        int recivedAmount = 500;
        StoreRegistry testStoreRegistry = new StoreRegistry();
        Sale instance = new Sale(testStoreRegistry);
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka",12);
        instance.addItem(itemDTO,5);
        Receipt result = instance.paid(recivedAmount,instance);


        assertTrue(result instanceof Receipt,"No receipt came back");
    }
}