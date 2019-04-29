package se.kth.iv1350.pocesSale.modell;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {



    @Test
    void testToString() {

        int recivedAmount = 500;
        StoreRegistry testStoreRegistry = new StoreRegistry();
        Sale instance = new Sale(testStoreRegistry);
        ItemDescriptionDTO itemDTO = new ItemDescriptionDTO("Jimmy", 23, 12f, "Leksaksdocka",12);
        instance.addItem(itemDTO,5);
        Receipt receipt = instance.paid(recivedAmount,instance);

        String expResult = "--- START OF RECEIPT---\n" + "" + instance.storeName+ " " + instance.storeAdress+ "\n";



        String result = receipt.toString();
        assertTrue(result.contains(expResult));

    }
}