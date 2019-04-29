package se.kth.iv1350.pocesSale.Test;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.startupp.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {
        PrintStream originalSysOut = null;

        try {
            originalSysOut = System.out;
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            String[] args = null;
            Main.main(args);
            assertTrue(outContent.toString().contains("\nDetta presenteras på skärmen (pengar tillbaka till kunden): "),"Wrong output when main is executed");
        }
        finally {
            System.setOut(originalSysOut);
        }
    }
}