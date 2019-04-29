package se.kth.iv1350.pocesSale.integration;

import se.kth.iv1350.pocesSale.modell.Sale;

/**
 * A class for conversation with external system. This is just an representation hence we don't know how the
 * real data base will be implemented
 */

public class AccountSystem {

    /**
     * just a method that is called when the booking is
     * @param book - instance of the sale;
     */

    public void bookSale(Sale book){
        testLog(book);
    }

    /**
     * Just prints out if something have been logged.
     * @param record - Instance of current sale
     */

    private void testLog(Sale record){
        System.out.println("Nu bokförs hela köpet\n");
    }
}
