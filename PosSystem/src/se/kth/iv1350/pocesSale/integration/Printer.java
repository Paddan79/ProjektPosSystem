package se.kth.iv1350.pocesSale.integration;

import se.kth.iv1350.pocesSale.modell.Receipt;

/**
 * Used to print receipt.
 */

public class Printer {

    /**
     * Printing Receipt
     * @param receipt - Receipt for a paid sale.
     */

    public void printReciept(Receipt receipt){
        System.out.println(receipt);
    }
}
