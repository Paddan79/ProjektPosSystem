package se.kth.iv1350.pocesSale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.controller.Controller;
import se.kth.iv1350.pocesSale.integration.IntegrationCreator;
import se.kth.iv1350.pocesSale.integration.Printer;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;
import se.kth.iv1350.pocesSale.modell.Receipt;
import se.kth.iv1350.pocesSale.modell.Sale;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {

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
    void testPrintReciept() {

        int recivedAmount = 500;
        Printer print = new Printer();
        StoreRegistry testStoreRegistry = new StoreRegistry();
        Sale instance = new Sale(testStoreRegistry);
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka",12);
        instance.addItem(itemDTO,5);
        Receipt receipt = instance.paid(recivedAmount,instance);
        print.printReciept(receipt);
        String expResult = "--- START OF RECEIPT---\n"  + testStoreRegistry.getStoreName()+ " " + testStoreRegistry.getStoreAdress()+ "\n";

        String result = outContent.toString();
        assertTrue(result.contains(expResult),"Wrong printout of receipt");
    }
}