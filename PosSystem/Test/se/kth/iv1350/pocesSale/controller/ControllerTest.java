package se.kth.iv1350.pocesSale.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.integration.ItemMissingException;
import se.kth.iv1350.pocesSale.integration.ItemRegistry;
import se.kth.iv1350.pocesSale.integration.ItemRegistryExceptions;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;
import se.kth.iv1350.pocesSale.modell.Receipt;
import se.kth.iv1350.pocesSale.modell.Sale;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new  PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        outContent = null;
        System.setOut(originalSysOut);
    }
    @Test
    void testStartSale() {

    }

    @Test
    void testRegisterItem() {

        int recivedAmount = 500;
        StoreRegistry testStoreRegistry = new StoreRegistry();
        Sale instance = new Sale(testStoreRegistry);
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka",12);
        instance.addItem(itemDTO,5);
        Sale result = instance;

        assertTrue(result instanceof Sale,"No sale came back");
    }

    @Test
    void testRegisterItemWithMissingException() throws ItemMissingException {
        try {
            ItemRegistry itemRegistry = new ItemRegistry();

            itemRegistry.getItem(5);

            int recivedAmount = 500;
            StoreRegistry testStoreRegistry = new StoreRegistry();
            Sale instance = new Sale(testStoreRegistry);
            ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka", 12);
            instance.addItem(itemDTO, 5);
            Sale result = instance;
            fail("Should give us an exceptions");
        }catch (ItemMissingException excTest){
            String result = excTest.getMessage();
            String expResult = "Felaktigt varuid: "+ 5 + " - Försök igen";

            assertTrue(result.contains(expResult),"Wrong error message when item is missing");
        }
        catch (ItemRegistryExceptions excTestFail){
            fail("Should not throw this exception " + excTestFail);
        }


    }

    @Test
    void testRegisterItemWithRegisterException() throws ItemMissingException {
        try {
            ItemRegistry itemRegistry = new ItemRegistry();

            itemRegistry.getItem(99);

            int recivedAmount = 500;
            StoreRegistry testStoreRegistry = new StoreRegistry();
            Sale instance = new Sale(testStoreRegistry);
            ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka", 12);
            instance.addItem(itemDTO, 5);
            Sale result = instance;
            fail("Should give us an exceptions");
        }catch (ItemMissingException excTestFail){
            fail("Should not throw this exception " + excTestFail);
        }
        catch (ItemRegistryExceptions excTest){
            String expResult = "When registerd item id 99 database crashed";
            String result = excTest.getMessage();
            assertTrue(result.contains(expResult), "Wrong error exception message");
        }


    }

    @Test
    void testPay() {
        int recivedAmount = 500;
        StoreRegistry testStoreRegistry = new StoreRegistry();
        Sale instance = new Sale(testStoreRegistry);
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka",12);
        instance.addItem(itemDTO,5);
        Receipt receipt = instance.paid(recivedAmount,instance);
        double expResult = 500-67.0;
        double result = receipt.giveMeChange();
        assertEquals(expResult,result,"Wrong Change");
    }


}