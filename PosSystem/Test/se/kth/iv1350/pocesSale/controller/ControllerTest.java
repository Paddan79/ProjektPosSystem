package se.kth.iv1350.pocesSale.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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