package se.kth.iv1350.pocesSale.controller;

import se.kth.iv1350.pocesSale.integration.IntegrationCreator;
import se.kth.iv1350.pocesSale.integration.ItemRegistry;
import se.kth.iv1350.pocesSale.integration.Printer;
import se.kth.iv1350.pocesSale.integration.StoreRegistry;
import se.kth.iv1350.pocesSale.modell.ItemDescriptionDTO;
import se.kth.iv1350.pocesSale.modell.Receipt;
import se.kth.iv1350.pocesSale.modell.Sale;

public class Controller {

    private StoreRegistry storeReg;
    private Printer printer;
    private Sale sale;
    private ItemRegistry itemReg;

    public Controller(IntegrationCreator creator, Printer printer) {
        this.storeReg = creator.getStoreRegistry();
        this.itemReg = creator.getItemRegistry();
        this.printer = printer;

    }

    public Sale startSale(){
        sale = new Sale(storeReg);

        return sale;
    }

    public Sale registerItem(int id, int quantity){
       ItemDescriptionDTO itemInfo = itemReg.getItem(id);
       System.out.println(quantity);

        sale.addItem(itemInfo, quantity);
        return sale;

    }



    public double pay(double recievedAmount){
        Receipt receipt = sale.paid(recievedAmount ,sale);
        printer.printReciept(receipt);
        return receipt.giveMeChange();

    }

    public double giveMeTotal(){
        return sale.giveMeTotal();

    }





}
