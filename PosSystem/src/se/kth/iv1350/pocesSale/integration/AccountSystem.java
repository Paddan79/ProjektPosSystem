package se.kth.iv1350.pocesSale.integration;

import se.kth.iv1350.pocesSale.modell.Sale;

public class AccountSystem {

    public void bookSale(Sale book){
        testLog(book);
    }

    private void testLog(Sale record){
        System.out.println("Nu bokförs hela köpet\n");
    }
}
