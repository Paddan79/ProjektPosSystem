package se.kth.iv1350.pocesSale.view;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.controller.Controller;
import se.kth.iv1350.pocesSale.integration.IntegrationCreator;
import se.kth.iv1350.pocesSale.integration.Printer;
import se.kth.iv1350.pocesSale.view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    private View instance;
    ByteArrayOutputStream printout;
    PrintStream originalSysOut;

    @BeforeEach
    public void setUp() {
        IntegrationCreator intCreate = new IntegrationCreator();
        Controller contr = new Controller(intCreate,new Printer());
        instance = new View(contr);

        printout = new ByteArrayOutputStream();

        PrintStream inMemSysOut = new PrintStream(printout);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalSysOut);
        printout = null;
    }

    @Test
    public void testRunFakeSale() {
    instance.sampleExecution();
    String result = printout.toString();
    String expRes = "Let's start shopping";
    assertTrue(result.contains(expRes), "Wrong printout after calling startNewsale().");
    }
}