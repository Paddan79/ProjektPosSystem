package se.kth.iv1350.pocesSale.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.integration.*;
import se.kth.iv1350.pocesSale.modell.CashRegister;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationCreatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetStoreRegistry() {
        IntegrationCreator instance = new IntegrationCreator();
        StoreRegistry result = instance.getStoreRegistry();
        assertTrue(result instanceof StoreRegistry,"IntegrationCreator did not create StoreRegistry");
    }

    @Test
    void testCreateItemRegistry() {
        IntegrationCreator instance = new IntegrationCreator();
        StoreRegistry result = instance.getStoreRegistry();
        assertTrue(result instanceof StoreRegistry,"IntegrationCreator did not create StoreRegistry");
    }

    @Test
    void testCreateSaleLog() {
        IntegrationCreator instance = new IntegrationCreator();
        SaleLog result = instance.getSaleLog();
        assertTrue(result instanceof SaleLog,"IntegrationCreator did not create SaleLog");
    }

    @Test
    void testCreateAccountSystem() {
        IntegrationCreator instance = new IntegrationCreator();
        AccountSystem result = instance.getAccountSystem();
        assertTrue(result instanceof AccountSystem,"IntegrationCreator did not create AccountSystem");
    }

    @Test
    void testCreateInventorySystem() {
        IntegrationCreator instance = new IntegrationCreator();
        InventorySystem result = instance.getInventorySystem();
        assertTrue(result instanceof InventorySystem,"IntegrationCreator did not create InventorySystem");
    }

    @Test
    void testCreateCashRegister() {
        IntegrationCreator instance = new IntegrationCreator();
        CashRegister result = instance.getCashRegister();
        assertTrue(result instanceof CashRegister,"IntegrationCreator did not create CashRegister");
    }
}