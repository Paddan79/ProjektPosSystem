package se.kth.iv1350.pocesSale.integration;

import se.kth.iv1350.pocesSale.modell.Sale;

/**
 * Saves the sale in a log.
 * Just now implemented by displaying the sale on the view console.
 * No data base exists.
 */

public class SaleLog {

    private Sale record;

    /**
     * Empty constructor for sale
     */

    public SaleLog(){

    }

    /**
     * Method to "log a sale"
     * @param record - the sale object.
     */

    public void logSale(Sale record){
        this.record = record;
        testLog(record);

    }

    /**
     * A method to get the sale, not included in the requirements. Needed in test purpose.
     * @return record - the sale object.
     */

    public Sale getSale(){
        return record;
    }

    private void testLog(Sale record){
        System.out.println(" Detta är en test logg, på hela köpet\n"+record.toString());

    }


}
