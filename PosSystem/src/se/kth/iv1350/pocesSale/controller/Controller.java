package se.kth.iv1350.pocesSale.controller;

import se.kth.iv1350.pocesSale.integration.IntegrationCreator;
import se.kth.iv1350.pocesSale.integration.ItemRegistry;
import se.kth.iv1350.pocesSale.integration.Printer;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;
import se.kth.iv1350.pocesSale.modell.Receipt;
import se.kth.iv1350.pocesSale.modell.Sale;

/**
 * This is the aplication's only controller class. All calls to the model pass through here.
 */

public class Controller {

    private StoreRegistry storeReg;
    private Printer printer;
    private Sale sale;
    private ItemRegistry itemReg;

    /**
     * Cuntructor for startup
     *
     * @param creator - An object of the class IntegrationCreator.
     * @param printer - An object of the class Printer.
     */

    public Controller(IntegrationCreator creator, Printer printer) {
        this.storeReg = creator.getStoreRegistry();
        this.itemReg = creator.getItemRegistry();
        this.printer = printer;

    }

    /**
     * Initiates a new sale
     * @return sale object
     */

    public Sale startSale(){
        sale = new Sale(storeReg);

        return sale;
    }

    /**
     *
     * Prepares an item to be included in the shopinglist
     *
     * @param id - EanCode
     * @param quantity - Number of items registered at the same time.
     * @return Sale - Sale object
     */

    public Sale registerItem(int id, int quantity){
       ItemDescriptionDTO itemInfo = itemReg.getItem(id);
       System.out.println(quantity);

        sale.addItem(itemInfo, quantity);
        return sale;

    }

    /**
     * Activated when customer pays for the sale.
     * Printing receipt and returns change amount
     * @param recievedAmount -  Amount recived from the customer
     * @return change - Change amount to be given back to customer
     */



    public double pay(double recievedAmount){
        Receipt receipt = sale.paid(recievedAmount ,sale);
        printer.printReciept(receipt);
        return receipt.giveMeChange();

    }

    /**
     * Gives back total price
     * @return running total - Total price including vat
     */

    public double giveMeTotal(){
        return sale.giveMeTotal();

    }





}
