package se.kth.iv1350.pocesSale.modell;

import java.time.format.DateTimeFormatter;

/**
 * Handles the format of the receipt.
 */

public class Receipt extends Sale {

    private Sale sale;

    private DateTimeFormatter formatDateAndTime = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
    private String formattedDateAndTime;

    /**
     * Contructor Manipulate Sales cunstructor.
     * @param endSale - Sale object for paid sale
     */
    public Receipt(Sale endSale){
        sale = endSale;
        formattedDateAndTime = endSale.saleDateTime.format(formatDateAndTime);
    }

    /**
     * Returnes the change.
     * @return change amount.
     */

    public double giveMeChange(){
        return Math.round(sale.changeAmount);
    }


    /**
     * Creates the layout of the receipt.
     * @return The string presentation of the receipt.
     */

    @Override
    public String toString(){
        StringBuilder recieptPresentation = new StringBuilder();
        recieptPresentation.append("--- START OF RECEIPT---\n");
        recieptPresentation.append("" + sale.storeName+ " " + sale.storeAdress+ "\n");
        recieptPresentation.append(formattedDateAndTime+"\n\n");
        recieptPresentation.append(sale.toString());
        recieptPresentation.append("\n--- END OF RECEIPT---");
        return recieptPresentation.toString();
    }
}
