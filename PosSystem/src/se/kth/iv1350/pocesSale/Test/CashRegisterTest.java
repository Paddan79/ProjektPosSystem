package se.kth.iv1350.pocesSale.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.modell.CashRegister;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {

    private CashRegister cRZero;


    @BeforeEach
    void setUp() {
        cRZero = new CashRegister();
    }

    @AfterEach
    void tearDown() {
        cRZero = null;
    }

    @Test
    void testUpdateCashAmount() {
        double insert = 30;
        cRZero.updateCashAmount(insert);
        double expResult = 130.0;
        double result = cRZero.getBalance();

        assertEquals(expResult , result,"Wrong balance");

    }

    @Test
    void testUpdateCashAmountWithNegativeAmount() {
        double insert = -30;
        cRZero.updateCashAmount(insert);
        double expResult = 70.0;
        double result = cRZero.getBalance();

        assertEquals(expResult , result,"Wrong balance");

    }

    @Test
    void testUpdateCashAmountWithZeroResult() {
        double insert = -100;
        cRZero.updateCashAmount(insert);
        double expResult = 0.0;
        double result = cRZero.getBalance();

        assertEquals(expResult , result,"Wrong balance");

    }

    @Test
    void testUpdateCashAmountWithDecimals() {
        double insert = 30.5;
        cRZero.updateCashAmount(insert);
        double expResult = 130.5;
        double result = cRZero.getBalance();

        assertEquals(expResult , result,"Wrong balance");

    }
}