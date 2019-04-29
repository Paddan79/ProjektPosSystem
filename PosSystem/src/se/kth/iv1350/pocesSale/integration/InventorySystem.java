package se.kth.iv1350.pocesSale.integration;

import se.kth.iv1350.pocesSale.modell.Sale;

/**
 * Just a class that shall do the method calls. to the Real data base.
 */

public class InventorySystem {
    /**
     * We don't know how the inventory actually look like, so this is just an representation.
     * @param quantity
     */

    public void uppdateQuantity(Sale quantity){
        testLog(quantity);
    }

    /**
     * An method to tell if the thing have been logged.
     * @param record
     */

    private void testLog(Sale record){
        System.out.println("Nu uppdateras invetarietRegistret\n");
    }
}
